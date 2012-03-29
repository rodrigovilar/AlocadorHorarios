package alocadorhorarios

import org.springframework.dao.DataIntegrityViolationException

class ProfessorController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }
	
	def imagem = {
		def professor = alocadorhorarios.Professor.get(params.id)
		byte[] imagem = professor.imagem
		response.outputStream << imagem
	}
	def imagemProfessor = {
		if (params.id){
			
		
		Professor professor = Professor.findById(params.id)
			if(professor){
				response.outputStream << professor.imagem
			}
		
		}
	}

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [professorInstanceList: Professor.list(params), professorInstanceTotal: Professor.count()]
    }

    def create() {
        [professorInstance: new Professor(params)]
    }

    def save() {
        def professorInstance = new Professor(params)
        if (!professorInstance.save(flush: true)) {
            render(view: "create", model: [professorInstance: professorInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'professor.label', default: 'Professor'), professorInstance.id])
        redirect(action: "show", id: professorInstance.id)
    }

    def show() {
        def professorInstance = Professor.get(params.id)
        if (!professorInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'professor.label', default: 'Professor'), params.id])
            redirect(action: "list")
            return
        }

        [professorInstance: professorInstance]
    }

    def edit() {
        def professorInstance = Professor.get(params.id)
        if (!professorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'professor.label', default: 'Professor'), params.id])
            redirect(action: "list")
            return
        }

        [professorInstance: professorInstance]
    }

    def update() {
        def professorInstance = Professor.get(params.id)
        if (!professorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'professor.label', default: 'Professor'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (professorInstance.version > version) {
                professorInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'professor.label', default: 'Professor')] as Object[],
                          "Another user has updated this Professor while you were editing")
                render(view: "edit", model: [professorInstance: professorInstance])
                return
            }
        }

        professorInstance.properties = params

        if (!professorInstance.save(flush: true)) {
            render(view: "edit", model: [professorInstance: professorInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'professor.label', default: 'Professor'), professorInstance.id])
        redirect(action: "show", id: professorInstance.id)
    }

    def delete() {
        def professorInstance = Professor.get(params.id)
        if (!professorInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'professor.label', default: 'Professor'), params.id])
            redirect(action: "list")
            return
        }

        try {
            professorInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'professor.label', default: 'Professor'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'professor.label', default: 'Professor'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
