package com.kettler.service.orderentry

import com.kettler.domain.actrcv.share.Customer;

import com.kettler.domain.orderentry.share.Cart;
import com.kettler.domain.orderentry.share.CartItem;
import com.kettler.domain.orderentry.share.Consumer;
import com.kettler.domain.orderentry.share.ConsumerShipTo;
import com.kettler.domain.orderentry.share.Coupon;
import com.kettler.domain.orderentry.share.SalesPerson;
import com.kettler.domain.orderentry.share.SalesTax
import com.kettler.domain.orderentry.share.ShipTo;

import com.kettler.domain.orderentry.share.ConsumerBillTo;
import com.kettler.domain.orderentry.share.OrderDetailItem;
import com.kettler.domain.orderentry.share.OrderDetailComment;
import com.kettler.domain.orderentry.share.OrderHeader;

import com.kettler.domain.item.share.ItemMasterExt;
import com.kettler.domain.item.share.ItemMaster
import com.kettler.domain.item.share.WebCategory;
import com.kettler.domain.item.share.WebDivision;

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

import grails.test.*

class OrderServiceTests extends GrailsUnitTestCase {
	OrderService orderService
    int nextOrderNo = 1
	def items = [:]
	Cart cart
	
	/*
	 * create a cart with two items, a consumer, bill-to, and ship-to
	 */
    protected void setUp() {
        super.setUp()
        mockDomain (ItemMasterExt)
        mockDomain (ItemMaster)
        mockDomain (Cart)
        mockDomain (CartItem)
        mockDomain (WebCategory)
        mockDomain (WebDivision)
        mockDomain (OrderHeader)
        mockDomain (OrderDetailItem)
        mockDomain (OrderDetailComment)
        mockDomain (Customer)
        mockDomain (SalesPerson)
        mockDomain (Coupon)
        mockDomain (Consumer)
        mockDomain (ConsumerShipTo)
        mockDomain (ConsumerBillTo)
        mockDomain (ShipTo)
        mockDomain (SalesTax)
        mockConfig('''
			orderentry {
				schema = 'test'
			}
		''')        
        assertEquals 'test', CH.config.orderentry.schema

        new SalesTax(id:'VA', arDistCode:'XVA', desc:'VA tax', taxPct:5.00g).save()
        new SalesTax(id:'WI', arDistCode:'XWI', desc:'WI tax', taxPct:5.00g).save()

    	def division = new WebDivision(name:'toys', keywords:'toys').save(flush:true) 
    	def category = new WebCategory(name:'balance bikes', division:division, keywords:'balance bikes').save(flush:true)
    	assert division
    	assert category
        def trike = new ItemMasterExt(itemNo:'trike',     compCode:'01', collection:'', category:category, division:division, desc:'a tricycle', taxableCode:true, distrCode:'x', stdUnitMeas:'EA', priceUnitMeas:'ea', retailPrice:1.98g)
        assert trike.save(flush:true)
        def scooter = new ItemMasterExt(itemNo:'scooter', compCode:'01', collection:'', category:category, division:division, desc:'a scooter',  taxableCode:true, distrCode:'x', stdUnitMeas:'EA', priceUnitMeas:'ea', retailPrice:1.98g).save(flush:true)
        items.trike = trike  
        items.scooter = scooter
    	cart = new Cart() 
		def cartItem = new CartItem(item:trike, qty:2)
        cart.addToItems cartItem
		assertTrue cartItem.validate()
		cartItem = new CartItem(item:scooter, qty:3)
        cart.addToItems cartItem
		assertTrue cartItem.validate()
		Consumer consumer = new Consumer(email:'dondenoncourt@gmail.com',password:'secret2',name:'Don Denoncourt')
		ConsumerShipTo shipTo = new ConsumerShipTo(name:'Don Denoncourt',
										addr1:'11203 Pinewood court',
										city:'Richmond', state:'VA', zipCode:'23238')
        consumer.addToShipTos (shipTo)
        if (!shipTo.save(flush:true)) {
        	shipTo.errors.each{println it}
        	assertTrue "shipTo.save() failed", false
        }
		ConsumerBillTo billTo = new ConsumerBillTo(name:'Don Denoncourt',
										addr1:'11203 Pinewood court',
										city:'Richmond', state:'VA', zipCode:'23238',
								        expYear:2011, expMonth:11,cardType:'visa', cardNo:'4111111111111111',ccid:123
		)
        billTo.save(flush:true)
        consumer.addToBillTos (billTo)
        if (!billTo.save(flush:true)) {
        	billTo.errors.each{println it}
        	assertTrue "billTo.save() failed", false
        }
        if (!consumer.save()) {
        	println consumer.errors.each {println it}
        	assert false
        }
		cart.consumerShipTo = shipTo
		cart.consumerBillTo = billTo
		cart.consumer = consumer
        if (!cart.save()) {
        	println cart.errors.each {println it}
        	assert false
        }
		assertEquals 2, cart.items.size()
        orderService = new OrderService()
        orderService.rpgService = new Expando()
        orderService.rpgService.getNextOrderNo = {compCode -> return ++nextOrderNo}
        Customer customer = new Customer(compCode:'01', custNo:'KE1126', name:'Retail Web', salespersonCode:'123')
		Customer.metaClass.static.findByCustNo = {'found'} // OrderHeader validation
		Customer.metaClass.static.findByCompCodeAndCustNo = {compCode, custNo -> customer}
		ItemMaster.metaClass.static.findByCompCodeAndItemNo = {compCode, itemNo -> 
																println "$compCode, $itemNo return items.get($itemNo):"+items.get(itemNo)?.toString()
															     return items.get(itemNo)
															  }
		
        SalesPerson salesPerson = new SalesPerson(id:'one', name:'Retail')
        
        ShipTo.metaClass.static.withCriteria = {a, b -> return false }
        
    }

