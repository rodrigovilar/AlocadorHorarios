package alocadorhorarios

class Curso {

	String nome
	Professor coordenador
	Professor viceCoordenador
	static hasMany = [periodos:Periodo]
	
    static constraints = {
		nome()
		coordenador(nullable:true)
		viceCoordenador(nullable:true)
    }

	
	String toString(){
		return nome
	}
}
