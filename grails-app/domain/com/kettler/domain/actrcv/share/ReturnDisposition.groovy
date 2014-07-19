package com.kettler.domain.actrcv.share
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

public class ReturnDisposition implements Serializable {
	String code
	static mapping = {
		table (name:'rtrndisp',schema:CH.config.accounting.schema)
	}
}
