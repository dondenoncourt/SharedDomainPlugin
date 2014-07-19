package com.kettler.domain.orderentry.share

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class ReasonCode implements Serializable {
	String id
	String desc
	static constraints = {
		id(maxSize:2,nullable:false)
		desc(maxSize:30,nullable:false)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = false
	static mapping = {
		table name:'oersnc', schema:CH.config.orderentry.schema
		version (false)
		id (generator:'assigned')
		columns {
			id (column:'RCCODE',type:'string')
			desc (column:'RCDESC', type:'string')
		}
	}
	boolean newEntity = false
	static transients = ['reasonCode', 'newEntity']
	def getReasonCode() {
		if (id) return id
		return 
	}
	void setReasonCode (def vlu) { id = vlu }
}