package alocadorhorarios

class ItemGradeController {

    def scaffold = true
	
	
	def periodo = {
		[departamentos:Departamento.list(), disciplinas:Disciplina.list()]
	}
}
