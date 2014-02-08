<%@page import="br.com.caelum.tarefa.dao.TarefaDAO"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><%@ taglib uri="http://displaytag.sf.net" prefix="display"%><%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="resources/js/jquery-1.9.1.js"></script>
<script type="text/javascript"
	src="resources/js/jquery-ui-1.10.1.custom.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link type="text/css" href="resources/css/tarefas.css" rel="stylesheet" />

<title>Lista de tarefas</title>
</head>
<body>

	<script type="text/javascript">
	function finalizaAgora(id) {
		$.post(
				"finalizaTarefa",
				{'id' : id},
				function() {
			$("#tarefa_" + id).html("Finalizado");
		} );
	}// End finalizaAgora
	//Minha fun��os
	function removeAgora(id) {
		//JQuery metodo->post(URLSpringMVC, {'identificador},Fun��o de manipula��o)
		$.post("removeTarefa",{'id' : id},
		function() {
			$("#tarefa_" + id).closest('tr').hide();
		} );
	}
</script>
	<a href="novaTarefa" class="link">Criar uma nova tarefa</a>
	<br />
	<br />

	<display:table name="tarefas" id="tarefa">
		<display:column property="id" title="ID" />
		<display:column property="descricao" title="Descri��o" />
		<display:column title="Finalizado?">
			<c:if test="${tarefa.finalizado eq true}">
			Finalizado
		</c:if>
			<c:if test="${tarefa.finalizado eq false}">
				<span id="tarefa_${tarefa.id}"> <a href="#"
					onclick="finalizaAgora(${tarefa.id})">Finalizar</a>
				</span>
			</c:if>

		</display:column>
		<display:column property="dataFinalizacao.time"
			title="Data de finaliza��o" format="{0,date,dd/MM/yyyy}" />
		<display:column title="Apagar tarefa">
			<a href="removeTarefa?id=${tarefa.id}">Remove</a>
		</display:column>
		<display:column title="Alterar tarefa">
			<a href="mostraTarefa?id=${tarefa.id}">Altera</a>
		</display:column>
		<display:column title="Desafio remove tarefa">
			<span id="tarefa_${tarefa.id}"> <a href="#"
				onclick="removeAgora(${tarefa.id})">Remove agora!</a>
			</span>
		</display:column>
	</display:table>
	<br />
	<a href="logout" title="Sair do sistema" class="link">Sair do
		sistema</a>
</body>
</html>