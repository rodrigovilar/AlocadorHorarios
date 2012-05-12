package alocadorhorarios

import com.grailsrocks.functionaltest.*

class DisciplinaFunctionalTests extends BrowserTestCase {
    void testList() {
		get ('/disciplina/list')
		assertContentContains "List"
		assertStatus 200
		
		get('/disciplina/create')
		assertContentContains "Create"
		assertStatus 200
		
		form {
			nome "redes"
			cargaHoraria "60"
			credito "4"
			click "create"
		}
		assertContentContains "redes"
		assertContentContains "60"
		assertContentContains "4"
		assertContentContains "created"
		assertStatus 200
		
		click "Edit"
		assertContentContains "Edit"
		assertStatus 200
		
		form {
			nome "corporativo"
			cargaHoraria "60"
			credito "4"
			click "_action_update"
		}
		
		assertContentContains "corporativo"
		assertContentContains "60"
		assertContentContains "4"
		assertContentContains "updated"
		assertStatus 200
		
		
		click "Disciplina List"
		
		click "corporativo"
		assertStatus 200
		
		
		form {
			click "_action_delete"
		}
		assertStatus 200
		
		assertContentContains "deleted"
		assertStatus 200
		
	}
}
