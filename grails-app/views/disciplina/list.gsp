
<%@ page import="alocadorhorarios.Disciplina" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'disciplina.label', default: 'Disciplina')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-disciplina" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-disciplina" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nome" title="${message(code: 'disciplina.nome.label', default: 'Nome')}" />
					
						<g:sortableColumn property="cargaHoraria" title="${message(code: 'disciplina.cargaHoraria.label', default: 'Carga Horaria')}" />
					
						<g:sortableColumn property="credito" title="${message(code: 'disciplina.credito.label', default: 'Credito')}" />
					
						<th><g:message code="disciplina.departamento.label" default="Departamento" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${disciplinaInstanceList}" status="i" var="disciplinaInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${disciplinaInstance.id}">${fieldValue(bean: disciplinaInstance, field: "nome")}</g:link></td>
					
						<td>${fieldValue(bean: disciplinaInstance, field: "cargaHoraria")}</td>
					
						<td>${fieldValue(bean: disciplinaInstance, field: "credito")}</td>
					
						<td>${fieldValue(bean: disciplinaInstance, field: "departamento")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${disciplinaInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
