package alocadorhorarios

class Professor {
	String matricula
	String nome
	String email
	byte[] imagem;
	
	static belongsTo = [departamento:Departamento]
	static hasMany = [telefones:Telefone]
	
    static constraints = {
		departamento()
		nome()
		matricula()
		email(email:true)
		imagem(nullable:true, size:0..300000 /*300k*/)
    }
}
