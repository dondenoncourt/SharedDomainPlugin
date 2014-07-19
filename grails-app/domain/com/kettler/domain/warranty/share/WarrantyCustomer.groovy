package com.kettler.domain.warranty.share;

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class WarrantyCustomer implements Serializable {
	String id
	String activeCode = ''
	String firstName = ''
	String lastOrCorpName = '' 
	String addr1
	String addr2 = '' 
	String city
	String state
	String zipCode
	String phone
	String fax = ''
	String email
    boolean marketing = true
	static constraints = {
		activeCode(maxSize:1,nullable:false)
		firstName(maxSize:15,nullable:false)
		lastOrCorpName(maxSize:30,nullable:false)
		addr1(maxSize:30,nullable:false)
		addr2(maxSize:30,nullable:false)
		city(maxSize:15,nullable:false)
		state(maxSize:2,nullable:false)
		zipCode(maxSize:9,nullable:false)
		phone(maxSize:10,nullable:false)
		fax(maxSize:10,nullable:false)
		email(maxSize:50,email:true,nullable:false)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = false
	static mapping = {
		table name:'wcust', schema:CH.config?.warranty?.schema
		version (false)
		id (generator:'assigned')
		columns {
			id (column:'WCUSID',type:'TrimString')
			activeCode (column:'WACTV', type:'TrimString')
			firstName (column:'WFNAME', type:'TrimString')
			lastOrCorpName (column:'WLNAME', type:'TrimString')
			addr1 (column:'WADDR1', type:'TrimString')
			addr2 (column:'WADDR2', type:'TrimString')
			city (column:'WCITY', type:'TrimString')
			state (column:'WSTAT', type:'TrimString')
			zipCode (column:'WZIPC', type:'TrimString')
			phone (column:'WPHONE', type:'TrimString')
			fax (column:'WFAXNO', type:'TrimString')
			email (column:'WEMAIL', type:'TrimString')
			marketing  type:'org.hibernate.type.YesNoType'
		}
	}
	boolean newEntity = false
	static transients = ['customerIdNo', 'newEntity']
	def getCustomerIdNo() {
		if (id) return id
		return 
	}
	void setCustomerIdNo (def vlu) { id = vlu }
}