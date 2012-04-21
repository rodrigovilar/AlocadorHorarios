package alocadorhorarios

import grails.test.mixin.support.*

@TestFor(ItemGrade)
@Mock([Periodo,Disciplina,Curso,Departamento])
class ItemGradeTests {

	public void testValidacao() {
		def itemGradeSemPeriodoDisciplina= new ItemGrade()
		assert !itemGradeSemPeriodoDisciplina.validate()

		Curso curso = new Curso(nome:"Sistema de Informaçao")

		Periodo periodo = new Periodo(numero:3)
		curso.addToPeriodos(periodo)
		assert periodo.validate()		

		def departamento = new Departamento(nome:"dep",Cor:"azul")
		def disciplina = new Disciplina(nome:"corporativos", cargaHoraria:60, credito:4)
		departamento.addToDisciplinas(disciplina)

		def itemGradeSemPeriodo = new ItemGrade()
		disciplina.addToItensGrade(itemGradeSemPeriodo)
		assert !itemGradeSemPeriodo.validate()
		
		def itemGradeSemDisciplina = new ItemGrade()
		periodo.addToItensGrade(itemGradeSemDisciplina)
		assert !itemGradeSemDisciplina.validate()
		
		def itemGrade = new ItemGrade()
		disciplina.addToItensGrade(itemGrade)
		periodo.addToItensGrade(itemGrade)
		
		assert itemGrade.validate()
	}

	public void testCRUD() {
		Periodo periodo = new Periodo(numero:1)
		Curso curso = new Curso(nome:"sistemas")
		curso.addToPeriodos(periodo)
		curso.save()

		Departamento departamento = new Departamento(nome:"Dep", cor:"azul")
		departamento.save()

		curso.addToPeriodos(periodo)
		periodo.save()

		Disciplina disciplina = new Disciplina(nome:"corporativos", cargaHoraria:60, credito:4)
		departamento.addToDisciplinas(disciplina)
		disciplina.save()

		def itemGrade = new ItemGrade()
		disciplina.addToItensGrade(itemGrade)
		periodo.addToItensGrade(itemGrade)
		itemGrade.save()


		def itensGrade = ItemGrade.list()
		assert itensGrade.size()== 1

		def itemCadastrado = itensGrade[0]
		itemGrade.delete()

		itensGrade = ItemGrade.list()
		assert itensGrade.size()== 0
	}
}