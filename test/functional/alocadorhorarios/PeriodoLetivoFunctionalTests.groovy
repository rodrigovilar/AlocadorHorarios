package alocadorhorarios

import com.grailsrocks.functionaltest.*

class PeriodoLetivoFunctionalTests extends BrowserTestCase {
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
	void testList() {
		get('/periodoLetivo/list')
		assertContentContains "List"
		assertStatus 200
		
		get('/periodoLetivo/create')
		assertContentContains "Create"
		assertStatus 200
		
		form {
			ano "11"
			numero "1"
			click "create"
		}
		assertContentContains "11"
		assertContentContains "1"
		assertContentContains "created"
		assertStatus 200
		
		click "Edit"
		assertContentContains "Edit"
		assertStatus 200
		
		form {
			ano "12"
			numero "2"
			click "_action_update"
		}
		assertContentContains "12"
		assertContentContains "2"
		assertContentContains "updated"
		assertStatus 200

		click "PeriodoLetivo List"
		assertContentContains "12"
		assertContentContains "2"
		assertContentContains "List"
		assertStatus 200
	}
}
