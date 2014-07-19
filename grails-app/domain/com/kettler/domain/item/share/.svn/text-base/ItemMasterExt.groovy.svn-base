package com.kettler.domain.item.share
import java.util.List;

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

import com.kettler.domain.item.share.BillOfMaterials as BOM
import com.kettler.domain.orderentry.share.Coupon;
import com.kettler.domain.warranty.share.WarrantyPeriod

public class ItemMasterExt extends ItemMaster implements Serializable { 
    static searchable = {
        only: 
        ['itemNo', 'altItemNo', 'substituteItemNo', 'desc', 
        'color', 'countryOfOrigin', 'shortName', 'collection', 'keywords'
        ]
        //        division component: true // note: neither division_keywords_id nor category_keywords_id can be null
        category component: true
        // be sure to add searchable mapping options
        // http://www.grails.org/Searchable+Plugin+-+Mapping+-+Class+Mapping
        // to map bools to strings and CHE to china etc.
    }
    static COUNTRIES = [
	USA:'united states',
    BGR:'bulgaria',
    DEU:'germany',
    CAN:'canada',
    CHE:'switzerland',
    CHN:'china',
    CZE:'chzech replublic',
    HKG:'hong kong',
    IDN:'indonsia',
    ITA:'italy',
    JPN:'japan',
    MEX:'mexico',
    NLD:'netherlands',
    POL:'poland',
    ROM:'romania',
    TWN:'taiwan',
    VTN:'vietnam'
    ]

    BigDecimal retailPrice = 0g	
    BigDecimal storeprice = 0
    boolean retail = true
    boolean alsoCanada = false
    boolean onlyCanada = false
    boolean commercial = false
    boolean shipToStore = false
    boolean storeInventory = false
    boolean kettlerStoreOnly = false 
    boolean assemblyRequired = false
    boolean specialOrder = false
    boolean parts = false

    boolean alsoLatino
    boolean onlyLatino

    //boolean inactive = false // TODO rename as archive
	String inactive = 'N' // N: not displayed S: displayed R: aRchived 
						  // note: ShopController also has a filter on inactive....    

    boolean comparable = false 
    int setupHeight = 0
    int setupWidth = 0
    int setupLength = 0
    int setUpWeight = 0
    int leadTimeFrom = 0
    int leadTimeTo = 0
    BigDecimal ageFrom  = 0g
    BigDecimal ageTo = 0g
    int weightLimit = 0
    boolean truck = false
    String youTube 
    String youTubeAssembly 
    String description2
    String keywords
    BigDecimal specialPrice = 0	
    BigDecimal msrp = 0	
    BigDecimal msrpCanada = 0	
    boolean ignoreBufferStock = false
    String collection // for patio
    String commercialWarrantyCode
    String residentialWarrantyCode
    int minQty = 1
	String imageAlt
	String imageTitle
	String metaDesc
    
    WebDivision division 
    WebCategory category
    
    int dealerId = 0
    Dealer getDealer() { dealerId?Dealer.get(dealerId):null }
    def setDealer(Dealer dealer) {dealerId = dealer.id }

    static hasMany = [accessories: ItemAccessory]
    static mappedBy = [accessories:'item']
    
    WarrantyPeriod getCommercialWarrantyPeriod() {
        if (commercialWarrantyCode) {
            return WarrantyPeriod.get(commercialWarrantyCode)
        }
        return null
    }
    void setCommercialWarrantyPeriod(WarrantyPeriod commercial) {
        commercialWarrantyCode = commercial.id 
    }
    WarrantyPeriod getResidentialWarrantyPeriod() {
        if (residentialWarrantyCode) {
            return WarrantyPeriod.get(residentialWarrantyCode)
        }
        return null
    }
    void setResidentialWarrantyPeriod(WarrantyPeriod residential ) {
        residentialWarrantyCode = residential.id 
    }
    static transients = ['commercialWarrantyPeriod','residentialWarrantyPeriod', 'webAvailable', 'dealer']
    
