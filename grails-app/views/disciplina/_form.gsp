<%@ page import="alocadorhorarios.Disciplina" %>



<div class="fieldcontain ${hasErrors(bean: disciplinaInstance, field: 'nome', 'error')} ">
	<label for="nome">
		<g:message code="disciplina.nome.label" default="Nome" />
		
	</label>
	<g:textField name="nome" value="${disciplinaInstance?.nome}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: disciplinaInstance, field: 'cargaHoraria', 'error')} required">
	<label for="cargaHoraria">
		<g:message code="disciplina.cargaHoraria.label" default="Carga Horaria" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="cargaHoraria" min="15" max="250" required="" value="${fieldValue(bean: disciplinaInstance, field: 'cargaHoraria')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: disciplinaInstance, field: 'credito', 'error')} required">
	<label for="credito">
		<g:message code="disciplina.credito.label" default="Credito" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="credito" min="3" max="25" required="" value="${fieldValue(bean: disciplinaInstance, field: 'credito')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: disciplinaInstance, field: 'departamento', 'error')} required">
	<label for="departamento">
		<g:message code="disciplina.departamento.label" default="Departamento" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="departamento" name="departamento.id" from="${alocadorhorarios.Departamento.list()}" optionKey="id" required="" value="${disciplinaInstance?.departamento?.id}" class="many-to-one"/>
</div>


<g:if test="${disciplinaInstance?.id}">
<div class="fieldcontain ${hasErrors(bean: disciplinaInstance, field: 'turmas', 'error')} ">
	<label for="turmas">
		<g:message code="disciplina.turmas.label" default="Turmas" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${disciplinaInstance?.turmas?}" var="t">
    <li><g:link controller="turma" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="turma" action="create" params="['disciplina.id': disciplinaInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'turma.label', default: 'Turma')])}</g:link>
</li>
</ul>

</div>
</g:if>
