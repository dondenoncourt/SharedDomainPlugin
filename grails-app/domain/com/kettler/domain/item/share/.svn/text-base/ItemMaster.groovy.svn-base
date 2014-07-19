package com.kettler.domain.item.share
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
class ItemMaster implements Serializable {
	String activeCode = ''
	String compCode = ''
	String itemNo = ''
	String desc = ''
	String shortName = ''
	String profitCenterClass = ''
	String productGroupClass = ''
	String articleGroupClass = ''
	String stdUnitMeas = ''
	String altUnitMeas = ''
	String lowestUnitMeas = ''
	String convCode = ''
	int convFactor = 0
	String catchWeightCode = ''
	BigDecimal unitWeight = 0.0g
	String binLocation = ''
	String nonStockCode = ''
	boolean taxableCode = true
	boolean serializedCode = false
	String arDistrictCode = ''
	String apDistrictCode = ''
	String substituteItemNo = ''
	String altItemNo = ''
	String priceUnitMeas = ''
	BigDecimal basePrice = 0.0g
	String costUnitMeas = ''
	BigDecimal replCost1 = 0.0g
	BigDecimal lastUnitCost = 0.0g
	BigDecimal aveCost = 0.0g
	BigDecimal lifoIndexCost = 0.0g
	String buyerCode = ''
	String priVendor = ''
	String altVendor = ''
	String priVendorItemNo = ''
	String altVendorItemNo = ''
	int deliveryWeeks = 0
	int minbal = 0
	int maxbal = 0
	int economicOrdQty = 0
	int noMonthsInFile = 0
	int lastLevelUsed = 0
	int lastOrder = 0
	int lastReceipt = 0
	int lastSale = 0
	int lastAdjust = 0
	int lastPhysical = 0
	Date lastUpdate = new Date()
	Long qtyOnOrder = 0
	Long qtyOnHand = 0
	Long qtyAlloc = 0
	Long qtyOnCredHold = 0
	Long qtyOnBackOrder = 0
	Date lastMaintDate = new Date()
	int lastMaintTime = 0
	String lastMaintUserId = ''
	Long upc = 0
	Long euroArticleNo = 0
	BigDecimal cubicFeet = 0.0g
	String customsTariffNo = ''
	int monthDayAdded = 0
	int yearAdded = 0
	String packageType = ''
	String shipInstructions = ''
	String autoUpdMinMax = ''
	BigDecimal minBalNoMonths = 0.0g
	BigDecimal maxBalNoMonths = 0.0g
	Long futureShipQty = 0
	String costCurrency1 = ''
	BigDecimal replCost2 = 0.0g
	String costCurrency2 = ''
	String nmfcNo = ''
	Long gtin = 0
	int dimLength = 0
	int dimWidth = 0
	int dimHeight = 0
	int firstReceipt = 0
	int firstSale = 0
	String addedBy = ''
	String drawbackCode = ''
	String shipTermsCode = ''
	boolean closeoutCode = false
	boolean fulfillmentCode = false
	String statusLevel = ''
	String color = ''
	String countryOfOrigin = ''
    String size = ''
    String sizeUom = ''

    static final KIT = 'KIT'
    static final WEIGHT = 'W'
    	
    boolean isKit() {shortName == KIT}
	private void setKit (def x) {} 
	static transients = ['kit']
	