    static mapping  = { 
        table name:'itemmastex', schema:CH.config?.inventory?.schema
        columns {
            commercial  	  type:'org.hibernate.type.YesNoType'
            alsoCanada        type:'org.hibernate.type.YesNoType'
            onlyCanada        type:'org.hibernate.type.YesNoType'
            alsoLatino        type:'org.hibernate.type.YesNoType'
            onlyLatino        type:'org.hibernate.type.YesNoType'
            shipToStore       type:'org.hibernate.type.YesNoType'
            storeInventory    type:'org.hibernate.type.YesNoType'
            kettlerStoreOnly  type:'org.hibernate.type.YesNoType'
            assemblyRequired  type:'org.hibernate.type.YesNoType'
            retail			  type:'org.hibernate.type.YesNoType'
            parts			  type:'org.hibernate.type.YesNoType'
            truck			  type:'org.hibernate.type.YesNoType'
            specialOrder      type:'org.hibernate.type.YesNoType'
			inactive 		  sqlType: 'char', length: 1
            ignoreBufferStock type:'org.hibernate.type.YesNoType'
			comparable		  type:'org.hibernate.type.YesNoType'
            commercialWarrantyCode        type:'TrimString'
            residentiallWarrantyCode      type:'TrimString'
            divisionKeywords nullable:true, column:'division_keywords_id'
            categoryKeywords nullable:true, column:'category_keywords_id'
            accessories				lazy:false, cascade: "all-delete-orphan"
            
            youTubeAssembly nullable:true, column:'YOU_TUBE_ASMBLY', type:'TrimString'
			imageAlt column:'imagealt', nullable:true, blank:true
			imageTitle  column:'imagetitle', nullable:true, blank:true
			metaDesc  column:'metadesc', nullable:true, blank:true
        }
        
    }
    static constraints = {
        commercialWarrantyCode nullable:true, blank:true, maxSize:2
        residentialWarrantyCode nullable:true, blank:true, maxSize:2
        youTube nullable:true, blank:true
        youTubeAssembly nullable:true, blank:true
        weightLimit nullable:false, min:0, max:500
        ageFrom nullable:false, min:0.0g, max:999.9g, scale:1
        ageTo nullable:false, min:0.0g, max:999.9g, scale:1
        retailPrice nullable:false, min:0.0g, scale:2, max:9999.99g
        storeprice nullable:false, min:0.0g, scale:2, max:9999.99g
        specialPrice nullable:true, min:0.0g, scale:2, max:9999.99g
        msrp nullable:true, min:0.0g, scale:2, max:9999.99g
        msrpCanada nullable:true, min:0.0g, scale:2, max:9999.99g
        description2 maxSize:30, nullable:true, blank:true
        keywords nullable:true, blank:true
        minQty min:1, nullable:false, blank:false
        alsoLatino nullable:false
        onlyLatino nullable:false
        dealerId 	validator: { dealerId, item ->
            if (dealerId) {
                Dealer dealer = Dealer.get(dealerId)
                if (!dealer) {
                    return "kettler.itemMasterExt.dealer.invalid" 
                } else if (!dealer.logo) {
                    return "kettler.itemMasterExt.dealer.no.logo" 
                }
            }
            return true			
        }  
        category 	validator: { category, item ->
            if (category.division.name != item.division.name) {
                return "kettler.itemMasterExt.category.invalid" 
            }
            return true			
        }
		inactive inList:['N','S','R'], validator: { inactive, item ->
            if (inactive == 'R' && (item.msrp || item.retailPrice || item.specialPrice )) {
                return "kettler.itemMasterExt.inactive.prices.invalid" 
            }
            return true			
        } 
		imageAlt nullable:true, blank:true
		imageTitle  nullable:true, blank:true
		metaDesc  nullable:true, blank:true

        // If archive selected and MSRP, retail price, or special price are not zero, error message "Must remove all price fields when archiving an item"
    }
    
