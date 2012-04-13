package alocadorhorarios

class Departamento {
	
	String nome
	String cor
	Professor chefe
	Professor subchefe
	
	static hasMany = [professores:Professor, disciplinas:Disciplina]

    static constraints = {
		nome()
		cor()
		chefe(nullable:true)
		subchefe(nullable:true)
    }
	
	
	String toString(){
		return nome
	}
}
