<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="./css/style.css">
    <title>Crud Servlets e JSP</title>
    <link rel="icon" href="imagens/icon.webp">


</head>

<body>
 <h1>Login em Api com UrlConnection java</h1>
<div class="container">

    <nav>
        <ul class="menu">
            <li><a href="index.html">Home</a></li>
            <li><a href="sobre.html">Sobre</a></li>
            <li><a href="#">O que fazemos?</a>
                <ul>
                    <li><a href="#">Web Design</a></li>
                    <li><a href="#">SEO</a></li>
                    <li><a href="#">Design</a></li>
                </ul>
            </li>

            <li><a href="#">Contato</a></li>
        </ul>
    </nav>


    <div class="div-menu">

        <div class="op">

           <span>${token}</span>
            <div class="div-login">


                <form id="form-login" method="POST" action="controladora?action=auth/login">

                    <div class="div_img"><img src="./imagens/user.png"></div>
                    <h1>Login de Usuário</h1>
                        <h1>Login em Api com UrlConnection java</h1>
                    <fieldset></fieldset>

                    <hr>
                    <label>Login:</label>
                    <input name="login" id="login" type="text" class="form-control">

                    <label for="password">Password:</label>
                    <input name="password" id="password" type="password" class="form-control">
                    <input type="hidden" name="acao" value="auth/login">



                    <button id="btnLoginApi" name="btnLoginApi" type="submit" class="btn btn-primary"
                            onclick="return valida()">Login normal</button>



                </form>
<c:if test="${mensagem != null}">
		<span id="mensagem"><%out.print(request.getAttribute("mensagem"));%>!</span>
                <script>
                    let login = document.getElementById("login");
                    login.focus();

                </script>
	</c:if>


	<c:if test="${token != null}">
    		<span id="token"><%out.print(request.getAttribute("token"));%>!</span>
                    <script>
                        let login = document.getElementById("login");
                        login.focus();

                    </script>
    	</c:if>


            </div>


        </div>


        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
              crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
                crossorigin="anonymous"></script>

        <script src="./scripts/login.js">

        </script>

</body>

</html>