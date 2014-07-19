package com.kettler.domain.orderentry.share

import java.io.Serializable;

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class ShipToZoneState implements Serializable {
	String state
	String scacCode
	static belongsTo = [ zone : ShipToZone ]

	static constraints = {
		state maxSize:2,blank:false,nullable:false, inList:['AL','AK','AZ','AR','CA','CO','CT','DE','DC','FL','GA','HI','ID','IL','IN','IA','KS','KY','LA','ME','MD','MA','MI','MN','MS','MO','MT','NE','NV','NH','NJ','NM','NY','NC','ND','MP','OH','OK','OR','PA','RI','SC','SD','TN','TX','UT','VT','VA','WA','WV','WI','WY']
		scacCode maxSize:4, nullable:false
	}
	
	static mapping = {
		table (name:'shiptozost',schema:CH.config?.orderentry?.schema)
	}

}
