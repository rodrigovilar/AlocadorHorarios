package alocadorhorarios

class Curso {

	String nome
	Professor coordenador
	Professor viceCoordenador
	
	static embedded = ['coordenador', 'viceCoordenador']

    static constraints = {
		nome()
		coordenador
		viceCoordenador
    }

}
