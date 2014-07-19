package com.kettler.domain.orderentry.share
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class InvoicedOrderDetailItem implements Serializable {
	String compCode
	Integer orderNo
	Integer shipNo = 0
	Integer lineNo
	String lineType
	String itemNo
	String desc = ''
	String distrCode = ''
	String qtyUnitMeas = 'EA '
	Integer orderQty = 0
	Integer shipQty = 0
	Integer backOrderQty = 0
	String backOrderCode = ''
	BigDecimal orderWeight = 0.0g
	boolean priceOverride = false
	BigDecimal unitPrice = 0.0g
	BigDecimal unitCost = 0.0g
	String priceUnitMeas = ''
	String convCode = ''
	Integer convFactor = 0
	BigDecimal itemDiscPct = 0.0g
	String discDistrCode = ''
	boolean subjToTax1 = false
	boolean subjToTax2 = false
	boolean subjToTax3 = false
	BigDecimal amount = 0.0g
	BigDecimal cost = 0.0g
	
	String custNo
	int shipToNo
	String salesperson1
	String salesperson2 = ''
	Date invoiceDate = new Date()
	BigDecimal commissionPct = 0.0g
	
	String returnToStock = ''
	String reasonCode = ''
	String nmfcNo = ''
	String discAllowProfitCenter = ''
	String discAllowCode = ''
	String discAllowEDICode = ''
	BigDecimal discAllowPct = 0.0g
	static constraints = {
		compCode(maxSize:2,nullable:false)
		orderNo(max:999999)
		shipNo(max:99,nullable:false)
		lineNo(min:1,max:9999,nullable:false)
		lineType(maxSize:1,inList:['I', 'N'],nullable:false)
		itemNo(maxSize:15,nullable:false)
		desc(maxSize:30,nullable:false)
		distrCode(maxSize:3,nullable:false)
		qtyUnitMeas(maxSize:3,nullable:false)
		orderQty(min:-1,max:99999,nullable:false)
		shipQty(min:-1, max:99999,nullable:false)
		backOrderQty(max:99999,nullable:false)
		backOrderCode(maxSize:1,nullable:false)
		orderWeight(max:new BigDecimal("9999.999"),nullable:false)
		priceOverride(maxSize:1,nullable:false)
		unitPrice(max:new BigDecimal("999999.999"),nullable:false)
		unitCost(max:new BigDecimal("999999.999"),nullable:false)
		priceUnitMeas(maxSize:3,nullable:false)
		convCode(maxSize:1,nullable:false)
		convFactor(max:9999,nullable:false)
		itemDiscPct(max:new BigDecimal("99.99"),nullable:false)
		discDistrCode(maxSize:3,nullable:false)
		subjToTax1(maxSize:1,nullable:false)
		subjToTax2(maxSize:1,nullable:false)
		subjToTax3(maxSize:1,nullable:false)
		amount(max:new BigDecimal("9999999.99"),nullable:false)
		cost(max:new BigDecimal("9999999.99"),nullable:false)
		
		custNo(maxSize:7,nullable:false)
		shipToNo(max:9999,nullable:false)
		salesperson1(maxSize:3,nullable:false)
		salesperson2(maxSize:3,nullable:false)
		//invoiceDate(nullable:false)
		commissionPct(max:new BigDecimal("99.99"),nullable:false)
		
		returnToStock(maxSize:1,nullable:false)
		reasonCode(maxSize:2,nullable:false)
		nmfcNo(maxSize:8,nullable:false)
		discAllowProfitCenter(maxSize:1,nullable:false)
		discAllowCode(maxSize:4,nullable:false)
		discAllowEDICode(maxSize:4,nullable:false)
		discAllowPct(max:new BigDecimal("99.999"),nullable:false)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = true
	static mapping = {
		table (name:'oeinv1',schema:CH.config.orderentry.schema)
		version (false)
		id (generator:'assigned')
		id (composite:['compCode','orderNo','shipNo','lineNo'])
		columns {
    		id (composite:['compCode','orderNo','shipNo','lineNo'])
			compCode (column:'OCOMP', type:'TrimString')
			orderNo (column:'OORDN', type:'int')
			shipNo (column:'OSHPN', type:'int')
			lineNo (column:'OSEQN', type:'int')
			lineType (column:'OTYPE', type:'TrimString')
			itemNo (column:'OITEM', type:'TrimString')
			desc (column:'ODESC', type:'TrimString')
			distrCode (column:'ODIST', type:'TrimString')
			qtyUnitMeas (column:'OQUNM', type:'TrimString')
			orderQty (column:'OQTYOR', type:'int')
			shipQty (column:'OQTYSH', type:'int')
			backOrderQty (column:'OQTYBO', type:'int')
			backOrderCode (column:'OBOCOD', type:'TrimString')
			orderWeight (column:'OOWGHT', type:'big_decimal')
			priceOverride (column:'OPROVR', type:'YesBlankType')
			unitPrice (column:'OPRICE', type:'big_decimal')
			unitCost (column:'OCOST', type:'big_decimal')
			priceUnitMeas (column:'OPUNM', type:'TrimString')
			convCode (column:'OCONC', type:'TrimString')
			convFactor (column:'OCONF', type:'int')
			itemDiscPct (column:'OIDISC', type:'big_decimal')
			discDistrCode (column:'ODDIST', type:'TrimString')
			subjToTax1 (column:'OSTXC1', type:'YesBlankType')
			subjToTax2 (column:'OSTXC2', type:'YesBlankType')
			subjToTax3 (column:'OSTXC3', type:'YesBlankType')
			amount (column:'OEXAMT', type:'big_decimal')
			cost (column:'OEXCST', type:'big_decimal')

			custNo (column:'OCUSTR', type:'string')
			shipToNo (column:'OSHIPT', type:'int')
			salesperson1 (column:'OSPER1', type:'string')
			salesperson2 (column:'OSPER2', type:'string')
			invoiceDate (column:'OINYMD', type:'DateYYMMDDUserType')
			commissionPct (column:'OCOMRT', type:'big_decimal')

			returnToStock (column:'ORSTK', type:'TrimString')
			reasonCode (column:'ORSNCD', type:'TrimString')
			nmfcNo (column:'ONMFCN', type:'TrimString')
			discAllowProfitCenter (column:'ODAPC', type:'TrimString')
			discAllowCode (column:'ODACOD', type:'TrimString')
			discAllowEDICode (column:'ODAEDI', type:'TrimString')
			discAllowPct (column:'ODAP', type:'big_decimal')
		}
	}
	boolean newEntity = false
	static transients = ['newEntity']
}
