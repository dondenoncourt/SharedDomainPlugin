package com.kettler.domain.item.share
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
class BillOfMaterials implements Serializable {
	String compCode
	String itemNo
	int seqNo
	String partItemNo
	int partQty
	String partUnitMeas
	static constraints = {
		compCode(maxSize:2,nullable:false)
		itemNo(maxSize:15,nullable:false)
		seqNo(max:9999,nullable:false)
		partItemNo(maxSize:15,nullable:false)
		partQty(max:99999,nullable:false)
		partUnitMeas(maxSize:3,nullable:false)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = true
	static mapping = {
		table (name:'inbomm',schema:CH.config.inventory.schema)
		version (false)
		id (generator:'assigned')
		id (composite:['compCode','itemNo','seqNo'])
		columns {
			id (composite:['compCode','itemNo','seqNo'])
			compCode (column:'BCOMP', type:'string')
			itemNo (column:'BITEM', type:'string')
			seqNo (column:'BSEQN', type:'int')
			partItemNo (column:'BCITM', type:'string')
			partQty (column:'BCQTY', type:'int')
			partUnitMeas (column:'BCUNM', type:'string')
		}
	}
	boolean newEntity = false
	static transients = ['newEntity']
}
