

function confirmar(idUser){
    let resposta = confirm("Confirmar a exclusão deste usuário?")
    if(resposta === true){
            window.location.href="controladora?acao=RemoveUsuario&id="+idUser
    }


}
