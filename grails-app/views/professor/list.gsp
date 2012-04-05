
<%@ page import="alocadorhorarios.Professor" %>
<!doctype html>
<html>
	<head>
	<link rel="stylesheet" href="${resource(dir: 'css', file: 'style.css')}" type="text/css">
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'professor.label', default: 'Professor')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-professor" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-professor" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nome" title="${message(code: 'professor.nome.label', default: 'Nome')}" />
					
						<g:sortableColumn property="matricula" title="${message(code: 'professor.matricula.label', default: 'Matricula')}" />
					
						<g:sortableColumn property="email" title="${message(code: 'professor.email.label', default: 'Email')}" />
					
						 
						<th>Imagem</th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${professorInstanceList}" status="i" var="professorInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${professorInstance.id}">${fieldValue(bean: professorInstance, field: "nome")}</g:link></td>
					
						<td>${fieldValue(bean: professorInstance, field: "matricula")}</td>
					
						<td>${fieldValue(bean: professorInstance, field: "email")}</td>
					
						 
						<td>   
							<img alt="" class="imgDoubleBorderLightGray" width="100" height="100"    src="/AlocadorHorarios/professor/imagemProfessor/${professorInstance.id}">
						</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${professorInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
