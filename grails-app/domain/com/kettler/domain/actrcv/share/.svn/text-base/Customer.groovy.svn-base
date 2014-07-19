package com.kettler.domain.actrcv.share
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

import org.hibernate.type.YesNoType

class Customer implements Serializable {
	String activeCode = ''
	String compCode = ''
	String custNo = ''
	String name = ''
	String addr1 = ''
	String addr2 = ''
	String addr3 = ''
	String city = ''
	String state = ''
	String zipCode = ''
	String shortName = ''
	String phoneNo = ''
	String faxNo = ''
	String contact = ''
	int monthYearOpened = 0
	String sicCode = ''
	String billingCycle = ''
	String servChgCode = ''
	BigDecimal servChgPct = 0.0g
	String paymentMethod = ''
	String stmtPrintCode = ''
	String collectionCode = ''
	int creditLimit = 0
	String creditRating = ''
	Date lastPmtDate = new Date()
	BigDecimal lastPmtAmnt = 0.0g
	Date lastChgDate = new Date()
	BigDecimal lastChgAmnt = 0.0g
	BigDecimal prevBalance = 0.0g
	BigDecimal currentChgs = 0.0g
	BigDecimal currentPmts = 0.0g
	BigDecimal currentAdjs = 0.0g
	BigDecimal servChgAmt = 0.0g
	BigDecimal servChgBal = 0.0g
	BigDecimal highBalance = 0.0g
	BigDecimal ytdServChg = 0.0g
	BigDecimal futureChgs = 0.0g
	BigDecimal futurePmts = 0.0g
	BigDecimal futureAdjs = 0.0g
	BigDecimal currentDue = 0.0g
	BigDecimal overDue1 = 0.0g
	BigDecimal overDue2 = 0.0g
	BigDecimal overDue3 = 0.0g
	BigDecimal overDue4 = 0.0g
	int nextCrdActNo = 0
	String salespersonCode = ''
	int itemPriceCode = 0
	boolean backOrderCode = false
	String termsCode = ''
	BigDecimal invoiceDiscPct = 0.0g
	boolean taxExempt = false
	String taxExemptCertNo = ''
	String taxCode1 = ''
	String taxCode2 = ''
	String taxCode3 = ''
	Date lastMaintDate = new Date()
	int lastMaintTime = 0
	String lastMaintUserId = ''
	String email = ''
	String salesDivision = ''
	String salesGroup = ''
	String countryCode = ''
	boolean emailInvoiceCode = false
	boolean paperInvoiceCode = false
	Date dateInactivated = new Date()
	String inactivatedUserId = ''
	Date lastAdjDate = new Date()
	BigDecimal lastAdjAmnt = 0.0g
	boolean shipComplete = false
	boolean printPackingList = false
	String packingListCode = ''
	boolean crHoldCode = false
	String crHoldUserId = ''
	Date crHoldDate = new Date()
	boolean sendShippingFile = false
	boolean sendReminderNotice = false
	String preRouteOrders = ''
	String refCode1 = ''
	String refCode2 = ''
	String refCode3 = ''
	String refCode4 = ''
	String countryName = ''
	String varsityGroupId = ''
	String fillOrKillCode = ''
	boolean lineDiscCode = false
	String profitCenter1 = ''
	String profitCenter2 = ''
	String profitCenter3 = ''
	String profitCenter4 = ''
	String profitCenter5 = ''
	BigDecimal lineDisc1 = 0.0g
	BigDecimal lineDisc2 = 0.0g
	BigDecimal lineDisc3 = 0.0g
	BigDecimal lineDisc4 = 0.0g
	BigDecimal lineDisc5 = 0.0g
	String fulfillCode = ''
	String fulfillWhse = ''
	String crCardOnFile = ''
	static constraints = {
		activeCode(maxSize:1,nullable:false)
		compCode(blank:false, maxSize:2,nullable:false)
		custNo(maxSize:7,nullable:false)
		name(blank:false,maxSize:30,nullable:false)
		addr1(minSize:1,maxSize:30,nullable:false, 
			validator: { addr1, cust ->
				if (!addr1.size()) {
					return "kettler.addr1.invalid"
				}
			}
		)
		addr2(maxSize:30,nullable:false)
		addr3(maxSize:30,nullable:false)
		city(maxSize:15,nullable:false, 
			validator: { city, cust ->
				if (['USA', 'CAN'].find {it == cust.countryCode}) {
					if (!city.size()) { 
						return "kettler.city.blank"
					}
				} 
				return true
			}
		)
		state(minSize:2,maxSize:2,nullable:false, 
			validator: { state, cust ->
				if (['USA', 'CAN'].find {it == cust.countryCode}) {
					if (!state.size()) { 
						return "kettler.state.blank"
					}
				} 
				return true
			}
		)
		zipCode(maxSize:9,nullable:false, 
			validator: { zipCode, cust ->
				if (cust.countryCode == 'USA') {
					if (!(zipCode ==~ /^\d{5,9}$/) ) { 
						return "kettler.zipCode.usa.invalid"
					}
				} else if (cust.countryCode == 'CAN') {
					if (!(zipCode ==~ /^\w{6}$/) ) { //TODO, what about embedded space{s) 
						return "kettler.zipCode.can.invalid"
					}
				}
				return true
			}
		)
		shortName(minSize:2,maxSize:10,nullable:false, 
			validator: { shortName, cust ->
				if (shortName.size() < 2) {
					return "kettler.shortName.invalid"
				}
			}
		)
		phoneNo(maxSize:10,nullable:false)
		faxNo(maxSize:10,nullable:false)
		contact(maxSize:20,nullable:false)
		monthYearOpened(max:9999,nullable:false)
		sicCode(maxSize:4,nullable:false)
		billingCycle(maxSize:1,nullable:false)
		servChgCode(maxSize:1,nullable:false)
		servChgPct(max:new BigDecimal("99.99"),nullable:false)
		paymentMethod(maxSize:1,nullable:false)
		stmtPrintCode(maxSize:1,nullable:false)
		collectionCode(maxSize:1,nullable:false)
		creditLimit(max:99999999,nullable:false)
		creditRating(maxSize:4,nullable:false)
		lastPmtDate(nullable:false)
		lastPmtAmnt(max:new BigDecimal("9999999.99"),nullable:false)
		lastChgDate(nullable:false)
		lastChgAmnt(max:new BigDecimal("9999999.99"),nullable:false)
		prevBalance(max:new BigDecimal("99999999.99"),nullable:false)
		currentChgs(max:new BigDecimal("99999999.99"),nullable:false)
		currentPmts(max:new BigDecimal("99999999.99"),nullable:false)
		currentAdjs(max:new BigDecimal("99999999.99"),nullable:false)
		servChgAmt(max:new BigDecimal("99999.99"),nullable:false)
		servChgBal(max:new BigDecimal("99999999.99"),nullable:false)
		highBalance(max:new BigDecimal("99999999.99"),nullable:false)
		ytdServChg(max:new BigDecimal("9999999.99"),nullable:false)
		futureChgs(max:new BigDecimal("99999999.99"),nullable:false)
		futurePmts(max:new BigDecimal("99999999.99"),nullable:false)
		futureAdjs(max:new BigDecimal("99999999.99"),nullable:false)
		currentDue(max:new BigDecimal("99999999.99"),nullable:false)
		overDue1(max:new BigDecimal("99999999.99"),nullable:false)
		overDue2(max:new BigDecimal("99999999.99"),nullable:false)
		overDue3(max:new BigDecimal("99999999.99"),nullable:false)
		overDue4(max:new BigDecimal("99999999.99"),nullable:false)
		nextCrdActNo(max:99999,nullable:false)
		salespersonCode(blank:false,maxSize:3,nullable:false)
		itemPriceCode(max:9,nullable:false)
		backOrderCode(maxSize:1,nullable:false)
		termsCode(blank:false,maxSize:3,nullable:false)
		invoiceDiscPct(max:new BigDecimal("99.99"),nullable:false)
		taxExempt(maxSize:1,nullable:false)
		taxExemptCertNo(maxSize:15,nullable:false)
		taxCode1(maxSize:3,nullable:false)
		taxCode2(maxSize:3,nullable:false)
		taxCode3(maxSize:3,nullable:false)
		lastMaintDate(nullable:false)
		lastMaintTime(max:999999,nullable:false)
		lastMaintUserId(maxSize:10,nullable:false)
		email(maxSize:50,email:true,nullable:false)
		salesDivision(blank:false,maxSize:1,nullable:false)
		salesGroup(maxSize:3,nullable:false)
		countryCode(blank:false,maxSize:3,nullable:false)
		emailInvoiceCode(maxSize:1,nullable:false, 
			validator: { emailInvoiceCode, cust ->
				if (emailInvoiceCode && !cust.email.trim().size()) {
					return "kettler.emailInvoiceCode.email.required"
				}
				return true
			}
		)
		paperInvoiceCode(maxSize:1,nullable:false)
		dateInactivated(nullable:false)
		inactivatedUserId(maxSize:10,nullable:false)
		lastAdjDate(nullable:false)
		lastAdjAmnt(max:new BigDecimal("9999999.99"),nullable:false)
		shipComplete(maxSize:1,nullable:false)
		printPackingList(maxSize:1,nullable:false)
		packingListCode(maxSize:2,nullable:false)
		crHoldCode(maxSize:1,nullable:false)
		crHoldUserId(maxSize:10,nullable:false)
		crHoldDate(nullable:false)
		sendShippingFile(maxSize:1,nullable:false)
		sendReminderNotice(maxSize:1,nullable:false)
		preRouteOrders(maxSize:1,nullable:false)
		refCode1(maxSize:2,nullable:false)
		refCode2(maxSize:2,nullable:false)
		refCode3(maxSize:2,nullable:false)
		refCode4(maxSize:2,nullable:false)
		countryName(maxSize:30,nullable:false)
		varsityGroupId(maxSize:4,nullable:false)
		fillOrKillCode(maxSize:1,nullable:false)
		lineDiscCode(maxSize:1,nullable:false)
		profitCenter1(maxSize:1,nullable:false)
		profitCenter2(maxSize:1,nullable:false)
		profitCenter3(maxSize:1,nullable:false)
		profitCenter4(maxSize:1,nullable:false)
		profitCenter5(maxSize:1,nullable:false)
		lineDisc1(max:new BigDecimal("99.9"),nullable:false)
		lineDisc2(max:new BigDecimal("99.9"),nullable:false)
		lineDisc3(max:new BigDecimal("99.9"),nullable:false)
		lineDisc4(max:new BigDecimal("99.9"),nullable:false)
		lineDisc5(max:new BigDecimal("99.9"),nullable:false)
		fulfillCode(maxSize:1,nullable:false)
		fulfillWhse(maxSize:3,nullable:false)
		crCardOnFile(maxSize:1,nullable:false)
	}
	static mapping = {
		table (name:'custmast',schema:CH.config.accounting.schema)
		columns {
			activeCode (column:'MACTV', type:'TrimString')
			compCode (column:'MCOMP', type:'TrimString')
			custNo (column:'MCUST', type:'TrimString')
			name (column:'MNAME', type:'TrimString')
			addr1 (column:'MADDR1', type:'TrimString')
			addr2 (column:'MADDR2', type:'TrimString')
			addr3 (column:'MADDR3', type:'TrimString')
			city (column:'MCITY', type:'TrimString')
			state (column:'MSTAT', type:'TrimString')
			zipCode (column:'MZIPC', type:'TrimString')
			shortName (column:'MSHRT', type:'TrimString')
			phoneNo (column:'MPHONE', type:'TrimString')
			faxNo (column:'MFAXNO', type:'TrimString')
			contact (column:'MCNTCT', type:'TrimString')
			monthYearOpened (column:'MDATOP', type:'int')
			sicCode (column:'MSICCD', type:'TrimString')
			billingCycle (column:'MCYCLE', type:'TrimString')
			servChgCode (column:'MSCCOD', type:'TrimString')
			servChgPct (column:'MSCPCT', type:'big_decimal')
			paymentMethod (column:'MPMETH', type:'TrimString')
			stmtPrintCode (column:'MNOSTM', type:'TrimString')
			collectionCode (column:'MCOLCD', type:'TrimString')
			creditLimit (column:'MCRLIM', type:'int')
			creditRating (column:'MCRRAT', type:'TrimString')
			lastPmtDate (column:'MLPDAT', type:'DateMMDDYYUserType')
			lastPmtAmnt (column:'MLPAMT', type:'big_decimal')
			lastChgDate (column:'MLCDAT', type:'DateMMDDYYUserType')
			lastChgAmnt (column:'MLCAMT', type:'big_decimal')
			prevBalance (column:'MPRBAL', type:'big_decimal')
			currentChgs (column:'MCCHGS', type:'big_decimal')
			currentPmts (column:'MCPMTS', type:'big_decimal')
			currentAdjs (column:'MCADJS', type:'big_decimal')
			servChgAmt (column:'MSRCHG', type:'big_decimal')
			servChgBal (column:'MSRBAL', type:'big_decimal')
			highBalance (column:'MHIBAL', type:'big_decimal')
			ytdServChg (column:'MYSCHG', type:'big_decimal')
			futureChgs (column:'MFCHGS', type:'big_decimal')
			futurePmts (column:'MFPMTS', type:'big_decimal')
			futureAdjs (column:'MFADJS', type:'big_decimal')
			currentDue (column:'MCURDU', type:'big_decimal')
			overDue1 (column:'MOVR01', type:'big_decimal')
			overDue2 (column:'MOVR02', type:'big_decimal')
			overDue3 (column:'MOVR03', type:'big_decimal')
			overDue4 (column:'MOVR04', type:'big_decimal')
			nextCrdActNo (column:'MNXTCR', type:'int')
			salespersonCode (column:'MSPCOD', type:'TrimString')
			itemPriceCode (column:'MPRCOD', type:'int')
			backOrderCode (column:'MBOCOD', type:'YesBlankType')
			termsCode (column:'MTMCOD', type:'string')
			invoiceDiscPct (column:'MINDIS', type:'big_decimal')
			taxExempt (column:'MTXEXM', type:'YesBlankType')
			taxExemptCertNo (column:'MTXEXC', type:'TrimString')
			taxCode1 (column:'MTXCD1', type:'TrimString')
			taxCode2 (column:'MTXCD2', type:'TrimString')
			taxCode3 (column:'MTXCD3', type:'TrimString')
			lastMaintDate (column:'MMDATE', type:'DateMMDDYYUserType')
			lastMaintTime (column:'MMTIME', type:'int')
			lastMaintUserId (column:'MMUSER', type:'TrimString')
			email (column:'MEMAIL', type:'TrimString')
			salesDivision (column:'MSDIV', type:'TrimString')
			salesGroup (column:'MSGRP', type:'TrimString')
			countryCode (column:'MCNTRY', type:'TrimString')
			emailInvoiceCode (column:'MEINVC', type:'org.hibernate.type.YesNoType')
			paperInvoiceCode (column:'MPINVC', type:'org.hibernate.type.YesNoType')
			dateInactivated (column:'MIDATE', type:'DateMMDDYYUserType')
			inactivatedUserId (column:'MIUSER', type:'TrimString')
			lastAdjDate (column:'MLADAT', type:'DateMMDDYYUserType')
			lastAdjAmnt (column:'MLAAMT', type:'big_decimal')
			shipComplete (column:'MSCMPL', type:'YesBlankType')
			printPackingList (column:'MPRTPL', type:'YesBlankType')
			packingListCode (column:'MPLCD', type:'TrimString')
			crHoldCode (column:'MCHCD', type:'org.hibernate.type.YesNoType')
			crHoldUserId (column:'MCHUSR', type:'TrimString')
			crHoldDate (column:'MCHDAT', type:'DateMMDDYYUserType')
			sendShippingFile (column:'MSNDSF', type:'YesBlankType')
			sendReminderNotice (column:'MSNDRN', type:'YesBlankType')
			preRouteOrders (column:'MPRERT', type:'TrimString')
			refCode1 (column:'MREF1', type:'TrimString')
			refCode2 (column:'MREF2', type:'TrimString')
			refCode3 (column:'MREF3', type:'TrimString')
			refCode4 (column:'MREF4', type:'TrimString')
			countryName (column:'MCNTNM', type:'TrimString')
			varsityGroupId (column:'MGRID', type:'TrimString')
			fillOrKillCode (column:'MFORK', type:'TrimString')
			lineDiscCode (column:'MLDISC', type:'YesBlankType')
			profitCenter1 (column:'MLDPC1', type:'TrimString')
			profitCenter2 (column:'MLDPC2', type:'TrimString')
			profitCenter3 (column:'MLDPC3', type:'TrimString')
			profitCenter4 (column:'MLDPC4', type:'TrimString')
			profitCenter5 (column:'MLDPC5', type:'TrimString')
			lineDisc1 (column:'MLDDP1', type:'big_decimal')
			lineDisc2 (column:'MLDDP2', type:'big_decimal')
			lineDisc3 (column:'MLDDP3', type:'big_decimal')
			lineDisc4 (column:'MLDDP4', type:'big_decimal')
			lineDisc5 (column:'MLDDP5', type:'big_decimal')
			fulfillCode (column:'MFCODE', type:'TrimString')
			fulfillWhse (column:'MFWHSE', type:'TrimString')
			crCardOnFile (column:'MCCOF', type:'TrimString')
		}
	}
	String toString() {
		if (countryCode == 'USA') {
			return "$custNo: $name, $city, $state"
		}
		return "$custNo: $name, $countryName"
	}
}
