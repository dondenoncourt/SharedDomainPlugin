package com.kettler.domain.orderentry.share;
 
import grails.test.*
import com.kettler.domain.item.share.ItemMasterExt

class CouponTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void test_contraints() {

        def item = new ItemMasterExt(itemNo:'valid', compCode:'01')
        mockDomain ItemMasterExt, [item]
    	def existingCoupon = new Coupon(no:'old coupon') 
    	mockForConstraintsTests(Coupon, [existingCoupon])
                
        // Validation should fail if properties are null. 
		def coupon = new Coupon() 
		assertFalse coupon.validate()
		assertEquals 'nullable', coupon.errors['no']
		assertEquals 'nullable', coupon.errors['start']
		assertEquals 'nullable', coupon.errors['expire']
   		assertEquals "kettler.coupon.no.percent.or.amount", coupon.errors['percent']
		assertEquals 4, coupon.errors.errorCount

		coupon = new Coupon(no:'') 
		assertFalse coupon.validate()
		assertEquals 'blank', coupon.errors['no']

   		coupon = new Coupon(percent:10, amount:100.25g, start:new Date()-5, expire:new Date()) 
		assertFalse coupon.validate()
        assertEquals "kettler.coupon.percent.and.amount", coupon.errors['percent']
   		assertEquals 2, coupon.errors.errorCount

   		coupon = new Coupon(no:'xyz', percent:101, expire:new Date(), start:new Date())  
		assertFalse coupon.validate()
		coupon.errors.each {println it}
        assertEquals "kettler.coupon.start.expire.invalid", coupon.errors['start']		                                                            
        assertEquals "range", coupon.errors['percent']
        assertEquals 2, coupon.errors.errorCount

		coupon = new Coupon(no:'xyz', compCode:item.compCode, item:item, percent:10, start:new Date()-5, expire:new Date()) 
        assertTrue coupon.validate()

		coupon = new Coupon(no:existingCoupon.no) 
        assertFalse coupon.validate()
        //coupon.errors.each {println it}
        assertEquals "unique", coupon.errors["no"]
   		assertEquals "kettler.coupon.no.percent.or.amount", coupon.errors['percent']
		assertEquals 'nullable', coupon.errors['start']
		assertEquals 'nullable', coupon.errors['expire']
        assertEquals 4, coupon.errors.errorCount
        
    }
}