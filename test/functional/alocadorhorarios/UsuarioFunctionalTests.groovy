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
		
		
		get('/usuario/list')
		assertContentContains "List"
		assertStatus 200
		
		/*click "Gonçalves"
		assertContentContains "Gonçalves"
		assertStatus 200
		form {
			j_username "Tiao"
			j_password "senha00"
			click "_action_update"
		}
		assertStatus 200
		assertContentContains "Tiao"
		assertContentContains "senha00"
		assertContentContains "updated"
		assertStatus 200
		*/
	}
}
