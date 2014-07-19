package com.kettler.domain.item.share

import java.io.Serializable;

import com.kettler.geocode.Geocode
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

/**
 * Represents locations of a Dealer.
 *
 * availabilityUpdated set when dealer updates availability of inventory.
 *
 * availabilityExpired set when dealer does not update inventory within
 * required time frame. 
 */
class DealerLocation implements Serializable {
    // TODO Custom validation messages
    def geocodeService

    public static float INVALIDLATLNG = 400.0F

    String name = ""
    String street
    String city
    String state
    String zip = ""
    Float lat = INVALIDLATLNG
    Float lng = INVALIDLATLNG
    long phone
    boolean availabilityExpired = false
    Date availabilityUpdated
    byte[] storePhoto


    static belongsTo = [dealer: Dealer]
    static hasMany = [inventories: DealerInventory]

    static constraints = {
        name(nullable:true)
        phone(nullable:true)
        street(blank: false)
        city(blank: false)
        state(minSize: 2, maxSize: 2)
        zip(minSize: 5, maxSize: 10, blank: true)
        availabilityUpdated(nullable:true)
        storePhoto(nullable:true,maxSize:31850)
//        lat(notEqual:INVALIDLATLNG)
//        lng(notEqual:INVALIDLATLNG)
    }

    
    def updateLatLng() {
        if (validate()) {
            Geocode bean = new Geocode(address: "${street} ${city} ${state} ${zip}")
            geocodeService.updateLatLng(bean)
            if (bean.success) {
                lat = bean.lat
                lng = bean.lng
            } else {
                lat = INVALIDLATLNG
                lng = INVALIDLATLNG
                log.error "Geocode failed: ${bean.errorMessage}, setting lat/lng to: ${INVALIDLATLNG}"
            }
        }
    }

    def beforeInsert() {
        updateLatLng()
    }

    def beforeUpdate() {
        updateLatLng()
    }
    static mapping  = { 
        table name:'dealer_location', schema:CH.config?.inventory?.schema
        columns {
            availabilityExpired	type:'org.hibernate.type.YesNoType' 
        	name				nullable:true, blank:true
        }
        
    }

    String toString() { "$street $city $state $zip" }
}
