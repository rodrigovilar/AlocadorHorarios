package alocadorhorarios

import java.awt.Desktop.Action;

import alocadorhorarios.Departamento;

import com.grailsrocks.functionaltest.*

class DepartamentoFunctionalTests extends BrowserTestCase {
    
	void testList(){
		get('/departamento/list')
		assertContentContains "List"
		assertStatus 200
		
		get('/departamento/create')
		assertContentContains "Create"
		assertStatus 200
		
		form {
			nome "dce"
			cor "amarelo"
			click "create"
		}
		assertContentContains "dce"
		assertContentContains "amarelo"
		assertContentContains "created"
		assertStatus 200
		
		click "Edit"
		assertContentContains "Edit"
		assertStatus 200
		
		form {
			nome "dcn"
			cor "verde"
			click "_action_update"
		}
		
		assertContentContains "dcn"
		assertContentContains "verde"
		assertContentContains "updated"
		assertStatus 200
		
		click "Departamento List"
		assertContentContains "dcn"
		assertContentContains "verde"
		assertContentContains "List"
		assertStatus 200
		
		click "dcn"
		click "Edit"
		
		click "addDisciplinas"
		
		form {
			nome "poo"
			cargaHoraria "60"
			credito "4"
			click "create"
		}
		assertContentContains "poo"
		assertContentContains "60"
		assertContentContains "4"
		assertStatus 200
		
		click "dcn"
		click "Edit"
		
		click "addDisciplinas"
				
		form{
			nome "banco de dados"
			cargaHoraria "60"
			credito "4"
			click "create"
		}
		assertContentContains "banco de dados"
		assertContentContains "60"
		assertContentContains "4"
		assertStatus 200
		
		
		click "dcn"
		click "Edit"
		
		click "addProfessores"
		
		form {
			matricula "102030"
			nome "john"
			email "john@x.com"
			click "create"
		}
		assertContentContains "102030"
		assertContentContains "john"
		assertContentContains "john@x.com"
		assertStatus 200
	}
}
