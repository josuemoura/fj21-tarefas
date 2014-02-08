<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div id="container">
	<c:import url="/WEB-INF/cabecalho.jsp" />
		<form action="efetuaLogin" method="post">
		<h2 id="login">Login Tarefas</h2>
			<label for="name">Usuário:</label>
			<input type="name" name="login">
			<label
				for="username">Senha:
			</label>
			<p>
			<a href="#">Esqueceu sua senha?</a>
			<input type="password" name="senha" />
				<div id="lower">
					<input type="checkbox">
					<label class="check" for="checkbox">Mantenha-me conectado
					</label>
					<input type="submit" value="Login">
				</div>
		</form>
	</div>
</body>
</html>