package alocadorhorarios

class ItemGrade {

	Integer id
	
	static belongsTo = [Periodo,Departamento]

	
    static constraints = {
    }
}
