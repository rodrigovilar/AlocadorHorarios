package alocadorhorarios

class Periodo {
	 
	Integer numero
	static hasMany = [itensGrade :ItemGrade]
	
	static belongsTo = Curso
	
	static constraints= {
		numero()
	}
}