package com.kettler.domain.orderentry.share
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class UserControl implements Serializable {
	String id
	String username
	boolean priceOverride= false
	boolean releaseC_h= false
	boolean cancelOrder= false
	boolean itemMaint= false
	boolean custMaint= false
	boolean vendorMaint= false
	boolean reinstateOrder= false
	boolean setupNewCust= false
	boolean releaseReq= false
	boolean verifyOrder= false
	boolean confirmOrder= false
	boolean enterShipped= false
	boolean contractPrice= false
	boolean enterNewOrder= false
	boolean orderMaint= false
	boolean salesNotesMaint= false
	boolean returnSales= false
	boolean returnWarehouse= false
	boolean returnManagement= false
	boolean returnAR= false
	
	
	static constraints = {
		username(maxSize:25,nullable:false)
		priceOverride(maxSize:1,nullable:false, inlist:['Y','N'])
		releaseC_h(maxSize:1,nullable:false, inlist:['Y','N'])
		cancelOrder(maxSize:1,nullable:false, inlist:['Y','N'])
		itemMaint(maxSize:1,nullable:false, inlist:['Y','N'])
		custMaint(maxSize:1,nullable:false, inlist:['Y','N'])
		vendorMaint(maxSize:1,nullable:false, inlist:['Y','N'])
		reinstateOrder(maxSize:1,nullable:false, inlist:['Y','N'])
		setupNewCust(maxSize:1,nullable:false, inlist:['Y','N'])
		releaseReq(maxSize:1,nullable:false, inlist:['Y','N'])
		verifyOrder(maxSize:1,nullable:false, inlist:['Y','N'])
		confirmOrder(maxSize:1,nullable:false, inlist:['Y','N'])
		enterShipped(maxSize:1,nullable:false, inlist:['Y','N'])
		contractPrice(maxSize:1,nullable:false, inlist:['Y','N'])
		enterNewOrder(maxSize:1,nullable:false, inlist:['Y','N'])
		orderMaint(maxSize:1,nullable:false, inlist:['Y','N'])
		salesNotesMaint(maxSize:1,nullable:false, inlist:['Y','N'])
		returnSales(maxSize:1,nullable:false, inlist:['Y','N'])
		returnWarehouse(maxSize:1,nullable:false, inlist:['Y','N'])
		returnManagement(maxSize:1,nullable:false, inlist:['Y','N'])
		returnAR(maxSize:1,nullable:false, inlist:['Y','N'])
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = false
	static mapping = {
		table (name:'oeuctl',schema:CH.config.orderentry.schema)
		version (false)
		id (generator:'assigned')
		columns {
			id (column:'UCID',type:'TrimString')
			username (column:'UCNAME', type:'TrimString')
			priceOverride (column:'UCPROV', type:'YesBlankType')
			releaseC_h (column:'UCRLCH', type:'YesBlankType')
			cancelOrder (column:'UCCNCL', type:'YesBlankType')
			itemMaint (column:'UCITEM', type:'YesBlankType')
			custMaint (column:'UCCUST', type:'YesBlankType')
			vendorMaint (column:'UCVEND', type:'YesBlankType')
			reinstateOrder (column:'UCRNST', type:'YesBlankType')
			setupNewCust (column:'UCSUNC', type:'YesBlankType')
			releaseReq (column:'UCRLRQ', type:'YesBlankType')
			verifyOrder (column:'UCVRFY', type:'YesBlankType')
			confirmOrder (column:'UCCONF', type:'YesBlankType')
			enterShipped (column:'UCSHPD', type:'YesBlankType')
			contractPrice (column:'UCCPRC', type:'YesBlankType')
			enterNewOrder (column:'UCNEW', type:'YesBlankType')
			orderMaint (column:'UCORDM', type:'YesBlankType')
			salesNotesMaint (column:'UCSNTE', type:'YesBlankType')
			returnSales (column:'UCRTNS', type:'YesBlankType')
			returnWarehouse (column:'UCRTNW', type:'YesBlankType')
			returnManagement (column:'UCRTNM', type:'YesBlankType')
			returnAR (column:'UCRTNR', type:'YesBlankType')
		}
	}
	boolean newEntity = false
	static transients = ['userId', 'newEntity']
	def getUserId() {
		if (id) return id
		return 
	}
	void setUserId (def vlu) { id = vlu }
}

