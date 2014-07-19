package com.kettler.domain.orderentry.share;
import grails.test.*
import groovy.mock.interceptor.*

class ConsumerTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void test_contraints() {
    	Consumer existingConsumer = new Consumer(email:'test@home.com', password:'secret2', name:'Sam Iam')
        mockForConstraintsTests(Consumer, [ existingConsumer ])
        // Validation should fail if properties are null. 
        def consumer = new Consumer()
        mockForConstraintsTests(Consumer, [existingConsumer, consumer])
        Consumer.metaClass.findByEmail {email -> return true}
        assertFalse consumer.validate() 
		assertEquals "nullable", consumer.errors["email"] 
		assertEquals "nullable", consumer.errors["password"]
        assertEquals "nullable", consumer.errors["name"]
                                                
		consumer.email = 'test@home.com'
        assertFalse consumer.validate() 
        //assertEquals "unique", consumer.errors["email"] no longer works as findByEmail not found in unit tests
        
        consumer.email = 'test2@home.com'
        consumer.password = '6digits'
        consumer.email='dontwork'
        assertFalse consumer.validate() 
        assertEquals "nullable", consumer.errors["name"] 
        
        consumer.email = 'test2@home.com'
        consumer.password = 'short'
        assertFalse consumer.validate()
        assertEquals "short", consumer.errors["password"] 
                
        consumer.password = '6digits'
        consumer.name = ''
        assertFalse consumer.validate()       		
		assertEquals "blank", consumer.errors["name"] 
        
        consumer.name = 'Don Denoncourt'
        assertTrue consumer.validate()
        
        consumer.saveAccount = false
        consumer.password = '' // is !saveAcount password is not required 
        assertTrue consumer.validate()
        //consumer.errors.each {println it}
                        
    }
}
