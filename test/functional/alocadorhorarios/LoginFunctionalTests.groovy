package alocadorhorarios

import com.grailsrocks.functionaltest.*

class LoginFunctionalTests extends BrowserTestCase {
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
}
