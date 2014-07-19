package com.kettler.domain.orderentry.share
import java.util.Date;

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import com.kettler.domain.actrcv.share.Customer

public class WebUser implements Serializable {
	String email
	String password
	String compCode = '01'
	String custNo
	SalesPerson salesperson
	String firstname
	String lastname
	int	loginFail = 0
	Date lastLogin	
	boolean imageDownload = false
	Role role
	UserControl user400 

	static embedded = ['role']

    //String spcode
    //String lastFirstName
    static transients = ['lastFirstName', 'spcode']
	
	String toString() {"id:$id, email:$email, $firstname $lastname custNo:$compCode:$custNo"}

    String getSpcode() {salesperson?.id}
    String getLastFirstName() {lastname+', '+firstname}

	static constraints = {
		email(blank:false,email:true,maxSize:40,nullable:false, 
			validator: { email, webUser ->
			    def user = WebUser.findByEmail(email)
	            if (user && user.id != webUser.id) {
	            	return 'webUser.email.unique'
	            }
			}
		)
		password(minSize:8,maxSize:100,blank:false,nullable:false) 
		custNo(maxSize:7, 
			validator: { custNo, webUser ->
	            if (webUser.role.name == Role.CUSTOMER || 
	            	webUser.role.name == Role.CUST_ADMIN) {
	            	 def cust = Customer.findByCustNo(custNo) 
	            	 webUser.compCode = cust?.compCode 
	            	 webUser.salesperson = SalesPerson.get(cust?.salespersonCode)
	            	 return cust != null
	            }
			}
		)
		compCode(maxSize:2, inList:['01', '02'],nullable:false) 
		firstname(maxSize:20,blank:false,nullable:false)
		lastname(maxSize:25,blank:false,nullable:false)
		salesperson(nullable:true,
				validator: { salesperson, webUser ->
	            if (webUser.role.name == Role.REP) {
	            	if (!salesperson?.id) {
	            		return false
	            	}
	            	webUser.compCode = SalesPerson.get(salesperson?.id)?.compCode
	            }
	            return true
			}
		)
		lastLogin(nullable:true)
		loginFail()
		user400(nullable:true, 
			validator: { user400, webUser ->
	            if (webUser.role.name == Role.KETTLER) {
	            	return user400?.id && UserControl.get(user400?.id)
	            }
			}
		)
	}	
	static mapping = {
		table (name:'webuser',schema:CH.config.orderentry.schema)
		custNo column:'custno'
		compCode column:'compcode'
		salesperson column:'spcode'
		user400 column:'user400', fetch:'join'
		imageDownload type:'org.hibernate.type.YesNoType'
	}
	def getCustomers() {
		if (role.name == Role.REP_ADMIN) {
			def repList = []
			SalesPerson.findAllByVendorNo(salesperson.vendorNo,[sort:'id', order:'asc']).each {rep ->
				repList << rep.id
			}
        	return Customer.withCriteria {'in'('salespersonCode', repList)}
		} else if (role.name == Role.REP) {
			return Customer.findAllBySalespersonCode(salesperson.id)
		}
	    return null
	}
}
