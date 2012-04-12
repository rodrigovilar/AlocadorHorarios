
package alocadorhorarios

import static org.junit.Assert.*

import grails.test.mixin.support.*


@TestFor(Professor)
@Mock(Departamento)
class ProfessorTests { 

	void testValidacaoProfessor() {

		def professorSemDepartamento = new Professor()
		assert !professorSemDepartamento.validate()

		Departamento departamento = new Departamento(nome:"Dep", cor:"azul")
		Professor professorVazio = new Professor()
		departamento.addToProfessores(professorVazio)
		assert !professorVazio.validate()

		Professor emailInvalido =
				new Professor(nome: "Prof nome", matricula: "123", email: "sdf")
		departamento.addToProfessores(emailInvalido)
		assert !emailInvalido.validate()

		Professor professorValido =
				new Professor(nome: "Prof nome", matricula: "123", email: "abc@mail.com")
		departamento.addToProfessores(professorValido)
		assert professorValido.validate()
	}
	
	void testCRUD() {
		Departamento departamento = new Departamento(nome:"Dep", cor:"azul")
		departamento.save()
		
		def professor =
			new Professor(nome: "Prof nome", matricula: "123", email: "abc@mail.com")
		departamento.addToProfessores(professor)
		professor.save()
		
		def professores = Professor.list()
		assert professores.size() == 1
		
		def professorCadastrado = professores[0]
		assertEquals professor.nome, professorCadastrado.nome
		assertEquals professor.matricula, professorCadastrado.matricula
		assertEquals professor.email, professorCadastrado.email
		
		professor.nome = "nome 2"
		professor.matricula = "1234"
		professor.email = "def@mail.com"
		professor.save()
		
		professores = Professor.list()
		assert professores.size() == 1
		
		professorCadastrado = professores[0]
		assertEquals professor.nome, professorCadastrado.nome
		assertEquals professor.matricula, professorCadastrado.matricula
		assertEquals professor.email, professorCadastrado.email

		professor.delete()
		
		professores = Professor.list()
		assert professores.size() == 0
	}
	
	void testTelefones() {
		Departamento departamento = new Departamento(nome:"Dep", cor:"azul")
		departamento.save()

		def professor =
			new Professor(nome: "Prof nome", matricula: "123", email: "abc@mail.com")
		departamento.addToProfessores(professor)
		professor.addToTelefones(new Telefone(numero:"8882-2345"))
		professor.addToTelefones(new Telefone(numero:"2344-2345"))
		professor.save()
		
		def professores = Professor.list()
		assert professores.size() == 1
		
		def professorCadastrado = professores[0]
		def telefones = professorCadastrado.telefones.toArray()
		assert telefones.length == 2
		
		def telefone1 = telefones[0]
		assertEquals "8882-2345", telefone1.numero
		def telefone2 = telefones[1]
		assertEquals "2344-2345", telefone2.numero
		
	}
	
	void testDependenciaDepartamento() {
		Departamento departamento = new Departamento(nome:"Dep", cor:"Azul")
		def professor =
			new Professor(nome: "Prof nome", matricula: "123", email: "abc@mail.com")
		departamento.addToProfessores(professor)
		departamento.save()
		
		def professores = Professor.list()
		assert professores.size() == 1

		assert departamento.professores.size() == 1
		
		Departamento departamento2 = new Departamento(nome:"Dep2", cor:"Verde")
		departamento2.addToProfessores(professor)
		departamento2.save()
		
		departamento.professores.remove(professor)
		departamento.save()

		professores = Professor.list()
		assert professores.size() == 1

		assert departamento2.professores.size() == 1
		assert departamento.professores.size() == 0 

		def professor2 =
			new Professor(nome: "Prof nome2", matricula: "2", email: "abc2@mail.com")
		assert !professor2.validate()
	}
}