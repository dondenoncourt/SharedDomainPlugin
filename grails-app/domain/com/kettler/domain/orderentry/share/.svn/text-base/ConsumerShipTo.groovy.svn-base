package com.kettler.domain.orderentry.share;

import com.kettler.domain.work.Constants 
import java.util.Date;
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class ConsumerShipTo implements Serializable {
	String name
	String addr1
	String addr2
	String city
	String state
	String zipCode
	Date dateCreated
	Date lastUpdated	
	
	static belongsTo = [ consumer : Consumer ] 
	
	static constraints = {
		name maxSize:50,blank:false,nullable:false
		addr1 maxSize:30,blank:false,nullable:false
		addr2 maxSize:30,nullable:true 
		city maxSize:15,blank:false,nullable:false
		state maxSize:2,blank:false,nullable:false, inList:['AL','AK','AZ','AR','CA','CO','CT','DE','DC','FL','GA','HI','ID','IL','IN','IA','KS','KY','LA','ME','MD','MA','MI','MN','MS','MO','MT','NE','NV','NH','NJ','NM','NY','NC','ND','MP','OH','OK','OR','PA','RI','SC','SD','TN','TX','UT','VT','VA','WA','WV','WI','WY']
		zipCode maxSize:9,blank:false,nullable:false, 
		        validator: { zipCode, shipTo ->
			        if (!(zipCode ==~ /^\d{5,9}$/) ) { 
			        	return "kettler.zipCode.usa.invalid"
			        }
			        def entry = Constants.zipStateMap.find{it.key.contains(zipCode[0..2].toInteger())}
			        if (!entry || entry.value != shipTo.state) {
			        	return "kettler.zipCode.state.no.match"
			        }
			        return true
				}
	}
	static mapping = {
		table name:'csmrshipto', schema:CH.config?.orderentry?.schema 
	}
	String toString() {"$name $addr1 $city,$state $zipCode"} 
	boolean equals(def o) {
	    if (this.is(o)) return true;
	    if (!o || getClass() != o.class) return false;
	    ConsumerShipTo that = (ConsumerShipTo) o;

	    if (name? !name.equals(that.name) : that.name != null) return false
	    if (addr1? !addr1.equals(that.addr1) : that.addr1 != null) return false
	    if (addr2? !addr2.equals(that.addr2) : that.addr2 != null) return false
	    if (city? !city.equals(that.city) : that.city != null) return false
	    if (state? !state.equals(that.state) : that.state != null) return false
	    if (zipCode? !zipCode.equals(that.zipCode) : that.zipCode != null) return false

	    return true;		
	}
	ConsumerShipTo unique(def list) {
		ConsumerShipTo exists
		list.each {that -> 
			if (this == that) {
				exists = that 
			}
	    }
		return exists?:this
	}

}
