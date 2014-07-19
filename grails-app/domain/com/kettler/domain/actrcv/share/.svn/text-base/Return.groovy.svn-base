package com.kettler.domain.actrcv.share
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

import com.kettler.domain.orderentry.share.Carrier
import com.kettler.domain.orderentry.share.ShipVia 

import org.hibernate.type.YesNoType
import com.kettler.domain.actrcv.share.TableCode

public class Return implements Serializable {
	String 			freightTrackingNo
	BigDecimal 		shipHandCustCr = 0.0g
	BigDecimal 		topPriorCustCr = 0.0g
	BigDecimal 		freightCustCr = 0.0g
	int			 	refurbRestockCustDb = 0
	BigDecimal 		freightInCustDb = 0.0g

	String 			freightCustCrDistrCode = ''
	
	BigDecimal		invoiceDisc = 0.0g
	int				invoiceDiscPct = 0
		
	boolean 		manufacturerDb = false 
	boolean 		fieldDestroy = false
	boolean			noRA = false
	String 			warehouse = '1  '
    boolean         hold = false
	
    Date			debitMemoCreated
	Date 			createDate
	String 			createUser
	Date 			changeDate
	String 			changeUser
	Date 			returnDate
	String          receivedBy
	Date 			confirmDate
	String			confirmedBy
	
	Date 			carrierNotifiedDate
			
	boolean 		freightClaim = false
	String			freightClaimNo
	Date			freightClaimSubmit	
	BigDecimal		freightClaimAmount = 0.00g
	Long			freightClaimGLCode
	Date			freightClaimPaid	
	BigDecimal		freightClaimAmountPaid = 0.00g
	String			freightClaimCheckNo
	boolean			freightClaimDenied = false
	
	String 			name
	String 			addr1
	String 			addr2 = ''
	String 			addr3 = ''
	String 			city
	String 			state
	String 			zipCode
	String 			countryCode = 'USA'
	
	String			shippingTerms = PREPAID
	static String PREPAID = 'PREPAID'
	static String COLLECT = 'COLLECT'
	@SuppressWarnings("unchecked")
	static HashMap SHIPPING_TERMS_MAP = [PREPAID:'Prepaid by Customer', COLLECT:'Collect at KETTLER\'s Expense']
	Customer        customer
	Carrier 		carrier
	ReturnStatus 	status
	ShipVia		    shipVia
	
	ReturnFreightDesc shipHandDesc
	ReturnFreightDesc freightDesc
		
	static hasMany = [ items : ReturnItem,
	                   notes : ReturnNote
	                 ]
	                   
