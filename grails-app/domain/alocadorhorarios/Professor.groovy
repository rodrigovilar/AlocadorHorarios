package alocadorhorarios

class Professor {
	
	String matricula
	String nome
	String email
	byte[] imagem
	
	static hasMany = [telefones:Telefone, turma:Turma]
	static belongsTo = [departamento:Departamento, turma:Turma]
	
    static constraints = {
		matricula()
		nome()
		email(email:true)
		imagem(nullable:true, size:0..300000 /*300k*/)
    }

	
	String toString(){
		 
		return nome
	}
 
}
