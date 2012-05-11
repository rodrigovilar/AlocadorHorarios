package alocadorhorarios
import grails.converters.JSON

import org.springframework.dao.DataIntegrityViolationException

class CursoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [cursoInstanceList: Curso.list(params), cursoInstanceTotal: Curso.count()]
    }

    def create() {
        [cursoInstance: new Curso(params)]
		
    }

    def save() {
		
        def cursoInstance = new Curso(params)
		
		if (!cursoInstance.id) {
			
			for (int i = 1; i <= params.int('quantidade'); i++) {
						cursoInstance.addToPeriodos(new Periodo(numero:i))
					}
		}
       
    	
		if (!cursoInstance.save(flush: true)) {
            render(view: "create", model: [cursoInstance: cursoInstance])
            return
        }

		

		flash.message = message (code: 'default.created.message', args: [message(code: 'curso.label', default: 'Curso'), cursoInstance.id])
        redirect(action: "show", id: cursoInstance.id)
    }

    def show() {
        def cursoInstance = Curso.get(params.id)
        if (!cursoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'curso.label', default: 'Curso'), params.id])
            redirect(action: "list")
            return
        }

        [cursoInstance: cursoInstance]
    }

    def edit() {
        def cursoInstance = Curso.get(params.id)
        if (!cursoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'curso.label', default: 'Curso'), params.id])
            redirect(action: "list")
            return
        }

        [cursoInstance: cursoInstance]
    }

    def update() {
        def cursoInstance = Curso.get(params.id)
        if (!cursoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'curso.label', default: 'Curso'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (cursoInstance.version > version) {
                cursoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'curso.label', default: 'Curso')] as Object[],
                          "Another user has updated this Curso while you were editing")
                render(view: "edit", model: [cursoInstance: cursoInstance])
                return
            }
        }

        cursoInstance.properties = params

        if (!cursoInstance.save(flush: true)) {
            render(view: "edit", model: [cursoInstance: cursoInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'curso.label', default: 'Curso'), cursoInstance.id])
        redirect(action: "show", id: cursoInstance.id)
    }

    def delete() {
        def cursoInstance = Curso.get(params.id)
        if (!cursoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'curso.label', default: 'Curso'), params.id])
            redirect(action: "list")
            return
        }

        try {
            cursoInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'curso.label', default: 'Curso'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'curso.label', default: 'Curso'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
	
	def PeriodoPorCurso() {
		def cr = Curso.get(params.int('id'))
		render cr.periodos as JSON
	}
}

