package alocadorhorarios;

import static org.junit.Assert.*;

@TestFor(Disciplina) 
@Mock(Departamento)
class DisciplinaTests {

	void testValidacaoDisciplina() {

		def disciplinaSemDepartamento = new Disciplina()
		assert !disciplinaSemDepartamento.validate()

		Departamento departamento = new Departamento(nome: "DCE", cor: "Azul")
		Disciplina disciplinaVazia = new Disciplina()
		departamento.addToDisciplinas(disciplinaVazia)
		assert !disciplinaVazia.validate()

		Disciplina cargaHorariaInvalida = new Disciplina(nome: "Matemática Elementar", cargaHoraria: "asdfg", credito: 4)
		departamento.addToDisciplinas(cargaHorariaInvalida)
		assert !cargaHorariaInvalida.validate()

		Disciplina creditoInvalido = new Disciplina(nome: "Matemática Elementar", cargaHoraria: 60, credito: "asdfg")
		departamento.addToDisciplinas(creditoInvalido)
		assert !creditoInvalido.validate()

		Disciplina disciplinaValida = new Disciplina(nome: "Matemática Elementar", cargaHoraria: 60, credito: 4)
		departamento.addToDisciplinas(disciplinaValida)
		assert disciplinaValida.validate()
	}

	void testCRUD() {

		Departamento departamento = new Departamento(nome: "DCE", cor: "Azul")
		departamento.save()

		def disciplina = new Disciplina(nome: "Banco de Dados I", cargaHoraria: 60, credito: 4)
		departamento.addToDisciplinas(disciplina)
		disciplina.save()

		def disciplinas = Disciplina.list()
		assert disciplinas.size() == 1

		def disciplinaCadastrada = disciplinas[0]
		assertEquals disciplina.nome, disciplinaCadastrada.nome
		assertEquals disciplina.cargaHoraria,

		disciplinaCadastrada.cargaHoraria
		assertEquals disciplina.credito, disciplinaCadastrada.credito

		disciplina.nome = "Sistemas Operacionais"
		disciplina.cargaHoraria = 60
		disciplina.credito = 4
		disciplina.save()

		disciplinas = Disciplina.list()
		assert disciplinas.size() == 1

		disciplinaCadastrada = disciplinas[0]
		assertEquals disciplina.nome, disciplinaCadastrada.nome
		assertEquals disciplina.cargaHoraria,

		disciplinaCadastrada.cargaHoraria
		assertEquals disciplina.credito, disciplinaCadastrada.credito

		disciplina.nome = "Engenharia de Sotware"
		disciplina.cargaHoraria = 60
		disciplina.credito = 4
		disciplina.save()

		disciplinas = Disciplina.list()
		assert disciplinas.size() == 1

		disciplinaCadastrada = disciplinas[0]
		assertEquals disciplina.nome, disciplinaCadastrada.nome
		assertEquals disciplina.cargaHoraria,

		disciplinaCadastrada.cargaHoraria
		assertEquals disciplina.credito, disciplinaCadastrada.credito

		disciplina.delete()

		disciplinas = Disciplina.list()
		assert disciplinas.size() == 0
	}

	void testDependenciaDepartamento() {

		Departamento departamento = new Departamento(nome: "DCE", cor: "Azul")
		def disciplina = new Disciplina(nome: "Engenharia de Software Aplicada", cargaHoraria: 60, credito: 4)
		departamento.addToDisciplinas(disciplina)
		departamento.save()
		disciplina.save()
		
		def disciplina2 = new Disciplina(nome: "Gest�o da Qualidade de Software", cargaHoraria: 60, credito: 4)
		departamento.addToDisciplinas(disciplina2)
		departamento.save()
		disciplina2.save()
		
		def disciplinas = Disciplina.list()
		assert disciplinas.size() == 2
		assert departamento.disciplinas.size() == 2

		Departamento departamento2 = new Departamento(nome: "DL", cor: "Laranja")
		def disciplina3 = new Disciplina(nome: "Portugu�s Instrumental", cargaHoraria: 60, credito: 4)
		departamento2.addToDisciplinas(disciplina3)
		departamento2.save()
		disciplina3.save()

		disciplinas = Disciplina.list()
		assert departamento2.disciplinas.size() == 1

		assert disciplinas.size() == 3

		departamento2.disciplinas.remove(disciplina3)
		departamento2.save()

		assert departamento.disciplinas.size() == 2
		assert departamento2.disciplinas.size() == 0
	}

}