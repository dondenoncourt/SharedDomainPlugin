package com.kettler.locator

import com.kettler.domain.item.share.DealerLocation

class DealerLocationController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def beforeInterceptor = {
         log.debug "action: $actionName params: $params flash: $flash"
    }
    def afterInterceptor = {
         log.debug "after action: $actionName params: $params"
    }

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
		if (params.sort == 'dealerName') {
			def dealerLocationInstanceList = DealerLocation.withCriteria {
				maxResults(params.max)
				firstResult(params.offset?params.offset.toInteger():0)
				dealer { customer {} } 
				order('customer_alias2.name', params.order) // strange syntax: alias built from dealer { customer {} }
			}
        	[dealerLocationInstanceList: dealerLocationInstanceList, dealerLocationInstanceTotal: DealerLocation.count()]
		} else {
        	[dealerLocationInstanceList: DealerLocation.list(params), dealerLocationInstanceTotal: DealerLocation.count()]
		}
    }

    def create = {
        def dealerLocationInstance = new DealerLocation()
        dealerLocationInstance.properties = params
        return [dealerLocationInstance: dealerLocationInstance]
    }

    def save = {
        def dealerLocationInstance = new DealerLocation(params)
        if (dealerLocationInstance.save()) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'dealerLocation.label', default: 'DealerLocation'), dealerLocationInstance.id])}"
            redirect(action: "show", id: dealerLocationInstance.id)
        }
        else {
            render(view: "create", model: [dealerLocationInstance: dealerLocationInstance])
        }
    }

    def show = {
        def dealerLocationInstance = DealerLocation.get(params.id)
        if (!dealerLocationInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'dealerLocation.label', default: 'DealerLocation'), params.id])}"
            redirect(action: "list")
        }
        else {
            [dealerLocationInstance: dealerLocationInstance]
        }
    }

    def edit = {
        def dealerLocationInstance = DealerLocation.get(params.id)
        if (!dealerLocationInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'dealerLocation.label', default: 'DealerLocation'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [dealerLocationInstance: dealerLocationInstance]
        }
    }

    def update = {
        def dealerLocationInstance = DealerLocation.get(params.id)
        if (dealerLocationInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (dealerLocationInstance.version > version) {
                    
                    dealerLocationInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'dealerLocation.label', default: 'DealerLocation')] as Object[], "Another user has updated this DealerLocation while you were editing")
                    render(view: "edit", model: [dealerLocationInstance: dealerLocationInstance])
                    return
                }
            }
            def storePhotoBefore = dealerLocationInstance.storePhoto
            dealerLocationInstance.properties = params
            if (!params.storePhoto.size) {
                dealerLocationInstance.storePhoto = storePhotoBefore
            }
            if (dealerLocationInstance.validate() ) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'dealerLocation.label', default: 'DealerLocation'), dealerLocationInstance.id])}"
                redirect(action: "show", id: dealerLocationInstance.id)
            } else {
            	dealerLocationInstance.save()
                render(view: "edit", model: [dealerLocationInstance: dealerLocationInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'dealerLocation.label', default: 'DealerLocation'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def dealerLocationInstance = DealerLocation.get(params.id)
        if (dealerLocationInstance) {
            try {
                dealerLocationInstance.delete()
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'dealerLocation.label', default: 'DealerLocation'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'dealerLocation.label', default: 'DealerLocation'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'dealerLocation.label', default: 'DealerLocation'), params.id])}"
            redirect(action: "list")
        }
    }

    def renderStorePhoto = {
        DealerLocation dealerLocationInstance = DealerLocation.get(params.id)
        if (dealerLocationInstance?.storePhoto) {
            response.setContentLength(dealerLocationInstance.storePhoto.length)
            response.outputStream.write(dealerLocationInstance.storePhoto)
        } else {
            response.sendError(404)
        }
    }
}
