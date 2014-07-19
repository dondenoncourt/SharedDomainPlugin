package com.kettler.domain.orderentry.share

import com.kettler.domain.work.Constants 
import groovy.sql.Sql
import java.sql.Types
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import org.codehaus.groovy.grails.commons.ApplicationHolder as AH

class ConsumerBillTo implements Serializable {
	String name
	String addr1
	String addr2
	String city
	String state
	String zipCode
	String cardType
	String cardNo
	int ccid
	String cardNoEncrypted = ''
    int    expYear
    int    expMonth
	Date dateCreated
	Date lastUpdated	
	
	static belongsTo = [ consumer : Consumer ] 

	def afterLoad = {
		decryptCardNo(this)
	}
	def beforeUpdate = {beforeChange()}	
	def beforeInsert = {beforeChange()}	
	private beforeChange() {
		if (CH.config.dataSource.driverClassName != 'com.ibm.as400.access.AS400JDBCDriver') {
			cardNoEncrypted = cardNo
		} // else an RPG trigger will encrypt
	}
	/* Note: need a static method to be able to get the sessionFactor
		CREATE PROCEDURE o99lib.VERIWEBDCR(
		IN   billToId 	BIGINT,
		OUT creditCard  CHAR(16)) 
		LANGUAGE RPGLE 
		NOT DETERMINISTIC 
		READS SQL DATA
		EXTERNAL NAME  o99lib.VERIWEBDCR
		PARAMETER STYLE GENERAL
	 */
    static decryptCardNo (ConsumerBillTo billTo) {
		if (CH.config.dataSource.driverClassName == 'com.ibm.as400.access.AS400JDBCDriver') {
			Sql sql = new Sql(AH.application.mainContext.sessionFactory.currentSession.connection())
	 		sql.call ("call ${(CH.config.dataSource.programLib)}.VERIWEBDCR (?,?)",
	 					[Sql.in(Types.DECIMAL, billTo.id), Sql.out(Types.CHAR)]
				     ) { creditCard -> 
					     	billTo.cardNo = creditCard
					     	billTo.cardNoEncrypted = ''
					   }
		} else {
		    billTo.cardNo = billTo.cardNoEncrypted
		    billTo.cardNoEncrypted = ''
		}
	}
	static constraints = {
		name maxSize:50,blank:false,nullable:false
		addr1 maxSize:30,blank:false,nullable:false
		addr2 maxSize:30,nullable:true
		city maxSize:15,blank:false,nullable:false
		state maxSize:2,blank:false,nullable:false, inList:['AL','AK','AZ','AR','CA','CO','CT','DE','DC','FL','GA','HI','ID','IL','IN','IA','KS','KY','LA','ME','MD','MA','MI','MN','MS','MO','MT','NE','NV','NH','NJ','NM','NY','NC','ND','MP','OH','OK','OR','PA','RI','SC','SD','TN','TX','UT','VT','VA','WA','WV','WI','WY']
		zipCode maxSize:9,blank:false,nullable:false, 
		        validator: { zipCode, billTo ->
			        if (!(zipCode ==~ /^\d{5,9}$/) ) { 
			        	return "kettler.zipCode.usa.invalid"
			        }
			        def entry = Constants.zipStateMap.find{it.key.contains(zipCode[0..2].toInteger())}
			        if (!entry || entry.value != billTo.state) {
			        	return "kettler.zipCode.state.no.match"
			        }
			        return true
				}
		cardNoEncrypted nullable:true
	    cardType nullable:true
		cardNo creditCard:true,nullable:true
		ccid blank:true,nullable:true
		expYear nullable:true
		expMonth nullable:true

//	    cardType nullable:false, blank:false, inList:["visa", "master card", "discover", "american express"] 
//		cardNo creditCard:true,blank:false
//		ccid min:1, blank:false,nullable:false
//		expYear range:(2010..2040), nullable:false
//		expMonth range:(1..12), nullable:false
	}
	static mapping = {
		table name:'csmrbillto', schema:CH.config?.orderentry?.schema 
		cardNoEncrypted column:'ccencrypt'
	}
	boolean equals(def o) {
	    if (this.is(o)) return true;
	    if (!o || getClass() != o.class) return false;
	    ConsumerBillTo that = (ConsumerBillTo) o;

	    if (name? !name.equals(that.name) : that.name != null) return false
	    if (addr1? !addr1.equals(that.addr1) : that.addr1 != null) return false
	    if (addr2? !addr2.equals(that.addr2) : that.addr2 != null) return false
	    if (city? !city.equals(that.city) : that.city != null) return false
	    if (state? !state.equals(that.state) : that.state != null) return false
	    if (zipCode? !zipCode.equals(that.zipCode) : that.zipCode != null) return false
	    if (cardType? !cardType.equals(that.cardType) : that.cardType != null) return false
	    if (cardNo? !cardNo.equals(that.cardNo) : that.cardNo != null) return false
	    if (ccid? !ccid.equals(that.ccid) : that.ccid != null) return false
	    if (expYear? !expYear.equals(that.expYear) : that.expYear != null) return false
	    if (expMonth? !expMonth.equals(that.expMonth) : that.expMonth != null) return false

	    return true;		
	}
	ConsumerBillTo unique(def list) {
		ConsumerBillTo exists
		list.each {that -> 
			if (this == that) {
				exists = that 
			}
	    }
		return exists?:this
	}
	String toString() {"$name $addr1 $city,$state $zipCode $cardType **** "+cardNo?(cardNo[12..(cardNo.size()-1)]):''} 
	String address() {"$name $addr1 $city,$state $zipCode"}
    String zeroPadCCID() {
    	if (cardType.toLowerCase() == 'american express') {
    		return new java.text.DecimalFormat('0000').format(ccid)
    	}
		return new java.text.DecimalFormat('000').format(ccid)
    }
}
