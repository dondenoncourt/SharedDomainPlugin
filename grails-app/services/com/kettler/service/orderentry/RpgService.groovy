package com.kettler.service.orderentry;
import com.kettler.domain.actrcv.share.Customer
import com.kettler.domain.orderentry.share.ConsumerBillTo;
import com.kettler.domain.orderentry.share.Control

import groovy.sql.Sql
import java.sql.Types
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH


public class RpgService implements Serializable {
	def sessionFactory
	boolean transactional = false
    def pgmLib = CH.config.dataSource.programLib
	
 	/*
 	CREATE PROCEDURE o99lib.nxtordno(
 			IN  compNo CHAR(2),
 			OUT nextOrdNo   decimal(6, 0))
 			LANGUAGE RPGLE 
 			NOT DETERMINISTIC 
 			NO SQL 
 			EXTERNAL NAME o99lib.nxtordno 
 			PARAMETER STYLE GENERAL
 	*/              
 	int getNextOrderNo(String compCode) {
		log.debug "getNextOrderNo($compCode)"
		if (CH.config.dataSource.driverClassName != 'com.ibm.as400.access.AS400JDBCDriver') {
	        Control cont = Control.get(compCode) 
	        cont.nextOrderNo += 1
	        cont.save(flush:true)
			println "in development directly using Control domain and not calling rpg: ${cont.nextOrderNo} = Control.get($compCode) "
	        return cont.nextOrderNo - 1
		}
		int returnOrderNo = 0  
		Sql sql = new Sql(sessionFactory.getCurrentSession().connection())
 		sql.call ("call ${pgmLib}.nxtordno (?,?)",
			   [Sql.in(Types.CHAR, compCode),
			    Sql.out(Types.DECIMAL)
			   ]
			    ) { nextOrdNo -> 
			    returnOrderNo = nextOrdNo
			}
		log.debug "$returnOrderNo getNextOrderNo($compCode)"
		return returnOrderNo 
 	}
 	
}
