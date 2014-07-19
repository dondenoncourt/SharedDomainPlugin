package com.kettler.domain.item.share;

import java.io.Serializable;

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class ItemLocationMaster implements Serializable { 

	String compCode
	String itemNo
	String warehouse
	String binLocation
	Long qtyOnHand = 0
	Long qtyAlloc = 0
	Long pickSequence = 0
	
	static mapping = {
		table (name:'INMLOC',schema:CH.config.inventory.schema)
		version (false)
		id (generator:'assigned')
		id (composite:['compCode','itemNo','warehouse','binLocation'])
		columns {
			id (composite:['compCode','itemNo','warehouse','binLocation'])
			compCode (column:'LCOMP', type:'string')
			itemNo (column:'LITEM', type:'string')
			warehouse (column:'LWHSE', type:'string')
			binLocation (column:'LLOCN', type:'string')
			qtyOnHand (column:'LONHND', type:'long')
			qtyAlloc (column:'LALLOC', type:'long')
			pickSequence (column:'LPICKS', type:'long')
		}
	}
	
	String toString() {
		"ItemLocationMaster=${compCode}, ${itemNo}, ${warehouse}, ${binLocation}, ${qtyOnHand}, ${qtyAlloc}, ${pickSequence}"
	}

}
