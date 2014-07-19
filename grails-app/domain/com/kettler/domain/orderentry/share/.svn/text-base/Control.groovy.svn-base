package com.kettler.domain.orderentry.share
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
class Control implements Serializable {
	String id
	String arInstalled
	String includeMisc
	int crChkARDays
	int crChkOrdValue
	String shipAvailQty
	String qtyUnitMeasDefault
	String printBulkPick
	int nextOrderNo
	int nextInvoiceNo
	int nextQuoteNo
	Long nextBolNo
	static constraints = {
		arInstalled(maxSize:1,nullable:false)
		includeMisc(maxSize:1,nullable:false)
		crChkARDays(max:999,nullable:false)
		crChkOrdValue(max:9999999,nullable:false)
		shipAvailQty(maxSize:1,nullable:false)
		qtyUnitMeasDefault(maxSize:1,nullable:false)
		printBulkPick(maxSize:1,nullable:false)
		nextOrderNo(max:999999,nullable:false)
		nextInvoiceNo(max:9999999,nullable:false)
		nextQuoteNo(max:99999,nullable:false)
		nextBolNo(max:9999999999,nullable:false)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = false
	static mapping = {
		table (name:'oectrl',schema:CH.config.orderentry.schema)
		version (false)
		id (generator:'assigned')
		columns {
			id (column:'CTLKEY',type:'string')
			arInstalled (column:'ARINST', type:'string')
			includeMisc (column:'INMISC', type:'string')
			crChkARDays (column:'ARDAYS', type:'int')
			crChkOrdValue (column:'ORVALU', type:'int')
			shipAvailQty (column:'SHPAVL', type:'string')
			qtyUnitMeasDefault (column:'UNMDFL', type:'string')
			printBulkPick (column:'BULKPL', type:'string')
			nextOrderNo (column:'NXTORD', type:'int')
			nextInvoiceNo (column:'NXTINV', type:'int')
			nextQuoteNo (column:'NXTQTE', type:'int')
			nextBolNo (column:'NXTBOL', type:'long')
		}
	}
	boolean newEntity = false
	static transients = ['controlKey', 'newEntity']
	def getControlKey() {
		if (id) return id
		return 
	}
	void setControlKey (def vlu) { id = vlu }
}

