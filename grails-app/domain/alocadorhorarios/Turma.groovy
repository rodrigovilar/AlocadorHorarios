package alocadorhorarios

class Turma {
	
	Professor professor
	
	static belongsTo = [periodoLetivo:PeriodoLetivo, disciplina:Disciplina]
	
    static constraints = {
    }
}
