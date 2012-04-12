package alocadorhorarios

class Telefone {
	String numero
	static belongsTo = [professor:Professor]

    static constraints = {
		numero(nullable:false)
    }
	
}
