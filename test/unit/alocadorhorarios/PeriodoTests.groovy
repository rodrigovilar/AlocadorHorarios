package alocadorhorarios

import static org.junit.Assert.*

import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*


@TestFor(Periodo)
@Mock(Curso)

class PeriodoTests {

    void testValidacaoPeriodo() {
		Periodo numeroInvalido = new Periodo()
		assert !numeroInvalido.validate()
		
		/*O teste abaixo foi alterado:
		 * Cria um periodo passando um numero no construtor e valida o mesmo
		 */
		
		Periodo periodoSemCurso = new Periodo(numero:5)
		assert periodoSemCurso.validate()
		
		
		Curso curso = new Curso(nome: "computacao")
		Periodo periodoVazio = new Periodo(numero:2)
	
			curso.addToPeriodos(periodoVazio)
		assert periodoVazio.validate()
		
		Periodo periodoValido = new Periodo(numero:3)
		curso.addToPeriodos(periodoValido)
		assert periodoValido.validate()		
		
	}
	
	void testCRUD(){
				
		Curso curso = new Curso(nome:"Sistemas de Informação")
		curso.save()
		
		def periodo = new Periodo(numero: 2)
		curso.addToPeriodos(periodo)
		periodo.save()
		
		def novoPeriodo = new Periodo(numero: 5)
		curso.addToPeriodos(novoPeriodo)
		novoPeriodo.save()
		
		def p = Periodo.list()
		assert p.size() == 2
		
		def periodoCadastrado = p[0]
		assertEquals(periodo.numero, periodoCadastrado.numero)
		
		
		periodo.delete()
		novoPeriodo.delete()
		p = Periodo.list()
		assert p.size() == 0
		
	}
	
}
