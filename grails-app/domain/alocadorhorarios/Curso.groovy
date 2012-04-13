package alocadorhorarios

class Curso {

	String nome
	Professor coordenador
	Professor viceCoordenador
	
    static constraints = {
		nome()
		coordenador(nullable:true)
		viceCoordenador(nullable:true)
    }

}
