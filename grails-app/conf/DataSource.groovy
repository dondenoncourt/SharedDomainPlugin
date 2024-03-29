dataSource {
    pooled = true
    driverClassName = "org.hsqldb.jdbcDriver"
    username = "sa"
    password = ""
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = true
    cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
}
inventory.schema = 'I99FILES'
accounting.schema = 'R99FILES'
orderentry.schema = 'O99FILES'
varsity.schema = 'VARFILES'
purchasing.schema = 'U99FILES'
rita.schema = 'O99FILES'
warranty.schema = 'W99FILES'
// environment specific settings
environments {
    development {
        dataSource {
            url = "jdbc:mysql://localhost/kettler"
            driverClassName = "com.mysql.jdbc.Driver"
            dialect = org.hibernate.dialect.MySQLDialect
            username = "donat"
            password = "vo2max"
            dbCreate = "update"
            logSql = false
			inventory.schema = 'kettler'
			accounting.schema = 'kettler'
			orderentry.schema = 'kettler'
			varsity.schema = 'kettler'
			purchasing.schema = 'kettler'
			rita.schema = 'kettler'
			warranty.schema = 'kettler'
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:hsqldb:mem:testDb"
            inventory.schema = null
            orderentry.schema = null
            accounting.schema = null
            varsity.schema = null
            purchasing.schema = null
            rita.schema = null
            warranty.schema = null
        }
    }
    production {
        dataSource {
			pooled = true
		 //   autoreconnect = true 		
			url = "jdbc:as400://brain/${inventory.schema};libraries=${inventory.schema},${accounting.schema},${orderentry.schema},${varsity.schema};transaction isolation=none"   
			driverClassName = "com.ibm.as400.access.AS400JDBCDriver"
			username = "webuser"
			password = "b2bweb"
			dialect = org.hibernate.dialect.DB2400Dialect.class
			logSql = false
			programLib = "O99LIB"
        }
    }
}
