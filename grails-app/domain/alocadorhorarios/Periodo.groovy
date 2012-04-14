package alocadorhorarios

class Periodo {
	 
	Integer numero
	static hasMany = [itensGrade :ItemGrade]
	
	static belongsTo = Curso
	
	static constraints= {
		numero(min:1, max:15)
	}
	
 	String toString(){
		 return numero
	 }
}
