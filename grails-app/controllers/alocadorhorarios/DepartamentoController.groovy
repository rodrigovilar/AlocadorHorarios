package alocadorhorarios
import grails.converters.JSON

import org.springframework.dao.DataIntegrityViolationException

class DepartamentoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [departamentoInstanceList: Departamento.list(params), departamentoInstanceTotal: Departamento.count()]
    }

    def create() {
        [departamentoInstance: new Departamento(params)]
    }

    def save() {
        def departamentoInstance = new Departamento(params)
        if (!departamentoInstance.save(flush: true)) {
            render(view: "create", model: [departamentoInstance: departamentoInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'departamento.label', default: 'Departamento'), departamentoInstance.id])
        redirect(action: "show", id: departamentoInstance.id)
    }

    def show() {
        def departamentoInstance = Departamento.get(params.id)
        if (!departamentoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'departamento.label', default: 'Departamento'), params.id])
            redirect(action: "list")
            return
        }

        [departamentoInstance: departamentoInstance]
    }

    def edit() {
        def departamentoInstance = Departamento.get(params.id)
        if (!departamentoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'departamento.label', default: 'Departamento'), params.id])
            redirect(action: "list")
            return
        }

        [departamentoInstance: departamentoInstance]
    }

    def update() {
        def departamentoInstance = Departamento.get(params.id)
        if (!departamentoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'departamento.label', default: 'Departamento'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (departamentoInstance.version > version) {
                departamentoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'departamento.label', default: 'Departamento')] as Object[],
                          "Another user has updated this Departamento while you were editing")
                render(view: "edit", model: [departamentoInstance: departamentoInstance])
                return
            }
        }

        departamentoInstance.properties = params

        if (!departamentoInstance.save(flush: true)) {
            render(view: "edit", model: [departamentoInstance: departamentoInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'departamento.label', default: 'Departamento'), departamentoInstance.id])
        redirect(action: "show", id: departamentoInstance.id)
    }

    def delete() {
        def departamentoInstance = Departamento.get(params.id)
        if (!departamentoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'departamento.label', default: 'Departamento'), params.id])
            redirect(action: "list")
            return
        }

        try {
            departamentoInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'departamento.label', default: 'Departamento'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'departamento.label', default: 'Departamento'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
	def DisciplinasporDepartamento() {
		def d = Depapartamento.get(params.int('idDepartamento'))
		render d.disciplinas as JSON
	}
}
