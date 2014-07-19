package com.kettler.domain.item.share;
import java.io.Serializable;

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class ItemAccessory implements Serializable {
	ItemMasterExt accessory
	static belongsTo = [item: ItemMasterExt]
    static mapping  = { 
    	table name:'itemacsry', schema:CH.config?.inventory?.schema
	}
}