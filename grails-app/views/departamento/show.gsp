
<%@ page import="alocadorhorarios.Departamento" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'departamento.label', default: 'Departamento')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-departamento" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-departamento" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list departamento">
			
				<g:if test="${departamentoInstance?.nome}">
				<li class="fieldcontain">
					<span id="nome-label" class="property-label"><g:message code="departamento.nome.label" default="Nome" /></span>
					
						<span class="property-value" aria-labelledby="nome-label"><g:fieldValue bean="${departamentoInstance}" field="nome"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${departamentoInstance?.cor}">
				<li class="fieldcontain">
					<span id="cor-label" class="property-label"><g:message code="departamento.cor.label" default="Cor" /></span>
					
						<span  style="background-color:${fieldValue(bean: departamentoInstance, field: "cor")} " class="property-value" aria-labelledby="cor-label"><g:fieldValue bean="${departamentoInstance}" field="cor"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${departamentoInstance?.chefe}">
				<li class="fieldcontain">
					<span id="chefe-label" class="property-label"><g:message code="departamento.chefe.label" default="Chefe" /></span>
					
						<span class="property-value" aria-labelledby="chefe-label"><g:link controller="professor" action="show" id="${departamentoInstance?.chefe?.id}">${departamentoInstance?.chefe?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${departamentoInstance?.subchefe}">
				<li class="fieldcontain">
					<span id="subchefe-label" class="property-label"><g:message code="departamento.subchefe.label" default="Subchefe" /></span>
					
						<span class="property-value" aria-labelledby="subchefe-label"><g:link controller="professor" action="show" id="${departamentoInstance?.subchefe?.id}">${departamentoInstance?.subchefe?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${departamentoInstance?.disciplinas}">
				<li class="fieldcontain">
					<span id="disciplinas-label" class="property-label"><g:message code="departamento.disciplinas.label" default="Disciplinas" /></span>
					
						<g:each in="${departamentoInstance.disciplinas}" var="d">
						<span class="property-value" aria-labelledby="disciplinas-label"><g:link controller="disciplina" action="show" id="${d.id}">${d?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${departamentoInstance?.professores}">
				<li class="fieldcontain">
					<span id="professores-label" class="property-label"><g:message code="departamento.professores.label" default="Professores" /></span>
					
						<g:each in="${departamentoInstance.professores}" var="p">
						<span class="property-value" aria-labelledby="professores-label"><g:link controller="professor" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${departamentoInstance?.id}" />
					<g:link class="edit" action="edit" id="${departamentoInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
