package alocadorhorarios

class ItemGrade {

	Integer id
	
	static belongsTo = [Periodo,Disciplina]

	
    static constraints = {
    }
}
