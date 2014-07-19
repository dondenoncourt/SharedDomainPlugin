package com.kettler.locator

import com.kettler.domain.item.share.DealerInventory

class DealerInventoryController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [dealerInventoryInstanceList: DealerInventory.list(params), dealerInventoryInstanceTotal: DealerInventory.count()]
    }

    def create = {
        def dealerInventoryInstance = new DealerInventory()
        dealerInventoryInstance.properties = params
        return [dealerInventoryInstance: dealerInventoryInstance]
    }

    def save = {
        def dealerInventoryInstance = new DealerInventory(params)
        if (dealerInventoryInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'dealerInventory.label', default: 'DealerInventory'), dealerInventoryInstance.id])}"
            redirect(action: "show", id: dealerInventoryInstance.id)
        }
        else {
            render(view: "create", model: [dealerInventoryInstance: dealerInventoryInstance])
        }
    }

    def show = {
        def dealerInventoryInstance = DealerInventory.get(params.id)
        if (!dealerInventoryInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'dealerInventory.label', default: 'DealerInventory'), params.id])}"
            redirect(action: "list")
        }
        else {
            [dealerInventoryInstance: dealerInventoryInstance]
        }
    }

    def edit = {
        def dealerInventoryInstance = DealerInventory.get(params.id)
        if (!dealerInventoryInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'dealerInventory.label', default: 'DealerInventory'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [dealerInventoryInstance: dealerInventoryInstance]
        }
    }

    def update = {
        def dealerInventoryInstance = DealerInventory.get(params.id)
        if (dealerInventoryInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (dealerInventoryInstance.version > version) {
                    
                    dealerInventoryInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'dealerInventory.label', default: 'DealerInventory')] as Object[], "Another user has updated this DealerInventory while you were editing")
                    render(view: "edit", model: [dealerInventoryInstance: dealerInventoryInstance])
                    return
                }
            }
            dealerInventoryInstance.properties = params
            if (!dealerInventoryInstance.hasErrors() && dealerInventoryInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'dealerInventory.label', default: 'DealerInventory'), dealerInventoryInstance.id])}"
                redirect(action: "show", id: dealerInventoryInstance.id)
            }
            else {
                render(view: "edit", model: [dealerInventoryInstance: dealerInventoryInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'dealerInventory.label', default: 'DealerInventory'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def dealerInventoryInstance = DealerInventory.get(params.id)
        if (dealerInventoryInstance) {
            try {
                dealerInventoryInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'dealerInventory.label', default: 'DealerInventory'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'dealerInventory.label', default: 'DealerInventory'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'dealerInventory.label', default: 'DealerInventory'), params.id])}"
            redirect(action: "list")
        }
    }
}
