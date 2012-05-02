package alocadorhorarios



import grails.test.mixin.*


class HorarioTests {

	void testValidacaoHorario (){
		Horario hora_fimInvalido = new Horario ()
		assert !hora_fimInvalido.validate()
		
		Horario hora_inicioInvalido = new Horario (hora_fim:"8")
		assert !hora_inicioInvalido.validate()
		
		Horario hora_fimInvalido1 = new Horario (hora_inicio:"10")
		assert !hora_fimInvalido1.validate()
		
		Departamento departamento = new Departamento(nome: "DCE", cor: "Azul")
		Disciplina disciplinaValida = new Disciplina(nome: "Matem�tica Elementar", cargaHoraria: 60, credito: 4)
		departamento.addToDisciplinas(disciplinaValida)

		PeriodoLetivo plValido  = new PeriodoLetivo(ano: 2012, numero:1)
		Turma turmaValida = new Turma()
		disciplinaValida.addToTurmas(turmaValida)
		plValido.addToTurmas(turmaValida)
		
		Horario horario = new Horario (hora_inicio:"7",hora_fim:"10")
		turmaValida.addToHorarios(horario)
		assert horario.validate()
		
		
	}

	void testCRUD(){
		Horario horario = new Horario (hora_inicio:"7",hora_fim:"10")
		horario.save()
		def horarios = Horario.list()
		assert horarios.size()==1
		def horarioAdicionado = horarios [0]
		assertEquals horario.hora_inicio,horarioAdicionado.hora_inicio
		assertEquals horario.hora_fim,horarioAdicionado.hora_fim
		horarioAdicionado = horarios[0]
		assertEquals horario.hora_inicio,horarioAdicionado.hora_inicio
		assertEquals horario.hora_fim,horarioAdicionado.hora_fim
		horario.delete()
	}
}