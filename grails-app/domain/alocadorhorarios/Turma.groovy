package alocadorhorarios

class Turma {
	
	static hasMany = [professores:Professor]
	static belongsTo = [periodoLetivo:PeriodoLetivo, disciplina:Disciplina]
	
    static constraints = {
    }
}