    static namedQueries = {
        division {key, max, priceOrder, mode, closeouts = false, archive = false ->
            def division = WebDivision.findByName(key)
            eq 'division', division 
            eq 'parts', false
            if (!closeouts && !archive && mode != 'canada') {
                eq 'activeCode', ' '
            }
            if (mode != 'store') {
                eq 'kettlerStoreOnly', false
                if (mode == 'canada') {
                    or {
                    	eq 'alsoCanada', true
                    	eq 'onlyCanada', true
                    }
                } else {
                	eq 'onlyCanada', false
					eq 'inactive', archive?'R':'S' 
					eq 'closeoutCode', closeouts
                }
            } 
            if (division?.name == 'patio' && mode != 'contract') {
                ne 'category', WebCategory.findByDivisionAndName(division, 'poly')
            }
            if (mode == 'latinoamerica') {
                or {
                    eq 'alsoLatino', true
                    eq 'onlyLatino', true
                }
            } else {
                eq 'onlyLatino', false
            }
            if (max) {
                and {
                    order 'retail', 'desc' // always show 'Y' after 'N' -- no prices last always
                    order 'retailPrice', priceOrder?:'desc'
                }
                maxResults(max)
            }
        }
        category {div, cat, max, priceOrder, mode, closeouts = false, archive = false  ->
            if (mode == 'latinoamerica') {
                if (cat == 'adults') {
                    or {
                        eq 'category', WebCategory.findByDivisionAndName(WebDivision.findByName(div), 'men')
                        eq 'category', WebCategory.findByDivisionAndName(WebDivision.findByName(div), 'women')
                    }
                } else {
                    eq 'category', WebCategory.findByDivisionAndName(WebDivision.findByName(div), cat)
                }
                or {
                    eq 'alsoLatino', true
                    eq 'onlyLatino', true
                }
            } else {
                eq 'category', WebCategory.findByDivisionAndName(WebDivision.findByName(div), cat)
                eq 'onlyLatino', false
            }
            eq 'parts', false
            if (!closeouts && !archive && mode != 'canada') {
                eq 'activeCode', ' '
            }
            if (mode == 'store') {
                eq 'specialOrder', false
            } else {
                eq 'kettlerStoreOnly', false
                if (mode == 'canada') {
                    or {
                        eq 'alsoCanada', true
                        eq 'onlyCanada', true
                    }
                } else {
                    eq 'onlyCanada', false
                    eq 'inactive', archive?'R':'S' 
                    eq 'closeoutCode', closeouts
                }
            } 
            if (mode != 'contract') {
                eq 'commercial', false
            }
            if (max) {
                and {
                    order 'retail', 'desc' // always show 'Y' after 'N' -- no prices last always
                    order 'retailPrice', priceOrder?:'desc'
                }
                maxResults(max)
            }
        }
        collection {collection, mode, closeouts = false, archive = false  ->
            eq 'collection', collection
            if (!closeouts && !archive && mode != 'canada') {
                eq 'activeCode', ' '
            }
            if (mode == 'store') {
				eq 'specialOrder', false
            } else {
                eq 'kettlerStoreOnly', false
                if (mode == 'canada') {
                    or {
                        eq 'alsoCanada', true
                        eq 'onlyCanada', true
                    }
                } else {
                    eq 'onlyCanada', false
					eq 'inactive', archive?'R':'S' 
					eq 'closeoutCode', closeouts
                }
            } 
        }
        patioFilter {accessories, tables, chairs, cushions, category, priceOrder, mode, closeouts = false, archive = false  ->
            eq ('profitCenterClass', '2')
            if (category) eq 'category', WebCategory.findByDivisionAndName(WebDivision.findByName('patio'), category)
            eq 'parts', false
            if (!closeouts && !archive && mode != 'canada') {
                eq 'activeCode', ' '
            }
            if (mode == 'store') {
				eq 'specialOrder', false
            } else {
                eq 'kettlerStoreOnly', false
                if (mode == 'canada') {
                    or {
                        eq 'alsoCanada', true
                        eq 'onlyCanada', true
                    }
                } else {
                    eq 'onlyCanada', false
					eq 'inactive', archive?'R':'S' 
					eq 'closeoutCode', closeouts
                }
            }  
			if (mode != 'contract') {
				eq 'commercial', false
			}
            or {
                if (accessories) 'in'('articleGroupClass', ['B98', 'B01', 'B10', 'B11', 'B14', 'B37'])
                if (tables)       eq ('articleGroupClass', 'B30')
                if (chairs)      'in'('articleGroupClass', ['B04', 'B06'])
                if (cushions)    'in'('articleGroupClass', ['B43', 'B44', 'B47', 'B49'])
            }
            if (priceOrder) {
                and {
                    order 'retail', 'desc' // always show 'Y' after 'N' -- no prices last always
                    order 'retailPrice', priceOrder?:'desc'
                }
            }
        }
        patioCustionsInCategory {category ->
            eq 'category', WebCategory.findByDivisionAndName(WebDivision.findByName('patio'), category)
            'in'('articleGroupClass', ['B43', 'B44', 'B47', 'B49'])
            maxResults(1)
        }
    }	
    static def POLY_COLOR_MAP = ['#FFFFFF':'000','#D4CBC2':'100','#571207':'200','#05512D':'440'] 
    static def IRON_COLOR_MAP = ['#2A2B2A':'26', '#2A2B2B':'22', '#2A2B2C':'20','#151515':'33','#322105':'99']
    static def SERENO_COLOR_MAP = ['#FFFFFF':'00','#A9F5A9':'44','#FFCC66':'66', '#DF0101':'77']
    
