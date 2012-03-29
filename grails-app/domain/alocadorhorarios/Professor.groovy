package alocadorhorarios

class Professor {
	String matricula
	String nome
	String email
	byte[] imagem;
	
    static constraints = {
		nome()
		matricula()
		email(email:true)
		imagem(maxSize:300000 /*300k*/)
    }
}
