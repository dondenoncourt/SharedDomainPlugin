package com.kettler.domain.orderentry.share;
import grails.test.*

class CreditCardEncryptDecryptTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void test_unique() {
        Consumer consumer = new Consumer(email:'test@home.com', password:'secret2', name:'Sam Iam')
		def one = new ConsumerBillTo( name:'Don Denoncourt', addr1:'11203 Pinewood Court', addr2:null, city:'Richmond', state:'VA', zipCode:'23238', cardType:'visa', 
				cardNo:'4111111111111111', ccid:123, expYear:2011, expMonth:12)
        consumer.addToBillTos one
        if (!consumer.save(flush:true)) {
        	consumer.errors.each {println it}
        	assert false
        }
        def updatedBillTo = ConsumerBillTo.findByName('Don Denoncourt')
        assertEquals '4111111111111111', updatedBillTo.cardNoEncrypted
    }
}

