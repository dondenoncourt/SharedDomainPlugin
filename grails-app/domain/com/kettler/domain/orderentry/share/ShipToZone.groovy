package com.kettler.domain.orderentry.share

import java.io.Serializable;

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class ShipToZone implements Serializable {
	String name
	BigDecimal cost
	static hasMany = [states : ShipToZoneState]
	
	static constraints = {
		name nullable:false, blank:false, maxSize:25, unique:true
		cost nullable:false, min:0.0g, scale:2, max:9999.99g
	}
	String toString(){name}
	
	static mapping = {
		table (name:'shiptozone',schema:CH.config?.orderentry?.schema)
	}

}
