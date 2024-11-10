function valida() {


    let form = document.forms["from-login"];
     let id = document.forms["from-login"]["id"].value;
    let login = document.forms["from-login"]["login"].value;
    let password = document.forms["from-login"]["password"].value;
    let acao = document.forms["from-login"]["acao"].value;
    let mensagem = .forms["from-login"]["mensagem"];
    let btnLogin =  document.forms["meu-form"]["btnLogin"]
    let btnLoginApi =  document.forms["meu-form"]["btnLoginApi"]


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


        btnLoginApi.addEventListener("click", (e) => {
             form.action = `controladora?acao=auth/login&login=${login}&password=${password}`;



        })


        form.submit();

        return true;
    }


}
