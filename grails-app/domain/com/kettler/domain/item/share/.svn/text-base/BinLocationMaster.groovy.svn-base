package com.kettler.domain.item.share;
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import java.io.Serializable


class BinLocationMaster implements Serializable { 

	String compCode
	String warehouse
	String location
	Long locationSequence = 0
	
	static mapping = {
		table (name:'inlocn',schema:CH.config.inventory.schema)
		version (false)
		id (generator:'assigned')
		id (composite:['compCode','warehouse','location'])
		columns {
			id (composite:['compCode','warehouse','location'])
			compCode (column:'LCOMP', type:'string')
			warehouse (column:'LWHSE', type:'string')
			location (column:'LLOCN', type:'string')
			locationSequence (column:'LSEQN', type:'long')
		}
	}
	
    String toString() {
        "BinLocationMaster=${compCode}, ${warehouse}, ${location}, ${locationSequence}"
    }
}
