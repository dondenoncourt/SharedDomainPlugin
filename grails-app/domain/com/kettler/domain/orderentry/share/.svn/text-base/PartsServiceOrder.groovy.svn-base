package com.kettler.domain.orderentry.share
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
class PartsServiceOrder implements Serializable {
	String compCode
    int orderNo
    int shipNo
    String custNo
    String orderType
    boolean quote
    int shipToNo
    Date quoteExpire
    String creditRelease
    boolean walkInOrder
    String backOrderCode
	static constraints = {
        orderNo(max:99999,nullable:false)
        shipNo(max:99,nullable:false)
        custNo(minSize:1,maxSize:12,blank:false,nullable:false)
        orderType(minSize:1,maxSize:1)
        shipToNo(max:9999,nullable:false)
    }
	static mapping = {
		table (name:'pscusord',schema:CH.config.orderentry.schema)
		columns {
			compCode        column:'COMPANYCODE', type:'TrimString'
            orderNo         column:'ORDERNUMBER', type:'int'
            shipNo          column:'SHIPNUMBER', type:'int'
            custNo          column:'CUSTOMERNUMBER', type:'TrimString'
            orderType       column:'ORDERTYPE', type:'TrimString'
            quote           column:'QUOTECODE', type:'YesBlankType'
			shipToNo        column:'SHIPTONUMBER', type:'int'
            quoteExpire     column:'QUOTEEXPIREDATE'
            creditRelease	column:'CREDITRELEASE', type:'TrimString'
			walkInOrder     column:'WALKINORDER', type:'YesBlankType'
			backOrderCode   column:'BACKORDCODE', type:'TrimString'
        }
	}
}
