package com.kettler.domain.item.share
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
class ItemWarehouse implements Serializable {
	String compCode
	String itemNo
	String warehouse
	String profitCenterClass = ''
	String productGroupClass = ''
	String articleGroupClass = ''
	Long qtyOnOrder = 0
	Long qtyOnHand = 0
	Long qtyAlloc = 0
	Long qtyOnCredHold = 0
	Long qtyOnBackOrder = 0
	int minBal = 0
	int maxBal = 0
	Long qtyFutureShip = 0
	static constraints = {
		compCode(maxSize:2,nullable:false)
		itemNo(maxSize:15,nullable:false)
		warehouse(maxSize:3,nullable:false)
		profitCenterClass(maxSize:1,nullable:false)
		productGroupClass(maxSize:3,nullable:false)
		articleGroupClass(maxSize:3,nullable:false)
		qtyOnOrder(max:99999999999,nullable:false)
		qtyOnHand(max:99999999999,nullable:false)
		qtyAlloc(max:99999999999,nullable:false)
		qtyOnCredHold(max:99999999999,nullable:false)
		qtyOnBackOrder(max:99999999999,nullable:false)
		minBal(max:9999999,nullable:false)
		maxBal(max:9999999,nullable:false)
		qtyFutureShip(max:99999999999,nullable:false)
	}
	static mapping = {
		table (name:'itemwhs',schema:CH.config.inventory.schema)
		columns {
			compCode (column:'WCOMP', type:'string')
			itemNo (column:'WITEM', type:'string')
			warehouse (column:'WWHSE', type:'string')
			profitCenterClass (column:'WCLAS1', type:'string')
			productGroupClass (column:'WCLAS2', type:'string')
			articleGroupClass (column:'WCLAS3', type:'string')
			qtyOnOrder (column:'WONORD', type:'long')
			qtyOnHand (column:'WONHND', type:'long')
			qtyAlloc (column:'WALLOC', type:'long')
			qtyOnCredHold (column:'WCRHLD', type:'long')
			qtyOnBackOrder (column:'WBKORD', type:'long')
			qtyFutureShip (column:'WFUSHP', type:'long')
			minBal (column:'WMNBAL', type:'int')
			maxBal (column:'WMXBAL', type:'int')
		}
	}
	String toString () {"$compCode:$warehouse:$itemNo: qtyOnHand:$qtyOnHand qtyAlloc:$qtyAlloc"}
    static def getItemWarehouse(String compCode, String itemNo, String warehouse) {
        return ItemWarehouse.withCriteria(uniqueResult:true) {
    		and {
    			eq('compCode', compCode)
    			eq('itemNo', itemNo)
    			eq('warehouse', warehouse)
    		}
        }
    }
}
