package com.kettler.domain.orderentry.share
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

import com.kettler.domain.actrcv.share.Customer
import com.kettler.domain.actrcv.share.Return
import org.hibernate.type.CharBooleanType
import org.hibernate.type.YesNoType
import com.kettler.domain.work.DateUtils
import java.sql.Time
import java.util.GregorianCalendar;

class OrderHeader implements Serializable {
	String compCode = ''
	int orderNo = 0
	int shipNo = 0
	int lineNo = 0
	String statusCode = 'N'   
	/*  B - Back order
		C - Confirmed (when order entry enters the shipping paperwork.  Of short
		    duration until invoice run and data is moved to the OEI*  files)          
		F - Future order (more than 10 days to shipment)
		H - On credit hold
		N - New status/Web (until verified)
		O - Open 
		P - Pick ticket printed
		S - Shipped
		X - Cancelled 
	 */
	String custNo = ''
	int shipToNo = 0
	int orderCentury = 20
	Date orderDate = new Date()
	int pickCentury = 20
	Date pickDateMDY = new Date()
	String warehouse = '1  '
	String poNo = ''
	String shipVia = ''
	String termsCode = ''
	String salesperson1 = ''
	String salesperson2 = ''
	BigDecimal invoiceDiscPct = 0.0g
	String taxCode1 = ''
	String taxCode2 = ''
	String taxCode3 = ''
	BigDecimal taxPct1 = 0.0g
	BigDecimal taxPct2 = 0.0g
	BigDecimal taxPct3 = 0.0g
	boolean creditMemoCode = false
	int invoiceNo = 0
	Date invoiceDate = DateUtils.getYearOne()
	BigDecimal orderTotal = 0.0g
	String creditCodes = ''
	String jobIdCode = ''
	String enteredBy = ''
	Date dateCreated = new Date() // Note: Grails will set this on insert
	int timeEntered = DateUtils.getTime(new Date())
	String acknowledgement = 'N'
	String acknEmail = ''
	String freightCode = ''
	int pickTime = 0
	String amOrPm = ''
	String freightTrackingNo = ''
	String carrierCode = ''
	String fobCode = ''
	String shippedStatus = ''
	String shipInstructions = ''
	String specialChrgCd1 = ''
	String specialChrgCd2 = ''
	String specialChrgCd3 = ''
	int dueCentury = 0
	Date dueDate = DateUtils.getYearOne()
	String releasedBy = ''
	String confirmedBy = ''
	boolean shipComplete = false
	String backOrderRelPriority = '999'
	Date pickDate = new Date()
	String packingListCode = '01'
	String custRef1 = ''
	Date custRef1Date = DateUtils.getYearOne()
	String verifiedBy = ''
	Date dateVerified = DateUtils.getYearOne()
	int timeVerified = 0
	String shippedBy = ''
	Date dateShipped = DateUtils.getYearOne()
	int timeShipped = 0
	String trailerNo = ''
	String sealNo = ''
	int noPackages = 0
	int noHandlingUnits = 0
	int weight = 0
	String lastF_mPgmName = ''
	String lastF_mUserId = ''
	Date lastF_mDate = DateUtils.getYearOne()
	int lastF_mTime = 0
	Date dateReleased = DateUtils.getYearOne()
	int timeReleased = 0
	Date dateConfirmed = DateUtils.getYearOne()
	int timeConfirmed = 0
	String backOrderReleasedBy = ''
	Date backOrderReleaseDate = DateUtils.getYearOne()
	int backOrderReleaseTime = 0
	String canceledBy = ''
	Date canceledDate = null
	int canceledTime = 0
	Long shippingPhoneNo = 0
	String routedBy = ''
	Date routedDate = DateUtils.getYearOne()
	int routedTime = 0
	String consolidatedInv = ''
	String cancelCode = ''
	String freightTerms = ''
	String overrideARCode = ''
	String refCode1 = ''
	String refCode2 = ''
	String refCode3 = ''
	String refCode4 = ''
	String custRef2 = ''
	String custRef3 = ''
	String custRef4 = ''
	String prerouteFlag = ''
	String preroutedBy = ''
	Date datePrerouted = DateUtils.getYearOne()
	int timePrerouted = 0
	BigDecimal cube = 0.0g
	int timeInvoiced = 0
	String dropShipCode = ''
	Date cancelAfterDate = null //new Date() + (365 * 10)
	String reinstatedBy = ''
	Date dateReinstated = DateUtils.getYearOne()
	int timeReinstated = 0
	boolean splitTermsCode = false
	int splitTermsPct1 = 0
	int splitTermsPct2 = 0
	int splitTermsPct3 = 0
	String termsCode1 = ''
	String termsCode2 = ''
	String termsCode3 = ''
	int dueCentury1 = 0
	Date dueDate1 = DateUtils.getYearOne()
	int dueCentury2 = 0
	Date dueDate2 = DateUtils.getYearOne()
	int dueCentury3 = 0
	Date dueDate3 = DateUtils.getYearOne()
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
	int sellToNo = 0
	boolean discAllowCode = false
	// denoncourt added
	Date approvedDate = null
	Time approvedTime = null
	String approvedBy = ''
	boolean webOrder = true
	boolean backOrder = false
	static belongsTo = [ ra : Return ] // note return would be better than ra but it's a reserved word
	
