package alocadorhorarios

class Disciplina {

	String nome
	Integer cargaHoraria
	Integer credito
	
    static hasMany = [itensGrade :ItemGrade]
	static belongsTo = [departamento:Departamento]

	static constraints = {
		nome()
		cargaHoraria()
		credito()
		departamento()
	}

}