package alocadorhorarios

class Disciplina {

	String nome
	Integer cargaHoraria
	Integer credito
     static hasMany = [itensgrade :ItemGrade]
	
	

	static constraints = {
		nome()
		cargaHoraria()
		credito()
	}

}