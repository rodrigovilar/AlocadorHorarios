
<%@ page import="alocadorhorarios.Professor" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'style.css')}" type="text/css">
		<g:set var="entityName" value="${message(code: 'professor.label', default: 'Professor')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-professor" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-professor" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list professor">
			
				<g:if test="${professorInstance?.nome}">
				<li class="fieldcontain">
					<span id="nome-label" class="property-label"><g:message code="professor.nome.label" default="Nome" /></span>
					
						<span class="property-value" aria-labelledby="nome-label"><g:fieldValue bean="${professorInstance}" field="nome"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${professorInstance?.matricula}">
				<li class="fieldcontain">
					<span id="matricula-label" class="property-label"><g:message code="professor.matricula.label" default="Matricula" /></span>
					
						<span class="property-value" aria-labelledby="matricula-label"><g:fieldValue bean="${professorInstance}" field="matricula"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${professorInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="property-label"><g:message code="professor.email.label" default="Email" /></span>
					
						<span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${professorInstance}" field="email"/></span>
					
				</li>
				</g:if>
		
				<g:if test="${professorInstance?.imagem}">					
				<li class="fieldcontain">
					<span id="imagem-label" class="property-label">
					
					<g:message code="professor.imagem.label" default="Imagem" /></span>
					 
					<img alt="" class="imgDoubleBorderLightGray" width="100" height="100"  style="margin-left: 15px" src="/AlocadorHorarios/professor/imagemProfessor/${professorInstance.id}">
					
					 
				</li>			
				</g:if>
				
				<g:if test="${professorInstance?.telefones}">
				<li class="fieldcontain">
					<span id="telefones-label" class="property-label"><g:message code="professor.telefones.label" default="Telefones" /></span>
					
						<g:each in="${professorInstance.telefones}" var="t">
						<span class="property-value" aria-labelledby="telefones-label"><g:link controller="telefone" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${professorInstance?.id}" />
					<g:link class="edit" action="edit" id="${professorInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
