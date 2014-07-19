package com.kettler.domain.varsity.share;

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import org.systemitools.types.*

class ShippingManifest implements Serializable {
	String compCode = ''
	String orderType = ''
	String orderShipNo = ''
	String subOrder = ''
	String invoiceNo = ''
	String poNo = ''
	String shipNo = ''
	String residentialFlag = ''
	String custNo = ''
	String hdqtrsNo = ''
	String shipToNo = ''
	String custName = ''
	String custAddr1 = ''
	String custAddr2 = ''
	String custAddr3 = ''
	String custAddr4 = ''
	String custAddr5 = ''
	String shipToCity = ''
	String shipToStateCode = ''
	String shipToPostalCd = ''
	String shipToCountry = ''
	String recipientTelephoneNo = ''
	String shipToContactName = ''
	String custZone = ''
	String regionZone = ''
	String relToShipperY_n = ''
	String shipperNo = ''
	String carrierCode = ''
	String serviceType = ''
	String originalSvcTypeQuestion = ''
	String shippingInstruction = ''
	BigDecimal orderValue = 0.0g
	BigDecimal shipValue = 0.0g
	BigDecimal invoiceAmount = 0.0g
	String userId = ''
	String warehouse = ''
	String groupId = ''
	String currency = ''
	String status = ''
	String mode = ''
	String holdCode = ''
	String fedexHoldAtStation = ''
	String termsCode = ''
	String prepayFlag = ''
	String fdxBillRecipientFlag = ''
	String recipientAccountNo = ''
	int frtChgLinNo
	String rateFileMember = ''
	int ccExpirationDate
	String creditCardNo = ''
	int boxesInput
	int boxesCounted
	BigDecimal totalWeight = 0.0g
	String weightUnitFlag = ''
	BigDecimal weightActual = 0.0g
	BigDecimal weightBillable = 0.0g
	BigDecimal weightRounded = 0.0g
	String boxValOverride = ''
	String hazardousFlag = ''
	String shipFromCustomer = ''
	String shipFromAddr1 = ''
	String shipFromAddr2 = ''
	String shipFromAddr3 = ''
	String shipFromCity = ''
	String shipFromState = ''
	String shipFromPostalCd = ''
	String shipFrPostalCd = ''
	String shipFromCountry = ''
	String shipFromPhone = ''
	String shipFromContactNm = ''
	String authorizedPerson = ''
	String authorizedTitle = ''
	int shipDate
	int shipTime
	int shipDate2
	int weighDate
	String orderTrackCode = ''
	String shipmentTrackingNo = ''
	String proNo = ''
	BigDecimal pureFreight = 0.0g
	BigDecimal actualFrtChg = 0.0g
	String surchargeType = ''
	BigDecimal surchargeTotal = 0.0g
	BigDecimal cwtCharge = 0.0g
	BigDecimal custFrtChg = 0.0g
	BigDecimal discAmount = 0.0g
	BigDecimal discPerc = 0.0g
	BigDecimal taxAmount = 0.0g
	BigDecimal taxPercent = 0.0g
	String codFlag = ''
	String fdxCodCode = ''
	String codLblEachBoxQuestion = ''
	String codValOverride = ''
	String cashFlag = ''
	String mhccod = ''
	String manifestPrt = ''
	String manifestNbr = ''
	int manifestPrintYmd
	int manifestPrintYmd2
	int manifestPrintHms
	String freightCode = ''
	String billOfLadingNo = ''
	String trailerNo = ''
	int mileage
	String vehicleNbr = ''
	String sealNbr = ''
	String uccLabelType = ''
	int asnTransDate
	int asnTransTime
	String asnTransStatus = ''
	String pall_contLabelFlag = ''
	String packingListFlag = ''
	String miscAlphaA = ''
	String miscAlphaB = ''
	BigDecimal miscNo1 = 0.0g
	BigDecimal miscNo2 = 0.0g
	BigDecimal charge1 = 0.0g
	BigDecimal charge2 = 0.0g
	BigDecimal charge3 = 0.0g
	BigDecimal charge4 = 0.0g
	BigDecimal charge5 = 0.0g
	String userAlphaA = ''
	String userAlphaB = ''
	BigDecimal userNumeric1 = 0.0g
	BigDecimal userNumeric2 = 0.0g
	String altAddressType = ''
	String altCustNo = ''
	String altHdqtNo = ''
	String altShptoNumbr = ''
	String altAddrContact = ''
	String altAddrName = ''
	String altAddress1 = ''
	String altAddress2 = ''
	String altAddress3 = ''
	String altAddrCity = ''
	String altAddrState = ''
	String altAddrPostalCd = ''
	String altAddrCountry = ''
	String altAddrPhone = ''
	String altAddrIdType = ''
	String altAddrIdNbr = ''
	String altAddrAcctNo = ''
	String altRelatedToShpr = ''
	String shipNotifLevel = ''
	String shipNotifDest1 = ''
	String emailAddress1 = ''
	String shipNotifDest2 = ''
	String emailAddress2 = ''
	String faxDest1 = ''
	String faxNo1 = ''
	String faxAttnTo1 = ''
	String faxCompany1 = ''
	String faxContactNo1 = ''
	String faxDest2 = ''
	String faxNo2 = ''
	String faxAttnTo2 = ''
	String faxCompany2 = ''
	String faxContactNo2 = ''
	String memoField = ''
	String shipReferType1 = ''
	String shipReferNo1 = ''
	String shipReferType2 = ''
	String shipReferNo2 = ''
	String bundleNo = ''
	String packControl = ''
	String updateFlag = ''
	String processingType = ''
	String lblPrtFlag = ''
	String addrPtrId = ''
	String codPtrId = ''
	String manifestPtrId = ''
	String commitmentFlag = ''
	int commitDate
	int commitTime
	String ipAddress = ''
	int portNo
	int dateAddedToFile
	int timeAddedToFile
	String addedByUserId = ''
	int dateUpdated
	int timeUpdated
	String updatedByUserId = ''
	String userModAction = ''
	int userModDate
	int userModTime
	String userModDspStn = ''


