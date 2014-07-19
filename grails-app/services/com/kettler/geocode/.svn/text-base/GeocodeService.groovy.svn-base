package com.kettler.geocode
import grails.converters.JSON

class GeocodeService {

    /*
    WARNING: transactional must be false otherwise a hibernate flush will be called,
    which will throw an exception in "beforeInsert" in DealerLocation.
     */
    static transactional = false

    def updateLatLng(Geocode bean) {
        log.debug "updateLatLng called with: ${bean}"
        if (!bean.address || bean.address.length() == 0) {
            bean.success = false
            bean.errorMessage = "Null or blank address not accepted"
            log.error "Error, no address"
        } else {
            def base = "http://maps.google.com/maps/api/geocode/json?"
            def qs = []
            qs << "address=" + URLEncoder.encode(bean.address)
            qs << "sensor=false"
            def url = new URL(base + qs.join("&"))
            def connection = url.openConnection()
            if(connection.responseCode == 200){
                def response = connection.content.text
                def jsonResp = JSON.parse(response)
                if (jsonResp.status.equals("OK")) {
                    bean.success = true
                    def answer = jsonResp.results[0]
                    bean.lat = answer.geometry.location.lat as float
                    bean.lng = answer.geometry.location.lng as float
                    def addrComp = answer.address_components
                    log.debug "found ${addrComp.size()} addr components"
                    addrComp.each {
                        if (it.types[0].equals("country")) {
                            bean.country = it.short_name
                            log.debug "country: ${bean.country}"
                        }
                    }
                } else {
                    bean.success = false
                    bean.errorMessage = "Error response: ${jsonResp.status}"
                }
            } else {
                bean.success = false
                bean.errorMessage = "${connection.responseCode}: ${connection.responseMessage}"
            }
            log.debug "updateLatLng returning: ${bean}"
        }
    }

/*::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
/*::                                                                         :*/
/*::  This routine calculates the distance between two points (given the     :*/
/*::  latitude/longitude of those points). It is being used to calculate     :*/
/*::  the distance between two ZIP Codes or Postal Codes using our           :*/
/*::  ZIPCodeWorld(TM) and PostalCodeWorld(TM) products.                     :*/
/*::                                                                         :*/
/*::  Definitions:                                                           :*/
/*::    South latitudes are negative, east longitudes are positive           :*/
/*::                                                                         :*/
/*::  Passed to function:                                                    :*/
/*::    lat1, lon1 = Latitude and Longitude of point 1 (in decimal degrees)  :*/
/*::    lat2, lon2 = Latitude and Longitude of point 2 (in decimal degrees)  :*/
/*::    unit = the unit you desire for results                               :*/
/*::           where: 'M' is statute miles                                   :*/
/*::                  'K' is kilometers (default)                            :*/
/*::                  'N' is nautical miles                                  :*/
/*::  United States ZIP Code/ Canadian Postal Code databases with latitude & :*/
/*::  longitude are available at http://www.zipcodeworld.com                 :*/
/*::                                                                         :*/
/*::  For enquiries, please contact sales@zipcodeworld.com                   :*/
/*::                                                                         :*/
/*::  Official Web site: http://www.zipcodeworld.com                         :*/
/*::                                                                         :*/
/*::  Hexa Software Development Center © All Rights Reserved 2004            :*/
/*::                                                                         :*/
/*::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/

    public double distance(double lat1, double lon1, double lat2, double lon2, char unit) {
      double theta = lon1 - lon2;
      double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
      dist = Math.acos(dist);
      dist = rad2deg(dist);
      dist = dist * 60 * 1.1515;
      if (unit == "K") {
        dist = dist * 1.609344;
      } else if (unit == "N") {
          dist = dist * 0.8684;
        }
      return (dist);
    }

/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
/*::  This function converts decimal degrees to radians             :*/
/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private double deg2rad(double deg) {
      return (deg * Math.PI / 180.0);
    }

/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
/*::  This function converts radians to decimal degrees             :*/
/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private double rad2deg(double rad) {
      return (rad * 180.0 / Math.PI);
    }

}
