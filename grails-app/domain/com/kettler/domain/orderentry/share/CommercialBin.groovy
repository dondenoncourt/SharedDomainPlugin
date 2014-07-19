package com.kettler.domain.orderentry.share
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class CommercialBin implements Serializable {
    String paymentMedia
    String lowerBound
    String upperBound
    String cmBinFlag

    static mapping = {
	 table name:'combin', schema:CH.config?.orderentry?.schema
         // version is set to false, because this isn't available by default for legacy databases
         version false
         id generator:'identity', column:'PAYMENT_MEDIA'
         id generator:'identity', column:'LOWER_BOUND'
         id composite:['paymentMedia','lowerBound'], generator:'assigned'
    }
    static constraints = {
        paymentMedia(size: 1..10, blank: false)
        lowerBound(size: 1..10, blank: false)
        upperBound(size: 0..10)
        cmBinFlag(size: 0..1)
    }
    String toString() {
        return "${paymentMedia}" 
    }
	

}
