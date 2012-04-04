package alocadorhorarios

class Telefone {
	String numero
	static belongsTo = Professor

    static constraints = {
		numero(nullable:false)
    }
	
}
