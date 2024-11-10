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
                
                <h1>Upload de Imagens com Servlet</h1>
              <form action="upload" method="post" enctype="multipart/form-data">

                Imagem: <input type="file" name="file" id="file">
                <img src="" width=100 height=100 border=1px>

                <input class="hide" type="submit" value="Enviar"/>


                <input type=file>
                <input type=button class=hide value="Adicionar outro">

              </form>


                  <span>${mensagem}</span>
             <br/>
             <br/>
             <br/>
             <br/>
             <form action="upload" method="get">
                <input type="submit" value="Visualizar Imagens"/>


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


  <script>
    function verificaMostraBotao(){
        $('input[type=file]').each(function(index){
            if ($('input[type=file]').eq(index).val() != ""){
                $('.hide').show();
            }
        });
    }

    $('input[type=file]').on("change", function(){
      verificaMostraBotao();
    });

   $('.hide').on("click", function(){
       $(document.body).append($('<input />', {type: "file" }).change(verificaMostraBotao));
       $(document.body).append($('<img />'));
       $('.hide').hide();
   });

function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
        $(input).next()
        .attr('src', e.target.result)
    };
    reader.readAsDataURL(input.files[0]);
    }
    else {
        var img = input.value;
        $(input).next().attr('src',img);
    }
}


  </script>



    </script>
</body>

</html>