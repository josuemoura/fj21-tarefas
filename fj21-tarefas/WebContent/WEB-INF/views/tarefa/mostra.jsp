<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="/WEB-INF/cabecalho.jsp"></c:import>
	<h3>Alterar tarefa - ${tarefa.id}</h3>

	<form action="alteraTarefa" method="post">

		<div>
		</div>
		<input type="hidden" name="id" value="${tarefa.id}" /> Descrição:<br />
		<textarea name="descricao" rows="5" cols="100">
			${tarefa.descricao}
		</textarea>
		<br /> Finalizado?<input type="checkbox" name="finalizado"
			value="true" ${tarefa.finalizado? 'checked' : ''} /> <br /> Data de
		finalização:
		
		<caelum:campoData id='dataFinalizacao' />

		<br /> 
		<div id="botaoAlterar">
			<input type="submit" value="Aleterar" />
		</div>
	</form>
</body>
</html>