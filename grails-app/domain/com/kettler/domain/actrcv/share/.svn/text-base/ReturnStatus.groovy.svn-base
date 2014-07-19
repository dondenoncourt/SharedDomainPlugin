package com.kettler.domain.actrcv.share
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

public class ReturnStatus implements Serializable {
	String 	id
	String 	code
	String 	desc
	int 	colLockLevel
	static mapping = {
		table (name:'rtrnstat',schema:CH.config.accounting.schema)
		version false
		id 				column:'code', generator:'assigned', type:'string'
		desc 			column:'descr'
		colLockLevel	column:'collcklvl'
		code 			 				insert:"false", update:"false"
	}
	def getCode() { 
		if (id) return id
		return 
	}
	void setCode (def vlu) { id = vlu }
	static transients = ['code']
	
	String toString() {"$id:$desc"}

}
