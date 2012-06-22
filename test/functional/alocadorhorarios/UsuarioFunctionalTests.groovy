package alocadorhorarios

import com.grailsrocks.functionaltest.*

class UsuarioFunctionalTests extends BrowserTestCase {
   
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
	void testUsuarioList(){
		get('/usuario/list')
		assertContentContains "List"
		assertStatus 200
		
		get('/usuario/create')
		assertStatus 200
		form {
			username "Manuel"
			password "1234"
			click "create"
		}
		assertStatus 200
		assertContentContains "Manuel"
		assertContentContains "created"
		assertStatus 200
		
		click "Edit"
		assertStatus 200
		
		form {
			username "Tiao"
			password "12340"
			click "_action_update"
		}
		assertStatus 200
		assertContentContains "Tiao"
		assertContentContains "updated"
		assertStatus 200
		
		click "Usuario List"
		assertContentContains "Tiao"
		assertContentContains "List"
		assertStatus 200
		
	}
}
