package com.kettler.domain.orderentry.share
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class Role implements Serializable {
	static ROLE_TYPE = ['Invalid', 
                    Role.CUST_ADMIN, 
                    Role.CUSTOMER,
                    Role.REP,
                    Role.KETTLER,
                    Role.SUPER_ADMIN,
                    Role.REP_ADMIN,
                    Role.STORE,
                    Role.STORE_MANAGER,
                    Role.INV_MANAGER,
                    Role.ASSISTANT_CONTROLLER,
                    Role.REP_PLUS,
                    Role.STORE_DELIVERIES_MANAGER
                ]
	static String CUST_ADMIN = 'Customer Admin'
	static String CUSTOMER = 'Customer'
	static String REP = 'Rep'
	static String KETTLER = 'Kettler'
	static String SUPER_ADMIN = 'Super Admin'
	static String REP_ADMIN = 'Rep Admin'
	static String STORE = 'Store Employee'
	static String STORE_MANAGER = 'Store Manager'
    static String INV_MANAGER = 'Inv Manager'
    static String ASSISTANT_CONTROLLER = 'Assistant Controller'
	static String REP_PLUS = 'Rep Plus'
	static String STORE_DELIVERIES_MANAGER = 'Store Deliveries Manager'

    int role

	static constraints = {
		role(range:1..12)
	}
	static mapping = {
		table (name:'role',schema:CH.config.orderentry.schema)
		columns {
			role (column:'role', type:'int')
		}
    }
	String getName() {return ROLE_TYPE[role]}
	
	static int getNo(String name) {
		return Role.ROLE_TYPE.indexOf(name)
	}
	private void setName(String name) {}
	static transients = ['name']
}
