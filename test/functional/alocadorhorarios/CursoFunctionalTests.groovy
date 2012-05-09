
package alocadorhorarios

import com.grailsrocks.functionaltest.*

class CursoFunctionalTests extends BrowserTestCase {
    void testList(){
		
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
		
		 
		get('/professor/create')
		assertContentContains "Create"
		assertStatus 200
		
		form {
			matricula "809077"
			nome "Paulo"
			email "paulo@terra.com.br"
			click "create"
		}
		assertContentContains "809077"
		assertContentContains "Paulo"
		assertContentContains "paulo@terra.com.br"
		assertContentContains "created"
		assertStatus 200
		
		
       
        get('/curso/list')
        assertContentContains "List"
        assertStatus 200
       
        get('/curso/create')
        assertContentContains "Create"
        assertStatus 200
       
        form {
           
      nome "Psicologia"
	 
      quantidade "1"
      click "create"
     
        }
        assertContentContains "Psicologia"
	
        assertContentContains "1"
        assertContentContains "created"
        assertStatus 200
       
       
       
        click "Edit"
        assertContentContains "Edit"
        assertStatus 200
       
        form {
            nome "Psicologia da Mulher"
			
            quantidade "1"
            click "_action_update"
        }
       
        assertContentContains "Psicologia da Mulher"
		
        assertContentContains "1"
       
        assertContentContains "updated"
        assertStatus 200
       
        click "Curso List"
        assertContentContains "Psicologia da Mulher"
       
       
        assertContentContains "1"
        assertContentContains "List"
        assertStatus 200
		
		
}
}