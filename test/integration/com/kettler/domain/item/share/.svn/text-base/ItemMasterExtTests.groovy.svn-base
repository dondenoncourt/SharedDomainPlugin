package com.kettler.domain.item.share;
import com.kettler.domain.actrcv.share.Customer
import grails.test.*
import org.compass.core.engine.SearchEngineQueryParseException

class ItemMasterExtTests extends GrailsUnitTestCase { 
	def searchableService
    protected void setUp() {
        super.setUp()
        ItemMasterExt.list()*.delete()
        assert new ItemMaster(compCode:'01', itemNo:'one',        shortName:'one',          nmfcNo:'15520-9', closeoutCode:false, basePrice:199.32g, taxableCode:true, desc:'one desc', arDistrictCode:'FIT', stdUnitMeas:'EA',  lowestUnitMeas:'EA').save()
        assert new ItemMaster(compCode:'01', itemNo:'two',        shortName:'two',          nmfcNo:'15520-9', closeoutCode:false, basePrice:214.01g, taxableCode:false, desc:'two desc', arDistrictCode:'TOY', stdUnitMeas:'PCK', lowestUnitMeas:'EA', convFactor:50).save() 
        assert new ItemMaster(compCode:'01', itemNo:'chair-desk', shortName:ItemMaster.KIT, nmfcNo:'15520-9', closeoutCode:false).save()
        assert new ItemMaster(compCode:'01', itemNo:'chair',      shortName:'chair',        nmfcNo:'15520-9', closeoutCode:false).save()
        assert new ItemMaster(compCode:'01', itemNo:'desk',       shortName:'desk',         nmfcNo:'15520-9', closeoutCode:false).save()
        
        def toys = new WebDivision(name:'toys', keywords:'toys')
		assert toys.save()   
        def tt =  new WebDivision(name:'table tennis', keywords:'table tennis')  
		assert tt.save()   
        def patio =  new WebDivision(name:'patio', keywords:'patio')   
		assert patio.save()
		
		assert new WebCategory(name:'balance bikes', division:toys, keywords:'balance bikes').save()
		assert new WebCategory(name:'tricycles', division:toys, keywords:'tricycles').save()
		assert new WebCategory(name:'indoor', division:tt, keywords:'indoor').save()
		assert new WebCategory(name:'outdoor', division:tt, keywords:'outdoor').save()
		assert new WebCategory(name:'resin', division:patio, keywords:'resin').save()
        		  
        def imw = new ItemMasterExt(itemNo:'a', altItemNo:'a2', substituteItemNo:'a3', desc:'alpha bike', shortName:'alphaShort', color:'orange', countryOfOrigin:'CHI', compCode:'01', 
        		       profitCenterClass:'4', articleGroupClass:'D13', division:WebDivision.findByName('toys'), category:WebCategory.findByName('balance bikes'), collection:'')
        def ok = imw.save(insert:true)
        if (!ok) {
            imw.errors.allErrors.each { println it.inspect() }
            assert ok
        }
        
        assert new ItemMasterExt(itemNo:'b', altItemNo:'b2', substituteItemNo:'b3', desc:'beta trike', shortName:'betaShort', color:'green', countryOfOrigin:'DEU', compCode:'01', 
    		       profitCenterClass:'4', articleGroupClass:'D01', division:WebDivision.findByName('toys'), category:WebCategory.findByName('balance bikes'), collection:'').save(insert:true)
        assert new ItemMasterExt(itemNo:'c', altItemNo:'c2', substituteItemNo:'c3', desc:'ceta table', shortName:'cetaShort', color:'yellow', countryOfOrigin:'USA', compCode:'01', 
    		       profitCenterClass:'1', articleGroupClass:'A40', division:WebDivision.findByName('table tennis'), category:WebCategory.findByName('indoor'), collection:'').save(insert:true)
        assert new ItemMasterExt(itemNo:'d', altItemNo:'d2', substituteItemNo:'d3', desc:'delta table', shortName:'deltaShort', color:'blue', countryOfOrigin:'USA', compCode:'01', 
    		       profitCenterClass:'1', articleGroupClass:'A49', division:WebDivision.findByName('table tennis'), category:WebCategory.findByName('outdoor'), collection:'').save(insert:true)
        assert new ItemMasterExt(itemNo:'e', altItemNo:'e2', substituteItemNo:'e3', desc:'epsilon patio', shortName:'epsilShort', color:'orange', countryOfOrigin:'CHI', compCode:'01', 
    		       profitCenterClass:'2', articleGroupClass:'B01', division:WebDivision.findByName('patio'), category:WebCategory.findByName('resin'), collection:'deNoncour').save(insert:true)
	    assert new ItemMasterExt(itemNo:'partsA',compCode:'01', parts:true, division:WebDivision.findByName('patio'), category:WebCategory.findByName('resin'), collection:'').save(insert:true)
		assert null == new ItemMasterExt(itemNo:'partsAB',compCode:'01', parts:true, division:WebDivision.findByName('patio'), category:WebCategory.findByName('tricycles'), collection:'').save(insert:true)
		assert new ItemMasterExt(itemNo:'partsAB',compCode:'01', parts:true, division:WebDivision.findByName('patio'), category:WebCategory.findByName('resin'), collection:'').save(insert:true)
        assert new ItemMasterExt(itemNo:'olddesk', altItemNo:'olddesk', substituteItemNo:'olddesk', desc:'old desk', shortName:'olddesk', countryOfOrigin:'DEU', compCode:'01', 
    		       closeoutCode:true, profitCenterClass:'4', articleGroupClass:'D01', division:WebDivision.findByName('patio'), category:WebCategory.findByName('resin'), collection:'').save(insert:true)
		
		def itemList = ItemMasterExt.withCriteria {
			def search = "ta"
			ilike('desc', "%${search}%")
		}
		println itemList.dump()
		assert itemList

    }

