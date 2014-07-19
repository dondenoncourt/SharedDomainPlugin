package com.kettler.domain.orderentry.share
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
/*
  Note on population:
  FexEd and UPS added manually then:
	insert into oeshpweb (viatext, sishinc, svcode, custview, sishinr) 
	select substring(sishin,3,30), sishin, sicrcd, 'N', ''
	  from varfiles.ctrlsi 
	 where  sishin like 'C-%' and SICRCD not in ('EGLB', 'UPS','FEDEX')
	
	update oeshpweb r set sishinr = 
	(select sishin 
	   from varfiles.ctrlsi c 
	  where c.sishin = concat('R-', r.viatext)  
	)
	 where r.sishinc = concat('C-', viatext)
 */
class ShipVia implements Serializable {
	String id
	String scacCode
	String commShipInstr
	String resiShipInstr
	boolean custView 
	static constraints = {
		id(maxSize:30,nullable:false)
		scacCode(maxSize:4,nullable:false)
		commShipInstr(maxSize:15,nullable:false)
		resiShipInstr(maxSize:15,nullable:false)
		custView(maxSize:1,nullable:false)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = false
	static mapping = {
		table (name:'oeshpweb',schema:CH.config.orderentry.schema)
		version (false)
		id (generator:'assigned')
		columns {
			id (column:'VIATEXT',type:'TrimString')
			scacCode (column:'SVCODE', type:'TrimString')
			commShipInstr (column:'SISHINC', type:'TrimString')
			resiShipInstr (column:'SISHINR', type:'TrimString')
			custView( column:'custview', type:'org.hibernate.type.YesNoType')
		}
	}
	boolean newEntity = false
	static transients = ['textForShipVia', 'newEntity']
	def getTextForShipVia() {
		if (id) return id
		return 
	}
	void setTextForShipVia (def vlu) { id = vlu }
}
