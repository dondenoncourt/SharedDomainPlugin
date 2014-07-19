package com.kettler.locator

import com.kettler.domain.comparator.DealerComparator;
import com.kettler.domain.item.share.Dealer
import com.kettler.domain.actrcv.share.Customer
import com.kettler.domain.item.share.WebDivision

class DealerController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def beforeInterceptor = {
         log.debug "action: $actionName params: $params flash: $flash"
    }
    def afterInterceptor = {
         log.debug "after action: $actionName params: $params"
    }

    def index = {
    }

    def search = {
        if (!params.custid || params.custid.length() == 0) {
            flash.message = "Account No is required"
            redirect(action: 'index')
        } else {
            Customer c = Customer.findByCustNo(params.custid.toUpperCase())
            if (c) {
                Dealer d = Dealer.findByCustomer(c)
                if (d) {
                    redirect(action: 'edit', id: d.id)
                } else {
                    flash.message = "No Dealer found for Account No: ${params.custid}, You need to create one"
                    redirect(action: 'create', params: [custId: c.custNo])
                }
            } else {
                flash.message = "No Dealer found with Account No: ${params.custid}"
                redirect(action: 'index')
            }
        }
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        params.offset = params.int('offset')?:0
        params.divisionId = params.divisionId?params.long('divisionId'):0
        def dealerInstanceList = []
        def dealerInstanceTotal = 0                  
        if (params.custNo || params.custName || params.divisionId) {
        	dealerInstanceList = Dealer.withCriteria {
    			if (params.custNo)   customer {eq 'custNo', params.custNo.toUpperCase()}
	       	    if (params.custName) customer {ilike 'name', params.custName+'%'}
	        	if (params.divisionId) {
	                divisions {eq 'id', params.long('divisionId')}
	            }
                order (params.sort?:'website', params.order?:'asc')
				maxResults(params.max)
				if (params.offset) firstResult(params.offset)
        	}
        	if (dealerInstanceList) {
        		dealerInstanceTotal = Dealer.withCriteria(unique:true) {
                    projections {rowCount()}
                	and {
	        			if (params.custNo)   customer {eq 'custNo', params.custNo.toUpperCase()}
	    	       	    if (params.custName) customer {ilike 'name', params.custName+'%'}
	    	        	if (params.divisionId) {
	    	                divisions {eq 'id', params.divisionId}
	    	            }
                	}
                }[0]
        	} else {
                flash.message = "No Dealer found for search criterion"
                redirect action:'list'
        	}
        } else {
        	dealerInstanceList = Dealer.list(params)
        	dealerInstanceTotal = Dealer.count()
        }
        [dealerInstanceList:dealerInstanceList, dealerInstanceTotal:dealerInstanceTotal, params:params]
    }


    def create = {
        def m = [:]
        def dealerInstance = new Dealer()
        dealerInstance.properties = params
        m.dealerInstance = dealerInstance
        if (params.custId) {
            Customer c = Customer.findByCustNo(params.custId)
            m.custId = c.custNo
            m.custName = c.name
        }
        return m
    }

    def save = {
        def m = [:]
        def dealerInstance = new Dealer(params)
       // dealerInstance.trackInventory = (params.trackInventory?.equals("on"))
        dealerInstance.customer = Customer.findByCustNo(params.custId)
        if (dealerInstance.save()) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'dealer.label', default: 'Dealer'), dealerInstance.id])}"
            redirect(action: "show", id: dealerInstance.id)
        }
        else {
            m.custId = params.custId
            m.custName = params.custName
            m.dealerInstance = dealerInstance
            render(view: "create", model: m)
        }
    }

    def show = {
        def dealerInstance = Dealer.get(params.id)
        if (!dealerInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'dealer.label', default: 'Dealer'), params.id])}"
            redirect(action: "list")
        }
        else {
            [dealerInstance: dealerInstance]
        }
    }

    def edit = {
        def dealerInstance = Dealer.get(params.id)
        if (!dealerInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'dealer.label', default: 'Dealer'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [dealerInstance: dealerInstance]
        }
    }

    def update = {
        def dealerInstance = Dealer.get(params.id)
        if (dealerInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (dealerInstance.version > version) {
                    
                    dealerInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'dealer.label', default: 'Dealer')] as Object[], "Another user has updated this Dealer while you were editing")
                    render(view: "edit", model: [dealerInstance: dealerInstance])
                    return
                }
            }
            def logoBefore = dealerInstance.logo
            dealerInstance.properties = params
            if (!params.logo.size) {
            	dealerInstance.logo = logoBefore
            }

            if (!dealerInstance.hasErrors() && dealerInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'dealer.label', default: 'Dealer'), dealerInstance.id])}"
                redirect(action: "show", id: dealerInstance.id)
            }
            else {
                render(view: "edit", model: [dealerInstance: dealerInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'dealer.label', default: 'Dealer'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def dealerInstance = Dealer.get(params.id)
        if (dealerInstance) {
            try {
                dealerInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'dealer.label', default: 'Dealer'), params.id])}"
                redirect(action: "list")
            } catch (org.springframework.dao.DataIntegrityViolationException e) {
				log.error e
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'dealer.label', default: 'Dealer'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'dealer.label', default: 'Dealer'), params.id])}"
            redirect(action: "list")
        }
    }

    def webDealers = {
    	def dealers
    	if (params.division && params.division != 'kettler usa') {
    		def division = WebDivision.findByName(params.division)
    		dealers = Dealer.withCriteria  {
    			divisions {eq "id", division.id }
				customer {eq 'compCode', (params.mode == 'canada')?'02':'01'}
    			eq("web", true)
    		}    		
    	} else {
    		dealers = Dealer.findAllByWeb(true)
    	}
    	[dealers:dealers.sort(new DealerComparator()), itemId:params.itemId, onlineDealers:true]
    }
    def trackInventory = {
        Dealer d = Dealer.get(params.id)
        if (d) {
        	d.trackInventory = params.yesNo=='true'
        	if (!d.save(validate:false)) {d.errors.each {log.error it}}
        }
        render "Track inventory ${(d.trackInventory?'enabled':'disabled')} for ${d.customer.name}"
    }
    def renderLogo = {
        Dealer d = Dealer.get(params.id)
        if (d?.logo) {
            response.setContentLength(d.logo.length)
            response.outputStream.write(d.logo)
        } else {
            response.sendError(404)
        }
    }
}
