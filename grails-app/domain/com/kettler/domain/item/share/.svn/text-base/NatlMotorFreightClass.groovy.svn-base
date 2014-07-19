package com.kettler.domain.item.share
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class NatlMotorFreightClass implements Serializable {
	String id
	String desc // was nmfcDescription
	String classCode
	static constraints = {
		desc(maxSize:30,nullable:false)
		classCode(maxSize:3,nullable:false)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = false
	static mapping = {
		table (name:'innmfc',schema:CH.config.inventory.schema)
//		cache usage:'read-only', include:'non-lazy'  Second-level cache is not enabled
		version (false)
		id (generator:'assigned')
		columns {
			id (column:'NMFCNM',type:'string')
			desc (column:'NMFCDS', type:'string')
			classCode (column:'NMFCCL', type:'string')
		}
	}
	boolean newEntity = false
	static transients = ['nmfcNumber', 'newEntity']
	def getNumber() {
		if (id) return id
		return 
	}
	void setNumber (def vlu) { id = vlu }
}