	//transients 
	String shipViaSCACShipIns = null
	boolean signatureRequired = false
	boolean insurance = false
	boolean liftGate = false
	boolean insideDelivery = false
	boolean resiDelivery = false
	String residentialCommercial = 'C'
	boolean hasExtraShipInst = false
	String extraShipInst = null
	Integer routingNo = null

	static transients = ['shipViaSCACShipIns', 
	                     'signatureRequired', 'insurance', 'liftGate', 'insideDelivery', 'resiDelivery', 'residentialCommercial', 
	                     'hasExtraShipInst', 'extraShipInst']

	static constraints = {
		compCode(maxSize:2,nullable:false)
		orderNo(max:999999,nullable:false)
		shipNo(max:99,nullable:false)
		lineNo(max:9999,nullable:false)
		statusCode(maxSize:1,nullable:false, inList:['W', 'B','C','F','H','N','O','P','S','X'])
		custNo(minSize:1,maxSize:7,blank:false,nullable:false, 
			validator: { custNo, ord ->
				return Customer.findByCustNo(custNo) != null
			}
		)
		shipToNo(max:9999,nullable:false, 
			validator: { shipToNo, ord ->
			    if (!shipToNo || shipToNo == 9999) {
			    	return true
			    }
				def shipTo = ShipTo.withCriteria {
					and {
						eq('compCode', ord.compCode)
						eq('custNo', ord.custNo)
						eq('shipToNo', shipToNo)
					}
				}
				return shipTo as boolean
			}
		)
		orderCentury(max:99,nullable:false)
		orderDate(nullable:false)
		pickCentury(max:99,nullable:false)
		pickDateMDY(nullable:false)
		warehouse(maxSize:3,nullable:false)
		poNo(maxSize:25,nullable:false)
		shipVia(maxSize:15,nullable:false)
		termsCode(maxSize:3,nullable:false)
		salesperson1(maxSize:3,nullable:false,
            validator: { slsp, ord ->
				return SalesPerson.get(slsp) as boolean
			}
		)
		salesperson2(maxSize:3,nullable:false)
		invoiceDiscPct(max:new BigDecimal("99.99"),nullable:false)
		taxCode1(maxSize:3,nullable:false)
		taxCode2(maxSize:3,nullable:false)
		taxCode3(maxSize:3,nullable:false)
		taxPct1(max:new BigDecimal(".99999"),nullable:false)
		taxPct2(max:new BigDecimal(".99999"),nullable:false)
		taxPct3(max:new BigDecimal(".99999"),nullable:false)
		creditMemoCode(maxSize:1,nullable:false)
		invoiceNo(max:9999999,nullable:false)
		invoiceDate(nullable:false)
		orderTotal(max:new BigDecimal("9999999.99"),nullable:false)
		creditCodes(maxSize:5,nullable:false)
		jobIdCode(maxSize:10,nullable:false)
		enteredBy(maxSize:10,nullable:false)
		dateCreated(nullable:false)
		timeEntered(max:999999,nullable:false)
		acknowledgement(maxSize:1,inList:[' ', 'Y', 'N', 'P'],nullable:false)
		freightCode(maxSize:1,nullable:false)
		pickTime(max:999999,nullable:false)
		amOrPm(maxSize:2,nullable:false)
		freightTrackingNo(maxSize:25,nullable:false)
		carrierCode(maxSize:4,nullable:false)
		fobCode(maxSize:2,nullable:false)
		shippedStatus(maxSize:2,nullable:false)
		shipInstructions(maxSize:15,nullable:false)
		specialChrgCd1(maxSize:5,nullable:false)
		specialChrgCd2(maxSize:5,nullable:false)
		specialChrgCd3(maxSize:5,nullable:false)
		dueCentury(max:99,nullable:false)
		dueDate(nullable:false)
		releasedBy(maxSize:10,nullable:false)
		confirmedBy(maxSize:10,nullable:false)
		shipComplete(maxSize:1,nullable:false)
		backOrderRelPriority(maxSize:3,nullable:false)
		pickDate(nullable:false)
		packingListCode(maxSize:2,nullable:false)
		custRef1(maxSize:25,nullable:false)
		custRef1Date(nullable:false)
		verifiedBy(maxSize:10,nullable:false)
		dateVerified(nullable:false)
		timeVerified(max:999999,nullable:false)
		shippedBy(maxSize:10,nullable:false)
		dateShipped(nullable:false)
		timeShipped(max:999999,nullable:false)
		trailerNo(maxSize:15,nullable:false)
		sealNo(maxSize:10,nullable:false)
		noPackages(max:999999,nullable:false)
		noHandlingUnits(max:999999,nullable:false)
		weight(max:99999,nullable:false)
		lastF_mPgmName(maxSize:10,nullable:false)
		lastF_mUserId(maxSize:10,nullable:false)
		lastF_mDate(nullable:false)
		lastF_mTime(max:999999,nullable:false)
		dateReleased(nullable:false)
		timeReleased(max:999999,nullable:false)
		dateConfirmed(nullable:false)
		timeConfirmed(max:999999,nullable:false)
		backOrderReleasedBy(maxSize:10,nullable:false)
		backOrderReleaseDate(nullable:false)
		backOrderReleaseTime(max:999999,nullable:false)
		canceledBy(maxSize:10,nullable:false)
		canceledDate(nullable:true)
		canceledTime(max:999999,nullable:false)
		shippingPhoneNo(max:9999999999,nullable:false)
		routedBy(maxSize:10,nullable:false)
		routedDate(nullable:false)
		routedTime(max:999999,nullable:false)
		consolidatedInv(maxSize:1,nullable:false)
		cancelCode(maxSize:2,nullable:false)
		freightTerms(maxSize:4,nullable:false)
		overrideARCode(maxSize:3,nullable:false)
		refCode1(maxSize:2,nullable:false)
		refCode2(maxSize:2,nullable:false)
		refCode3(maxSize:2,nullable:false)
		refCode4(maxSize:2,nullable:false)
		custRef2(maxSize:30,nullable:false)
		custRef3(maxSize:30,nullable:false)
		custRef4(maxSize:30,nullable:false)
		prerouteFlag(maxSize:1,nullable:false)
		preroutedBy(maxSize:10,nullable:false)
		datePrerouted(nullable:false)
		timePrerouted(max:999999,nullable:false)
		cube(max:new BigDecimal("99999.9"),nullable:false)
		timeInvoiced(max:999999,nullable:false)
		dropShipCode(maxSize:1,nullable:false)
		cancelAfterDate(nullable:true,
				validator: { cancelAfterDate, ord ->
			    if (cancelAfterDate) { 
			    	GregorianCalendar cal = new GregorianCalendar()
			    	cal.setTime(cancelAfterDate)
			    	if (cal.get(GregorianCalendar.YEAR) != 1 && cancelAfterDate <= ord.pickDate) {
			    		return 'orderHeader.cancelDate.less.than.pickDate'
			    	}
			    }
			    return true
			}
		)
				
		reinstatedBy(maxSize:10,nullable:false)
		dateReinstated(nullable:false)
		timeReinstated(max:999999,nullable:false)
		splitTermsCode(maxSize:1,nullable:false)
		splitTermsPct1(max:99,nullable:false)
		splitTermsPct2(max:99,nullable:false)
		splitTermsPct3(max:99,nullable:false)
		termsCode1(maxSize:3,nullable:false)
		termsCode2(maxSize:3,nullable:false)
		termsCode3(maxSize:3,nullable:false)
		dueCentury1(max:99,nullable:false)
		dueDate1(nullable:false)
		dueCentury2(max:99,nullable:false)
		dueDate2(nullable:false)
		dueCentury3(max:99,nullable:false)
		dueDate3(nullable:false)
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
		sellToNo(max:9999,nullable:false)
		discAllowCode(maxSize:1,nullable:false)
		// denoncourt added
		approvedDate(nullable:true)
		approvedTime(nullable:true)
		approvedBy(maxSize:100,nullable:false)
		webOrder(maxSize:1,nullable:false)
		backOrder(maxSize:1,nullable:false)
		acknEmail(maxSize:50,email:true,nullable:false)
		ra(nullable:true)
		routingNo(nullable:true)
	}
	static mapping = {
		table (name:'ordheader',schema:CH.config.orderentry.schema)
		columns {
			compCode (column:'OCOMP', type:'TrimString')
			orderNo (column:'OORDN', type:'int')
			shipNo (column:'OSHPN', type:'int')
			lineNo (column:'OSEQN', type:'int')
			statusCode (column:'OSTAT', type:'TrimString')
			custNo (column:'OCUSTN', type:'TrimString')
			shipToNo (column:'OSHPTO', type:'int')
			orderCentury (column:'OORDCN', type:'int')
			orderDate (column:'OORDDT', type:'DateMMDDYYUserType')
			pickCentury (column:'OPICCN', type:'int')
			pickDateMDY (column:'OPICDT', type:'DateMMDDYYUserType')
			warehouse (column:'OWHSE', type:'TrimString')
			poNo (column:'OPONUM', type:'TrimString')
			shipVia (column:'OSHVIA', type:'TrimString')
			termsCode (column:'OTMCOD', type:'TrimString')
			salesperson1 (column:'OSPCD1', type:'TrimString')
			salesperson2 (column:'OSPCD2', type:'TrimString')
			invoiceDiscPct (column:'OINDIS', type:'big_decimal')
			taxCode1 (column:'OTXCD1', type:'TrimString')
			taxCode2 (column:'OTXCD2', type:'TrimString')
			taxCode3 (column:'OTXCD3', type:'TrimString')
			taxPct1 (column:'OTXPC1', type:'big_decimal')
			taxPct2 (column:'OTXPC2', type:'big_decimal')
			taxPct3 (column:'OTXPC3', type:'big_decimal')
			creditMemoCode (column:'OCRMEM', type:'YesBlankType')
			invoiceNo (column:'OINVNO', type:'int')
			invoiceDate (column:'OINVDT', type:'DateMMDDYYUserType')
			orderTotal (column:'OTOTAL', type:'big_decimal')
			creditCodes (column:'OCRCDS', type:'TrimString')
			jobIdCode (column:'OJOBID', type:'TrimString')
			enteredBy (column:'OUSRID', type:'TrimString')
			dateCreated (column:'OUDATE', type:'DateMMDDYYUserType')
			timeEntered (column:'OUTIME', type:'int')
			acknowledgement (column:'OPACKN', type:'string')
			freightCode (column:'OFRTCD', type:'TrimString')
			pickTime (column:'OPTIME', type:'int')
			amOrPm (column:'OAMPM', type:'TrimString')
			freightTrackingNo (column:'OFRTRK', type:'TrimString')
			carrierCode (column:'OSVCOD', type:'TrimString')
			fobCode (column:'OFOBCD', type:'TrimString')
			shippedStatus (column:'OSHSTS', type:'TrimString')
			shipInstructions (column:'OSHIN', type:'TrimString')
			specialChrgCd1 (column:'OCHCD1', type:'TrimString')
			specialChrgCd2 (column:'OCHCD2', type:'TrimString')
			specialChrgCd3 (column:'OCHCD3', type:'TrimString')
			dueCentury (column:'ODUECN', type:'int')
			dueDate (column:'ODUEDT', type:'DateMMDDYYUserType')
			releasedBy (column:'ORLSBY', type:'TrimString')
			confirmedBy (column:'OCNFBY', type:'TrimString')
			shipComplete (column:'OSCMPL', type:'YesBlankType')
			backOrderRelPriority (column:'ORPRTY', type:'TrimString')
			pickDate(column:'OPCYMD', type:'DateCCYYMMDDUserType')
			packingListCode (column:'OPLCD', type:'TrimString')
			custRef1 (column:'OCRFNO', type:'TrimString')
			custRef1Date (column:'OCRFDT', type:'DateCCYYMMDDUserType')
			verifiedBy (column:'OVERBY', type:'TrimString')
			dateVerified (column:'OVDATE', type:'DateMMDDYYUserType')
			timeVerified (column:'OVTIME', type:'int')
			shippedBy (column:'OSHPBY', type:'TrimString')
			dateShipped (column:'OSDATE', type:'DateMMDDYYUserType')
			timeShipped (column:'OSTIME', type:'int')
			trailerNo (column:'"OTRLR#"', type:'TrimString')
			sealNo (column:'"OSEAL#"', type:'TrimString')
			noPackages (column:'OPKGS', type:'int')
			noHandlingUnits (column:'OHUNIT', type:'int')
			weight (column:'OWGHT', type:'int')
			lastF_mPgmName (column:'OLMPGM', type:'TrimString')
			lastF_mUserId (column:'OLMUSR', type:'TrimString')
			lastF_mDate (column:'OLMDAT', type:'DateMMDDYYUserType')
			lastF_mTime (column:'OLMTIM', type:'int')
			dateReleased (column:'ORLSDT', type:'DateMMDDYYUserType')
			timeReleased (column:'ORLSTM', type:'int')
			dateConfirmed (column:'OCNFDT', type:'DateMMDDYYUserType')
			timeConfirmed (column:'OCNFTM', type:'int')
			backOrderReleasedBy (column:'OBORBY', type:'TrimString')
			backOrderReleaseDate (column:'OBORDT', type:'DateMMDDYYUserType')
			backOrderReleaseTime (column:'OBORTM', type:'int')
			canceledBy (column:'OCNCBY', type:'TrimString')
			canceledDate (column:'OCNCDT', type:'DateMMDDYYUserType')
			canceledTime (column:'OCNCTM', type:'int')
			shippingPhoneNo (column:'OPHONE', type:'long')
			routedBy (column:'ORTDBY', type:'TrimString')
			routedDate (column:'ORTDDT', type:'DateMMDDYYUserType')
			routedTime (column:'ORTDTM', type:'int')
			consolidatedInv (column:'OCONCD', type:'TrimString')
			cancelCode (column:'OXCODE', type:'TrimString')
			freightTerms (column:'OFRTRM', type:'TrimString')
			overrideARCode (column:'OOARCD', type:'TrimString')
			refCode1 (column:'OCRFC1', type:'TrimString')
			refCode2 (column:'OCRFC2', type:'TrimString')
			refCode3 (column:'OCRFC3', type:'TrimString')
			refCode4 (column:'OCRFC4', type:'TrimString')
			custRef2 (column:'OCRFN2', type:'TrimString')
			custRef3 (column:'OCRFN3', type:'TrimString')
			custRef4 (column:'OCRFN4', type:'TrimString')
			prerouteFlag (column:'OPRERT', type:'TrimString')
			preroutedBy (column:'OPRTBY', type:'TrimString')
			datePrerouted (column:'OPRTDT', type:'DateMMDDYYUserType')
			timePrerouted (column:'OPRTTM', type:'int')
			cube (column:'OCUBE', type:'big_decimal')
			timeInvoiced (column:'OINVTM', type:'int')
			dropShipCode (column:'ODSCD', type:'TrimString')
			cancelAfterDate (column:'OCADAT', type:'date')
			reinstatedBy (column:'ORNSBY', type:'TrimString')
			dateReinstated (column:'ORNSDT', type:'DateMMDDYYUserType')
			timeReinstated (column:'ORNSTM', type:'int')
			splitTermsCode (column:'OSTCOD', type:'org.hibernate.type.YesNoType')
			splitTermsPct1 (column:'OSTPC1', type:'int')
			splitTermsPct2 (column:'OSTPC2', type:'int')
			splitTermsPct3 (column:'OSTPC3', type:'int')
			termsCode1 (column:'OTMCD1', type:'TrimString')
			termsCode2 (column:'OTMCD2', type:'TrimString')
			termsCode3 (column:'OTMCD3', type:'TrimString')
			dueCentury1 (column:'ODUEC1', type:'int')
			dueDate1 (column:'ODUED1', type:'DateMMDDYYUserType')
			dueCentury2 (column:'ODUEC2', type:'int')
			dueDate2 (column:'ODUED2', type:'DateMMDDYYUserType')
			dueCentury3 (column:'ODUEC3', type:'int')
			dueDate3 (column:'ODUED3', type:'DateMMDDYYUserType')
			lineDiscCode (column:'OLDISC', type:'YesBlankType')
			profitCenter1 (column:'OLDPC1', type:'TrimString')
			profitCenter2 (column:'OLDPC2', type:'TrimString')
			profitCenter3 (column:'OLDPC3', type:'TrimString')
			profitCenter4 (column:'OLDPC4', type:'TrimString')
			profitCenter5 (column:'OLDPC5', type:'TrimString')
			lineDisc1 (column:'OLDDP1', type:'big_decimal')
			lineDisc2 (column:'OLDDP2', type:'big_decimal')
			lineDisc3 (column:'OLDDP3', type:'big_decimal')
			lineDisc4 (column:'OLDDP4', type:'big_decimal')
			lineDisc5 (column:'OLDDP5', type:'big_decimal')
			sellToNo (column:'OSELTO', type:'int')
			discAllowCode (column:'ODCAL', type:'YesBlankType')
			// denoncourt added
			approvedDate(column:'approvdate', type:'date')
			approvedTime(column:'approvtime', type:'time')
			approvedBy(column:'approvby', type:'TrimString')
			webOrder(column:'weborder', type:'org.hibernate.type.YesNoType')
			backOrder(column:'backorder', type:'org.hibernate.type.YesNoType')
			acknEmail (column:'ACKNEMAIL', type:'TrimString')
			ra_id(column:'raid', type:'int')
			routingNo(column:'troutd')
		}
	}
	
	String toString() {"compCode: $compCode custNo: $custNo orderNo: $orderNo"}
}
