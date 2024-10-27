<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Resultado</title>
</head>
<body>
<h1>Mensagem Recebida:</h1>
<p class="msg"><%= request.getAttribute("mensagem") %></p>
<p class="msg">Alterado com sucesso!</p>
</body>
</html>