package com.kettler.domain.orderentry.share
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
class ShipTo implements Serializable {
	String compCode
	String custNo
	int shipToNo
	String orderNo = ''
	String shipNo = '  '
	String name
	String addr1
	String addr2 = ''
	String addr3 = ''
	String city
	String state
	String zipCode
	String phoneNo = ''
	String faxNo = ''
	String contactPerson = ''
	String salespersonCode = ''
	String taxCode1 = ''
	String taxCode2 = ''
	String taxCode3 = ''
	String residentialCommercial = ''
	String countryCode = 'USA'
	String countryName = 'UNITED STATES'

	void setShipNo(String shipNoIn) {
		if (shipNoIn) {
			shipNo = new java.text.DecimalFormat('00').format(shipNoIn.toInteger())
		}
	}
	String getShipNo() {shipNo}

	static constraints = {
		compCode(maxSize:2,nullable:false)
		custNo(maxSize:7,nullable:false)
		shipToNo(min:1, max:9999,nullable:false, 
			validator: { shipToNo, shipTo ->
				def exists = ShipTo.withCriteria(uniqueResult:true) {
					and {
						eq('compCode', shipTo.compCode)
						eq('custNo',   shipTo.custNo)
						eq('shipToNo', shipTo.shipToNo)
						eq('orderNo',  shipTo.orderNo)
						eq('shipNo',   shipTo.shipNo)
					}
				}
				if (exists && shipToNo == 9999) { // delete if drop-ship so it gets effectively replaced
					exists.delete()
					return true
				}
				return !exists as boolean
			}
		)
		orderNo(maxSize:6,nullable:false)
		shipNo(maxSize:2,nullable:false)
		name(maxSize:30,nullable:false)
		addr1(blank:false,maxSize:30,nullable:false)
		addr2(maxSize:30,nullable:false)
		addr3(maxSize:30,nullable:false)
		city(maxSize:15,nullable:false, 
			validator: { city, shipTo ->
				if (['USA', 'CAN'].find {it == shipTo.countryCode}) {
					if (!city.size()) { 
						return "kettler.city.blank"
					}
				} 
				return true
			}
		)
		state(maxSize:2,nullable:false, 
			validator: { state, shipTo ->
				if (['USA', 'CAN'].find {it == shipTo.countryCode}) {
					if (!state.size()) { 
						return "kettler.state.blank"
					}
				} 
				return true
			}
		) 
		zipCode(maxSize:9,nullable:false, 
			validator: { zipCode, shipTo ->
				if (shipTo.countryCode == 'USA') {
					if (!(zipCode ==~ /^\d{5,9}$/) ) { 
						return "kettler.zipCode.usa.invalid"
					}
				} else if (shipTo.countryCode == 'CAN') {
					if (!(zipCode.replaceAll(/ /,'') ==~ /^\w{6}$/) ) {  
						return "kettler.zipCode.can.invalid"
					}
				}
				return true
			}
		)
		phoneNo(maxSize:10,nullable:false,matches:/^\d{0,10}$/ )
		faxNo(maxSize:10,nullable:false,matches:/^\d{0,10}$/ )
		contactPerson(maxSize:20,nullable:false)
		salespersonCode(maxSize:3,nullable:false)
		taxCode1(maxSize:3,nullable:false)
		taxCode2(maxSize:3,nullable:false)
		taxCode3(maxSize:3,nullable:false)
		residentialCommercial(maxSize:1,inList:['C','R'],nullable:false)
		countryCode(minSize:2,maxSize:3,nullable:false)
		countryName(minSize:2,maxSize:30, blank:false ) 
	}
	static mapping = {
		table (name:'shipto',schema:CH.config.orderentry.schema)
		columns {
			compCode (column:'STCOMP', type:'TrimString')
			custNo (column:'STCUST', type:'TrimString')
			shipToNo (column:'STNUMB', type:'int')
			orderNo (column:'STORDN', type:'TrimString')
			shipNo (column:'STSHPN', type:'TrimString')
			name (column:'STNAME', type:'TrimString')
			addr1 (column:'STADR1', type:'TrimString')
			addr2 (column:'STADR2', type:'TrimString')
			addr3 (column:'STADR3', type:'TrimString')
			city (column:'STCITY', type:'TrimString')
			state (column:'STSTAT', type:'TrimString')
			zipCode (column:'STZIPC', type:'TrimString')
			phoneNo (column:'STPHON', type:'TrimString')
			faxNo (column:'STFAXN', type:'TrimString')
			contactPerson (column:'STCNTC', type:'TrimString')
			salespersonCode (column:'STSPCD', type:'TrimString')
			taxCode1 (column:'STXCD1', type:'TrimString')
			taxCode2 (column:'STXCD2', type:'TrimString')
			taxCode3 (column:'STXCD3', type:'TrimString')
			residentialCommercial (column:'STRCCD', type:'TrimString')
			countryCode (column:'STCNTR', type:'TrimString')
			countryName (column:'STCNTN', type:'TrimString')
		}
	}

	static ShipTo retreiveShipTo(String compCode, String custNo, int shipToNo, int orderNo, int shipNo) {
		def shipTo = ShipTo.withCriteria() {  
            and {
                eq('compCode', compCode)
                eq('custNo', custNo)
                eq('shipToNo', shipToNo)
                if (shipToNo == 9999) {
	                eq('orderNo', orderNo?orderNo.toString():'')
	                eq('shipNo', new java.text.DecimalFormat('00').format(shipNo))
                }
            }
        }    
		if (shipTo) {
			return shipTo[0]
		}
		return null
    }

	String toString() {
		if (countryCode == 'USA') {
			if (city) { // only should happen when a dummy ShipTo is created for UI
				return "$name: $city, $state $zipCode"
			}
			return name
		} else if (countryCode == 'CAN') {
			return "$name: $countryName, $city, $state $zipCode"
		}
		return "$name: $countryName"
	}
	
}
