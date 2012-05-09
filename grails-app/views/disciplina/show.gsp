
<%@ page import="alocadorhorarios.Disciplina" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'disciplina.label', default: 'Disciplina')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-disciplina" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-disciplina" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list disciplina">
			
				<g:if test="${disciplinaInstance?.nome}">
				<li class="fieldcontain">
					<span id="nome-label" class="property-label"><g:message code="disciplina.nome.label" default="Nome" /></span>
					
						<span class="property-value" aria-labelledby="nome-label"><g:fieldValue bean="${disciplinaInstance}" field="nome"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${disciplinaInstance?.cargaHoraria}">
				<li class="fieldcontain">
					<span id="cargaHoraria-label" class="property-label"><g:message code="disciplina.cargaHoraria.label" default="Carga Horaria" /></span>
					
						<span class="property-value" aria-labelledby="cargaHoraria-label"><g:fieldValue bean="${disciplinaInstance}" field="cargaHoraria"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${disciplinaInstance?.credito}">
				<li class="fieldcontain">
					<span id="credito-label" class="property-label"><g:message code="disciplina.credito.label" default="Credito" /></span>
					
						<span class="property-value" aria-labelledby="credito-label"><g:fieldValue bean="${disciplinaInstance}" field="credito"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${disciplinaInstance?.departamento}">
				<li class="fieldcontain">
					<span id="departamento-label" class="property-label"><g:message code="disciplina.departamento.label" default="Departamento" /></span>
					
						<span class="property-value" aria-labelledby="departamento-label"><g:link controller="departamento" action="show" id="${disciplinaInstance?.departamento?.id}">${disciplinaInstance?.departamento?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${disciplinaInstance?.itensGrade}">
				<li class="fieldcontain">
					<span id="itensGrade-label" class="property-label"><g:message code="disciplina.itensGrade.label" default="Itens Grade" /></span>
					
						<g:each in="${disciplinaInstance.itensGrade}" var="i">
						<span class="property-value" aria-labelledby="itensGrade-label"><g:link controller="itemGrade" action="show" id="${i.id}">${i?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${disciplinaInstance?.turmas}">
				<li class="fieldcontain">
					<span id="turmas-label" class="property-label"><g:message code="disciplina.turmas.label" default="Turmas" /></span>
					
						<g:each in="${disciplinaInstance.turmas}" var="t">
						<span class="property-value" aria-labelledby="turmas-label"><g:link controller="turma" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${disciplinaInstance?.id}" />
					<g:link class="edit" action="edit" id="${disciplinaInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
