package com.kettler.geocode

import grails.test.*

class GeocodeServiceTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
        mockLogging(GeocodeService.class)
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testService() {
        Geocode bean = new Geocode()
        bean.address = '1355 London Bridge Rd   Virginia Beach, VA 23453'
        GeocodeService service = new GeocodeService()
        service.updateLatLng(bean)
        println bean
        assertTrue bean.success
        assertTrue bean.lat > 0.0F
        assertTrue bean.lng < 0.0F
        bean = new Geocode()
        bean.address = ''
        service.updateLatLng(bean)
        println bean
        assertFalse bean.success
        assertTrue bean.errorMessage.length() > 0
    }
}
