package alocadorhorarios

class Professor {
	String matricula
	String nome
	String email
	
	static hasMany = [telefones:Telefone]
	byte[] imagem;
	
    static constraints = {
		nome()
		matricula()
		email(email:true)
		imagem(size:0..300000 /*300k*/)
    }
}
