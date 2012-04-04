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
}