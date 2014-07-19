package com.kettler.domain.orderentry.share 

import java.io.Serializable;

import com.kettler.domain.item.share.ItemMasterExt
import com.kettler.domain.item.share.ItemMaster
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class CartItem implements Serializable { 
	Date dateCreated
	Date lastUpdated
	ItemMasterExt item
	int couponId // Coupon coupon doesn't work as nullable:true is ignored
	int qty
	int itemIdWithColor = 0
	int itemIdWithFrameSize = 0
	String color = ''
    Long giftCardId = 0 // MFB putting back from branch
	static belongsTo = [ cart : Cart ] 

	Coupon getCoupon() {return couponId?Coupon.get(couponId):null}
	def setCoupon(Coupon coupon) {couponId = coupon.id}

	ItemMaster getItemWithColor() {itemIdWithColor?ItemMaster.get(itemIdWithColor):null}
	void setItemWithColor(int id) {itemIdWithColor = id}
	ItemMaster getItemWithFrameSize() {itemIdWithFrameSize?ItemMaster.get(itemIdWithFrameSize):null}
	void setItemWithFrameSize(int id) {itemIdWithFrameSize = id}
	
	static transients = ['coupon', 'itemWithColor', 'itemWithFrameSize']
	                     
    static constraints = {
		qty min:1, nullable:false
		item nullable:false
		color nullable:true, blank:true
		couponId 		validator: { couponId, cartItem ->
		    if (couponId) {
		    	Coupon coupon = Coupon.get(couponId)
		        if (coupon && coupon?.item?.id != cartItem?.item?.id) {  
		            return "kettler.coupon.item.invalid" 
		        }
		    }
		    return true			
		}
        giftCardId nullable: true
	}
	String toString() {"$id:$item.desc coupon.id:${coupon?.id}"}
	
	static mapping = {
		table (name:'cartitem',schema:CH.config?.orderentry?.schema)
	}
}
