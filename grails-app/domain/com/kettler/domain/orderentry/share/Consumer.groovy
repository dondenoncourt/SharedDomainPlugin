package com.kettler.domain.orderentry.share;
import java.io.Serializable;
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class Consumer implements Serializable {
	String email
	String password
	String name
    long phone = 0
    boolean saveAccount = true
    boolean marketing = true
	Date dateCreated
	Date lastUpdated	
	static hasMany = [ 
           shipTos : ConsumerShipTo,
           billTos : ConsumerBillTo
    ]	
	static transients = ['saveAccount']
	def afterLoad = {
		def decrypt = password.bytes
		decrypt.eachWithIndex{d,i -> decrypt[i] = (d ^ 127)}
		password = new String(decrypt)
	}
	def beforeInsert = {beforeSave ()}
	def beforeUpdate = {beforeSave ()}	
	private  beforeSave () {
		def encrypt = password.bytes
		encrypt.eachWithIndex{e,i -> encrypt[i] =  (e ^ 127)}
		password = new String(encrypt)
	}
    static constraints = {
		name nullable:false, blank:false
		email nullable:false, blank:false, email:true, unique:true
		password validator: { password, consumer ->
			if (consumer.saveAccount) {
				if (!password) {
					return "blank"
				}
				if (password.size() < 7) { // be sure to change CheckoutCommand if you change this line
					return "short"
				}
			} 
			return true
		}
		
	}
	static mapping = {
		table name:'csmr', schema:CH.config?.orderentry?.schema 
	   	phone            nullable:true, range:1000000000..9999999999
		marketing  type:'org.hibernate.type.YesNoType'
		shipTos lazy:false, cascade:'all-delete-orphan'
		billTos lazy:false, cascade:'all-delete-orphan'
	}
	
	String toString() {"$name $email"}
}
