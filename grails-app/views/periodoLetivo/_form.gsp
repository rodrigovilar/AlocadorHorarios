<%@ page import="alocadorhorarios.PeriodoLetivo" %>



<div class="fieldcontain ${hasErrors(bean: periodoLetivoInstance, field: 'ano', 'error')} required">
	<label for="ano">
		<g:message code="periodoLetivo.ano.label" default="Ano" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="ano" required="" value="${fieldValue(bean: periodoLetivoInstance, field: 'ano')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: periodoLetivoInstance, field: 'numero', 'error')} required">
	<label for="numero">
		<g:message code="periodoLetivo.numero.label" default="Numero" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="numero" min="1" max="2" required="" value="${fieldValue(bean: periodoLetivoInstance, field: 'numero')}"/>
</div>


<g:if test="${periodoLetivoInstance?.id}">
<div class="fieldcontain ${hasErrors(bean: periodoLetivoInstance, field: 'turmas', 'error')} ">
	<label for="turmas">
		<g:message code="periodoLetivo.turmas.label" default="Turmas" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${periodoLetivoInstance?.turmas?}" var="t">
    <li><g:link controller="turma" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="turma" action="create" params="['periodoLetivo.id': periodoLetivoInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'turma.label', default: 'Turma')])}</g:link>
</li>
</ul>

</div>
</g:if>

