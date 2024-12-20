<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                  <h1>Lista de Usuários</h1>
  
  
                  <form action="controladora" method="GET">
                    <input type="text" name="login">
                    <input type="hidden" name ="acao" value="FiltrarUsuario">
                    <input type="submit" value="Pesquisar" >
                 </form>
     
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Login</th>
                         <th scope="col">Role</th>
                         <th scope="col">Ação</th>
                    </tr>
     
                </thead>
                
                <tbody>
     
                    <c:forEach var="u" items="${usuarios}">
                            <tr>
             
                            <td>${u.getLogin()}</td>
                            <td>${u.getRole()}</td>
                            <td>
                            <a href="controladora?acao=RemoveUsuario&id=${u.getId()}">Remover</a>
                            <a href="controladora?acao=EditaUsuario&id=${u.getId()}&login=${u.getLogin()}&role=${u.getRole()}">Editar</a>
                            </td>
             
                        </tr>
             
                  </c:forEach>
     
     
                </tbody>
            </table>
     
                  
                    
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