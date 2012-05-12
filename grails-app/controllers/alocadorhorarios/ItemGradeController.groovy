package alocadorhorarios
import grails.converters.JSON

class ItemGradeController {

    def scaffold = true
	
	
	def periodo = {
		[departamentos:Departamento.list(), disciplinas:Disciplina.list(), cursos:Curso.list()]
		
		 
		
	}
	
	def selectDisciplina =  {
		def departamento = Departamento.get(params.id)
		render departamento?.disciplinas as JSON
		
	}

	def SalvarItemGrade(){
		def pe = Periodo.get(params.int('idPerido'))
		def di = Disciplina.get(params.int('idDisciplina'))
		def i=new ItemGrade()
		di.addToItensGrade(i)
		pe.addToItensGrade(i)
		i.save()
		
	}
}
