package alocadorhorarios

class Professor {
	String matricula
	String nome
	String email
	
	static hasMany = [telefones:Telefone]
	
    static constraints = {
		nome()
		matricula()
		email(email:true)
    }
}
