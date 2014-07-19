
package com.kettler.domain.orderentry.share;

import com.kettler.domain.orderentry.share.ShipToZoneState

import com.kettler.domain.orderentry.share.ShipToZone
 
import grails.test.*


class ShipToZoneStateTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void test_contraints() {

                
        mockForConstraintsTests(ShipToZoneState)

        // Validation should fail if properties are null. 
		def shipToZoneState = new ShipToZoneState() 
		assertFalse shipToZoneState.validate()
        assertEquals 'nullable', shipToZoneState.errors['state']
        assertEquals 'nullable', shipToZoneState.errors['scacCode']
        
        shipToZoneState.state = 'xa'
		shipToZoneState.scacCode = '1111'
        assertFalse shipToZoneState.validate()
        assertEquals 'inList', shipToZoneState.errors['state']

		shipToZoneState.state = ''
		shipToZoneState.scacCode = '1111'
		assertFalse shipToZoneState.validate()
		assertEquals 'blank', shipToZoneState.errors['state']

		shipToZoneState.state = 'VA'
		shipToZoneState.scacCode = '12345'
		assertFalse shipToZoneState.validate()
		assertEquals 'maxSize', shipToZoneState.errors['scacCode']

		shipToZoneState.state = 'VA'
		shipToZoneState.scacCode = '1234'
		assertFalse shipToZoneState.validate()
		assertEquals "nullable", shipToZoneState.errors['zone']

		ShipToZone shipToZone = new ShipToZone(name:'NorthEast', cost:125.00g)
        mockDomain(ShipToZone, [ shipToZone ])

        shipToZone.addToStates shipToZoneState 

        
        assertTrue shipToZoneState.validate()
 
        
    }
}