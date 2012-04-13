package alocadorhorarios

class Disciplina {

	String nome
	Integer cargaHoraria
	Integer credito
	
    static hasMany = [itensgrade:ItemGrade]
	static belongsTo = [departamento:Departamento]

	static constraints = {
		nome()
		cargaHoraria()
		credito()
	}
	
	
	String toString(){
		return nome
	}

}