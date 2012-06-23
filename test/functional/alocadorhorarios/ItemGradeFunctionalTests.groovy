package alocadorhorarios

import com.grailsrocks.functionaltest.*

class ItemGradeFunctionalTests extends BrowserTestCase {
    
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
		get('/itemGrade/list')
		assertContentContains "List"
		assertStatus 200
        
		get('/itemGrade/create')
		assertContentContains "Create"
		assertStatus 200
		
		form {
			selects['disciplina.id'].select "1"
			selects['periodo.id'].select "1"
			click "create"
		}
		assertContentContains "1"
		assertContentContains "1"
		assertStatus 200
    }
}
