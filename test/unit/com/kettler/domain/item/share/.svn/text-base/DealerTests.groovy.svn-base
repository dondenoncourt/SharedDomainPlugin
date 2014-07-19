package com.kettler.domain.item.share

import grails.test.*
import com.kettler.domain.actrcv.share.Customer
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class DealerTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
        mockDomain (Customer)
        mockDomain (Dealer)
        mockDomain (WebDivision)
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

    void testRequireRelations() {
        Dealer d1 = new Dealer()
        assertFalse d1.validate()
    }

    void testAttributes() {
        Dealer d1 = new Dealer(website:'foo')
        assertEquals d1.website, 'foo'
    }

    void testCustomerRelationship() {
        Customer c1 = new Customer(compCode:'01', custNo:'RETAIL', name:'Retail Web')
        WebDivision wd = new WebDivision(name:'toys', keywords:'toys')
        Dealer d1 = new Dealer(customer: c1, division: wd)
        assertEquals d1.customer.name, 'Retail Web'
        assertEquals d1.division.name, 'toys'
        assertTrue d1.validate()
    }
}
