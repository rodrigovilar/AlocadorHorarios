package alocadorhorarios

class ItemGrade {

	Integer id
	
	static belongsTo = [periodo:Periodo,departamento:Departamento]

	
    static constraints = {
    }
}
