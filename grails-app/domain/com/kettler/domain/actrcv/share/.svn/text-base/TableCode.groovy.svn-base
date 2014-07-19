package com.kettler.domain.actrcv.share
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
class TableCode implements Serializable {
	String compCode
	String type
	String code
	String desc
	Long debitAcctNo
	Long creditAcctNo
	String normalSign
	String salesCode
	String salesDivision
	static constraints = {
		compCode(maxSize:2,nullable:false)
		type(maxSize:1,nullable:false)
		code(maxSize:3,nullable:false)
		desc(maxSize:20,nullable:false)
		debitAcctNo(max:9999999999999,nullable:false)
		creditAcctNo(max:9999999999999,nullable:false)
		normalSign(maxSize:1,nullable:false)
		salesCode(maxSize:1,nullable:false)
		salesDivision(maxSize:1,nullable:false)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = true
	static mapping = {
		table (name:'artabl',schema:CH.config.accounting.schema)
//		cache usage:'read-only', include:'non-lazy'  issues with datasources plugin
		version (false)
		id (generator:'assigned')
		id (composite:['compCode','type','code'])
		columns {
			id (composite:['compCode','type','code'])
			compCode (column:'RCOMP', type:'string')
			type (column:'RTYPE', type:'string')
			code (column:'RCODE', type:'string')
			desc (column:'RDESC', type:'string')
			debitAcctNo (column:'RDACCT', type:'long')
			creditAcctNo (column:'RCACCT', type:'long')
			normalSign (column:'RNSIGN', type:'string')
			salesCode (column:'RSLSCD', type:'string')
			salesDivision (column:'RSLSDV', type:'string')
		}
	}
	boolean newEntity = false
	static transients = ['newEntity']
}
