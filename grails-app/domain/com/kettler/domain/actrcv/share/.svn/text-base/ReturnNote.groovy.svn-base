package com.kettler.domain.actrcv.share;
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class ReturnNote implements Serializable {
	String 	note
	String	user
	boolean showOnPdf = true
	Date    createDate = new Date()
	static belongsTo = [ ra : Return ]	// note return would be better than header but it's a reserved word
   	static mapping = {
		table (name:'rtrnnote',schema:CH.config.accounting.schema)
	    showOnPdf column:'pdfshow', type:'org.hibernate.type.YesNoType'
	    createDate 	column:'createdate'
	}
}
