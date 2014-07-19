package com.kettler.domain.actrcv.share
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

import com.kettler.domain.item.share.ItemMaster
import com.kettler.domain.orderentry.share.InvoicedOrderDetailItem

import org.hibernate.type.YesNoType

public class ReturnItem implements Serializable {
	int 				orderNo	= 0
	int   				shipNo = 0
	String 				itemNo
	String 				desc
	int 				authQty
	int					receivedQty
	boolean				noRA = false
	
	BigDecimal 			unitPrice

	ReturnReason 	reason
	
	static belongsTo = [ ra : Return ] // note return would be better than ra but it's a reserved word
   	static hasMany =   [ details : ReturnItemDetail]
	
	static constraints = {
		itemNo maxSize:15,nullable:false,
			validator: { itemNo, raItem ->
			    // if the item did not come from an invoiced order, validate itemNo
			    if (!raItem.orderNo) {
					def item = ItemMaster.findByCompCodeAndItemNo(raItem.ra.customer.compCode, itemNo)
	                if (!item) {
	                    return "kettler.orderDetailItem.itemNo.invalid" 
	                } 
			    }
                return true
			}
		authQty             min:0
		orderNo           	max:999999, nullable:false  //TODO validate against orderheader
		shipNo           	max:99, nullable:false  
		reason	   			nullable:false
	}
	static mapping = {
		table (name:'rtrnitm',schema:CH.config.accounting.schema)
		desc          		column:'descr'
		orderNo				column:'orderno'
	    shipNo				column:'shipno'
		itemNo				column:'itemno'
		authQty				column:'authQty'
		receivedQty			column:'rcvqty'
		unitPrice           column:'unitprice'
		noRA		        column:'nora', 		type:'org.hibernate.type.YesNoType'
			
	}
	String toString() {"orderNo: $orderNo itemNo: $itemNo authQty: $authQty receivedQty: $receivedQty reason: $reason?.id"}

}