    def colorMap() {
        if (division.name != 'patio' || closeoutCode) {
            return null
        }
        def initialColorMap = [:]
        if (category.name == 'poly') { 
            initialColorMap = ItemMasterExt.POLY_COLOR_MAP
        } else if (category.name == 'wrought iron') {  
            initialColorMap = ItemMasterExt.IRON_COLOR_MAP 
            if (collection.toLowerCase() == 'sereno') { 
                initialColorMap = ItemMasterExt.SERENO_COLOR_MAP    
            }
        } else {
            return null
        }
        // see if items available for colors
        def colorMap = [:]
        initialColorMap.each {color, itemNoColorSuffix ->
            def matcher = itemNo =~ "(.*)\\d{${itemNoColorSuffix.size()},${itemNoColorSuffix.size()}}\$"
            if (matcher.count) {
	            def itemColorPrefix = matcher[0][1]
	            ItemMaster itemWithOtherColor = ItemMaster.findByCompCodeAndItemNo(compCode, "$itemColorPrefix$itemNoColorSuffix")
	            if (itemNo == "$itemColorPrefix$itemNoColorSuffix"  || itemWithOtherColor) {
	                //colorMap.put(itemWithOtherColor.color, itemNoColorSuffix)
	                colorMap.put(color, [itemNoColorSuffix,itemWithOtherColor.color])
	            }
            }
        }
        if (colorMap.size() > 1) {
            return colorMap
        }  
        return null	
    }

    /*
     * If availability drops below 4, the item should display “out of stock.”
     * Items marked closeouts must have an availability of at least 1 instead of the greater than 3 standard.
     * 
     *  Note: a static method is used as object method caused issues
     *  with integration testing, test would say null id and error in this method
     */
    static boolean isWebAvailable(def item) {
        if (item instanceof ItemMasterExt && item.specialOrder) {
            return true
        }
        int available = 0
        if (item?.shortName == ItemMaster.KIT) {
             available = bomInventoryAvail(item)
        } else {
             available = warehouseAvailable(item)
        }
        if (item?.closeoutCode                                        || // no buffer stock required
           (item instanceof ItemMasterExt && item?.ignoreBufferStock) || // explictly ignored 
           (item instanceof ItemMaster                             ) ) { // assume patio color or bike size
            return (available > 0)
        }
        return (available > 3)
    }
    static int warehouseAvailable(ItemMaster item) {
    	return ItemWarehouse.executeQuery(
    			"select sum(qtyOnHand - qtyAlloc - qtyOnBackOrder) from ItemWarehouse where compCode = :compCode and itemNo = :itemNo and warehouse = :warehouse", 
    			[compCode:item.compCode, itemNo:item.itemNo, warehouse:'1'])[0]?:0
    }
    static int bomInventoryAvail (ItemMaster item) {
        int available = 1000
        BOM.findAllByCompCodeAndItemNo(item.compCode, item.itemNo).each {part ->
            int partAvail = ItemMasterExt.warehouseAvailable(ItemMaster.findByCompCodeAndItemNo(part.compCode, part.partItemNo))
            if (partAvail / part.partQty < available) {
                available = partAvail / part.partQty
            }
        }
        return available
    }
        
