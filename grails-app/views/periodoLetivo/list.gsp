
<%@ page import="alocadorhorarios.PeriodoLetivo" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'periodoLetivo.label', default: 'PeriodoLetivo')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-periodoLetivo" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-periodoLetivo" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="ano" title="${message(code: 'periodoLetivo.ano.label', default: 'Ano')}" />
					
						<g:sortableColumn property="numero" title="${message(code: 'periodoLetivo.numero.label', default: 'Numero')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${periodoLetivoInstanceList}" status="i" var="periodoLetivoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${periodoLetivoInstance.id}">${fieldValue(bean: periodoLetivoInstance, field: "ano")}</g:link></td>
					
						<td>${fieldValue(bean: periodoLetivoInstance, field: "numero")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${periodoLetivoInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