    static constraints = {
		activeCode(maxSize:1,nullable:false)
		compCode(maxSize:2,nullable:false)
		itemNo(maxSize:15,nullable:false)
		desc(maxSize:30,nullable:false)
		shortName(maxSize:10,nullable:false)
		profitCenterClass(maxSize:1,nullable:false)
		productGroupClass(maxSize:3,nullable:false)
		articleGroupClass(maxSize:3,nullable:false)
		stdUnitMeas(maxSize:3,nullable:false)
		altUnitMeas(maxSize:3,nullable:false)
		lowestUnitMeas(maxSize:3,nullable:false)
		convCode(maxSize:1,nullable:false)
		convFactor(max:9999,nullable:false)
		catchWeightCode(maxSize:1,nullable:false)
		unitWeight(max:new BigDecimal("9999.999"),nullable:false)
		binLocation(maxSize:6,nullable:false)
		nonStockCode(maxSize:1,nullable:false)
		taxableCode(maxSize:1,nullable:false)
		serializedCode(maxSize:1,nullable:false)
		arDistrictCode(maxSize:3,nullable:false)
		apDistrictCode(maxSize:3,nullable:false)
		substituteItemNo(maxSize:15,nullable:false)
		altItemNo(maxSize:15,nullable:false)
		priceUnitMeas(maxSize:3,nullable:false)
		basePrice(max:new BigDecimal("999999.999"),nullable:false)
		costUnitMeas(maxSize:3,nullable:false)
		replCost1(max:new BigDecimal("999999.999"),nullable:false)
		lastUnitCost(max:new BigDecimal("999999.999"),nullable:false)
		aveCost(max:new BigDecimal("999999.999"),nullable:false)
		lifoIndexCost(max:new BigDecimal("999999.999"),nullable:false)
		buyerCode(maxSize:3,nullable:false)
		priVendor(maxSize:7,nullable:false)
		altVendor(maxSize:7,nullable:false)
		priVendorItemNo(maxSize:15,nullable:false)
		altVendorItemNo(maxSize:15,nullable:false)
		deliveryWeeks(max:99,nullable:false)
		minbal(max:9999999,nullable:false)
		maxbal(max:9999999,nullable:false)
		economicOrdQty(max:9999999,nullable:false)
		noMonthsInFile(max:99,nullable:false)
		lastLevelUsed(max:999,nullable:false)
		lastOrder(max:999999,nullable:false)
		lastReceipt(max:999999,nullable:false)
		lastSale(max:999999,nullable:false)
		lastAdjust(max:999999,nullable:false)
		lastPhysical(max:999999,nullable:false)
		lastUpdate(nullable:false)
		qtyOnOrder(max:99999999999,nullable:false)
		qtyOnHand(max:99999999999,nullable:false)
		qtyAlloc(max:99999999999,nullable:false)
		qtyOnCredHold(max:99999999999,nullable:false)
		qtyOnBackOrder(max:99999999999,nullable:false)
		lastMaintDate(nullable:false)
		lastMaintTime(max:999999,nullable:false)
		lastMaintUserId(maxSize:10,nullable:false)
		upc(max:999999999999,nullable:false)
		euroArticleNo(max:9999999999999,nullable:false)
		cubicFeet(max:new BigDecimal("9999.9"),nullable:false)
		customsTariffNo(maxSize:12,nullable:false)
		monthDayAdded(max:9999,nullable:false)
		yearAdded(max:9999,nullable:false)
		packageType(maxSize:4,nullable:false)
		shipInstructions(maxSize:15,nullable:false)
		autoUpdMinMax(maxSize:1,nullable:false)
		minBalNoMonths(max:new BigDecimal("99.9"),nullable:false)
		maxBalNoMonths(max:new BigDecimal("99.9"),nullable:false)
		futureShipQty(max:99999999999,nullable:false)
		costCurrency1(maxSize:3,nullable:false)
		replCost2(max:new BigDecimal("999999.999"),nullable:false)
		costCurrency2(maxSize:3,nullable:false)
		nmfcNo(maxSize:8,nullable:false)
		gtin(max:99999999999999,nullable:false)
		dimLength(max:999,nullable:false)
		dimWidth(max:999,nullable:false)
		dimHeight(max:999,nullable:false)
		firstReceipt(max:999999,nullable:false)
		firstSale(max:999999,nullable:false)
		addedBy(maxSize:10,nullable:false)
		drawbackCode(maxSize:1,nullable:false)
		shipTermsCode(maxSize:3,nullable:false)
		closeoutCode(maxSize:1,nullable:false)
		fulfillmentCode(maxSize:1,nullable:false)
		statusLevel(maxSize:1,nullable:false)
		color(maxSize:15,nullable:false)
		countryOfOrigin(maxSize:3,nullable:false)
        size(maxSize:4,nullable:false) 
        sizeUom(maxSize:4,nullable:false) 
   	}
	static mapping = {
		table (name:'itemmast',schema:CH.config.inventory.schema)
        tablePerHierarchy false
		columns {
			activeCode (column:'IACTV', type:'TrimString')
			compCode (column:'ICOMP', type:'TrimString')
			itemNo (column:'IITEM', type:'TrimString')
			desc (column:'IDESC', type:'TrimString')
			shortName (column:'ISHRT', type:'TrimString')
			profitCenterClass (column:'ICLAS1', type:'TrimString')
			productGroupClass (column:'ICLAS2', type:'TrimString')
			articleGroupClass (column:'ICLAS3', type:'TrimString')
			stdUnitMeas (column:'ISUNM', type:'TrimString')
			altUnitMeas (column:'IAUNM', type:'TrimString')
			lowestUnitMeas (column:'ILUNM', type:'TrimString')
			convCode (column:'ICONC', type:'TrimString')
			convFactor (column:'ICONF', type:'int')
			catchWeightCode (column:'ICWGT', type:'TrimString')
			unitWeight (column:'IWGHT', type:'big_decimal')
			binLocation (column:'IBLOC', type:'TrimString')
			nonStockCode (column:'INSTCD', type:'TrimString')
			taxableCode (column:'ITAXCD', type:'org.hibernate.type.YesNoType')
			serializedCode (column:'ISERCD', type:'org.hibernate.type.YesNoType')
			arDistrictCode (column:'IARDCD', type:'TrimString')
			apDistrictCode (column:'IAPDCD', type:'TrimString')
			substituteItemNo (column:'ISITEM', type:'TrimString')
			altItemNo (column:'IAITEM', type:'TrimString')
			priceUnitMeas (column:'IPUNM', type:'TrimString')
			basePrice (column:'IPRICE', type:'big_decimal')
			costUnitMeas (column:'ICUNM', type:'TrimString')
			replCost1 (column:'IRCOST', type:'big_decimal')
			lastUnitCost (column:'ILCOST', type:'big_decimal')
			aveCost (column:'IACOST', type:'big_decimal')
			lifoIndexCost (column:'IICOST', type:'big_decimal')
			buyerCode (column:'IBUYER', type:'TrimString')
			priVendor (column:'IVENDR', type:'TrimString')
			altVendor (column:'IAVEND', type:'TrimString')
			priVendorItemNo (column:'IVITEM', type:'TrimString')
			altVendorItemNo (column:'IAVITM', type:'TrimString')
			deliveryWeeks (column:'IDELWK', type:'int')
			minbal (column:'IMNBAL', type:'int')
			maxbal (column:'IMXBAL', type:'int')
			economicOrdQty (column:'IEOQTY', type:'int')
			noMonthsInFile (column:'"I#MONS"', type:'int')
			lastLevelUsed (column:'ILLEVL', type:'int')
			lastOrder (column:'IODATE', type:'int')
			lastReceipt (column:'IRDATE', type:'int')
			lastSale (column:'ISDATE', type:'int')
			lastAdjust (column:'IADATE', type:'int')
			lastPhysical (column:'IPDATE', type:'int')
			lastUpdate (column:'IUDATE', type:'DateMMDDYYUserType')
			qtyOnOrder (column:'IONORD', type:'long')
			qtyOnHand (column:'IONHND', type:'long')
			qtyAlloc (column:'IALLOC', type:'long')
			qtyOnCredHold (column:'ICRHLD', type:'long')
			qtyOnBackOrder (column:'IBKORD', type:'long')
			lastMaintDate (column:'IMDATE', type:'DateMMDDYYUserType')
			lastMaintTime (column:'IMTIME', type:'int')
			lastMaintUserId (column:'IMUSER', type:'TrimString')
			upc (column:'IUPC', type:'long')
			euroArticleNo (column:'IEAN', type:'long')
			cubicFeet (column:'ICUBE', type:'big_decimal')
			customsTariffNo (column:'ICTNUM', type:'TrimString')
			monthDayAdded (column:'IADDMD', type:'int')
			yearAdded (column:'IADDYR', type:'int')
			packageType (column:'ICOMM', type:'TrimString')
			shipInstructions (column:'ISHIN', type:'TrimString')
			autoUpdMinMax (column:'IUMMCD', type:'TrimString')
			minBalNoMonths (column:'IMNMON', type:'big_decimal')
			maxBalNoMonths (column:'IMXMON', type:'big_decimal')
			futureShipQty (column:'IFUSHP', type:'long')
			costCurrency1 (column:'ICCUR', type:'TrimString')
			replCost2 (column:'IRCST2', type:'big_decimal')
			costCurrency2 (column:'ICCUR2', type:'TrimString')
			nmfcNo (column:'INMFCN', type:'TrimString')
			gtin (column:'IGTIN', type:'long')
			dimLength (column:'IDIML', type:'int')
			dimWidth (column:'IDIMW', type:'int')
			dimHeight (column:'IDIMH', type:'int')
			firstReceipt (column:'IFRDT', type:'int')
			firstSale (column:'IFSDT', type:'int')
			addedBy (column:'IADDBY', type:'TrimString')
			drawbackCode (column:'IDBCD', type:'TrimString')
			shipTermsCode (column:'IINCO', type:'TrimString')
			closeoutCode (column:'ICOCD', type:'YesBlankType')
			fulfillmentCode (column:'IFCODE', type:'YesBlankType')
			statusLevel (column:'ISTLVL', type:'TrimString')
			color (column:'ICOLOR', type:'TrimString')
			countryOfOrigin (column:'ICOO', type:'TrimString')
            size (column:'ISIZE', type:'TrimString')
            sizeUom (column:'ISIZEUOM', type:'TrimString')
   		}
	}
    static namedQueries = {
        frameSizes {compCode, itemNo, desc ->
            eq 'compCode', compCode
            like 'itemNo', itemNo[0..4]+'%'
            eq 'desc', desc
            eq 'activeCode', ' '
        }
        colors {compCode, itemNo, desc, dashSpot ->
            eq 'compCode', compCode
            like 'itemNo', itemNo[0..dashSpot]+'%'
            eq 'desc', desc
            eq 'activeCode', ' '
        }
	}
}
