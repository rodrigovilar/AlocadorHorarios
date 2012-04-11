package alocadorhorarios

import static org.junit.Assert.*

import grails.test.mixin.support.*


class DepartamentoTests {

	void testValidacaoDepartamento() {
	
		Departamento nomeInvalido =
				new Departamento(cor: "azul")
		assert !nomeInvalido.validate()
	
		Departamento corInvalida =
				new Departamento(nome: "DCE")
		assert !corInvalida.validate()
		
		Departamento chefeInvalido =
				new Departamento(nome: "DCE", cor: "azul")
		assert chefeInvalido.validate()
		
	}
	
	void testCRUD() {
		
		Departamento departamento1 = new Departamento(nome:"DCE", cor:"azul")
		Departamento departamento2 = new Departamento(nome:"DL", cor:"verde")
		departamento1.save()
		departamento2.save()
		
		def departamentos = Departamento.list()
		assert departamentos.size() == 2
	
		def departamentoCadastrado1 = departamentos[0]
		assertEquals departamento1.nome, departamentoCadastrado1.nome
		assertEquals departamento1.cor, departamentoCadastrado1.cor
		
		def departamentoCadastrado2 = departamentos[1]
		assertEquals departamento2.nome, departamentoCadastrado2.nome
		assertEquals departamento2.cor, departamentoCadastrado2.cor
		
		departamento1.nome = "nome 1"
		departamento1.cor = "vermelho"
		departamento1.save()
		
		departamentos = Departamento.list()
		assert departamentos.size() == 2
		
		departamentoCadastrado1 = departamentos[0]
		assertEquals departamento1.nome, departamentoCadastrado1.nome
		assertEquals departamento1.cor, departamentoCadastrado1.cor
		
		departamento1.delete()
		
		departamentos = Departamento.list()
		assert departamentos.size() == 1
	}
	
}