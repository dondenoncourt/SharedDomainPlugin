package com.kettler.domain.warranty.share;
//use schema:CH.config.[config.groovy custom variable] to soft-code library
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class WarrantyPeriod implements Serializable {
	String id
	String desc
	int days
	int years
	static constraints = {
		desc(maxSize:30,nullable:false)
		days(max:999,nullable:false)
		years(max:99,nullable:false)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = false
	static mapping = {
		table name:'wwper', schema:CH.config?.warranty?.schema
		version (false)
		id (generator:'assigned')
		columns {
			id (column:'WPCODE',type:'string')
			desc (column:'WPDESC', type:'TrimString')
			days (column:'WPDAYS', type:'int')
			years (column:'WPYRS', type:'int')
		}
	}
	boolean newEntity = false
	static transients = ['warrPerCode', 'newEntity']
	def getWarrPerCode() {
		if (id) return id
		return 
	}
	void setWarrPerCode (def vlu) { id = vlu }
	String toString() {id} // DO NOT change this until WarrantyItem.period changed to string and getWarrantyPeriod() added
}