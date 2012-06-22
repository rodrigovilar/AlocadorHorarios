package alocadorhorarios

import com.grailsrocks.functionaltest.*

class TelefoneFunctionalTests extends BrowserTestCase {
	
	void testLogin() {
		get('/login/auth')
		assertStatus 200
		
		form {
			j_username "joao"
			j_password "1234"
			click "submit"
		}
		assertContentContains "submit"
		assertStatus 200
	}
	
    void testSomeWebsiteFeature() {
		
		get('/telefone/list')
		assertContentContains "List"
		assertStatus 200
		
		get('/telefone/create')
		assertContentContains "Create"
		assertStatus 200
		
		form {
			numero "8332210011"
			click "create"
		}
		assertContentContains "8332210011"
		assertContentContains "created"
		assertStatus 200
		
		click "Edit"
		//assertContentContains "Edit"
		//assertStatus 200
		form {
			numero "8132210011"
			click "_action_update"
		}
		assertContentContains "8132210011"
		assertContentContains "updated"
		assertStatus 200
		
		click "Telefone List"
		assertContentContains "8132210011"
		assertContentContains "List"
		assertStatus 200
		
		
    }
}
