function validar(){

    let login = frmUsuario.login.value
    let role = frmUsuario.role.value
    let password = frmUsuario.password.value
     alert("ola")
    if(login === ""){
        alert("Preencha o campo login!")
        frmUsuario.login.focus();
        return false;
    } else if (password === ""){
    alert("Informe sua senha!")
        frmUsuario.password.focus();
        return false;
    } else{
        document.forms["frmContato"].submit();

    }



}
