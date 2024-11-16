<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

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
                
                <h1>Editar Usuário</h1>


                <form action="controladora" method="POST " name="meu-form">
	
                    <div class="form-group">
                          <label for="exampleInputEmail1">Id</label>
                          <input name="id" type="text" class="form-control" id="id" value="<%out.print(request.getAttribute("id"));%>" readonly>
                  
                      </div>
                  
                      <div class="form-group">
                          <label for="exampleInputEmail1">Endereço de email</label>
                          <input name="login" type="email" class="form-control" id="login" aria-describedby="emailHelp"
                                value="<%out.print(request.getAttribute("login"));%>">
                          <small id="emailHelp" class="form-text text-muted">Nunca vamos compartilhar seu email, com ninguém.</small>
                      </div>
                  
                      <div class="form-group">
                          <label for="exampleInputPassword1">Senha</label>
                          <input name="password" type="password" class="form-control" id="exampleInputPassword1" value="<%out.print(request.getAttribute("password"));%>">
                      </div>

                      <div class="form-group">
                        <label for="password1">Senha</label>
                        <input name="password1" type="password" class="form-control" id="password1" placeholder="Senha">
                    </div>
                  
                      <input type="hidden" class="form-control" name="acao" value="SalvaUsuario">
                         <input type="hidden" name="login" value = "<%out.print(request.getAttribute("login"));%>">
                            <input type="hidden" name="msg" value = "<%out.print(request.getAttribute("msg"));%>">


                      <div class="form-group">
        
                                                 <select class = "form-control" name="role" onChange="seleciona()">
                                                  <c:forEach var="u" items="${enums}">
                                                      <option name="" id="${u.getId(u)}" value="${u.getDescricao()}">${u.getDescricao()}</option>
                                                      </c:forEach>
                                                 </select>
        
        
                      </div>
                      
                      <br>
                        <br>
                        <button name="btn-salvar" type="submit" class="btn btn-primary"
                            onclick="return valida()">Salvar</button>
                        <img name="img-confirm" id="img-confirm">
                        <div id="spinner"></div>
                    </div>

                  ${msg}
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