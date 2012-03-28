package alocadorhorarios

class Departamento {
	
	Professor chefe
	String nome
	String cor

    static constraints = {
		nome()
		cor()
		chefe(nullable:true)
    }
}
