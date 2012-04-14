package alocadorhorarios

class ItemGrade {
	
	static belongsTo = [periodo:Periodo,disciplina:Disciplina]

	static constraints = {
	}

}
