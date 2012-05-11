package alocadorhorarios

import grails.converters.JSON

class DisciplinaController {

	def scaffold = true

	def disciplinasPorPeriodo(){
		def p = Periodo.get(params.int('id'))
		def itensGrade = p.itensGrade
		def disciplinas = []
		for (def itemGrade : itensGrade) {
		disciplinas.add(ItemGrade.disciplina)
			
		}

		render disciplinas as JSON
	}
}
