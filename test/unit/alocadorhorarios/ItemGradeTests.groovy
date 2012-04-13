package alocadorhorarios

import grails.test.mixin.support.*

@TestFor(ItemGrade)
@Mock([Periodo,Disciplina,Curso,Departamento])
class ItemGradeTests {

	public void testValidacao() {
		def itemGradeSemPeriodo= new ItemGrade()
		assert !itemGradeSemPeriodo.validate()

		def curso = new Curso (nome:"Sistemas")
		def periodo = new Periodo(numero:1)
		curso.addToPeriodos(periodo)

		def departamento = new Departamento(nome:"dep",Cor:"azul")
		def disciplina = new Disciplina(nome:"corporativos", cargaHoraria:60, credito:4)
		departamento.addToDisciplinas(disciplina)

		def itemGrade = new ItemGrade()
		disciplina.addToItensGrade(itemGrade)
		periodo.addToItensGrade(itemGrade)

		assert itemGrade.validate()
	}

	public void testCRUD() {

		Curso curso = new Curso(nome:"sistemas")
		curso.addToPeriodos(periodo)
		curso.save()

		Departamento departamento = new Departamento(nome:"Dep", cor:"azul")
		departamento.addToDisciplinas(disciplina)
		departamento.save()

		Periodo periodo = new Periodo(1)
		curso.addToPeriodos(periodo)
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

		itemCadastrado = itensGrade
		itemGrade.delete()

		itensGrade = ItemGrade.list()
		assert itensGrade.size()== 0
	}
}
