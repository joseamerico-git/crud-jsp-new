<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="./css/style.css">
    <title>Crud Servlets e JSP</title>
    <link rel="icon" href="imagens/icon.webp">

</head>

<body>

    <div class="container">
${login}
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
            <div class="div_img"><img src="./imagens/icon.webp"></div>

            <div class="op">

                <h1>Editando Clientes em api </h1>

            <c:if test="${token != null}">
                 <script>
                     let login = document.getElementById("login");
                     let token = document.getElementById("token");

                     token.value = "${token}";
                     console.log("token "+ token.value);
                   </script>
            </c:if>


                <form action="controladora" method="PUT" name="meu-form">

                  <input type="text" id="codigo" readonly name="codigo" value="<%out.print(request.getAttribute("codigo"));%>"></input>
                  <div class="form-group">
                        <label for="nome">Nome</label></br>
                        <input name="nome" type="text" class="form-control" id="nome" value="<%out.print(request.getAttribute("nome"));%>"
                            placeholder="Seu Nome"></input>
                        </br>

                     	<input type="text" id="token" name="token" value="<%out.print(request.getAttribute("token"));%>"></input>

                        <input type="hidden" name="acao" value="EditaClienteApi">

                    </div>

                    </br>
                    <div>

                        <br>
                        <br>
                        <button name="btn" type="submit" class="btn btn-primary"
                            >Enviar</button>
                        <img name="img-confirm" id="img-confirm">
                        <div id="spinner"></div>
                         <input type="hidden" id="msg" name="msg" value="<%out.print(request.getAttribute("msg"));%>">
                        <c:if test="${msg != null}">
                                        <span value="${msg}"></span>
                                    </c:if>
                    </div>


                </form>


            </div>


        </div>

    </div>


    </div>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>


    <script src="./scripts/validaUsuario.js">

    </script>
</body>

</html>