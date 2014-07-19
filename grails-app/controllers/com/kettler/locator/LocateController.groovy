package com.kettler.locator
import grails.converters.JSON
import grails.util.Environment
import com.kettler.geocode.Geocode
import com.kettler.domain.item.share.Dealer
import com.kettler.domain.item.share.WebDivision
import com.kettler.domain.comparator.DealerComparator
import com.sun.org.apache.bcel.internal.classfile.DescendingVisitor
import com.kettler.domain.item.share.DealerLocation

class LocateController {
    def geocodeService
    def beforeInterceptor = {
    	log.debug "action: $actionName params: $params flash: $flash $Environment.current"
    }

    def index = {
        // TODO Convert valid remote addr to lat/lng for fallback if
        // user browser does not support geolocation
        log.debug "remoteAddr: ${request.getRemoteAddr()}"
        log.debug "X-Forwarded-For: ${request.getHeader("X-Forwarded-For")}"
        log.debug "Client-IP: ${request.getHeader("Client-IP")}"
        session.distance = 20.0F
        [division: params.division, itemId: params.itemId, locator:true]
    }
    
    def products = {
    	redirect controller:'shop', action:'products', params:params
    }

    /** Handles the search button */
    def search = {
        def result = [:]
        session.distance = params.distance as float
        Geocode bean = new Geocode(address: params.data)
        geocodeService.updateLatLng(bean)
        if (bean.country && bean.country.size()>0) {
            if (!bean.country.equals("US") && !bean.country.equals("CA")) {
                bean.success = false
                bean.errorMessage = 'This dealer locator service is only valid for United States and Canada'
            }
        }
        result.success = bean.success
        if (!bean.success) {
            result.error = bean.errorMessage
        } else {
            result.lat = bean.lat as String
            result.lng = bean.lng as String
        }
        log.debug "search result: ${result}"
        render result as JSON
    }

