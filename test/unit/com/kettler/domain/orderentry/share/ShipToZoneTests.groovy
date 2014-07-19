
package com.kettler.domain.orderentry.share


import com.kettler.domain.orderentry.share.ShipToZone
 
import grails.test.*


class ShipToZoneTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void test_contraints() {

    	ShipToZone shipToZoneExisting = new ShipToZone(name:'NorthEast', cost:125.00g)
        mockForConstraintsTests(ShipToZone, [ shipToZoneExisting ])
        //assert existingConsumer.save()

        // Validation should fail if properties are null. 
		def shipToZone = new ShipToZone() 
		assertFalse shipToZone.validate() 
		assertEquals "nullable", shipToZone.errors["name"] 
		assertEquals "nullable", shipToZone.errors["cost"]
                                                
		shipToZone.name = 'NorthEast'
        assertFalse shipToZone.validate() 
        assertEquals "unique", shipToZone.errors["name"]
        
        shipToZone.name = ''
        shipToZone.cost = 125.00g
        assertFalse shipToZone.validate() 
        assertEquals "blank", shipToZone.errors["name"] 
        
        shipToZone.name = '01234567890123456789012345'
        shipToZone.cost = 125.00g
        assertFalse shipToZone.validate()
        assertEquals "maxSize", shipToZone.errors["name"] 
                
//cannot run for 0, it sends back nullable????
//        shipToZone.name = 'South'
//        shipToZone.cost = 0.00g
//		println(shipToZone.dump())
//        assertFalse shipToZone.validate()
//        assertEquals "min", shipToZone.errors["cost"] 

        shipToZone.name = 'South'
        shipToZone.cost = -10.00g
		println(shipToZone.dump())
        assertFalse shipToZone.validate()
        assertEquals "min", shipToZone.errors["cost"]
		
		shipToZone.name = 'South'
		shipToZone.cost = 10000.00g
		assertFalse shipToZone.validate()
		assertEquals "max", shipToZone.errors["cost"]

		
		shipToZone.name = 'East'
		shipToZone.cost = 150.00g
		assertTrue shipToZone.validate()

        
    }
}