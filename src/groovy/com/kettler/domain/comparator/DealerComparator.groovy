package com.kettler.domain.comparator

import com.kettler.domain.item.share.Dealer

/**
 * For sorting dealers based on having logo, an 800 number
 * User: Mike Brown
 * Date: Oct 24, 2010
 * Time: 4:18:48 PM
 */
class DealerComparator implements Comparator {
    //static tollFreeNumbers = ['800','866','877','888']

    int compare(Object o1, Object o2) {
        int res = 0
        if (!o1.class.equals(Dealer.class) || !o2.class.equals(Dealer.class)) {
            throw new IllegalArgumentException("DealerComparater called with non-Dealer argument")
        }
        Dealer d1 = (Dealer)o1
        Dealer d2 = (Dealer)o2
        boolean d1HasLogo = d1.logo 
        boolean d2HasLogo = d2.logo 
        boolean d1Has800 = d1.phone as boolean 
        boolean d2Has800 = d2.phone as boolean 
        if (d1.trackInventory && !d2.trackInventory) {
			res = -1
        } else if (!d1.trackInventory && d2.trackInventory) {
			res = 1
        } else if (d1HasLogo && d2HasLogo) {
            if ((d1Has800 && d2Has800) || (!d1Has800 && !d2Has800)) {
                res = d1.customer?.name?.compareTo(d2.customer?.name)
            } else if (d1Has800) {
                res = -1
            } else if (d2Has800) {
                res = 1
            }
        } else if (d1HasLogo) {
            res = -1
        } else if (d2HasLogo) {
            res = 1
        }
        res
    }
}
