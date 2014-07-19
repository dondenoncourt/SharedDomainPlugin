package com.kettler.domain.orderentry.share;
import grails.test.*

class ConsumerBillToTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void test_contraints() {
        mockForConstraintsTests(ConsumerBillTo)

        // Validation should fail if properties are null. 
		def billTo = new ConsumerBillTo() 
		assertFalse billTo.validate()
        assertEquals 'nullable', billTo.errors['addr1']
        assertEquals 'nullable', billTo.errors['cardNo']
        assertEquals 'nullable', billTo.errors['cardType']
        assertEquals 'min',      billTo.errors['ccid']
        assertEquals 'nullable', billTo.errors['city']
        assertEquals 'nullable', billTo.errors['consumer']
        assertEquals 'nullable', billTo.errors['name']
        assertEquals 'nullable', billTo.errors['state']
        assertEquals 'nullable', billTo.errors['zipCode']
        
        billTo.name = 'Don G Denoncourt'
        billTo.addr1 = '11203 Pinewood Court'
        billTo.city = 'Ashburn'
        billTo.state = 'xa'
        billTo.zipCode = 'myzip'
                
        assertFalse billTo.validate()
        assertEquals 'inList', billTo.errors['state']
        assertEquals "kettler.zipCode.usa.invalid", billTo.errors['zipCode']
        
        billTo.state = 'VA'
        billTo.zipCode = '20148' 
        billTo.cardType = 'invalid'
        billTo.cardNo = 'invalid'
        billTo.ccid = 0
        assertFalse billTo.validate()
        assertEquals 'creditCard', billTo.errors['cardNo']
        assertEquals "min", billTo.errors['ccid'] 
        assertEquals "inList", billTo.errors['cardType'] 
        
        billTo.cardType = 'visa'
        billTo.cardNo = '4111111111111111'
        billTo.ccid = 23
        assertFalse billTo.validate()
        assertEquals "nullable", billTo.errors['consumer'] 
        assertEquals "023", billTo.zeroPadCCID() 

        billTo.cardType = 'american express'
        billTo.ccid = 12
        assertEquals "0012", billTo.zeroPadCCID() 
        
        Consumer consumer = new Consumer(email:'test@home.com', password:'secret2', name:'Sam Iam')
        mockDomain(Consumer, [ consumer ])

        consumer.addToBillTos billTo 

        
        assertFalse billTo.validate()
        //billTo.errors.each {println it}
        assertEquals 'range', billTo.errors['expYear']
        assertEquals 'range', billTo.errors['expMonth']
        billTo.expYear = 2011
        billTo.expMonth = 11
        
        assertTrue billTo.validate()
                
    }
    void test_equals() {
    		def one = new ConsumerBillTo( name:'Don Denoncourt', addr1:'11203 Pinewood Court', addr2:null, city:'Richmond', state:'VA', zipCode:'23238', cardType:'visa', cardNo:'4111111111111111', ccid:123, expYear:2011, expMonth:12)
    		def two = new ConsumerBillTo( name:'Don Denoncourt', addr1:'11203 Pinewood Court', addr2:null, city:'Richmond', state:'VA', zipCode:'23238', cardType:'visa', cardNo:'4111111111111111', ccid:123, expYear:2011, expMonth:12)
    		assertEquals one,two
    }
    void test_unique() {
        Consumer consumer = new Consumer(email:'test@home.com', password:'secret2', name:'Sam Iam')
        mockDomain(Consumer, [ consumer ])
		def one = new ConsumerBillTo( name:'Don Denoncourt', addr1:'11203 Pinewood Court', addr2:null, city:'Richmond', state:'VA', zipCode:'23238', cardType:'visa', cardNo:'4111111111111111', ccid:123, expYear:2011, expMonth:12)
        consumer.addToBillTos one 
		def two = new ConsumerBillTo( name:'Sue Denoncourt', addr1:'11203 Pinewood Court', addr2:null, city:'Richmond', state:'VA', zipCode:'23238', cardType:'visa', cardNo:'4111111111111111', ccid:123, expYear:2011, expMonth:12)
        assert two.unique(consumer.billTos).is(two)
        consumer.addToBillTos two 
		def dup = new ConsumerBillTo( name:'Don Denoncourt', addr1:'11203 Pinewood Court', addr2:null, city:'Richmond', state:'VA', zipCode:'23238', cardType:'visa', cardNo:'4111111111111111', ccid:123, expYear:2011, expMonth:12)
        assert one.unique(consumer.billTos).is(one)
    }
}