    protected void tearDown() {
        super.tearDown()
    }

    void test_build_order() {
    	assertEquals 2, items.size()
    	assertTrue items.trike.id > 0
    	assertEquals 2, cart.items.size()
    	assertNotNull orderService
    	assertNotNull orderService.rpgService
    	assertEquals 2, orderService.rpgService.getNextOrderNo('01')
    	assertEquals 3, orderService.rpgService.getNextOrderNo('01')
    	String ccRoutingNo = '9999'
    	OrderHeader ord = orderService.write(cart, ccRoutingNo)
        assertEquals ord.orderNo, cart.orderNo
        
        assertEquals 4, ord.orderNo
        def ordItems = OrderDetailItem.list().sort{ it.itemNo}
        assertEquals 2, ordItems.size()
        assertNotNull "no order detail items found", ordItems                                                
        assertEquals 'scooter', ordItems[0].itemNo                 
        assertEquals 'a scooter', ordItems[0].desc
        assertEquals 1.98g, ordItems[0].unitPrice
        assertEquals 3, ordItems[0].orderQty
        assertEquals true, ordItems[0].subjToTax1
        assertEquals 5.94g,  ordItems[0].amount
        
        assertEquals 'trike', ordItems[1].itemNo
        assertEquals 3.96g,  ordItems[1].amount
        assertEquals 0.05g, ord.taxPct1 
        assertEquals 10.40g, ord.orderTotal // $9.90 plus VA tax
        
    }
    void test_build_bike_order() {
    	def division = new WebDivision(name:'bikes', keywords:'bikes').save(flush:true) 
    	def category = new WebCategory(name:'men', division:division, keywords:'bikes').save(flush:true)
        def bike = new ItemMasterExt(itemNo:'XX123A',     compCode:'01', collection:'', category:category, division:division, desc:'man bike 51 IN', taxableCode:true, distrCode:'x', stdUnitMeas:'EA', priceUnitMeas:'ea', retailPrice:1.98g,
        							 size:'51', sizeUom:'IN')
        assert bike.save(flush:true)
        def bike2 = new ItemMasterExt(itemNo:'XX123B',     compCode:'01', collection:'', category:category, division:division, desc:'man bike 55 IN', taxableCode:true, distrCode:'x', stdUnitMeas:'EA', priceUnitMeas:'ea', retailPrice:1.98g,
				 size:'55', sizeUom:'IN')
        assert bike2.save(flush:true)
        items.XX123A = bike  
        items.XX123B = bike2
        assert bike2.id
        // Because Ext extends ItemMaster, mockDomain gets confused
		ItemMaster.metaClass.static.get = {id -> return ItemMasterExt.get(id)} 
        		
        assertEquals 4, items.size() 
        assertNotNull items.get('XX123A')
		assertNotNull ItemMaster.findByCompCodeAndItemNo('01', 'XX123A' )  
		def cartItem = new CartItem(item:bike, qty:1, itemIdWithFrameSize:bike2.id)
    	assertEquals bike2.id, cartItem.itemIdWithFrameSize 
        cart.addToItems cartItem
		assertTrue cartItem.validate()

    	String ccRoutingNo = '123456'
		OrderHeader ord = orderService.write(cart, ccRoutingNo)
        assertEquals ord.orderNo, cart.orderNo
        
        assertEquals 2, ord.orderNo
        def ordItems = OrderDetailItem.list().sort{ it.itemNo}
        assertEquals 3, ordItems.size()
        assertNotNull "no order detail items found", ordItems                                                
        assertNotNull ordItems.find {it.itemNo == 'XX123B'}               
        assertEquals 'man bike 55 IN', ordItems[0].desc
    	
    }
}
