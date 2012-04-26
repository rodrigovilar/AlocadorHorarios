package alocadorhorarios

import java.awt.Desktop.Action;

import alocadorhorarios.Departamento;

import com.grailsrocks.functionaltest.*

class DepartamentoFunctionalTests extends BrowserTestCase {
    void testSomeWebsiteFeature() {
        // Here call get(uri) or post(uri) to start the session
        // and then use the custom assertXXXX calls etc to check the response
        //
        // get('/something')
        // assertStatus 200
        // assertContentContains 'the expected text'
    }
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
		
	}
	
}
