package com.kettler.domain.orderentry.share
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
class SalesPerson implements Serializable {
	String id
	String name
	Date hireDate
	String houseFlag = ''
	String compCode = '01'
	String emailAddress = ''
	String vendorNo = ''
	static constraints = {
		name(maxSize:30,nullable:false)
		hireDate(nullable:false)
		houseFlag(maxSize:1,nullable:false)
		compCode(maxSize:2,nullable:false)
		emailAddress(maxSize:50,email:true,nullable:false)
		vendorNo(maxSize:7,nullable:false)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = false
	static mapping = {
		table (name:'oesper',schema:CH.config.orderentry.schema)
		cache usage:'read-only', include:'non-lazy'
		version (false)
		id (generator:'assigned')
		columns {
			id (column:'SPCODE',type:'string')
			name (column:'SPNAME', type:'string')
			hireDate (column:'SPHDAT', type:'DateMMDDYYUserType')
			houseFlag (column:'SPHFLG', type:'string')
			compCode (column:'SPCOMP', type:'string')
			emailAddress (column:'SPEMA', type:'string')
			vendorNo (column:'SPVEND', type:'string')
		}
	}
	boolean newEntity = false
	static transients = ['salespersonCode', 'newEntity']
	def getSalespersonCode() {
		if (id) return id
		return 
	}
	void setSalespersonCode (def vlu) { id = vlu }
	String toString() {"$id: $name"}
}
