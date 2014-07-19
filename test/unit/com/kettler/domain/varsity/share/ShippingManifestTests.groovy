package com.kettler.domain.varsity.share

import grails.test.*

class ShippingManifestTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void test_contraints() {
        mockForConstraintsTests(ShippingManifest)
    	def mani = new ShippingManifest(compCode:'01', orderShipNo:'377066-01', actualFrtChg:9.78g, totalWeight:3g) 
    	if (!mani.save()) {
    		mani.errors.each {println it}
    		assert false
    	}
    }
}
