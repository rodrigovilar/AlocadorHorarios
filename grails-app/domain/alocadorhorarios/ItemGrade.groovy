package alocadorhorarios

class ItemGrade {
	Integer id
	static belongsTo = [periodo:Periodo, disciplina:Disciplina]

	static constraints = {
	}

}