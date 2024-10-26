function valida() {


    let form = document.forms["meu-form"];
    let login = document.forms["meu-form"]["login"].value;
    let password = document.forms["meu-form"]["password"].value;
    let password1 = document.forms["meu-form"]["password1"].value;



    if (login === "") {
        alert("Preencha o campo email!");
        form.login.style.cssText = "border:solid 1px red;";
        form.login.focus()
        return false;
    }

    if (password === "") {
        alert("Preencha o campo password!");
        //form.password.style.cssText = "border:solid 1px red;";
        form.password.focus()
        return false;
    }
    else if (password1 === "") {
        alert("Preencha o campo confirm!");
        form.password1.style.cssText = "border:solid 1px red;";
        form.password1.focus()
        return false;
    }

    else if(password!=password1){
        alert("As senhas informadas não conferem!");
        form.password1.style.cssText = "border:solid 1px red;";
        return false;
    }


    else if (password === password1) {
        
        document.getElementById("img-confirm").src = "./imagens/chck.png";
        form.login.style.cssText = "border:solid 1px green;";
        form.password.style.cssText = "border:solid 1px green;";
        form.password1.style.cssText = "border:solid 1px green;";
        form.action  = 'controladora?action=AdicionaUsuario';
        document.getElementById("meu-form").submit();
        return true;
    }


}
