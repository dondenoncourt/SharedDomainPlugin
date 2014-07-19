package com.kettler.domain.orderentry.share 
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
class Carrier implements Serializable {
	String id
	String desc
	String shortDesc
	String commercialShipNotes
	String residentialShipNotes
	String phoneNoRequired
	String carrierAssignedMShipperAssignedUCode
	String transMethodCode
	String phoneNo = ''
	static constraints = {
		desc(maxSize:30,nullable:false)
		shortDesc(maxSize:15,nullable:false)
		commercialShipNotes(maxSize:15,nullable:false)
		residentialShipNotes(maxSize:15,nullable:false)
		phoneNoRequired(maxSize:1,nullable:false)
		carrierAssignedMShipperAssignedUCode(maxSize:1,nullable:false)
		transMethodCode(maxSize:2,nullable:false)
		phoneNo(maxSize:10,nullable:false)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = false
	static mapping = {
		table (name:'oescac',schema:CH.config.orderentry.schema)
		cache usage:'read-only', include:'non-lazy'
		version (false)
		id (generator:'assigned')
		columns {
			id (column:'SVCODE',type:'TrimString')
			desc (column:'SVDESC', type:'TrimString')
			shortDesc (column:'SVSHRT', type:'TrimString')
			commercialShipNotes (column:'SVCSI', type:'TrimString')
			residentialShipNotes (column:'SVRSI', type:'TrimString')
			phoneNoRequired (column:'SVPREQ', type:'TrimString')
			carrierAssignedMShipperAssignedUCode (column:'SVTYPE', type:'TrimString')
			transMethodCode (column:'SVTMET', type:'TrimString')
			phoneNo (column:'"SV800#"', type:'TrimString')
		}
	}
	boolean newEntity = false
	static transients = ['scacCode', 'newEntity']
	def getScacCode() {
		if (id) return id
		return 
	}
	void setScacCode (def vlu) { id = vlu }
}
