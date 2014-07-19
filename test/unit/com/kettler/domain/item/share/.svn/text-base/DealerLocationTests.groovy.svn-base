package com.kettler.domain.item.share
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

import grails.test.*
import com.kettler.domain.actrcv.share.Customer
import com.kettler.geocode.GeocodeService

class DealerLocationTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
        mockDomain (DealerLocation)
        mockDomain (DealerInventory)
        mockDomain (Dealer)
        mockDomain (Customer)
        mockDomain (ItemMasterExt)
        mockDomain (WebDivision)
        mockDomain (WebCategory)
        mockConfig('''
			orderentry {
				schema = 'test'
			}
		''')
        assertEquals 'test', CH.config.orderentry.schema
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testConstraints() {
        DealerLocation dl1 = new DealerLocation()
        assertFalse dl1.validate()
        println dl1.errors["lat"]
        println dl1.errors["city"]
        assertEquals null, dl1.errors["lat"]
        assertEquals null, dl1.errors["lng"]
        assertEquals "nullable", dl1.errors["street"]
        assertEquals "nullable", dl1.errors["city"]
        assertEquals "nullable", dl1.errors["state"]
        assertEquals null, dl1.errors["zip"]
        assertEquals "nullable", dl1.errors["dealer"]
    }

    void testDealerAssociation() {
        Dealer d = new Dealer()
        Customer c1 = new Customer(compCode:'01', custNo:'RETAIL', name:'Retail Web')
        d.customer = c1
        DealerLocation dl = new DealerLocation()
        dl.street = '12 main'
        dl.city = 'jamestown'
        dl.state = 'va'
        WebDivision wd = new WebDivision(name:'toys', keywords:'toys')
        WebCategory wc = new WebCategory(name:'balance bikes', keywords:'balance bikes')
        ItemMasterExt item = new ItemMasterExt(itemNo:'a', altItemNo:'a2', substituteItemNo:'a3',
                desc:'alpha bike', shortName:'alphaShort', color:'orange', countryOfOrigin:'CHI',
                compCode:'01', profitCenterClass:'4', articleGroupClass:'D13',
                division:wd, category:wc, collection:'')
        DealerInventory di = new DealerInventory(quantity:2, item:item)
        dl.addToInventories(di)
        d.addToLocations(dl)
        assertTrue d.locations.size() == 1
    }

}
