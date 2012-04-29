
<%@ page import="alocadorhorarios.Curso" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'curso.label', default: 'Curso')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-curso" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-curso" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list curso">
			
				<g:if test="${cursoInstance?.nome}">
				<li class="fieldcontain">
					<span id="nome-label" class="property-label"><g:message code="curso.nome.label" default="Nome" /></span>
					
						<span class="property-value" aria-labelledby="nome-label"><g:fieldValue bean="${cursoInstance}" field="nome"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${cursoInstance?.coordenador}">
				<li class="fieldcontain">
					<span id="coordenador-label" class="property-label"><g:message code="curso.coordenador.label" default="Coordenador" /></span>
					
						<span class="property-value" aria-labelledby="coordenador-label"><g:link controller="professor" action="show" id="${cursoInstance?.coordenador?.id}">${cursoInstance?.coordenador?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${cursoInstance?.viceCoordenador}">
				<li class="fieldcontain">
					<span id="viceCoordenador-label" class="property-label"><g:message code="curso.viceCoordenador.label" default="Vice Coordenador" /></span>
					
						<span class="property-value" aria-labelledby="viceCoordenador-label"><g:link controller="professor" action="show" id="${cursoInstance?.viceCoordenador?.id}">${cursoInstance?.viceCoordenador?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${cursoInstance?.periodos}">
				<li class="fieldcontain">
					<span id="periodos-label" class="property-label"><g:message code="curso.periodos.label" default="Periodos" /></span>
					
						<g:each in="${cursoInstance.periodos}" var="p">
						<span class="property-value" aria-labelledby="periodos-label"><g:link controller="periodo" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${cursoInstance?.id}" />
					<g:link class="edit" action="edit" id="${cursoInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