    protected void tearDown() {
        super.tearDown()
    }

    void test_searchable() {
        Thread.start {searchableService.index()}
        try {
        	//String searchStr = convertCountry("betaShort")
        	def params = [:]
            def search = ItemMasterExt.search("betaShort", params )
            assertEquals 1, search.results.size()
            assertEquals 'b', search.results[0].itemNo
                        
            search = ItemMasterExt.search("toys", params )
            assertEquals 0, search.results.size()  // turned off WebDivision in search 
//            assertEquals 'a', search.results[0].itemNo
            // note, you can put 'sort' then 'order' or 'direction' in params
//            
//            search = ItemMasterExt.search {        
//                must(queryString("toys")) 
//                mustNot(term("parts", true))       
//            }
//            assertEquals 2, search.results.size()
            
        } catch (SearchEngineQueryParseException ex) {
        	println ex
            assert false
        }

    }
    void test_convert_country() {
    	assertEquals "MADE IN DEU ", ItemMasterExt.convertCountry("MADE IN GERMANY")
    	assertEquals "DEU bike ", ItemMasterExt.convertCountry("german bike")
    	assertEquals "USA bike ", ItemMasterExt.convertCountry("US bike")
    	assertEquals "TWN toy ", ItemMasterExt.convertCountry("taiwan toy")
    	assertEquals "TWN toy ", ItemMasterExt.convertCountry("tai toy")
    	assertEquals "MEX toy ", ItemMasterExt.convertCountry("mexican toy")
    	assertEquals "MEX toy ", ItemMasterExt.convertCountry("mexico toy")
    	assertEquals "ITA bicycle ", ItemMasterExt.convertCountry("ITALIAN bicycle")
    	assertEquals "bicycle made in ITA ", ItemMasterExt.convertCountry("bicycle made in italy")
    }
    void test_accessories() {
    	def item = ItemMasterExt.findByItemNo('partsAB')
    	assertEquals 'partsAB', ItemMasterExt.findByItemNo('partsAB').itemNo
    	List accessories = []
    	accessories << ItemMasterExt.findByItemNo('b').id
    	accessories << ItemMasterExt.findByItemNo('c').id
    	assertEquals 2, accessories.size()
        accessories.each{accessoryId ->
	    	item.addToAccessories(new ItemAccessory(accessory:ItemMasterExt.get(accessoryId)))
	    }
    	assertEquals 2, item.accessories.size()
    }
    void test_exclusive_dealer() {
        WebDivision wd = new WebDivision(name:'toys2', keywords:'toys')        
        if (!wd.save(flush:true)) {
        	wd.errors.each{println it}
        	assertEquals("WebDivision save failed", true, false)
        }
        Customer c1 = new Customer(compCode:'01', custNo:'KE1126', name:'Retail Web', salespersonCode:'123',
        		         addr1:'street', city:'city', state:'VA', zipCode:'23238', shortName:'KE1126',
        		         activeCode:'Y', countryCode:'USA', salesDivision:'S', termsCode:'1')
        if (!c1.save(flush:true)) {
        	c1.errors.each{println it}
        	assertEquals("customer save failed", true, false)
        }
        Dealer d = new Dealer(division:wd, customer:c1)
        if (!d.save(flush:true)) {
        	d.errors.each{println it}
        	assertEquals("dealer save failed", true, false)
        }
        WebCategory wc = new WebCategory(division:wd, name:'balance bikes2', keywords:'balance bikes')
        if (!wc.save(flush:true)) {
        	wc.errors.each{println it}
        	assertEquals("WebCategory save failed", true, false)
        }
        ItemMasterExt itemEx = new ItemMasterExt(itemNo:'a', altItemNo:'a2', substituteItemNo:'a3',
                desc:'alpha bike', shortName:'alphaShort', color:'orange', countryOfOrigin:'CHI',
                compCode:'01', profitCenterClass:'4', articleGroupClass:'D13',
                division:wd, category:wc, collection:'', dealerId:d.id)
        if (!itemEx.save(flush:true)) {
            assertEquals "kettler.itemMasterExt.dealer.no.logo", itemEx.errors.getFieldError('dealerId').code
        }
        d.logo = 'some bytes'.bytes
        d.save(flush:true)
        if (!itemEx.save(flush:true)) {
        	itemEx.errors.each{println it}
        	assertEquals("item save failed", true, false)
        }
        
    }
    void test_named_queries() {
    	assertEquals 1, ItemMasterExt.division('patio', 0, null).count()
    	assertEquals 1, ItemMasterExt.division('patio', 0, null, true).count()
    	assertEquals false, ItemMasterExt.division('patio', 10, null).list()[0].closeoutCode
    	assertEquals true, ItemMasterExt.division('patio', 10, null, true).list()[0].closeoutCode
    	assertEquals 1, ItemMasterExt.category('patio', 'resin', 0, null).count()
    	assertEquals 1, ItemMasterExt.category('patio', 'resin', 0, null, true).count()
    	assertEquals false, ItemMasterExt.category('patio', 'resin', 10, null).list()[0].closeoutCode
    	assertEquals true, ItemMasterExt.category('patio', 'resin', 10, null, true).list()[0].closeoutCode
    	assertEquals 1, ItemMasterExt.collection('deNoncour', null).count()
    	assertEquals 0, ItemMasterExt.collection('deNoncour', null, true).count()
    }
    
}
