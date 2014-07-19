package com.kettler.domain.orderentry.share;

import java.io.Serializable;

import com.kettler.domain.item.share.ItemMasterExt
import com.kettler.domain.item.share.WebCategory
import com.kettler.domain.item.share.WebDivision
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class Coupon implements Serializable {
	String no 
	ItemMasterExt item
	int percent
	BigDecimal amount
	Date start
	Date expire
    boolean singleUse
    WebUser createdBy
    WebUser approvedBy

    WebDivision division 
    WebCategory category
	
    static transients = ['approved']

    static constraints = {
		no unique:true, maxSize:15, nullable:false, blank:false
		item nullable:true, validator: {item, coupon ->
			if (item && (coupon.division || coupon.category)) {
	            return "kettler.coupon.one.of.item.div.cat"
			}
	        return true
		}
		division nullable:true, validator: {divsion, coupon ->
			if (divsion && (coupon.item || coupon.category)) {
	            return "kettler.coupon.one.of.item.div.cat"
			}
	        return true
		}
		category nullable:true, validator: {category, coupon ->
			if (category && (coupon.division || coupon.item)) {
	            return "kettler.coupon.one.of.item.div.cat"
			}
	        return true
		}
	    percent range:(0..100), validator: { percent, coupon ->
	        if (percent && coupon.amount) {  
	            return "kettler.coupon.percent.and.amount" 
	        } else if (!percent && !coupon.amount) {
	            return "kettler.coupon.no.percent.or.amount" 
	        }
	        return true
		}
	    amount max: new BigDecimal("9999999.99"), nullable:true
		start nullable:false, validator: { start, coupon ->
	        if (start >= coupon.expire) {  
	            return "kettler.coupon.start.expire.invalid" 
	        }
	        return true
		}
		expire nullable:false, validate: { expire, coupon ->
            Date d = coupon.start.plus(6*30)
            if (expire.compareTo(d) > 0) {
                return "kettler.coupon.expire.sixMonths"
            }
            return true
        }
        createdBy nullable: false, validator: { createdBy, coupon ->
            if (createdBy.equals(coupon.approvedBy)) {
                return "kettler.coupon.same.users"
            }
            return true
        }
        approvedBy nullable: true, validator: { approvedBy, coupon ->
            if (approvedBy?.equals(coupon.createdBy)) {
                return "kettler.coupon.same.users"
            }
            return true
        }
	}
	static mapping = {
		table (name:'coupon', schema:CH.config?.orderentry?.schema)
        columns {
            singleUse (column:'SINGLEUSE', type:'YesBlankType')
        }
	}
	
	String toString() {
        if (amount) {
            "" + no + ':$' + amount
        } else {
            "$no:$percent%"
        }
    }

    boolean isApproved() { return approvedBy != null }
}
