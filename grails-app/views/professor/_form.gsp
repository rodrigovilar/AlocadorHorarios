<%@ page import="alocadorhorarios.Professor" %>



<div class="fieldcontain ${hasErrors(bean: professorInstance, field: 'matricula', 'error')} ">
	<label for="matricula">
		<g:message code="professor.matricula.label" default="Matricula" />
		
	</label>
	<g:textField name="matricula" value="${professorInstance?.matricula}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: professorInstance, field: 'nome', 'error')} ">
	<label for="nome">
		<g:message code="professor.nome.label" default="Nome" />
		
	</label>
	<g:textField name="nome" value="${professorInstance?.nome}"/>
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



<div class="fieldcontain ${hasErrors(bean: professorInstance, field: 'departamento', 'error')} required">
	<label for="departamento">
		<g:message code="professor.departamento.label" default="Departamento" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="departamento" name="departamento.id" from="${alocadorhorarios.Departamento.list()}" optionKey="id" required="" value="${professorInstance?.departamento?.id}" class="many-to-one"/>
</div>


<g:if test="${professorInstance?.id}">
<div class="fieldcontain ${hasErrors(bean: professorInstance, field: 'telefones', 'error')} ">
	<label for="telefones">
		<g:message code="professor.telefones.label" default="Telefones" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${professorInstance?.telefones?}" var="t">
    <li><g:link controller="telefone" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="telefone" action="create" params="['professor.id': professorInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'telefone.label', default: 'Telefone')])}</g:link>
</li>
</ul>

</div>
</g:if>
