package com.kettler.domain.orderentry.share

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class OrderDiscountAllowance implements Serializable {
	String compCode
	int orderNo
	int shipNo
	String profitCenter
	String code
	BigDecimal percent
	static constraints = {
		compCode(maxSize:2,nullable:false)
		orderNo(max:999999,nullable:false)
		shipNo(max:99,nullable:false)
		profitCenter(maxSize:1,nullable:false)
		code(maxSize:4,nullable:false)
		percent(max:new BigDecimal("99.999"),nullable:false)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = true
	static mapping = {
		table (name:'orddscalw',schema:CH.config.orderentry.schema)
		columns {
			compCode (column:'OCOMP', type:'TrimString')
			orderNo (column:'OORDN', type:'int')
			shipNo (column:'OSHPN', type:'int')
			profitCenter (column:'OPCTR', type:'TrimString')
			code (column:'ODACD', type:'TrimString')
			percent (column:'ODAPCT', type:'big_decimal')
		}
	}
	boolean newEntity = false
	static transients = ['newEntity']
}

