package alocadorhorarios

class Periodo {
	 
	Integer numero
	static hasMany = [itensGrade :ItemGrade]
	
	static belongsTo = [curso:Curso]
	
	static constraints= {
		numero()
	}
	
 	String toString(){
		 return numero
	 }
}