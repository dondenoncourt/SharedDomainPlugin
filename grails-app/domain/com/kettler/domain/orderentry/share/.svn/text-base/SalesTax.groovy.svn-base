package com.kettler.domain.orderentry.share
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
class SalesTax implements Serializable {
	String id
	String desc
	BigDecimal taxPct
	String arDistCode
    boolean taxFreight
	static constraints = {
		desc(maxSize:30,nullable:false)
		taxPct(max:new BigDecimal("99.999"),nullable:false)
		arDistCode(maxSize:3,nullable:false)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = false
	static mapping = {
		table (name:'oestax',schema:CH.config.orderentry.schema)
		cache usage:'read-only', include:'non-lazy'
		version (false)
		id (generator:'assigned')
		columns {
			id (column:'TXCODE',type:'string')
			desc (column:'TXDESC', type:'string')
			taxPct (column:'TXPCNT', type:'big_decimal')
			arDistCode (column:'TXARCD', type:'string')
			taxFreight (column:'TXFRGT', type:'YesBlankType')
		}
	}
	boolean newEntity = false
	static transients = ['salesTaxCode', 'newEntity']
	def getSalesTaxCode() {
		if (id) return id
		return 
	}
	void setSalesTaxCode (def vlu) { id = vlu }
    
    static boolean hasSalesTax(String state) {
println "SalesTax.get($state)?.taxPct > 0.0: "+(SalesTax.get(state)?.taxPct > 0.0)
        SalesTax.get(state)?.taxPct > 0.0
    }
    static boolean taxesFreight(String state) {
println "SalesTax.get($state)?.taxFreight:"+SalesTax.get(state)?.taxFreight
        SalesTax.get(state)?.taxFreight
    }
}
