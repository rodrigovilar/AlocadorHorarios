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
		
		click "809088"
		assertStatus 200
		
		click "Edit"
		assertStatus 200
		
		click "addTelefones"
		form {
			numero "8399998989"
			click "create"
		}
		assertContentContains "8399998989"
		assertContentContains "created"
		assertStatus 200
		
		
		form {
			click "_action_delete"
		}
		assertStatus 200
		
		assertContentContains "deleted"
		assertStatus 200
		
	 }
}
