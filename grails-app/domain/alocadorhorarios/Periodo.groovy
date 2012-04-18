package alocadorhorarios

class Periodo {
	 
	Integer numero
	static hasMany = [itensGrade :ItemGrade]
	
	static belongsTo = [curso:Curso]
	
	static constraints= {
		numero(min:1, max:15)
	}
	
 	String toString(){
		 return "$curso - $numero"
	 }
}
