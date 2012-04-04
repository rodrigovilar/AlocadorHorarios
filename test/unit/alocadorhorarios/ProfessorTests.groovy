package alocadorhorarios

import static org.junit.Assert.*

import grails.test.mixin.support.*


@TestFor(Professor)
class ProfessorTests {

	void testValidacaoProfessor() {

		def professorVazio = new Professor()
		assert !professorVazio.validate()

		def emailInvalido =
				new Professor(nome: "Prof nome", matricula: "123", email: "sdf")
		assert !emailInvalido.validate()

		def professorValido =
				new Professor(nome: "Prof nome", matricula: "123", email: "abc@mail.com")
		assert professorValido.validate()
	}
	
	void testCRUD() {
		def professor =
			new Professor(nome: "Prof nome", matricula: "123", email: "abc@mail.com")
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
		def professor =
			new Professor(nome: "Prof nome", matricula: "123", email: "abc@mail.com")
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
}