index.jsp<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	
<body>
	
	<h2>Index</h2>

	<a href="http://localhost:8080/crud-jsp/adiciona-usuarios.html">link text</a>
 	<jsp:forward page="/controladora?acao=ListaUsuarios" />

</body>

</html>
