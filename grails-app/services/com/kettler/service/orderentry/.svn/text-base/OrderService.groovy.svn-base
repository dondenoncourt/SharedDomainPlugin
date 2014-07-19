package com.kettler.service.orderentry

import com.kettler.domain.actrcv.share.Customer
import com.kettler.domain.orderentry.share.Cart;
import com.kettler.domain.orderentry.share.OrderDetailItem;
import com.kettler.domain.orderentry.share.OrderDetailComment;
import com.kettler.domain.orderentry.share.OrderDetailMisc;
import com.kettler.domain.orderentry.share.SalesTax;
import com.kettler.domain.orderentry.share.ShipTo;
import com.kettler.domain.orderentry.share.OrderHeader
import com.kettler.domain.item.share.ItemMasterExt;
import com.kettler.domain.work.DateUtils

/* note: OrderService is overridden in B2B */
class OrderService {
	def rpgService  // note: unit test types as Expando
    static transactional = true

    def write(Cart cart, String ccRoutingNo) {
		int max = 0
		int orderNo = rpgService.getNextOrderNo('01')
    	OrderHeader ord = new OrderHeader(
    			 compCode:			'01',  
    			 custNo:			'KE1126',  
    			 orderNo:			orderNo, 
    			 statusCode:		'O',
                 poNo:				orderNo,
	             salesperson1: 		Customer.findByCompCodeAndCustNo('01', 'KE1126').salespersonCode, 
	             packingListCode:	'01',
	             acknEmail:			cart.email,
	             shippingPhoneNo:	cart.phone,
	             shipToNo:			9999, 
	             shipNo:			1,
	             taxCode1:          cart.calcTax()?(cart.consumerShipTo?.state?:cart.consumerBillTo?.state):'',
	             carrierCode: 		'UPSN',
	             timeEntered:       DateUtils.getTime(new Date()),
				 approvedDate: 		new Date(),
				 approvedTime:  	new java.sql.Time(new Date().time),
	             fobCode: 			'PP', // prepaid by kettler
	             termsCode:			'9', // pay by credit card
	             routingNo:			ccRoutingNo.toInteger(),
	             cancelAfterDate:	DateUtils.getBeginningOfTime(),
	             enteredBy:			'WEB',
	             approvedBy:        'WEB'
	         	)
		ord.orderTotal = cart.total()
		switch (cart.upsServiceCode) { 
		case '03':
			ord.shipInstructions = 'R-UPS GND RESID'
			if ((cart.subTotal() - cart.shippingCost) < 40.0g ) {
				ord.fobCode = 'PC' // charge to customer
			} else {
				ord.fobCode = 'PP' // prepaid by kettler
				cart.shippingCost = 0.0g
			}
			break
		case '02':
			ord.shipInstructions = 'R-UPS 2DY AIR R'
			ord.fobCode = 'PC' // charge to customer
			break
		case '13':		
			ord.shipInstructions = 'R-UPS ND AR RES'
			ord.fobCode = 'PC' // charge to customer
			break
		case '99': 
			ord.shipInstructions = 'R-TRAILER'
			ord.fobCode = 'PP' // prepaid by kettler
			ord.carrierCode = ''
			ord.shipVia = 'ROUTING'
			if (ord.orderTotal >= 999.00g) {
				ord.specialChrgCd1 = 'RESD'
				ord.specialChrgCd2 = 'IND'
			}
			break
		default:
			assert false
		}
		
		def cartShipTo = cart.consumerShipTo?:cart.consumerBillTo
		def salesTax = SalesTax.get(cartShipTo.state)
		if (salesTax) {
			ord.taxPct1 = salesTax.taxPct/100.0g?:0g
		}
		int lastLineNo = 0
	    BigDecimal taxableAmount = 0.00g
		cart.items.eachWithIndex{cartItem, index ->
	        def ordItem = new OrderDetailItem(
	        		 compCode:		'01',  
	                 orderNo:		ord.orderNo, 
	                 shipNo:		ord.shipNo,
	                 lineNo: 		index ? (index+1) * 10: 10,
	                 itemNo:		(cartItem.itemWithColor?:(cartItem.itemWithFrameSize?:cartItem.item)).itemNo,
	                 desc:			(cartItem.itemWithColor?:(cartItem.itemWithFrameSize?:cartItem.item)).desc,
	                 distrCode:		cartItem.item.arDistrictCode,
	                 nmfcNo:		cartItem.item.nmfcNo,
	                 qtyUnitMeas:	cartItem.item.stdUnitMeas,
	                 orderQty:		cartItem.qty,
	                 shipQty:       cartItem.qty,
	                 priceUnitMeas: cartItem.item.priceUnitMeas,
	                 unitPrice:		cartItem.item.closeoutCode?cartItem.item.specialPrice:cartItem.item.retailPrice,
	                 amount:		(cartItem.qty * (cartItem.item.closeoutCode?cartItem.item.specialPrice:cartItem.item.retailPrice)),
	                 subjToTax1:    ord.taxPct1?true:false,
	                 lineType:'I' // Stock item
	                )
	        if (cartItem.item.taxableCode) {
	        	ordItem.subjToTax1 = true
	        	ordItem.subjToTax2 = false
	        	ordItem.subjToTax3 = false
		    	taxableAmount += ordItem.amount
	        }
	    	if (!ordItem.save()) {
	    		ordItem.errors.each {log.error it.inspect()}
	    		assert false
	    	}
	    	lastLineNo = ordItem.lineNo
		}
		
		lastLineNo += 10
        def ordDtlCmt = new OrderDetailComment(
            compCode:'01', orderNo:ord.orderNo, shipNo:ord.shipNo,
            lineNo:lastLineNo, 
            text: cart.consumerBillTo.cardType,
            printCode:'I')
        if (!ordDtlCmt.save(insert:true, flush:true)) {
        	assert false
            ordDtlCmt.errors.each { log.error it.inspect()}
        }
		lastLineNo += 10
		def cardNo = cart.consumerBillTo.cardNo
        ordDtlCmt = new OrderDetailComment(
            compCode:'01', orderNo:ord.orderNo, shipNo:ord.shipNo,
            lineNo:lastLineNo,  
            text: "**** **** **** ${cardNo[12..(cardNo.size()-1)]}",
            printCode:'I')
        if (!ordDtlCmt.save(insert:true, flush:true)) {
        	assert false
            ordDtlCmt.errors.each { log.error it.inspect()}
        }
		if (cart.shippingCost) {
			lastLineNo += 10
	        def ordDtlMsc = new OrderDetailMisc(
	            compCode:	'01', 
	            orderNo:	ord.orderNo, 
	            shipNo:		ord.shipNo,
	            lineNo:		lastLineNo,
	            desc:		'UPS charge',
	            distrCode:  'UPS',
	            amount:		cart.shippingCost,
	            flatChargeCode: true
	            )
	        if (!ordDtlMsc.save(insert:true, flush:true)) {
	        	ordDtlMsc.errors.each { log.error it.inspect()}
	        	assert false
	        }
		}
		
		ShipTo shipTo = new ShipTo(
		        compCode:	ord.compCode,
				orderNo:	ord.orderNo,
		        shipNo:		1, 
				shipToNo:	9999, 
		        custNo:		ord.custNo,
				name:		cartShipTo.name,
				addr1:		cartShipTo.addr1,
				addr2:		cartShipTo.addr2?:'',
				city:		cartShipTo.city,
				state:		cartShipTo.state,
				zipCode:	cartShipTo.zipCode,
				residentialCommercial:'R'
		        )
		if (!shipTo.save()) {
			shipTo.errors.each {log.error it.inspect()}
			assert false
		}
		if (!ord.save(flush:true)) { // flush so Id can be displayed
			ord.errors.each{log.error it.inspect()}
			assert false
		}
		cart.orderPlaced = true
		cart.orderNo = ord.orderNo
		return ord
    }
}
