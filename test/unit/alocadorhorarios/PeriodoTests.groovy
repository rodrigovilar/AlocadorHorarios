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
		
		Periodo periodoSemCurso = new Periodo()
		assert !periodoSemCurso.validate()
		
		
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
		
		def p2 = Periodo.list()
		assert p2.size() == 1
		
		def periodoCadastrado = p2[0]
		assertEquals(periodo.numero, periodoCadastrado.numero)
		
		periodo.numero = 3
		periodo.save()
		
		def p3 = Periodo.list()
		assert p3.size() == 1
		
		periodoCadastrado = p3[0]
		assertEquals(periodo.numero, periodoCadastrado.numero)
		
		periodo.delete()
		
		p3 = Periodo.list()
		assert p3.size() == 0
		
		p2 = Periodo.list()
		assert p2.size() == 0
	
	}
	
}
