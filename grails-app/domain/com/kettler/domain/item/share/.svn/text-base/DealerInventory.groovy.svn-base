package com.kettler.domain.item.share
import java.io.Serializable;

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

/**
 * Represents inventory count and item for a given dealer location.
 * available will be set by dealer to indicate available inventory for a location.
 * When the dealer starts the process of updating available inventory, this flag
 * will be cleared, so it must be reset by the dealer to show it is available. 
 */
class DealerInventory implements Serializable {
    int quantity = 0
    boolean available = false
    ItemMasterExt item
    Date dateCreated
    Date lastUpdated

    static belongsTo = [dealerLocation: DealerLocation]

    static constraints = {
    }
    static mapping  = { 
        table name:'dealer_inventory', schema:CH.config?.inventory?.schema
        columns {
    		available	type:'org.hibernate.type.YesNoType' 
        }
        
    }

    String toString() { "$item.shortName: $quantity"}
}
