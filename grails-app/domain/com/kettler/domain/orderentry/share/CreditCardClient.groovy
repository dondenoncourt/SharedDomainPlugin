package com.kettler.domain.orderentry.share

//use schema:CH.config.[config.groovy custom variable] to soft-code library
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class CreditCardClient implements Serializable {
	String compCode
	String userForPayware
	String userPasswordForInternalPaywareUser
	String paywareTerminal
	static constraints = {
		compCode(maxSize:2,nullable:false)
		userForPayware(maxSize:8,nullable:false)
		userPasswordForInternalPaywareUser(maxSize:24,nullable:false)
		paywareTerminal(maxSize:16,nullable:false)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = true
	static mapping = {
		table name:'vepctl', schema:CH.config.orderentry.schema
		version (false)
		id (generator:'assigned')
		id (composite:['compCode','userForPayware'])
		columns {
			id (composite:['compCode','userForPayware'])
			compCode (column:'CCCOMP', type:'string')
			userForPayware (column:'RUSRID', type:'string')
			userPasswordForInternalPaywareUser (column:'RUSRPW', type:'string')
			paywareTerminal (column:'RCLIEN', type:'string')
		}
	}
	boolean newEntity = false
	static transients = ['newEntity']
}
