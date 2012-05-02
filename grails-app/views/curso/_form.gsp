
<%@ page import="alocadorhorarios.Curso" %>


<div class="fieldcontain ${hasErrors(bean: cursoInstance, field: 'nome', 'error')} ">
	<label for="nome">
		<g:message code="curso.nome.label" default="Nome" />
		
	</label>
	<g:textField name="nome" value="${cursoInstance?.nome}"/>
</div>


<div class="fieldcontain ${hasErrors(bean: cursoInstance, field: 'coordenador', 'error')} ">
	<label for="coordenador">
		<g:message code="curso.coordenador.label" default="Coordenador" />
		
	</label>
	<g:select id="coordenador" name="coordenador.id" from="${alocadorhorarios.Professor.list()}" 

optionKey="id" value="${cursoInstance?.coordenador?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>


<div class="fieldcontain ${hasErrors(bean: cursoInstance, field: 'viceCoordenador', 'error')} ">
	<label for="viceCoordenador">
		<g:message code="curso.viceCoordenador.label" default="Vice Coordenador" />
		
	</label>
	<g:select id="viceCoordenador" name="viceCoordenador.id" from="${alocadorhorarios.Professor.list()}" 

optionKey="id" value="${cursoInstance?.viceCoordenador?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>


<div class="fieldcontain ${hasErrors(bean: cursoInstance, field: 'quantidade', 'error')}" >
	<label for="quantidade">
		<g:message code="curso.quantidade.label" default="Quantidade"/>
	
	</label>
	<g:textField type="number" name="quantidade"/>	
</div>


<g:if test="${cursoInstance?.id}">
<div class="fieldcontain ${hasErrors(bean: cursoInstance, field: 'periodos', 'error')} ">
	<label for="periodos">
		<g:message code="curso.periodos.label" default="Periodos" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${cursoInstance?.periodos?}" var="p">
    <li><g:link controller="periodo" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>

</div>
</g:if>

