package com.kettler.domain.actrcv.share
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

public class ReturnFreightDenial implements Serializable {
	String code
	static mapping = {
		table (name:'rtrnnix',schema:CH.config.accounting.schema)
		cache usage:'read-only', include:'non-lazy'
	}
}

