
<%@ page import="alocadorhorarios.Departamento" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'departamento.label', default: 'Departamento')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-departamento" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-departamento" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nome" title="${message(code: 'departamento.nome.label', default: 'Nome')}" />
					
						<g:sortableColumn property="cor" title="${message(code: 'departamento.cor.label', default: 'Cor')}" />
					
						<th><g:message code="departamento.chefe.label" default="Chefe" /></th>
					
						<th><g:message code="departamento.subchefe.label" default="Subchefe" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${departamentoInstanceList}" status="i" var="departamentoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${departamentoInstance.id}">${fieldValue(bean: departamentoInstance, field: "nome")}</g:link></td>
					
						<td>${fieldValue(bean: departamentoInstance, field: "cor")}</td>
					
						<td>${fieldValue(bean: departamentoInstance, field: "chefe")}</td>
					
						<td>${fieldValue(bean: departamentoInstance, field: "subchefe")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${departamentoInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
