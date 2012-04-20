package alocadorhorarios

class Disciplina {

	String nome
	Integer cargaHoraria
	Integer credito
	
    static hasMany = [itensGrade:ItemGrade, turma:Turma]
	static belongsTo = [departamento:Departamento]

	static constraints = {
		nome()
		cargaHoraria(max:250, min:15)
		credito (max:25, min:3)
		 
	}
	
	
	String toString(){
		return nome
	}

}
