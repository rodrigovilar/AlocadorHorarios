package alocadorhorarios

class Departamento {
	
	Professor chefe
	Professor subchefe
	String nome
	String cor

    static constraints = {
		nome()
		cor()
		chefe(nullable:true)
		subchefe(nullable:true)
    }
}