	static constraints = {
		shipHandCustCr      max:new BigDecimal("999999.99")
		topPriorCustCr      max:new BigDecimal("999999.99")
		freightCustCr       max:new BigDecimal("999999.99")
		refurbRestockCustDb max:100
		freightInCustDb     max:new BigDecimal("999999.99")
		freightCustCrDistrCode(maxSize:3,inList:["UPS", "FRT", "IHC"],nullable:false)

		invoiceDisc max:new BigDecimal("99.999"), scale:3
		invoiceDiscPct min:0, max:100, 
					validator: { invoiceDiscPct, rtrn ->
						if (invoiceDiscPct && rtrn.invoiceDisc) {
							return "return.invoice.discount.amount.percent.exclusive"
						}
					}	
		
		freightTrackingNo 	maxSize:25, nullable:true, 
							validator: { freightTrackingNo, rtrn ->
								if (['CMPEN','CMDIF'].find {it == freightTrackingNo}) {
									return "return.freightTrackingNo.required"
								}
							}		
		freightClaimNo		nullable:true, maxSize:50
		freightClaimSubmit	nullable:true
		freightClaimAmount	nullable:true
		freightClaimGLCode	nullable:true, max:9999999999999
		freightClaimPaid    nullable:true
        freightClaimAmountPaid nullable:true
		freightClaimCheckNo nullable:true,maxSize:50
		
		warehouse           maxSize:3, nullable:false

		debitMemoCreated    nullable:true
		changeDate 			nullable:true 
		changeUser 			nullable:true,maxSize:30 
		returnDate 			nullable:true 
		receivedBy			nullable:true,maxSize:30
		confirmDate			nullable:true
		confirmedBy			nullable:true,maxSize:30

		shippingTerms		minSize:7, maxSize:7
		carrier	   			nullable:true
		carrierNotifiedDate nullable:true
		shipVia				nullable:true
		
		name				maxSize:30
		addr1				maxSize:30, blank:false, nullable:false
		addr2				maxSize:30,nullable:false
		addr3				maxSize:30,nullable:false
		city				maxSize:15, nullable:false, 
				validator: { city, ra ->
					if (['USA', 'CAN'].find {it == ra.countryCode}) {
						if (!city.size()) { 
							return "kettler.city.blank"
						}
					} 
					return true
				}
		state				maxSize:2,nullable:false, 
				validator: { state, ra ->
					if (['USA', 'CAN'].find {it == ra.countryCode}) {
						if (!state.size()) { 
							return "kettler.state.blank"
						}
					} 
					return true
				}
		zipCode				maxSize:9,nullable:false, 
			validator: { zipCode, ra ->
				if (ra.countryCode == 'USA') {
					if (!(zipCode ==~ /^\d{5,9}$/) ) { 
						return "kettler.zipCode.usa.invalid"
					}
				} else if (ra.countryCode == 'CAN') {
					if (!(zipCode ==~ /^\w{6}$/) && !(zipCode ==~ /^\w{3}\s\w{3}$/)) {
						return "kettler.zipCode.can.invalid"
					}
				}
				return true
			}
		countryCode			minSize:2,maxSize:3,nullable:false
		
		items				nullable:false

		shipHandDesc		nullable:true, validator: {desc, rtrn ->if (rtrn.shipHandCustCr && !desc) return "return.shipHandDesc.required"}
		freightDesc			nullable:true, validator: {desc, rtrn ->if (rtrn.freightCustCr  && !desc)  return "return.freightDesc.required"}
		
	//		validator: {items, rtrn ->if (!items) return "return.items.required"}
	}
	static mapping = {
		table (name:'rtrn',schema:CH.config.accounting.schema)
		shipHandCustCr      column:'hndcstcr'
		topPriorCustCr      column:'topcstcr'
		freightCustCr       column:'fgtcstcr'
		refurbRestockCustDb column:'stkcstdbpc' // was stkcstdb TODO remove stkcstdb in table
		freightInCustDb     column:'fgtincstdb'
			
		freightCustCrDistrCode column:'fgtcrdistr', maxSize:3
			
		invoiceDisc         column:'invdisc'
		invoiceDiscPct		column:'invdiscpct'
		
		manufacturerDb      column:'mfgdb',     type:'org.hibernate.type.YesNoType'
		fieldDestroy        column:'flddestry', type:'org.hibernate.type.YesNoType'
		noRA		        column:'nora', 		type:'org.hibernate.type.YesNoType'
		hold		                            type:'org.hibernate.type.YesNoType'

		notes               column:'notes'
		freightTrackingNo   column:'frttrk'
		carrierNotifiedDate column:'carrcalled'

		shippingTerms		column:'shipterms'
			
		freightClaim        column:'fgtclm',  	type:'org.hibernate.type.YesNoType'
		freightClaimNo		column:'fgtclmno'
		freightClaimSubmit	column:'fgtclmsbm'
		freightClaimAmount  column:'fgtclmamt'
		freightClaimGLCode	column:'fgtclmgl'
		freightClaimPaid    column:'fgtclmpaid'
        freightClaimAmountPaid column:'fgtclmin'
		freightClaimCheckNo column:'fgtclmchk'
		freightClaimDenied  column:'fgtclmrjct',type:'org.hibernate.type.YesNoType'
			
		createDate          column:'createdate' 
		createUser          column:'createuser'
		changeDate          column:'changedate' 
		changeUser          column:'changeuser'
		returnDate          column:'rtrndate'
			
		zipCode				column:'zipcode'
		countryCode			column:'cntrycode'
		shipHandDesc		column:'shphnddsc'
		freightDesc			column:'fghtdsc'

		status				lazy:false
		customer			lazy:false
		carrier				lazy:false
		shipVia				lazy:false
	}

	private BigDecimal sumFreightClaimAmount() {
	   BigDecimal fgtClmAmt = 0.00g
	   items?.each {item ->
	       item?.details.each {dtl ->
            	fgtClmAmt += dtl.freightClaimAmount?:0
	       }
	   }
	   return fgtClmAmt
	}
    def beforeUpdate() {
        freightClaimAmount = sumFreightClaimAmount()
    }

}
