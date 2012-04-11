package alocadorhorarios

class Departamento {
	
	String nome
	String cor
	Professor chefe
	Professor subchefe
	
	static hasMany = [professores:Professor, disciplinas:Disciplina]

    static constraints = {
		nome()
		cor(inList:['Azul','Vermelhor','Amarelo','Preto','Verde'])
		chefe(nullable:true)
		subchefe(nullable:true)
    }
}
