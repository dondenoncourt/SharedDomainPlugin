package com.kettler.domain.actrcv.share
import com.kettler.domain.orderentry.share.ReasonCode

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

public class ReturnReason implements Serializable {
	String code
	ReasonCode crsReason
	static mapping = {
		table (name:'rtrnreas',schema:CH.config.accounting.schema)
	}
	String toString() {code}
}
