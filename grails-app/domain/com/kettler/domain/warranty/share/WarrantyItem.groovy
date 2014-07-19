package com.kettler.domain.warranty.share;
//use schema:CH.config.[config.groovy custom variable] to soft-code library
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class WarrantyItem implements Serializable {
	String custNo
	int sequenceNo
	String compCode
	String itemNo
	String itemDesc
	String retailerNo = ''
	String retailerName = 'KETTLER WEB'
	Date purchaseDate
	int purchaseQty
	String unitOfMeasure = 'EA'
//	WarrantyPeriod period 
	String warrantyCode
	Date expirationDate
	boolean serializedCode = false
	static constraints = {
		custNo(maxSize:7,nullable:false)
		sequenceNo(max:999,nullable:false)
		compCode(maxSize:2,nullable:false)
		itemNo(maxSize:15,nullable:false)
		itemDesc(maxSize:30,nullable:false)
		retailerNo(maxSize:7,nullable:false)
		retailerName(maxSize:30,nullable:false)
		purchaseQty(max:9999,nullable:false)
		unitOfMeasure(maxSize:3,nullable:false)
//		warrantyCode(maxSize:2,nullable:false)
		serializedCode(maxSize:1,nullable:false)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = true
	static mapping = {
		table name:'wwitem', schema:CH.config?.warranty?.schema
		version (false)
		id (generator:'assigned')
		id (composite:['custNo','sequenceNo'])
		columns {
			id (composite:['custNo','sequenceNo'])
			custNo (column:'WCUSID', type:'TrimString')
			sequenceNo (column:'WSEQN', type:'int')
			compCode (column:'WCOMP', type:'TrimString')
			itemNo (column:'WITEM', type:'TrimString')
			itemDesc (column:'WDESC', type:'TrimString')
			retailerNo (column:'WRTLR', type:'TrimString')
			retailerName (column:'WRNAME', type:'TrimString')
			purchaseDate (column:'WPDATE', type:'DateMMDDYYUserType')
			purchaseQty (column:'WPQTY', type:'int')
			unitOfMeasure (column:'WUNM', type:'TrimString')
			warrantyCode (column:'WWCODE', type:'TrimString')
			period (column:'WWCODE', type:'TrimString')
			expirationDate (column:'WXDATE', type:'DateMMDDYYUserType')
			serializedCode (column:'WSERCD', type:'org.hibernate.type.YesNoType')
		}
	}
	boolean newEntity = false
	static transients = ['newEntity', 'warrantyPeriod']
	WarrantyPeriod getWarrantyPeriod() {
		return WarrantyPeriod.get(warrantyCode)
	}
	private void setWarrantyPeriod(String ignore) {} 
}