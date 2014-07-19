package com.kettler.domain.actrcv.share;
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH


class ReturnItemDetail  implements Serializable {
	BigDecimal			freightClaimAmount
	String				freightClaimGLCode
	ReturnCondition 	condition
	ReturnDisposition	disposition
	ReturnFreightDenial freightDenial
	static belongsTo = [ returnItem : ReturnItem ]  

	String dtlWarehouse
	String dtlLocation

	static constraints = {
		disposition         nullable:true
		condition          	nullable:true
		freightDenial		nullable:true
		freightClaimAmount	nullable:true
		freightClaimGLCode	nullable:true, maxSize:3
		dtlWarehouse        nullable:true
		dtlLocation         nullable:true
	}
	static mapping = {
		table (name:'rtrnitmdtl',schema:CH.config.accounting.schema)
		desc          		column:'descr'
		condition			column:'cond_id'
		disposition			column:'disp_id'
		freightDenial		column:'fgtclmnix'
		freightClaimAmount  column:'fgtclmamt'
		freightClaimGLCode	column:'fgtclmgl'
		dtlWarehouse		column:'warehouse'
		dtlLocation			column:'location'
	}
	String toString() {"cond: ${condition?.code} disp ${disposition?.code} freightClaimAmount: $freightClaimAmount freightClaimGLCode: $freightClaimGLCode"}
}
