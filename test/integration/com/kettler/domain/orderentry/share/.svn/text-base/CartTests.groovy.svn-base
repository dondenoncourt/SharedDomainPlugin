package com.kettler.domain.orderentry.share

import java.math.BigDecimal;

import grails.test.*
import com.kettler.domain.item.share.ItemMasterExt
import com.kettler.domain.item.share.WebDivision
import com.kettler.domain.item.share.WebCategory
import com.kettler.domain.orderentry.share.Coupon

class CartTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
        
        def salesTax = new SalesTax(desc:'va', taxPct:5.0g, arDistCode:'x')
        salesTax.id = 'VA'
        assert salesTax.save()
        
        Consumer consumer = new Consumer(email:'test@home.com', password:'secret2', name:'Sam Iam')
        ConsumerBillTo billTo = new ConsumerBillTo() 
        billTo.name = 'Don G Denoncourt'
        billTo.addr1 = '11203 Pinewood Court'
        billTo.city = 'Richmond'
        billTo.state = 'VA'
        billTo.zipCode = '23238'
        billTo.cardType = 'visa'
        billTo.cardNo = '4111111111111111'
        billTo.ccid = 123
        consumer.addToBillTos billTo 
        billTo.expYear = 2011
        billTo.expMonth = 11
        
        if (!consumer.save()) {
        	consumer.errors.each {println it}
        	assert false
        }
        assertTrue billTo.validate()
        
    }

    protected void tearDown() {
        super.tearDown()
    }
    
    void test_constraints() {
		def div = new WebDivision(name:'toys', keywords:'toys')
		assert div.save()   
		def cat = new WebCategory(name:'knives', division:div, keywords:'knives')
		assert cat.save()
		def item = new ItemMasterExt(itemNo:'valid', compCode:'01', category:cat, division:div, retailPrice:1.00g)
        // Validation should fail if properties are null. 
    	def cart = new Cart() 
		//assertFalse cart.validate()

		def cartItem = new CartItem()
		assertFalse cartItem.validate()
        assertEquals 'min.notmet', cartItem.errors.getFieldError('qty').code
        assertEquals 'nullable', cartItem.errors.getFieldError('cart').code
        assertEquals 'nullable', cartItem.errors.getFieldError('item').code
        assertEquals 3, cartItem.errors.errorCount

        cart.addToItems cartItem
        
        cartItem.item = item
        cartItem.qty = 2
        
		assertTrue cartItem.validate()
        //cartItem.errors.each {println it}
    }
    void test_cart_level_coupon() {
    	// TODO
    }

    void test_item_level_coupon() {
    	def division = new WebDivision(name:'toys', keywords:'toys').save(flush:true) 
    	def category = new WebCategory(name:'balance bikes', division:division, keywords:'balance bikes').save(flush:true)
    	assert division
    	assert category
        def item1 = new ItemMasterExt(itemNo:'item1', compCode:'01', collection:'', category:category, division:division, retailPrice:1.00g)
        assert item1.save(flush:true)
        def item2 = new ItemMasterExt(itemNo:'item2', compCode:'01', collection:'', category:category, division:division, retailPrice:1.00g).save(flush:true)
                
    	def cart = new Cart() 
		def cartItem = new CartItem(item:item1, qty:2)
        cart.addToItems cartItem
		assertTrue cartItem.validate()

        def couponItem2 = new Coupon(no:'xyz', item:item2, percent:10, start:new Date()-5, expire:new Date()) 
        assertTrue couponItem2.validate()
        couponItem2.save(flush:true)
        cartItem.coupon = couponItem2
        cartItem.validate()
        println "cartItem.errors.each {println it}:" 
        cartItem.errors.each {println it}
        assertEquals "kettler.coupon.item.invalid", cartItem.errors.getFieldError('couponId').code
        assertEquals 1, cartItem.errors.errorCount

		def couponItem1 = new Coupon(no:'abc', item:item1, percent:10, start:new Date()-5, expire:new Date())
        assertTrue couponItem1.validate()
        println "couponItem1.errors.each {println it}:" 
        couponItem1.errors.each {println it}
        couponItem1.save(flush:true)
        cartItem.coupon = couponItem1
		assertTrue cartItem.validate()
		
		assert Consumer.findByEmail('test@home.com') 
		cart.consumer = Consumer.findByEmail('test@home.com') 
		cart.consumerBillTo = cart.consumer.billTos.toArray()[0]
		assert cart.consumerBillTo
		assertEquals 1, cart.items.size()
		assertEquals 1.89g, cart.total()
		assertEquals 2, cart.total().scale()
        
    }

}
