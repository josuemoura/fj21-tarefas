<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

<link rel="stylesheet" type="text/css" href="<c:url value="resource/css/reset.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value="resource/css/animate.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value="resource/css/styles.css" />">

</head>

<!-- Main HTML -->

<body>
	<div id="container">
		<form>
			<label for="name">Username:</label>
			<input type="name">
			<label
				for="username">Password:
			</label>
			<p>
			<a href="#">Esqueceu sua senha?</a>
			<input type="password" />
				<div id="lower">
					<input type="checkbox">
					<label class="check" for="checkbox">Keep me logged in
					</label>
					<input type="submit" value="Login">
				</div>
		</form>
	</div>

</body>
</html>