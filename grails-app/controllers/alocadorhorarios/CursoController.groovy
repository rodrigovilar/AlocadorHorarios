package alocadorhorarios

class CursoController {

    def scaffold = true
	
	def addPeriodos() {
		
		int i
		Curso curso
		
		for (i = 1; i <= curso.getQuantidadeDePeriodos() ; i++) {
			Periodo p = new Periodo(i)
			curso.periodos.add(p)
		} 
	}
}
