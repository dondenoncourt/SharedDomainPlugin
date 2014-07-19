package com.kettler.domain.orderentry.share;

import java.io.Serializable;
import java.math.BigDecimal;

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class Cart implements Serializable {
	Date dateCreated
	Date lastUpdated
	long phone = 0
	String email = ''
	boolean orderPlaced = false
	int orderNo = 0
	String upsServiceCode = setInitialServicecode()
	BigDecimal shippingCost = 0.00g
	boolean saveAccount = true
	boolean registerWarranty = true
    String paypalPayerId
    String paypalToken
    String paypalTransactionId
    String paypalCorrelationId
	static hasMany = [items : CartItem]

	static String LTL = '99'
	static String GROUND = '03'
	static String GROUNDFEDEX = '21'
	static String rateService = CH.config.rateService
	
	static int GIFT_CARD_NON_INV_LINE_NO = 9992
	
	// first class associations don't work as nullable:true is ignored
	int couponId
	int consumerId
	// shipTo and billTo are in Consumer but we need the user selected ones
	int shipToId
	int billToId
//	Coupon coupon
//    Consumer consumer
//    ConsumerShipTo consumerShipTo
//    ConsumerBillTo consumerBillTo
	int giftCardId
	
	Coupon getCoupon() {couponId?Coupon.get(couponId):null}
	def setCoupon(Coupon coupon) {couponId = coupon.id}
	
	Consumer getConsumer() {consumerId?Consumer.get(consumerId):null}
	def setConsumer(Consumer consumer) {consumerId = consumer.id}
	
	public GiftCard getGiftCard() {giftCardId ? GiftCard.get(giftCardId) : null }
	public void setGiftCard(GiftCard gc) { giftCardId = gc.id }
	
	def setShipToBillTo(Consumer consumer) {
		if (consumer.billTos) {
			billToId = consumer.billTos.toArray()[0].id
		}
		if (consumer.shipTos) {
			shipToId = consumer.shipTos.toArray()[0].id
		}
	}
	ConsumerShipTo getConsumerShipTo() {shipToId?ConsumerShipTo.get(shipToId):null}
	def setConsumerShipTo(ConsumerShipTo shipTo) {shipToId = shipTo.id?:0}
	
	ConsumerBillTo getConsumerBillTo() {billToId?ConsumerBillTo.get(billToId):null}
	def setConsumerBillTo(ConsumerBillTo billTo) {billToId = billTo.id}

	boolean isTruck() {
		return items.find {it.item.truck} as boolean
	}


	static transients = ['coupon', 'consumer', 'consumerShipTo', 'consumerBillTo', 'truck', 'shipToBillTo', 'giftCard', 'rateService']

	static SHIP_METHODS_UPS = ['03':'UPS Ground 4-8 business days', '02':'UPS Second Day', '13':'UPS Next Day', '99':'Truck/Freight (ground floor only)']
	static SHIP_METHODS_FEDEX = ['99':'Truck/Freight (ground floor only)', '20':'FEDEX 2 DAY', '21':'FEDEX GROUND', '22':'STANDARD OVERNIGHT']
	
	static constraints = {
		if (CH.config.rateService.equals('UPS')){
			println '****************************    UPS'
			upsServiceCode inList:SHIP_METHODS_UPS.keySet() as List
		} else if (CH.config.rateService.equals('FEDEX')){
			println '****************************    FEDEX'
			upsServiceCode inList:SHIP_METHODS_FEDEX.keySet() as List
		}
        coupon			 nullable:true
        consumer		 nullable:true
        consumerShipTo   nullable:true
        consumerBillTo   nullable:true
        phone            nullable:true
        orderNo			 nullable:true
        email 			 email:true, nullable:true, blank:true
        paypalPayerId    nullable:true
        paypalToken      nullable:true
        paypalTransactionId nullable:true
        paypalCorrelationId nullable:true
	}
	static mapping = {
		table (name:'cart',schema:CH.config?.orderentry?.schema)
		columns {
			orderPlaced  	type:'org.hibernate.type.YesNoType'
			items			lazy:false, cascade: "all-delete-orphan", sort:'id'
			saveAccount      type:'org.hibernate.type.YesNoType'
			registerWarranty type:'org.hibernate.type.YesNoType'
		}
	}
	
	String setInitialServicecode(){
		if (CH.config.rateService.equals('UPS')){
			println 'HERE in UPS'
			return '03'
		} else if (CH.config.rateService.equals('FEDEX')){
			println 'HERE in FEDEX'
			return '21'
		}
	}
	
	BigDecimal totalWithoutGiftCard(def state = null) {
	   log.debug("totalWithoutGiftCard(${state})")
	   BigDecimal total = subTotal()
	   if (coupon) {
		if (coupon.percent) {
			total -= totalItemCost() * (coupon.percent/100)
		} else {
			total -= coupon.amount
		}
	   }

	   total += calcTax(state)
       log.debug "Cart.totalWithoutGiftCard, total after tax: ${total}"
       return total.setScale(2, BigDecimal.ROUND_HALF_UP)
	}
	BigDecimal total(def state = null) {
		log.debug("total(${state})")
		BigDecimal total = totalWithoutGiftCard(state)
		GiftCard gc = getGiftCard()
		log.debug "Cart.getTotal, has GC, total: ${total}, giftCardReduced: ${giftCardReduced(state)}, gc.currentValue: ${gc?.currentValue}, gc.origValue: ${gc?.originalValue}"
		total -= giftCardReduced(state)
		if (total < BigDecimal.ZERO) {
			total = BigDecimal.ZERO
		}
		return total.setScale(2, BigDecimal.ROUND_HALF_UP)
	}
	BigDecimal subTotal() {
		return totalItemCost() + shippingCost
	}
	BigDecimal totalItemCost() {
		   BigDecimal total = 0.00g
		   items.each {item ->
			   total += (item.item.closeoutCode?item.item.specialPrice:item.item.retailPrice) * item.qty
			   if (item.coupon) {
				if (item.coupon.percent) {
					total -= ((item.item.closeoutCode?item.item.specialPrice:item.item.retailPrice) * item.qty) * (item.coupon.percent/100)
				} else {
					total -= item.coupon.amount
				}
			   }
		   }
		   return total
	   }
	BigDecimal totalWeight() {
		BigDecimal total = 0.00g
		items.each {item ->
			total += item.item.unitWeight
		}
		return total
	}

	int totalQuantity() {
		int total = 0
		items.each { total += it.qty}
		return total
	}
	/*
	VA sales tax rate is 5%.  This tax is on products/merchandise shipped to the state of Virginia (not the bill to address).
	The delivery/shipping/transportation charges are NOT taxable to the customer.
	
	Wisconsin sales tax is 5%.  This is on products/merchandise shipped to the state of Wisconsin (not the bill to address,
	usually any WI sales are in fact being shipped to WI).
	The transportation charges ARE taxable.   (freight charges should be taxable at the 5% rate)
	 */
	BigDecimal calcTax() {
		log.debug "calcTax() with no arguments "
		if (consumerShipTo?.state) {
			calcTax(consumerShipTo?.state)
		} else {
			calcTax(consumerBillTo?.state)
		}
	}
	BigDecimal calcTax(String shipToState) {
		log.debug "calcTax(${shipToState}) "
		if (items.find{it.item.arDistrictCode.equals("GFC")}) {
			return 0g
		}
		BigDecimal tax = 0g
		SalesTax salesTax = SalesTax.get(shipToState?:'XX')
		if (salesTax) {
			BigDecimal totalCost = 0.00g
			   items.each {item ->
				   BigDecimal cost = (item.item.closeoutCode?item.item.specialPrice:item.item.retailPrice) * item.qty
				   if (item.coupon) {
					if (item.coupon.percent) {
						cost -= cost * (item.coupon.percent/100)
					} else {
						cost -= item.coupon.amount
					}
				   }
				totalCost += cost
				   tax += cost * (salesTax.taxPct / 100.0g)
				   println "$tax += $cost * ($salesTax.taxPct / 100.0g)"
			   }
			if (coupon) {
				if (coupon.percent) {
					tax -= (totalCost * (coupon.percent/100.0g) * (salesTax.taxPct / 100.0g))
				} else {
					tax -= ((totalCost - coupon.amount) * (salesTax.taxPct / 100.0g))
				}
			}
			if (shipToState == 'WI') {
				   tax += shippingCost * (salesTax.taxPct / 100.0g)
			}	
		}
		println "calcTax($shipToState) returning $tax"
		return tax
	}

	BigDecimal giftCardReduced(def state = null) {
		def reducedAmount = 0.00g
		if (giftCard && giftCard.id) {
			def totalWithNoGiftCard = totalWithoutGiftCard(state)
			def cardValue = giftCard.currentValue
			if (orderPlaced) {
				def odi = OrderDetailItem.findWhere(orderNo:orderNo, lineNo:GIFT_CARD_NON_INV_LINE_NO)	
				if (odi) {
					cardValue = odi.unitPrice * -1
				}
			}
	        if (totalWithNoGiftCard > cardValue) {
				reducedAmount = cardValue
	        } else {
				reducedAmount = totalWithNoGiftCard
	        }
		} 
		reducedAmount
	}
}
