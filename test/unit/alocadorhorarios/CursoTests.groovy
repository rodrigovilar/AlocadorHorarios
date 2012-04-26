package alocadorhorarios

import static org.junit.Assert.*

import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*

@TestFor(Curso)
@Mock(Professor)

class CursoTests {
	
	void testPersist() {
		
		def professor =
			new Professor(nome: "Scaico", matricula: "123", email: "Scaico@dce.ufpb.br")
		
			def professor2 =
						new Professor(nome: "Rodrigo Vilar", matricula: "123", email: "rodrigo@dce.ufpb.br")
		Curso curso = new Curso(nome:"Sistema de Informa�ao", coordenador:professor,viceCoordenador : professor2)
		curso.save()
		
		
		def cursos = Curso.list()
		assert cursos.size() == 1
		
		def cursoCadastrado = cursos[0]
		assertEquals curso.nome, cursoCadastrado.nome
		assertEquals curso.coordenador, cursoCadastrado.coordenador
		assertEquals curso.viceCoordenador, cursoCadastrado.viceCoordenador
		
		curso.nome = "Ecologia"
		curso.coordenador= professor2
		curso.save()
		
		assertEquals curso.nome, cursoCadastrado.nome
		assertEquals curso.coordenador, cursoCadastrado.coordenador
		assertEquals curso.viceCoordenador, cursoCadastrado.viceCoordenador

		curso.delete()
		
		cursos = Curso.list()
		assert cursos.size() == 0
	}

	void testValidacaoCurso() {
		
		def professor =
		new Professor(nome: "Scaico", matricula: "123", email: "Scaico@dce.ufpb.br")
	
		def professor2 =
					new Professor(nome: "Rodrigo Vilar", matricula: "123", email: "rodrigo@dce.ufpb.br")

		def cursoSemNome = new Curso( coordenador:professor,vicecoordenador : professor2)
		assert !cursoSemNome.validate()


		def cursoVazio = new Curso( )
		assert !cursoVazio.validate()
		
		
		def cursoSemCoordenador = new Curso(nome:"Contabilidade",vicecoordenador: professor)
	    assert cursoSemCoordenador.validate()
		
		def cursoSemViceCoordenador = new Curso (nome :" F�sica", coordenador : professor2) 
		assert cursoSemViceCoordenador.validate()
		
		}
}