	static constraints = {
		compCode(maxSize:4,nullable:false)
		orderType(maxSize:1,nullable:false)
		orderShipNo(maxSize:10,nullable:false)
		subOrder(maxSize:20,nullable:false)
		invoiceNo(maxSize:6,nullable:false)
		poNo(maxSize:20,nullable:false)
		shipNo(maxSize:20,nullable:false)
		residentialFlag(maxSize:1,nullable:false)
		custNo(maxSize:10,nullable:false)
		hdqtrsNo(maxSize:3,nullable:false)
		shipToNo(maxSize:10,nullable:false)
		custName(maxSize:40,nullable:false)
		custAddr1(maxSize:40,nullable:false)
		custAddr2(maxSize:40,nullable:false)
		custAddr3(maxSize:40,nullable:false)
		custAddr4(maxSize:40,nullable:false)
		custAddr5(maxSize:40,nullable:false)
		shipToCity(maxSize:35,nullable:false)
		shipToStateCode(maxSize:2,nullable:false)
		shipToPostalCd(maxSize:12,nullable:false)
		shipToCountry(maxSize:2,nullable:false)
		recipientTelephoneNo(maxSize:15,nullable:false)
		shipToContactName(maxSize:40,nullable:false)
		custZone(maxSize:2,nullable:false)
		regionZone(maxSize:10,nullable:false)
		relToShipperY_n(maxSize:1,nullable:false)
		shipperNo(maxSize:15,nullable:false)
		carrierCode(maxSize:5,nullable:false)
		serviceType(maxSize:2,nullable:false)
		originalSvcTypeQuestion(maxSize:2,nullable:false)
		shippingInstruction(maxSize:15,nullable:false)
		orderValue(max:new BigDecimal("999999999.999999"),nullable:false)
		shipValue(max:new BigDecimal("999999999.999999"),nullable:false)
		invoiceAmount(max:new BigDecimal("999999999.999999"),nullable:false)
		userId(maxSize:10,nullable:false)
		warehouse(maxSize:10,nullable:false)
		groupId(maxSize:4,nullable:false)
		currency(maxSize:3,nullable:false)
		status(maxSize:1,nullable:false)
		mode(maxSize:15,nullable:false)
		holdCode(maxSize:1,nullable:false)
		fedexHoldAtStation(maxSize:1,nullable:false)
		termsCode(maxSize:2,nullable:false)
		prepayFlag(maxSize:1,nullable:false)
		fdxBillRecipientFlag(maxSize:1,nullable:false)
		recipientAccountNo(maxSize:15,nullable:false)
		frtChgLinNo(max:999,nullable:false)
		rateFileMember(maxSize:15,nullable:false)
		ccExpirationDate(max:99999999,nullable:false)
		creditCardNo(maxSize:20,nullable:false)
		boxesInput(max:9999999,nullable:false)
		boxesCounted(max:9999999,nullable:false)
		totalWeight(max:new BigDecimal("9999999.99"),nullable:false)
		weightUnitFlag(maxSize:1,nullable:false)
		weightActual(max:new BigDecimal("9999999.9999"),nullable:false)
		weightBillable(max:new BigDecimal("9999999.9999"),nullable:false)
		weightRounded(max:new BigDecimal("9999999.9999"),nullable:false)
		boxValOverride(maxSize:1,nullable:false)
		hazardousFlag(maxSize:1,nullable:false)
		shipFromCustomer(maxSize:40,nullable:false)
		shipFromAddr1(maxSize:40,nullable:false)
		shipFromAddr2(maxSize:40,nullable:false)
		shipFromAddr3(maxSize:40,nullable:false)
		shipFromCity(maxSize:35,nullable:false)
		shipFromState(maxSize:2,nullable:false)
		shipFromPostalCd(maxSize:12,nullable:false)
		shipFrPostalCd(maxSize:5,nullable:false)
		shipFromCountry(maxSize:2,nullable:false)
		shipFromPhone(maxSize:15,nullable:false)
		shipFromContactNm(maxSize:40,nullable:false)
		authorizedPerson(maxSize:35,nullable:false)
		authorizedTitle(maxSize:35,nullable:false)
		shipDate(max:999999,nullable:false)
		shipTime(max:999999,nullable:false)
		shipDate2(max:99999999,nullable:false)
		weighDate(max:99999999,nullable:false)
		orderTrackCode(maxSize:4,nullable:false)
		shipmentTrackingNo(maxSize:15,nullable:false)
		proNo(maxSize:35,nullable:false)
		pureFreight(max:new BigDecimal("999999999.9999"),nullable:false)
		actualFrtChg(max:new BigDecimal("999999999.999999"),nullable:false)
		surchargeType(maxSize:1,nullable:false)
		surchargeTotal(max:new BigDecimal("9999999.9999"),nullable:false)
		cwtCharge(max:new BigDecimal("99999.99"),nullable:false)
		custFrtChg(max:new BigDecimal("999999999.999999"),nullable:false)
		discAmount(max:new BigDecimal("9999999.9999"),nullable:false)
		discPerc(max:new BigDecimal("999.9999"),nullable:false)
		taxAmount(max:new BigDecimal("9999999.9999"),nullable:false)
		taxPercent(max:new BigDecimal("999.9999"),nullable:false)
		codFlag(maxSize:1,nullable:false)
		fdxCodCode(maxSize:1,nullable:false)
		codLblEachBoxQuestion(maxSize:1,nullable:false)
		codValOverride(maxSize:1,nullable:false)
		cashFlag(maxSize:1,nullable:false)
		mhccod(maxSize:1,nullable:false)
		manifestPrt(maxSize:1,nullable:false)
		manifestNbr(maxSize:15,nullable:false)
		manifestPrintYmd(max:999999,nullable:false)
		manifestPrintYmd2(max:99999999,nullable:false)
		manifestPrintHms(max:999999,nullable:false)
		freightCode(maxSize:2,nullable:false)
		billOfLadingNo(maxSize:15,nullable:false)
		trailerNo(maxSize:10,nullable:false)
		mileage(max:99999,nullable:false)
		vehicleNbr(maxSize:12,nullable:false)
		sealNbr(maxSize:12,nullable:false)
		uccLabelType(maxSize:1,nullable:false)
		asnTransDate(max:99999999,nullable:false)
		asnTransTime(max:999999,nullable:false)
		asnTransStatus(maxSize:1,nullable:false)
		pall_contLabelFlag(maxSize:1,nullable:false)
		packingListFlag(maxSize:1,nullable:false)
		miscAlphaA(maxSize:30,nullable:false)
		miscAlphaB(maxSize:30,nullable:false)
		miscNo1(max:new BigDecimal("999999999.9999"),nullable:false)
		miscNo2(max:new BigDecimal("999999999.9999"),nullable:false)
		charge1(max:new BigDecimal("999999999.9999"),nullable:false)
		charge2(max:new BigDecimal("999999999.9999"),nullable:false)
		charge3(max:new BigDecimal("999999999.9999"),nullable:false)
		charge4(max:new BigDecimal("999999999.9999"),nullable:false)
		charge5(max:new BigDecimal("999999999.9999"),nullable:false)
		userAlphaA(maxSize:15,nullable:false)
		userAlphaB(maxSize:15,nullable:false)
		userNumeric1(max:new BigDecimal("99999.99"),nullable:false)
		userNumeric2(max:new BigDecimal("99999.99"),nullable:false)
		altAddressType(maxSize:2,nullable:false)
		altCustNo(maxSize:10,nullable:false)
		altHdqtNo(maxSize:3,nullable:false)
		altShptoNumbr(maxSize:10,nullable:false)
		altAddrContact(maxSize:40,nullable:false)
		altAddrName(maxSize:40,nullable:false)
		altAddress1(maxSize:40,nullable:false)
		altAddress2(maxSize:40,nullable:false)
		altAddress3(maxSize:40,nullable:false)
		altAddrCity(maxSize:35,nullable:false)
		altAddrState(maxSize:2,nullable:false)
		altAddrPostalCd(maxSize:12,nullable:false)
		altAddrCountry(maxSize:2,nullable:false)
		altAddrPhone(maxSize:15,nullable:false)
		altAddrIdType(maxSize:1,nullable:false)
		altAddrIdNbr(maxSize:20,nullable:false)
		altAddrAcctNo(maxSize:20,nullable:false)
		altRelatedToShpr(maxSize:1,nullable:false)
		shipNotifLevel(maxSize:1,nullable:false)
		shipNotifDest1(maxSize:1,nullable:false)
		emailAddress1(maxSize:50,nullable:false)
		shipNotifDest2(maxSize:1,nullable:false)
		emailAddress2(maxSize:50,nullable:false)
		faxDest1(maxSize:1,nullable:false)
		faxNo1(maxSize:15,nullable:false)
		faxAttnTo1(maxSize:35,nullable:false)
		faxCompany1(maxSize:35,nullable:false)
		faxContactNo1(maxSize:15,nullable:false)
		faxDest2(maxSize:1,nullable:false)
		faxNo2(maxSize:15,nullable:false)
		faxAttnTo2(maxSize:35,nullable:false)
		faxCompany2(maxSize:35,nullable:false)
		faxContactNo2(maxSize:15,nullable:false)
		memoField(maxSize:150,nullable:false)
		shipReferType1(maxSize:2,nullable:false)
		shipReferNo1(maxSize:35,nullable:false)
		shipReferType2(maxSize:2,nullable:false)
		shipReferNo2(maxSize:35,nullable:false)
		bundleNo(maxSize:9,nullable:false)
		packControl(maxSize:35,nullable:false)
		updateFlag(maxSize:1,nullable:false)
		processingType(maxSize:2,nullable:false)
		lblPrtFlag(maxSize:1,nullable:false)
		addrPtrId(maxSize:10,nullable:false)
		codPtrId(maxSize:10,nullable:false)
		manifestPtrId(maxSize:10,nullable:false)
		commitmentFlag(maxSize:1,nullable:false)
		commitDate(max:99999999,nullable:false)
		commitTime(max:999999,nullable:false)
		ipAddress(maxSize:30,nullable:false)
		portNo(max:99999,nullable:false)
		dateAddedToFile(max:99999999,nullable:false)
		timeAddedToFile(max:999999,nullable:false)
		addedByUserId(maxSize:10,nullable:false)
		dateUpdated(max:99999999,nullable:false)
		timeUpdated(max:999999,nullable:false)
		updatedByUserId(maxSize:10,nullable:false)
		userModAction(maxSize:1,nullable:false)
		userModDate(max:99999999,nullable:false)
		userModTime(max:999999,nullable:false)
		userModDspStn(maxSize:10,nullable:false)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = true
	static mapping = {
		table name:'mfh1mh', schema:CH.config.varsity.schema
		version (false)
		id (generator:'assigned')
		id (composite:['compCode','orderType','orderShipNo'])
		columns {
			id (composite:['compCode','orderType','orderShipNo'])
			compCode (column:'MHCMNO', type:'TrimString')
			orderType (column:'MHOTYP', type:'TrimString')
			orderShipNo (column:'MHORDR', type:'TrimString')
			subOrder (column:'MHORD2', type:'TrimString')
			invoiceNo (column:'MHINVN', type:'TrimString')
			poNo (column:'MHPNBR', type:'TrimString')
			shipNo (column:'MHSHMT', type:'TrimString')
			residentialFlag (column:'MHRSDL', type:'TrimString')
			custNo (column:'MHCUST', type:'TrimString')
			hdqtrsNo (column:'MHCHDQ', type:'TrimString')
			shipToNo (column:'MHSHPT', type:'TrimString')
			custName (column:'MHCNAM', type:'TrimString')
			custAddr1 (column:'MHCAD1', type:'TrimString')
			custAddr2 (column:'MHCAD2', type:'TrimString')
			custAddr3 (column:'MHCAD3', type:'TrimString')
			custAddr4 (column:'MHCAD4', type:'TrimString')
			custAddr5 (column:'MHCAD5', type:'TrimString')
			shipToCity (column:'MHSCTY', type:'TrimString')
			shipToStateCode (column:'MHSTAT', type:'TrimString')
			shipToPostalCd (column:'MHZIPC', type:'TrimString')
			shipToCountry (column:'MHSCNT', type:'TrimString')
			recipientTelephoneNo (column:'"MHTEL#"', type:'TrimString')
			shipToContactName (column:'MHCCON', type:'TrimString')
			custZone (column:'MHZONE', type:'TrimString')
			regionZone (column:'MHZONR', type:'TrimString')
			relToShipperY_n (column:'MHRELP', type:'TrimString')
			shipperNo (column:'"MHSHP#"', type:'TrimString')
			carrierCode (column:'MHCRCD', type:'TrimString')
			serviceType (column:'MHSVTP', type:'TrimString')
			originalSvcTypeQuestion (column:'MHSVT2', type:'TrimString')
			shippingInstruction (column:'MHSHIN', type:'TrimString')
			orderValue (column:'MHORDV', type:'big_decimal')
			shipValue (column:'MHSHPV', type:'big_decimal')
			invoiceAmount (column:'MHIAMT', type:'big_decimal')
			userId (column:'MHUSER', type:'TrimString')
			warehouse (column:'MHWHSE', type:'TrimString')
			groupId (column:'MHGRID', type:'TrimString')
			currency (column:'MHCURR', type:'TrimString')
			status (column:'MHSTUS', type:'TrimString')
			mode (column:'MHMODE', type:'TrimString')
			holdCode (column:'MHHOLD', type:'TrimString')
			fedexHoldAtStation (column:'MHFHLD', type:'TrimString')
			termsCode (column:'MHTERM', type:'TrimString')
			prepayFlag (column:'MHPSHF', type:'TrimString')
			fdxBillRecipientFlag (column:'MHFBRF', type:'TrimString')
			recipientAccountNo (column:'MHFRAC', type:'TrimString')
			frtChgLinNo (column:'MHFLIN', type:'int')
			rateFileMember (column:'MHRMBR', type:'TrimString')
			ccExpirationDate (column:'MHEDAT', type:'int')
			creditCardNo (column:'"MHCC#"', type:'TrimString')
			boxesInput (column:'MHBOXI', type:'int')
			boxesCounted (column:'MHBOXC', type:'int')
			totalWeight (column:'MHTOTW', type:'big_decimal')
			weightUnitFlag (column:'MHWTUN', type:'TrimString')
			weightActual (column:'MHAWGT', type:'big_decimal')
			weightBillable (column:'MHBWGT', type:'big_decimal')
			weightRounded (column:'MHRWGT', type:'big_decimal')
			boxValOverride (column:'MHBVOF', type:'TrimString')
			hazardousFlag (column:'MHHAZF', type:'TrimString')
			shipFromCustomer (column:'MHFCST', type:'TrimString')
			shipFromAddr1 (column:'MHFAD1', type:'TrimString')
			shipFromAddr2 (column:'MHFAD2', type:'TrimString')
			shipFromAddr3 (column:'MHFAD3', type:'TrimString')
			shipFromCity (column:'MHFCTY', type:'TrimString')
			shipFromState (column:'MHFST', type:'TrimString')
			shipFromPostalCd (column:'MHFZIP', type:'TrimString')
			shipFrPostalCd (column:'MHCZIP', type:'TrimString')
			shipFromCountry (column:'MHFCNT', type:'TrimString')
			shipFromPhone (column:'MHFPHN', type:'TrimString')
			shipFromContactNm (column:'MHSCON', type:'TrimString')
			authorizedPerson (column:'MHAUTH', type:'TrimString')
			authorizedTitle (column:'MHTITL', type:'TrimString')
			shipDate (column:'MHDATE', type:'int')
			shipTime (column:'MHTIME', type:'int')
			shipDate2 (column:'MHSDAT', type:'int')
			weighDate (column:'MHWDAT', type:'int')
			orderTrackCode (column:'MHTRAC', type:'TrimString')
			shipmentTrackingNo (column:'"MHPRO#"', type:'TrimString')
			proNo (column:'MHPRO2', type:'TrimString')
			pureFreight (column:'MHSHCH', type:'big_decimal')
			actualFrtChg (column:'MHDCHG', type:'big_decimal')
			surchargeType (column:'MHSRCT', type:'TrimString')
			surchargeTotal (column:'MHSRCH', type:'big_decimal')
			cwtCharge (column:'MHCCHG', type:'big_decimal')
			custFrtChg (column:'MHCUSC', type:'big_decimal')
			discAmount (column:'MHDSC$', type:'big_decimal')
			discPerc (column:'MHDSCP', type:'big_decimal')
			taxAmount (column:'MHTAX$', type:'big_decimal')
			taxPercent (column:'MHTAXP', type:'big_decimal')
			codFlag (column:'MHMCDF', type:'TrimString')
			fdxCodCode (column:'MHFCOD', type:'TrimString')
			codLblEachBoxQuestion (column:'MHEACO', type:'TrimString')
			codValOverride (column:'MHCDOF', type:'TrimString')
			cashFlag (column:'MHCSHF', type:'TrimString')
			mhccod (column:'MHCCOD', type:'TrimString')
			manifestPrt (column:'MHMPRT', type:'TrimString')
			manifestNbr (column:'MHMANF', type:'TrimString')
			manifestPrintYmd (column:'MHPYMD', type:'int')
			manifestPrintYmd2 (column:'MHMPDT', type:'int')
			manifestPrintHms (column:'MHPHMS', type:'int')
			freightCode (column:'MHPYCD', type:'TrimString')
			billOfLadingNo (column:'"MHBIL#"', type:'TrimString')
			trailerNo (column:'MHTRLR', type:'TrimString')
			mileage (column:'MHMILE', type:'int')
			vehicleNbr (column:'MHVHCL', type:'TrimString')
			sealNbr (column:'MHSEAL', type:'TrimString')
			uccLabelType (column:'MHUCCL', type:'TrimString')
			asnTransDate (column:'MHASND', type:'int')
			asnTransTime (column:'MHASNT', type:'int')
			asnTransStatus (column:'MHASNS', type:'TrimString')
			pall_contLabelFlag (column:'MHPCFL', type:'TrimString')
			packingListFlag (column:'MHPKLF', type:'TrimString')
			miscAlphaA (column:'MHMSCA', type:'TrimString')
			miscAlphaB (column:'MHMSCB', type:'TrimString')
			miscNo1 (column:'MHMSC1', type:'big_decimal')
			miscNo2 (column:'MHMSC2', type:'big_decimal')
			charge1 (column:'MHCHG1', type:'big_decimal')
			charge2 (column:'MHCHG2', type:'big_decimal')
			charge3 (column:'MHCHG3', type:'big_decimal')
			charge4 (column:'MHCHG4', type:'big_decimal')
			charge5 (column:'MHCHG5', type:'big_decimal')
			userAlphaA (column:'MHUSEA', type:'TrimString')
			userAlphaB (column:'MHUSEB', type:'TrimString')
			userNumeric1 (column:'MHUSE1', type:'big_decimal')
			userNumeric2 (column:'MHUSE2', type:'big_decimal')
			altAddressType (column:'MHATYP', type:'TrimString')
			altCustNo (column:'MHACST', type:'TrimString')
			altHdqtNo (column:'MHAHDQ', type:'TrimString')
			altShptoNumbr (column:'MHASHP', type:'TrimString')
			altAddrContact (column:'MHACON', type:'TrimString')
			altAddrName (column:'MHANAM', type:'TrimString')
			altAddress1 (column:'MHAAD1', type:'TrimString')
			altAddress2 (column:'MHAAD2', type:'TrimString')
			altAddress3 (column:'MHAAD3', type:'TrimString')
			altAddrCity (column:'MHACTY', type:'TrimString')
			altAddrState (column:'MHASTT', type:'TrimString')
			altAddrPostalCd (column:'MHAZIP', type:'TrimString')
			altAddrCountry (column:'MHACRY', type:'TrimString')
			altAddrPhone (column:'MHAPHN', type:'TrimString')
			altAddrIdType (column:'MHAINT', type:'TrimString')
			altAddrIdNbr (column:'MHAEIN', type:'TrimString')
			altAddrAcctNo (column:'MHACCT', type:'TrimString')
			altRelatedToShpr (column:'MHARLP', type:'TrimString')
			shipNotifLevel (column:'MHNTLV', type:'TrimString')
			shipNotifDest1 (column:'MHSDS1', type:'TrimString')
			emailAddress1 (column:'MHEML1', type:'TrimString')
			shipNotifDest2 (column:'MHSDS2', type:'TrimString')
			emailAddress2 (column:'MHEML2', type:'TrimString')
			faxDest1 (column:'MHFDS1', type:'TrimString')
			faxNo1 (column:'MHFAX1', type:'TrimString')
			faxAttnTo1 (column:'MHFAT1', type:'TrimString')
			faxCompany1 (column:'MHFCP1', type:'TrimString')
			faxContactNo1 (column:'MHFCN1', type:'TrimString')
			faxDest2 (column:'MHFDS2', type:'TrimString')
			faxNo2 (column:'MHFAX2', type:'TrimString')
			faxAttnTo2 (column:'MHFAT2', type:'TrimString')
			faxCompany2 (column:'MHFCP2', type:'TrimString')
			faxContactNo2 (column:'MHFCN2', type:'TrimString')
			memoField (column:'MHMEMO', type:'TrimString')
			shipReferType1 (column:'MHSRT1', type:'TrimString')
			shipReferNo1 (column:'"MHSR#1"', type:'TrimString')
			shipReferType2 (column:'MHSRT2', type:'TrimString')
			shipReferNo2 (column:'"MHSR#2"', type:'TrimString')
			bundleNo (column:'MHBNDL', type:'TrimString')
			packControl (column:'MHPCKC', type:'TrimString')
			updateFlag (column:'MHPUPF', type:'TrimString')
			processingType (column:'MHSTYP', type:'TrimString')
			lblPrtFlag (column:'MHLPRF', type:'TrimString')
			addrPtrId (column:'MHAPTR', type:'TrimString')
			codPtrId (column:'MHCPTR', type:'TrimString')
			manifestPtrId (column:'MHMPTR', type:'TrimString')
			commitmentFlag (column:'MHCMTF', type:'TrimString')
			commitDate (column:'MHCDAT', type:'int')
			commitTime (column:'MHCTIM', type:'int')
			ipAddress (column:'MHIPAD', type:'TrimString')
			portNo (column:'MHIPRT', type:'int')
			dateAddedToFile (column:'MHADDT', type:'int')
			timeAddedToFile (column:'MHADTI', type:'int')
			addedByUserId (column:'MHADUS', type:'TrimString')
			dateUpdated (column:'MHUPDT', type:'int')
			timeUpdated (column:'MHUPTI', type:'int')
			updatedByUserId (column:'MHUPUS', type:'TrimString')
			userModAction (column:'MHMACT', type:'TrimString')
			userModDate (column:'MHMDAT', type:'int')
			userModTime (column:'MHMTIM', type:'int')
			userModDspStn (column:'MHDSTN', type:'TrimString')
		}
	}
	boolean newEntity = false
	static transients = ['newEntity']
}
