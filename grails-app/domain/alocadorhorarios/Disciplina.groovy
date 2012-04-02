package alocadorhorarios

class Disciplina {

	String nome
	Integer cargaHoraria
	Integer credito

	static constraints = {
		nome()
		cargaHoraria()
		credito()
	}

}