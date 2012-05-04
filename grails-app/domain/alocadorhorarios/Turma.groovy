package alocadorhorarios

class Turma {
	
	Professor professor
	
	static belongsTo = [periodoLetivo:PeriodoLetivo, disciplina:Disciplina]
	static hasMany = [horarios: Horario]
    static constraints = {
    }
}
