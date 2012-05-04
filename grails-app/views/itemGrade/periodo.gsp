<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.awt.event.ItemEvent"%>
<html>
<head>

<title>Alocador Disciplinas</title>
 
<script type="text/javascript"
	src="${resource(dir: 'js', file: 'jquery-1.7.2.min.js')}"></script>
<script type="text/javascript"
	src="${resource(dir: 'js', file: 'jquery.easyui.min.js')}"></script>
 
<style type="text/css">


.left {
	width: 120px;
	float: left;
	border: 5px solid #000;
	-moz-border-radius: 10px; /* Para Firefox */
	-webkit-border-radius: 10px; /*Para Safari e Chrome */
	border-radius: 10px; /* Para Opera 10.5+*/
}

.left table {
	background: #E0ECFF;
	-moz-border-radius: 10px; /* Para Firefox */
	-webkit-border-radius: 10px; /*Para Safari e Chrome */
	border-radius: 10px; /* Para Opera 10.5+*/
}

.left td {
	background: #eee;
}

.right {
	float: right;
	width: 600px;
}

.right table {
	background: #E0ECFF;
	width: 100%;
}

.right td {
	background: #fafafa;
	text-align: center;
	padding: 2px;
}

.right td {
	background: #E0ECFF;
}

.right td.drop {
	background: #fafafa;
	width: 100px;
}

.right td.over {
	background: #FBEC88;
}

#select {
	width: 120px;
}

.item {
	text-align: center;
	border: 1px solid #499B33;
	background: #fafafa;
	width: 110px;
}

.assigned {
	border: 1px solid #BC2A4D;
}
</style>
<script>
	$(function() {
		$('.left .item').draggable({
			revert : true,
			proxy : 'clone'
		});
		$('.right td.drop').droppable({
			onDragEnter : function() {
				$(this).addClass('over');
			},
			onDragLeave : function() {
				$(this).removeClass('over');
			},
			onDrop : function(e, source) {
				$(this).removeClass('over');
				if ($(source).hasClass('assigned')) {
					$(this).append(source);
				} else {
					var c = $(source).clone().addClass('assigned');
					$(this).empty().append(c);
					c.draggable({
						revert : true
					});
				}
			}
		});
	});
</script>
</head>
<body>
	<div style="width: 750px; border: 1px;">
		<div class="left">
			<g:select id="select" optionKey="id" optionValue="nome"
				name="departamento.nome" from="${departamentos}" />
			<table>
				<g:each in="${disciplinas}">
					<tr>
						<td><div class="item">
								${it.nome }
							</div></td>
					</tr>
				</g:each>
			</table>
		</div>
		<div class="right">
				<table>
			<tr>
				<td class="blank"></td>
				<td class="title">1º Período</td>
				<td class="title">2º Período</td>
				<td class="title">3º Período</td>
				<td class="title">4º Período</td>
				<td class="title">5º Período</td>
				<td class="title">6º Período</td>
				<td class="title">7º Período</td>
				<td class="title">8º Período</td>
				 
				
				 
			</tr>
			<tr>
				<td class="time">Sistemas</td>
				<td class="drop"></td>
				<td class="drop"></td>
				<td class="drop"></td>
				<td class="drop"></td>
				<td class="drop"></td>
				<td class="drop"></td>
				<td class="drop"></td>
				<td class="drop"></td>
				 
				
			</tr>
		
		</table>
		</div>
	</div>
</body>
</html>