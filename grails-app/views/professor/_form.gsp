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

<div class="fieldcontain ${hasErrors(bean: professorInstance, field: 'imagem', 'error')} required">
	<label for="imagem">
		<g:message code="professor.imagem.label" default="Imagem" />
		<span class="required-indicator">*</span>
	</label>
	<input type="file" id="imagem" name="imagem" />
</div>

