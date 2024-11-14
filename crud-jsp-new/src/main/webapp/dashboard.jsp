<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="./css/style.css">
    <title>Crud Servlets e JSP dashboard</title>
    <link rel="icon" href="imagens/icon.webp">
    <input type="hidden" id="token" name="token">
    <input type="hidden" id="login" name="login">


</head>
<body>

  <span id="bem-vindo">Bem vindo! <%out.print(request.getAttribute("login"));%>!</span>
<c:if test="${token != null}">
    		<span id="token"><%out.print(request.getAttribute("token"));%>!</span>
                    <script>
                        let login = document.getElementById("login");
                        let token = document.getElementById("token");
                        let op = document.getElementById("op");
                        token.value = "${token}";
                        console.log("token "+ token.value);





                    </script>
    	</c:if>


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

                  <li><a href="login.jsp">Entrar</a></li>


          </ul>
          </nav>


        <div class="div-menu">
            <div class="div_img"><img src="./imagens/icon.webp"></div>

           <div id="op" class="op">
               <h1>Usuários</h1>
               <a class="fcc-btn" href="adiciona-usuarios.jsp">Adicionar um novo usuário</a>
               <a class="fcc-btn" href="listar-usuarios.jsp">Listar usuários cadastrados</a>
               <a class="fcc-btn" href="controladora?acao=RelatorioUsuario">Relatório</a>

                              </div>

        </div>




          <footer>
  Some copyright info or perhaps some author
  info for an &lt;article&gt;?
</footer>

    </div>

</body>
</html>'