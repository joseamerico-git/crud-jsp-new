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

                <h1>Cadastro de Usuários na "API HIDROBIKE "</h1>
                <h2>"http://xxx.xxx.xxx.xx/auth/register"</h2>


                <form action="controladora" method="POST" name="meu-form">
                    <div class="form-group">
                        <label for="login">Email</label></br>
                        <input name="login" type="email" class="form-control" id="login" aria-describedby="emailHelp"
                            placeholder="Seu email">
                        <br>
                        <small id="emailHelp" class="form-text text-muted">Nunca vamos compartilhar seu email, com
                            ninguém.</small>
                    </div>

                    <div class="form-group">
                        <label for="password">Senha</label>
                        <input name="password" type="password" class="form-control" id="password" placeholder="Senha">
                    </div>
                    <div class="form-group">
                        <label for="password1">Senha</label>
                        <input name="password1" type="password" class="form-control" id="password1" placeholder="Senha">
                    </div>


                    <input type="hidden" name="acao" value="auth/register">
                    <br>
                    <div>
                        <select name="role" class="form-control">
                            <option value="1">ADMIN</option>
                            <option value="2">USER</option>
                        </select>
                        <br>
                        <br>
                        <button name="btn_register" id="btn_register" type="submit" class="btn btn-primary"
                            onclick="return valida()">Enviar</button>
                        <img name="img-confirm" id="img-confirm">
                        <div id="spinner"></div>
                        ${msg}
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