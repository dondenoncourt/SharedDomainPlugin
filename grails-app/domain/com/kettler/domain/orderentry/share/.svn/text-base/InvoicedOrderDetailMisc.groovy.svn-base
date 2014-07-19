package com.kettler.domain.orderentry.share
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class InvoicedOrderDetailMisc implements Serializable {
	String compCode
	int orderNo
	int shipNo
	int lineNo
	String lineType
	String desc
	String distrCode
	String printCode
	BigDecimal amount
	BigDecimal cost
	boolean subjToTax1 = false
	boolean subjToTax2 = false
	boolean subjToTax3 = false
	String custNo
	int shipToNo
	String salesperson1
	String salesperson2
	int invoiceCentury
	Date invoiceDate
	String toString() {"$compCode:$orderNo:$shipNo:$lineNo:$lineType:$desc:$distrCode amount:$amount, cost:$cost"	}
	static constraints = {
		compCode(maxSize:2,nullable:false)
		orderNo(max:999999,nullable:false)
		shipNo(max:99,nullable:false)
		lineNo(max:9999,nullable:false)
		lineType(maxSize:1,nullable:false)
		desc(maxSize:30,nullable:false)
		distrCode(maxSize:3,nullable:false)
		printCode(maxSize:1,nullable:false)
		amount(max:new BigDecimal("9999999.99"),nullable:false)
		cost(max:new BigDecimal("9999999.99"),nullable:false)
		subjToTax1(maxSize:1,nullable:false)
		subjToTax2(maxSize:1,nullable:false)
		subjToTax3(maxSize:1,nullable:false)
		custNo(maxSize:7,nullable:false)
		shipToNo(max:9999,nullable:false)
		salesperson1(maxSize:3,nullable:false)
		salesperson2(maxSize:3,nullable:false)
		invoiceCentury(max:99,nullable:false)
		//invoiceDate(max:999999,nullable:false)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = true
	static mapping = {
		table (name:'oeinv2',schema:CH.config.orderentry.schema)
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
			desc (column:'ODESC', type:'TrimString')
			distrCode (column:'ODIST', type:'TrimString')
			printCode (column:'OPCOD', type:'TrimString')
			amount (column:'OEXAMT', type:'big_decimal')
			cost (column:'OEXCST', type:'big_decimal')
			subjToTax1 (column:'OSTXC1', type:'YesBlankType')
			subjToTax2 (column:'OSTXC2', type:'YesBlankType')
			subjToTax3 (column:'OSTXC3', type:'YesBlankType')
			custNo (column:'OCUSTR', type:'TrimString')
			shipToNo (column:'OSHIPT', type:'int')
			salesperson1 (column:'OSPER1', type:'TrimString')
			salesperson2 (column:'OSPER2', type:'TrimString')
			invoiceCentury (column:'OINVCN', type:'int')
			invoiceDate (column:'OINYMD', type:'DateYYMMDDUserType')
		}
	}
	boolean newEntity = false
	static transients = ['newEntity']
}
