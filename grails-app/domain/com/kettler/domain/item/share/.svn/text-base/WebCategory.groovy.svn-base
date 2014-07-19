package com.kettler.domain.item.share;

import java.io.Serializable;

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class WebCategory implements Serializable { 
	static searchable = true 
 	String name
//	String seoName
	String keywords
	String title
	String descr
	String seoName	
	String toString() {"${division.name}:${name}"}
	static belongsTo = [ division : WebDivision ]

	static mapping  = {
		table (name:'webcat',schema:CH.config?.inventory?.schema)
	}

	/* delete this 
		update i99files.webcat set seo_name = name;
		update i99files.webdiv set seo_name = name;
		update i99files.webdiv set seo_name = 'table-tennis' where name = 'table tennis';
		update i99files.webdiv set seo_name = 'patio-furniture' where name = 'patio';
		update i99files.webcat set seo_name = 'child-carriers' where name = 'child carriers' and exists (select * from i99files.webdiv where id = division_id);
		update i99files.webcat set seo_name = 'electric-bikes' where name = 'e-bikes' and exists (select * from i99files.webdiv where id = division_id);
		update i99files.webcat set seo_name = 'wrought-iron' where name = 'wrought iron' and exists (select * from i99files.webdiv where id = division_id);
		update i99files.webcat set seo_name = 'balance-bikes' where name = 'balance bikes and scooters' and exists (select * from i99files.webdiv where id = division_id);
		update i99files.webcat set seo_name = 'outdoor-play' where name = 'outdoor play' and exists (select * from i99files.webdiv where id = division_id);
		update i99files.webcat set seo_name = 'pedal-vehicles' where name = 'pedal vehicles' and exists (select * from i99files.webdiv where id = division_id);
		update i99files.webcat set seo_name = 'ride-ons' where name = 'ride-ons' and exists (select * from i99files.webdiv where id = division_id);
		update i99files.webcat set seo_name = 'exercise-bikes' where name = 'exercise bikes' and exists (select * from i99files.webdiv where id = division_id);
	 
	 */
}