    static COUNTRIES_MAP = [USA:['united states', 'us', 'usa'],
                            BGR:['bulgaria','bulgarian'],
						    DEU:['germany','german'],
						    CAN:['canada', 'canadian'],
						    CHE:['switzerland', 'swiss'],
						    CHN:['china','chinese'],
						    CZE:['chzech replublic'],
						    HKG:['hong kong'],
                            IDN:['indonsia','indonesian'],
						    ITA:['italy','italian'],
						    JPN:['japan','japanese'],
						    MEX:['mexico','mexican'],
						    NLD:['netherlands'],
						    POL:['poland','polish'],
						    ROM:['romania'],
						    TWN:['taiwan', 'tai'],
						    VTN:['vietnam', 'vietnamese']
						    ]
    static String convertCountry(String searchStr) {
        def newSearchStr = ''
        if (searchStr) {
            searchStr.tokenize().each {token ->
                def entry = ItemMasterExt.COUNTRIES_MAP.find {it.value.find{it == token.toLowerCase()
                    }
                }
                if (entry) {
                    newSearchStr += "$entry.key "
                } else {
                    newSearchStr += "$token "
                }	
            }
        } 
        return newSearchStr
    }   
    static List getBikeFrameSizes(ItemMasterExt item) {
    	List bfs
        if (item.division.name == 'bikes' &&                                				  // bikes,  
            item.category.name  != 'accessories' &&                         				  // but not accessories  
            item.category.name  != 'child carriers' &&                         				  // or child carriers, 
            ItemMasterExt.countByItemNoLikeAndDesc(item.itemNo[0..4]+'%', item.desc ) == 1 && 					  // that have only 1 in retail,
            ItemMaster.countByItemNoLikeAndActiveCode(item.itemNo[0..4]+'%', ' ') > 1) {      // with multiple items with frame sizes 
        	bfs = ItemMaster.frameSizes(item.compCode, item.itemNo, item.desc).list()
        }
        List bikeFrameSizes = []
        if (item.specialOrder) {
            bikeFrameSizes = bfs
        } else { // check inventory
            bfs.each{it ->
                if (ItemMasterExt.isWebAvailable(it)) {
                    bikeFrameSizes << it
                }
            }
        }
    	(bikeFrameSizes?.size() > 1)?bikeFrameSizes:null
    }
    static List getPatioColors(ItemMasterExt item) {
    	List colorsPreInv
        def dashSpot = item.itemNo.indexOf('-')
        if (item.division.name == 'patio' &&
            item.category.name  != 'accessories' &&
            dashSpot > 0 &&
            ItemMaster.countByItemNoLikeAndActiveCode(item.itemNo[0..dashSpot]+'%', ' ') > 1) {      // and with multiple items with colors
        	colorsPreInv = ItemMaster.colors(item.compCode, item.itemNo, item.desc, dashSpot).list()
        }
        List colors = []
        colorsPreInv.each{iCRS ->
            if (ItemMasterExt.isWebAvailable(iCRS)) {
                colors << iCRS
            }
        }
    	(colors?.size() > 1)?colors:null
    }
    
    
    String toString() {"$id:$compCode:$itemNo:$desc"
    }
}
/* note: populate with image project's PopulateController.fromFtp */
