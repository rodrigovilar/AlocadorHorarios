package alocadorhorarios

class Periodo {
	 
	Integer numero
	static hasMany = [itensGrade :ItemGrade]
	
	static constraints= {
		numero()
	}
}