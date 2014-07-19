package com.kettler.domain.item.share;

import java.io.Serializable;

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class WebDivision implements Serializable {
	static searchable = true  

	String name 
	String seoName
	String keywords
	String title
	String descr
    static constraints = {
        name unique:true
    }
	static hasMany = [categories : WebCategory]
	
	String toString() {name}
	
	static mapping  = {
		table (name:'webdiv',schema:CH.config?.inventory?.schema)
	}
    static namedQueries = {
        retail { ->
           le ('id', 5.toLong())
        }
    }

}
