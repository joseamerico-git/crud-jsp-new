<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Usuário</title>
   

</head>
<body>

    <div class="container menu" >
        <h1>Editar Usuário</h1>


        <form action="" method="POST" >
	
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
          
              <input type="hidden" name="acao" value="EditaUsuario">
              
              <div>
                  <select name="role" value="<%out.print(request.getAttribute("role"));%>">
                      <option value="<%out.print(request.getAttribute("role"));%>">"<%out.print(request.getAttribute("descRole"));%>"</option>
          
                  </select>
          
              </div>
              
              <button type="submit" class="btn btn-primary">Salvar</button>
          </form>
          
          <script src="scripts/validador.js">
          
          </script>
          
          <script>
              var select = document.querySelector('select');
              select.addEventListener('change', function() {
              var option = this.selectedOptions[0];
              var texto = option.textContent;
              console.log(texto);
              console.log(select.value);
          
          });
          
          </script>
          
          <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
                   integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
             <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                     integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
                     crossorigin="anonymous"></script>
          
          

    </div>

</body>
</html>