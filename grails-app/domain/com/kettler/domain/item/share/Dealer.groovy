package com.kettler.domain.item.share
import java.io.Serializable;

import com.kettler.domain.actrcv.share.Customer
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

/**
 * Domain object to represent dealer for retail web site.
 */
class Dealer implements Serializable {
    Customer customer
    String website
    boolean trackInventory = false
    byte[] logo
    long phone = 0
    boolean web = false

    static hasMany = [locations: DealerLocation, divisions: WebDivision]
    static constraints = {
        website(nullable:true, blank:false)
        logo(nullable:true,maxSize:40960)
        phone(nullable:true)
    }
    static mapping  = { 
        table name:'dealer', schema:CH.config?.inventory?.schema
        columns {
            web			  	type:'org.hibernate.type.YesNoType', column:'web_dealer'
            trackInventory	type:'org.hibernate.type.YesNoType', column:'track_inv'
        }
    	divisions joinTable: [name: 'dealer_division', column: 'division_id', key: 'dealer_id']
    }

    String toString() { customer?.name }
}
