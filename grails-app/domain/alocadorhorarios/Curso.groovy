package alocadorhorarios

class Curso {

	String nome
	Professor coordenador
	Professor viceCoordenador
	static hasMany = [periodos:Periodo]
	
	Integer quantidadeDePeriodos
	
    static constraints = {
		nome()
		coordenador(nullable:true)
		viceCoordenador(nullable:true)
		quantidadeDePeriodos(nullable:true)
    }

	
	String toString(){
		return nome
	}
}
