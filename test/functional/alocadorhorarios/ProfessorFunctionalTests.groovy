package alocadorhorarios

import com.grailsrocks.functionaltest.*

class ProfessorFunctionalTests extends BrowserTestCase {
    void testList() {
		get('/professor/list')
		assertContentContains "List"
		assertStatus 200
		
		get('/professor/create')
		assertContentContains "Create"
		assertStatus 200
		
		form {
			matricula "809077"
			nome "professor de ingles"
			email "professoringles@terra.com.br"
			click "create"
		}
		assertContentContains "809077"
		assertContentContains "professor de ingles"
		assertContentContains "professoringles@terra.com.br"
		assertContentContains "created"
		assertStatus 200
		
		click "Edit"
		assertContentContains "Edit"
		assertStatus 200
		
		form {
			matricula "809088"
			nome "professor de calculo"
			email "professorcalculo@terra.com.br"
			click "_action_update"
		}
		assertContentContains "809088"
		assertContentContains "professor de calculo"
		assertContentContains "professorcalculo@terra.com.br"
		assertContentContains "updated"
		assertStatus 200
		
		click "Professor List"
		assertContentContains "809088"
		assertContentContains "professor de calculo"
		assertContentContains "professorcalculo@terra.com.br"
		assertContentContains "List"
		assertStatus 200
		
	 }
}
