package alocadorhorarios

class Professor {
	String matricula
	String nome
	String email
	
    static constraints = {
		nome()
		matricula()
		email(email:true)
    }
}
