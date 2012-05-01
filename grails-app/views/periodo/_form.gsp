
<%@ page import="alocadorhorarios.Periodo" %>



<div class="fieldcontain ${hasErrors(bean: periodoInstance, field: 'numero', 'error')} required">
	<label for="numero">
		<g:message code="periodo.numero.label" default="Numero" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="numero" min="1" max="15" required="" value="${fieldValue(bean: 

periodoInstance, field: 'numero')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: periodoInstance, field: 'curso', 'error')} required">
	<label for="curso">
		<g:message code="periodo.curso.label" default="Curso" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="curso" name="curso.id" from="${alocadorhorarios.Curso.list()}" optionKey="id" required="" 

value="${periodoInstance?.curso?.id}" class="many-to-one"/>
</div>



<g:if test="${periodoInstance?.id}">
<div class="fieldcontain ${hasErrors(bean: periodoInstance, field: 'itensGrade', 'error')} ">
	<label for="itensGrade">
		<g:message code="periodo.itensGrade.label" default="Itens Grade" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${periodoInstance?.itensGrade?}" var="i">
    <li><g:link controller="itemGrade" action="show" id="${i.id}">${i?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="itemGrade" action="create" params="['periodo.id': periodoInstance?.id]">${message(code: 

'default.add.label', args: [message(code: 'itemGrade.label', default: 'ItemGrade')])}</g:link>
</li>
</ul>

</div>
</g:if>