    /** Event callback from Google maps.  Can happen on zoom, pan, etc.
     params: ne corner (neLat, neLng) and sw corner (swLat, swLng)
     of displayed Google map.
     Finds dealers within region and returns json array of marker data.
     From Statement of work:
     - Division specific
     - Test that dealer is active (status A in the AR system) and
       last charge date (Last Chg field) within 18 months of the current date
     - The locator will use US Zip Code or Canadian Postal Code to search for
       retailers within a mile radius chosen from a drop down menu
     - An option is to add an item number from the Store Inventory list of items
     - If no dealers were in the radius, prompt them to increase the radius or
       view the Web Dealer Listing
    */
    def bndsChanged = {
        def result = [:]
        def dealerListMap = [:]
        def markerArray = []
        def dealerArray = []
        log.debug "search radius: ${session.distance} miles"
        result.success = true
        //'neLat='+ne.lat()+'&neLng='+ne.lng()+'&swLat='+sw.lat()+'&swLng='+sw.lng()
        def divList = []
        if (params.division) {
            log.debug "has division: ${params.division}, class: ${params.division.class.name}"
            divList = [ params.division ] //params.divisions.tokenize(",")
        }
        try {
            def swLat = params.swLat as float
            def neLat = params.neLat as float
            def swLng = params.swLng as float
            def neLng = params.neLng as float
            def cLat = params.cLat as float
            def cLng = params.cLng as float
            def dealers = []
            def division
            if (params.division) {
                division = WebDivision.findByName(params.division)
        		dealers = Dealer.withCriteria  {
									divisions {eq "id", division.id }
									customer {eq 'compCode', (params.mode == 'canada')?'02':'01'}
								}    		
                log.debug "found ${dealers.size()} dealers for division: ${params.division}"
            } else {
				dealers = Dealer.withCriteria {
						customer {
							eq 'compCode', (params.mode == 'canada')?'02':'01'
							order ('name', "desc")
						}
						maxResults(30)
				}
                log.debug "No division, returned ${dealers.size()} dealers"
            }
            dealers.each { dealer ->
                if (isDealerActive(dealer)) {
                    dealer.locations.each { location ->
                        //log.debug "dealer, name: ${dealer.customer.name}, lat: ${location.lat}, lng: ${location.lng}"
                        def distance = geocodeService.distance(cLat, cLng, location.lat, location.lng, 'M' as char)
                        //log.debug "distance from center: ${distance}, in radius: ${distance <= session.distance}"
                        if (distance <= session.distance && location.lat >= swLat && location.lat <= neLat &&
                            location.lng >= swLng && location.lng <= neLng) {
                                def marker = [:]
                                marker.lat = location.lat
                                marker.lng = location.lng
                                marker.dName = location.name?:dealer.customer?.name
                                marker.website = dealer.website
                                marker.phone = dealer.customer?.phoneNo
                                marker.location = location

                                marker.infowin = g.render(template:"infoWindowTemplate", model: marker)
                                markerArray << marker
                                //log.debug "added marker: ${marker.dName}"
                                def dealerItem = [:]
                                dealerItem.dealer = dealer                 
                                dealerItem.name = location.name?:dealer.customer?.name
                                dealerItem.website = dealer.website
                                dealerItem.phone = dealer?.customer?.phoneNo
                                dealerItem.location = location
                                dealerItem.distance = distance
                                if (params.itemId && locationHasInventory(location, params.itemId)) {
                                	dealerItem.inventory = true
	                            }
                                dealerItem.inStockItems = getInventories(division, location)
                                log.debug "inStockItems: ${dealerItem.inStockItems}"
                                dealerArray << dealerItem
                        } else {
                            //log.debug "Not within radius"
                        }
                    }
                } else {
                    //log.debug "Dealer ${dealer?.customer?.name} is not active"
                }
            }
            dealerListMap.dealers = dealerArray
            if (dealerArray.size() > 0) {
                result.dealerList = g.render(template:"dealerListTemplate", 
						model: 
							[locations:
								dealerArray.sort{a,b -> 
									if (a.dealer.trackInventory && !b.dealer.trackInventory) {
										return -1
									} else if (!a.dealer.trackInventory && b.dealer.trackInventory) {
										return 1
									}
									// otherwise both do or don't track inventory
									a.distance <=> b.distance
								}
							])
            } else {
                result.dealerList = g.render(template:"noDealersFoundTemplate", model: dealerListMap)
            }
            result.markers = markerArray
        } catch (Exception e) {
            log.error e.message,e
            result.success = false
            result.error = "Error finding dealers: ${e.message}"
        }
        render result as JSON
    }

    private boolean locationHasInventory(location, itemId) {
        boolean res = false
        def iItemId = itemId as Integer
        location.inventories.each { inv ->
            log.debug "id: ${inv.item.id}, itemNo: ${inv.item.itemNo}, desc: ${inv.item.desc}, qty: ${inv.quantity}"
            if (inv.available && inv.item.id == iItemId) {
                res = true
            }
        }
        res
    }

    private List getInventories(WebDivision division, DealerLocation location) {
        def res = []
        location.inventories.each { inv ->
            if (inv.available && inv.item?.division?.equals(division)) {
                res << inv.item?.desc
            }
        }
        res
    }

    /**
     * Determine if dealer is active (activeCode == "A" or " " and lastChgDate > 18 months ago
     * @param dealer Dealer to test
     * @return true if active
     */
    private boolean isDealerActive(dealer) {
        //log.debug "isDealerActive, ${dealer.customer?.name} activeCode: [${dealer.customer?.activeCode}], lstchg: ${dealer.customer?.lastChgDate}"
        boolean res = false
        GregorianCalendar gc = new GregorianCalendar()
        gc.add(Calendar.MONTH, -18)
        def actCode = dealer.customer?.activeCode.equals('') || dealer.customer?.activeCode.equals('A')
        //log.debug "actCode: ${actCode}"
        return dealer.customer.lastChgDate > gc.getTime() && actCode
    }
}
