package alocadorhorarios

class Horario {
	
	String hora_inicio
	String hora_fim
	
	static belongsTo = [turma:Turma]
	
	static constraints = {
	
	  hora_inicio inList : ["7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22"]
	  hora_fim inList : ["7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22"]
	
	  }
	
	}
