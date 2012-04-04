<%@ page import="alocadorhorarios.Professor" %>



<div class="fieldcontain ${hasErrors(bean: professorInstance, field: 'nome', 'error')} ">
	<label for="nome">
		<g:message code="professor.nome.label" default="Nome" />
		
	</label>
	<g:textField name="nome" value="${professorInstance?.nome}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: professorInstance, field: 'matricula', 'error')} ">
	<label for="matricula">
		<g:message code="professor.matricula.label" default="Matricula" />
		
	</label>
	<g:textField name="matricula" value="${professorInstance?.matricula}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: professorInstance, field: 'email', 'error')} ">
	<label for="email">
		<g:message code="professor.email.label" default="Email" />
		
	</label>
	<g:field type="email" name="email" value="${professorInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: professorInstance, field: 'imagem', 'error')} ">
	<label for="imagem">
		<g:message code="professor.imagem.label" default="Imagem" />
		
	</label>
	<input type="file" id="imagem" name="imagem" />
</div>

<div class="fieldcontain ${hasErrors(bean: professorInstance, field: 'telefones', 'error')} ">
	<label for="telefones">
		<g:message code="professor.telefones.label" default="Telefones" />
		
	</label>
	<g:select name="telefones" from="${alocadorhorarios.Telefone.list()}" multiple="multiple" optionKey="id" size="5" value="${professorInstance?.telefones*.id}" class="many-to-many"/>
</div>

