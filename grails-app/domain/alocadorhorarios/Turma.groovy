package alocadorhorarios

class Turma {
	
	static belongsTo = [periodoLetivo:PeriodoLetivo,disciplina:Disciplina]
//	static hasMany = [horario:Horario]
	
    static constraints = {
    }
}
