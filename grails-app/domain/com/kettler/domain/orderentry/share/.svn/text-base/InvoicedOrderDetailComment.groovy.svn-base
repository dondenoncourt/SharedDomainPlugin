package com.kettler.domain.orderentry.share
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class InvoicedOrderDetailComment implements Serializable {
	String compCode
	int orderNo
	int shipNo
	int lineNo
	String lineType
	String desc
	String custNo
	int shipToNo
	String salesperson1
	String salesperson2
	int invoiceCentury
	Date invoiceDate
	String programName
	String printCode
	String printCode2
	String printCode3
	String printCode4
	String printCode5
	String printCode6
	static constraints = {
		compCode(maxSize:2,nullable:false)
		orderNo(max:999999,nullable:false)
		shipNo(max:99,nullable:false)
		lineNo(max:9999,nullable:false)
		lineType(maxSize:1,inList:['C'],nullable:false)
		desc(maxSize:30,nullable:false)
		printCode(maxSize:1,nullable:false)
		custNo(maxSize:7,nullable:false)
		shipToNo(max:9999,nullable:false)
		salesperson1(maxSize:3,nullable:false)
		salesperson2(maxSize:3,nullable:false)
		invoiceCentury(max:99,nullable:false)
		//invoiceYymmdd(max:999999,nullable:false)
		programName(maxSize:10,nullable:false)
		printCode2(maxSize:1,nullable:false)
		printCode3(maxSize:1,nullable:false)
		printCode4(maxSize:1,nullable:false)
		printCode5(maxSize:1,nullable:false)
		printCode6(maxSize:1,nullable:false)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = true
	static mapping = {
		table (name:'oeinv3',schema:CH.config.orderentry.schema)
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
			printCode (column:'OPCOD', type:'TrimString')
			custNo (column:'OCUSTR', type:'TrimString')
			shipToNo (column:'OSHIPT', type:'int')
			salesperson1 (column:'OSPER1', type:'TrimString')
			salesperson2 (column:'OSPER2', type:'TrimString')
			invoiceCentury (column:'OINVCN', type:'int')
			invoiceDate (column:'OINYMD', type:'DateYYMMDDUserType')
			programName (column:'OPGMNM', type:'TrimString')
			printCode2 (column:'OPCOD2', type:'TrimString')
			printCode3 (column:'OPCOD3', type:'TrimString')
			printCode4 (column:'OPCOD4', type:'TrimString')
			printCode5 (column:'OPCOD5', type:'TrimString')
			printCode6 (column:'OPCOD6', type:'TrimString')
		}
	}
	boolean newEntity = false
	static transients = ['newEntity']
}
