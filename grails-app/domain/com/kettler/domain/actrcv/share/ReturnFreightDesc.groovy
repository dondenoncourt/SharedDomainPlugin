package com.kettler.domain.actrcv.share
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

public class ReturnFreightDesc implements Serializable {
	String descr

	static constraints = {
		descr         maxSize:30 
	}	
	static mapping = {
		table (name:'rtrnfgtdsc',schema:CH.config.accounting.schema)
		cache usage:'read-only', include:'non-lazy'
	}
}