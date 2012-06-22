package alocadorhorarios

import com.grailsrocks.functionaltest.*

class TurmaFunctionalTests extends BrowserTestCase {
	
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
		get('/turma/list')
		assertContentContains "List"
		assertStatus 200
		
		get('/turma/create')
		assertContentContains "Create"
		assertStatus 200
		
		form {
			selects['disciplina.id'].select "1"
			selects['periodoLetivo.id'].select "1"
			selects['professor.id'].select "1"
			click "create"
		}
		assertStatus 200
    }
}
