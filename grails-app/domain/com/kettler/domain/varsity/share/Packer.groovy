package com.kettler.domain.varsity.share
 
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import org.systemitools.types.*

class Packer implements Serializable {
	String compCode = ''
	String orderShipNo = ''
	String packControl = ''
	String type = ''
	String status = ''
	Long indexNo = 0l
	String containerId = ''
	String itemNo = ''
	String itemStyle = ''
	String itemColor = ''
	String itemSize = ''
	String itemLotNo = ''
	String itemSerialNo = ''
	String itemUnitMeasure = ''
	String itemDesc = ''
	String orderType = ''
	String warehouse = ''
	String orderNo = ''
	Long packageNo = 0l
	String productCode = ''
	String hazardous = ''
	BigDecimal convertsLineUomToHazUom = 0g
	String hazQtyCode = ''
	String hazDesc = ''
	BigDecimal packQuantity = 0g
	BigDecimal caseQuantity = 0g
	String pickListNo = ''
	String poNo = ''
	BigDecimal roundedWeight = 0g
	BigDecimal actualWeight = 0g
	BigDecimal billableWeight = 0g
	String reportWgt_aesFlg = ''
	BigDecimal unitPrice = 0g
	BigDecimal extendedPrice = 0g
	BigDecimal itemWeight = 0g
	String wtUom = ''
	BigDecimal unitValue = 0g
	BigDecimal itemCubicSize = 0g
	BigDecimal totalCubicSize = 0g
	String cubicUom = ''
	String freightClassCode = ''
	int packFactor
	String packFactorUm = ''
	String upcCode = ''
	String addlDesc1 = ''
	String addlDesc2 = ''
	String addlDesc3 = ''
	String pkmrks = ''
	String invoiceNo = ''
	int invLineNo
	int sequenceNo
	String exportInfoCode = ''
	String dutiableGoodsFlag = ''
	String aesLicenseTypeCd = ''
	String eccn = ''
	String expLicenseNo = ''
	int expLicExpireDate
	String licExceptnSymbol = ''
	String ftsrExemptionNo = ''
	String harmonizedCode = ''
	String scheduleBCode = ''
	String aesCommodityDesc = ''
	BigDecimal scheduleBUnit1 = 0g
	String scheduleBUom1 = ''
	BigDecimal conversionFactorForUnit1 = 0g
	BigDecimal scheduleBUnit2 = 0g
	String scheduleBUom2 = ''
	BigDecimal conversionFactorForUnit12 = 0g
	String foreign_domest_f_d = ''
	String countryOfOrigin = ''
	String countryOfManftr = ''
	String naftaProducer = ''
	String naftaPrefCriteria = ''
	String dangerousGoodsCode = ''
	String netCostMethRvc = ''
	int netCostBegDate
	int netCostEndDate
	int shipDate
	int shipTime
	String shippedContainer = ''
	BigDecimal qValue = 0g
	String ddtcExemptionNo = ''
	String ddtcRegistrationNo = ''
	String ddtcSmeIndicator = ''
	String ddtcEligPtyCertf = ''
	String ddtcUsmlCategryCd = ''
	String ddtcUnitOfMsrCd = ''
	int ddtcQuantity
	String ddtcLicenseLineNo = ''
	String vehicleFlag = ''
	String vinProductId = ''
	String vinQualifier = ''
	String vehicleTitleNo = ''
	String vehicleTitleState = ''
	String itemComment1 = ''
	String itemComment2 = ''
	String itemComment3 = ''
	String itemComment4 = ''
	String misc1 = ''
	String misc2 = ''
	String misc3 = ''
	String misc4 = ''
	String misc5 = ''
	String misc6 = ''
	String misc7 = ''
	String misc8 = ''
	String misc9 = ''
	String misc10 = ''
	BigDecimal numeric1 = 0g
	BigDecimal numeric2 = 0g
	BigDecimal numeric3 = 0g
	BigDecimal numeric4 = 0g
	BigDecimal numeric5 = 0g
	Long numericS1 = 0l
	Long numericS2 = 0l
	Long numericS3 = 0l
	Long numericS4 = 0l
	Long numericS5 = 0l
	String flagArray = ''
	String packerId = ''
	String lastChangeUser = ''
	int lineNo
	String varsity01MscFld = ''
	String varsity02MscFld = ''
	String varsity03MscFld = ''
	BigDecimal varsityMiscDecFld = 0g
	BigDecimal varsityMiscDecFld2 = 0g
	BigDecimal varsityMiscDecFld3 = 0g
	Long aesCommodityLineNo = 0l
	Long varsityMiscNumFld = 0l
	Long varsityMiscNumFld2 = 0l
	int lastChangeTime
	int lastChangeDate
	String lastChangeDsp = ''
	static constraints = {
		compCode(maxSize:4,nullable:false)
		orderShipNo(maxSize:20,nullable:false)
		packControl(maxSize:35,nullable:false)
		type(maxSize:5,nullable:false)
		status(maxSize:5,nullable:false)
		indexNo(max:999999999999999,nullable:false)
		containerId(maxSize:30,nullable:false)
		itemNo(maxSize:40,nullable:false)
		itemStyle(maxSize:10,nullable:false)
		itemColor(maxSize:10,nullable:false)
		itemSize(maxSize:10,nullable:false)
		itemLotNo(maxSize:15,nullable:false)
		itemSerialNo(maxSize:30,nullable:false)
		itemUnitMeasure(maxSize:5,nullable:false)
		itemDesc(maxSize:36,nullable:false)
		orderType(maxSize:1,nullable:false)
		warehouse(maxSize:10,nullable:false)
		orderNo(maxSize:15,nullable:false)
		packageNo(max:99999999999999,nullable:false)
		productCode(maxSize:16,nullable:false)
		hazardous(maxSize:1,nullable:false)
		convertsLineUomToHazUom(max:new BigDecimal("999999.99999"),nullable:false)
		hazQtyCode(maxSize:3,nullable:false)
		hazDesc(maxSize:50,nullable:false)
		packQuantity(max:new BigDecimal("999999999.99"),nullable:false)
		caseQuantity(max:new BigDecimal("999999999.99"),nullable:false)
		pickListNo(maxSize:15,nullable:false)
		poNo(maxSize:20,nullable:false)
		roundedWeight(max:new BigDecimal("9999999.9999"),nullable:false)
		actualWeight(max:new BigDecimal("9999999.9999"),nullable:false)
		billableWeight(max:new BigDecimal("9999999.9999"),nullable:false)
		reportWgt_aesFlg(maxSize:1,nullable:false)
		unitPrice(max:new BigDecimal("9999999.9999"),nullable:false)
		extendedPrice(max:new BigDecimal("9999999999999.9999"),nullable:false)
		itemWeight(max:new BigDecimal("9999999.9999"),nullable:false)
		wtUom(maxSize:5,nullable:false)
		unitValue(max:new BigDecimal("9999999.9999"),nullable:false)
		itemCubicSize(max:new BigDecimal("999999999999.9999"),nullable:false)
		totalCubicSize(max:new BigDecimal("999999999999.9999"),nullable:false)
		cubicUom(maxSize:3,nullable:false)
		freightClassCode(maxSize:16,nullable:false)
		packFactor(max:999999,nullable:false)
		packFactorUm(maxSize:5,nullable:false)
		upcCode(maxSize:15,nullable:false)
		addlDesc1(maxSize:35,nullable:false)
		addlDesc2(maxSize:35,nullable:false)
		addlDesc3(maxSize:35,nullable:false)
		pkmrks(maxSize:15,nullable:false)
		invoiceNo(maxSize:25,nullable:false)
		invLineNo(max:9999999,nullable:false)
		sequenceNo(max:9999999,nullable:false)
		exportInfoCode(maxSize:2,nullable:false)
		dutiableGoodsFlag(maxSize:1,nullable:false)
		aesLicenseTypeCd(maxSize:3,nullable:false)
		eccn(maxSize:15,nullable:false)
		expLicenseNo(maxSize:12,nullable:false)
		expLicExpireDate(max:99999999,nullable:false)
		licExceptnSymbol(maxSize:50,nullable:false)
		ftsrExemptionNo(maxSize:50,nullable:false)
		harmonizedCode(maxSize:15,nullable:false)
		scheduleBCode(maxSize:15,nullable:false)
		aesCommodityDesc(maxSize:45,nullable:false)
		scheduleBUnit1(max:new BigDecimal("9999999.9999"),nullable:false)
		scheduleBUom1(maxSize:3,nullable:false)
		conversionFactorForUnit1(max:new BigDecimal("9999999.9999"),nullable:false)
		scheduleBUnit2(max:new BigDecimal("9999999.9999"),nullable:false)
		scheduleBUom2(maxSize:3,nullable:false)
		conversionFactorForUnit12(max:new BigDecimal("9999999.9999"),nullable:false)
		foreign_domest_f_d(maxSize:1,nullable:false)
		countryOfOrigin(maxSize:2,nullable:false)
		countryOfManftr(maxSize:2,nullable:false)
		naftaProducer(maxSize:2,nullable:false)
		naftaPrefCriteria(maxSize:1,nullable:false)
		dangerousGoodsCode(maxSize:15,nullable:false)
		netCostMethRvc(maxSize:2,nullable:false)
		netCostBegDate(max:99999999,nullable:false)
		netCostEndDate(max:99999999,nullable:false)
		shipDate(max:99999999,nullable:false)
		shipTime(max:999999,nullable:false)
		shippedContainer(maxSize:30,nullable:false)
		qValue(max:new BigDecimal("999.9"),nullable:false)
		ddtcExemptionNo(maxSize:12,nullable:false)
		ddtcRegistrationNo(maxSize:6,nullable:false)
		ddtcSmeIndicator(maxSize:1,nullable:false)
		ddtcEligPtyCertf(maxSize:1,nullable:false)
		ddtcUsmlCategryCd(maxSize:2,nullable:false)
		ddtcUnitOfMsrCd(maxSize:3,nullable:false)
		ddtcQuantity(max:9999999,nullable:false)
		ddtcLicenseLineNo(maxSize:3,nullable:false)
		vehicleFlag(maxSize:1,nullable:false)
		vinProductId(maxSize:25,nullable:false)
		vinQualifier(maxSize:1,nullable:false)
		vehicleTitleNo(maxSize:15,nullable:false)
		vehicleTitleState(maxSize:2,nullable:false)
		itemComment1(maxSize:50,nullable:false)
		itemComment2(maxSize:50,nullable:false)
		itemComment3(maxSize:50,nullable:false)
		itemComment4(maxSize:50,nullable:false)
		misc1(maxSize:20,nullable:false)
		misc2(maxSize:20,nullable:false)
		misc3(maxSize:20,nullable:false)
		misc4(maxSize:20,nullable:false)
		misc5(maxSize:20,nullable:false)
		misc6(maxSize:20,nullable:false)
		misc7(maxSize:20,nullable:false)
		misc8(maxSize:20,nullable:false)
		misc9(maxSize:20,nullable:false)
		misc10(maxSize:20,nullable:false)
		numeric1(max:new BigDecimal("9999999.9999"),nullable:false)
		numeric2(max:new BigDecimal("9999999.9999"),nullable:false)
		numeric3(max:new BigDecimal("9999999.9999"),nullable:false)
		numeric4(max:new BigDecimal("9999999.9999"),nullable:false)
		numeric5(max:new BigDecimal("9999999.9999"),nullable:false)
		numericS1(max:999999999999999,nullable:false)
		numericS2(max:999999999999999,nullable:false)
		numericS3(max:999999999999999,nullable:false)
		numericS4(max:999999999999999,nullable:false)
		numericS5(max:999999999999999,nullable:false)
		flagArray(maxSize:200,nullable:false)
		packerId(maxSize:10,nullable:false)
		lastChangeUser(maxSize:10,nullable:false)
		lineNo(max:9999999,nullable:false)
		varsity01MscFld(maxSize:30,nullable:false)
		varsity02MscFld(maxSize:30,nullable:false)
		varsity03MscFld(maxSize:30,nullable:false)
		varsityMiscDecFld(max:new BigDecimal("9999999.9999"),nullable:false)
		varsityMiscDecFld2(max:new BigDecimal("9999999.9999"),nullable:false)
		varsityMiscDecFld3(max:new BigDecimal("9999999.9999"),nullable:false)
		aesCommodityLineNo(max:999999999999999,nullable:false)
		varsityMiscNumFld(max:999999999999999,nullable:false)
		varsityMiscNumFld2(max:999999999999999,nullable:false)
		lastChangeTime(max:999999,nullable:false)
		lastChangeDate(max:99999999,nullable:false)
		lastChangeDsp(maxSize:10,nullable:false)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = true
	static mapping = {
		table name:'vppack', schema:CH.config.varsity.schema
		version (false)
		id (generator:'assigned')
		id (composite:['compCode','orderShipNo','packControl','type','containerId','itemNo','itemStyle','itemColor','itemSize','itemLotNo','itemSerialNo','lineNo'])
		columns {
			id (composite:['compCode','orderShipNo','packControl','type','containerId','itemNo','itemStyle','itemColor','itemSize','itemLotNo','itemSerialNo','lineNo'])
			compCode (column:'PKCMNO', type:'TrimString')
			orderShipNo (column:'PKSHIP', type:'TrimString')
			packControl (column:'PKPCKC', type:'TrimString')
			type (column:'PKTYPE', type:'TrimString')
			status (column:'PKSTAT', type:'TrimString')
			indexNo (column:'PKINDX', type:'long')
			containerId (column:'PKCNID', type:'TrimString')
			itemNo (column:'PKPKIT', type:'TrimString')
			itemStyle (column:'PKSTYL', type:'TrimString')
			itemColor (column:'PKCOLR', type:'TrimString')
			itemSize (column:'PKSIZE', type:'TrimString')
			itemLotNo (column:'"PKLOT#"', type:'TrimString')
			itemSerialNo (column:'"PKSER#"', type:'TrimString')
			itemUnitMeasure (column:'PKITUM', type:'TrimString')
			itemDesc (column:'PKITDS', type:'TrimString')
			orderType (column:'PKOTYP', type:'TrimString')
			warehouse (column:'PKWHSE', type:'TrimString')
			orderNo (column:'PKORDR', type:'TrimString')
			packageNo (column:'PKPKNO', type:'long')
			productCode (column:'PKCLAS', type:'TrimString')
			hazardous (column:'PKHAZ', type:'TrimString')
			convertsLineUomToHazUom (column:'PKHQTY', type:'big_decimal')
			hazQtyCode (column:'PKMACD', type:'TrimString')
			hazDesc (column:'PKHDES', type:'TrimString')
			packQuantity (column:'PKPKQT', type:'big_decimal')
			caseQuantity (column:'PKCSQT', type:'big_decimal')
			pickListNo (column:'PKPKLT', type:'TrimString')
			poNo (column:'PKPONO', type:'TrimString')
			roundedWeight (column:'PKRWGT', type:'big_decimal')
			actualWeight (column:'PKAWGT', type:'big_decimal')
			billableWeight (column:'PKBWBT', type:'big_decimal')
			reportWgt_aesFlg (column:'PKAESW', type:'TrimString')
			unitPrice (column:'PKUNTP', type:'big_decimal')
			extendedPrice (column:'PKEXTP', type:'big_decimal')
			itemWeight (column:'PKIWGT', type:'big_decimal')
			wtUom (column:'PKWUOM', type:'TrimString')
			unitValue (column:'PKUVAL', type:'big_decimal')
			itemCubicSize (column:'PKCUBI', type:'big_decimal')
			totalCubicSize (column:'PKTCUB', type:'big_decimal')
			cubicUom (column:'PKCUBU', type:'TrimString')
			freightClassCode (column:'PKFCLS', type:'TrimString')
			packFactor (column:'PKPFCT', type:'int')
			packFactorUm (column:'PKPFUM', type:'TrimString')
			upcCode (column:'"PKUPC#"', type:'TrimString')
			addlDesc1 (column:'PKDES1', type:'TrimString')
			addlDesc2 (column:'PKDES2', type:'TrimString')
			addlDesc3 (column:'PKDES3', type:'TrimString')
			pkmrks (column:'PKMRKS', type:'TrimString')
			invoiceNo (column:'PKINVN', type:'TrimString')
			invLineNo (column:'PKINLN', type:'int')
			sequenceNo (column:'PKSEQN', type:'int')
			exportInfoCode (column:'PKCEIC', type:'TrimString')
			dutiableGoodsFlag (column:'PKDTYF', type:'TrimString')
			aesLicenseTypeCd (column:'PKLICD', type:'TrimString')
			eccn (column:'PKECCN', type:'TrimString')
			expLicenseNo (column:'PKLICN', type:'TrimString')
			expLicExpireDate (column:'PKLCDT', type:'int')
			licExceptnSymbol (column:'PKESYM', type:'TrimString')
			ftsrExemptionNo (column:'PKFTEN', type:'TrimString')
			harmonizedCode (column:'PKHARM', type:'TrimString')
			scheduleBCode (column:'PKSCDB', type:'TrimString')
			aesCommodityDesc (column:'PKCDES', type:'TrimString')
			scheduleBUnit1 (column:'PKSBU1', type:'big_decimal')
			scheduleBUom1 (column:'PKSBM1', type:'TrimString')
			conversionFactorForUnit1 (column:'PKSBC1', type:'big_decimal')
			scheduleBUnit2 (column:'PKSBU2', type:'big_decimal')
			scheduleBUom2 (column:'PKSBM2', type:'TrimString')
			conversionFactorForUnit12 (column:'PKSBC2', type:'big_decimal')
			foreign_domest_f_d (column:'PKORIG', type:'TrimString')
			countryOfOrigin (column:'PKCCOR', type:'TrimString')
			countryOfManftr (column:'PKCMFG', type:'TrimString')
			naftaProducer (column:'PKNPRD', type:'TrimString')
			naftaPrefCriteria (column:'PKPRCT', type:'TrimString')
			dangerousGoodsCode (column:'PKDGCD', type:'TrimString')
			netCostMethRvc (column:'PKNCST', type:'TrimString')
			netCostBegDate (column:'PKNCBD', type:'int')
			netCostEndDate (column:'PKNCED', type:'int')
			shipDate (column:'PKSDAT', type:'int')
			shipTime (column:'PKSTIM', type:'int')
			shippedContainer (column:'PKSHCN', type:'TrimString')
			qValue (column:'PKQVAL', type:'big_decimal')
			ddtcExemptionNo (column:'PKITAR', type:'TrimString')
			ddtcRegistrationNo (column:'PKREGN', type:'TrimString')
			ddtcSmeIndicator (column:'PKSMEI', type:'TrimString')
			ddtcEligPtyCertf (column:'PKEPCI', type:'TrimString')
			ddtcUsmlCategryCd (column:'PKCATC', type:'TrimString')
			ddtcUnitOfMsrCd (column:'PKDUOM', type:'TrimString')
			ddtcQuantity (column:'PKDQTY', type:'int')
			ddtcLicenseLineNo (column:'PKDLLN', type:'TrimString')
			vehicleFlag (column:'PKVEHF', type:'TrimString')
			vinProductId (column:'PKVINP', type:'TrimString')
			vinQualifier (column:'PKVINQ', type:'TrimString')
			vehicleTitleNo (column:'PKTTLN', type:'TrimString')
			vehicleTitleState (column:'PKTTLS', type:'TrimString')
			itemComment1 (column:'PKCOM1', type:'TrimString')
			itemComment2 (column:'PKCOM2', type:'TrimString')
			itemComment3 (column:'PKCOM3', type:'TrimString')
			itemComment4 (column:'PKCOM4', type:'TrimString')
			misc1 (column:'PKMSC1', type:'TrimString')
			misc2 (column:'PKMSC2', type:'TrimString')
			misc3 (column:'PKMSC3', type:'TrimString')
			misc4 (column:'PKMSC4', type:'TrimString')
			misc5 (column:'PKMSC5', type:'TrimString')
			misc6 (column:'PKMSC6', type:'TrimString')
			misc7 (column:'PKMSC7', type:'TrimString')
			misc8 (column:'PKMSC8', type:'TrimString')
			misc9 (column:'PKMSC9', type:'TrimString')
			misc10 (column:'PKMSC0', type:'TrimString')
			numeric1 (column:'PKNUM1', type:'big_decimal')
			numeric2 (column:'PKNUM2', type:'big_decimal')
			numeric3 (column:'PKNUM3', type:'big_decimal')
			numeric4 (column:'PKNUM4', type:'big_decimal')
			numeric5 (column:'PKNUM5', type:'big_decimal')
			numericS1 (column:'PKNMS1', type:'long')
			numericS2 (column:'PKNMS2', type:'long')
			numericS3 (column:'PKNMS3', type:'long')
			numericS4 (column:'PKNMS4', type:'long')
			numericS5 (column:'PKNMS5', type:'long')
			flagArray (column:'PKFLAG', type:'TrimString')
			packerId (column:'PKPKID', type:'TrimString')
			lastChangeUser (column:'PKUSER', type:'TrimString')
			lineNo (column:'"PKLIN#"', type:'int')
			varsity01MscFld (column:'PKVS01', type:'TrimString')
			varsity02MscFld (column:'PKVS02', type:'TrimString')
			varsity03MscFld (column:'PKVS03', type:'TrimString')
			varsityMiscDecFld (column:'PKVS10', type:'big_decimal')
			varsityMiscDecFld2 (column:'PKVS11', type:'big_decimal')
			varsityMiscDecFld3 (column:'PKVS12', type:'big_decimal')
			aesCommodityLineNo (column:'PKVS20', type:'long')
			varsityMiscNumFld (column:'PKVS21', type:'long')
			varsityMiscNumFld2 (column:'PKVS23', type:'long')
			lastChangeTime (column:'PKCHGT', type:'int')
			lastChangeDate (column:'PKCHGD', type:'int')
			lastChangeDsp (column:'PKDSTN', type:'TrimString')
		}
	}
	boolean newEntity = false
	boolean returnIt = true
	static transients = ['newEntity', 'returnIt']
}
