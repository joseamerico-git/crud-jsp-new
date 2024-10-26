function loadSpinner() {
    let cont = 0;
    let newElement = setInterval(() => {
        let element = document.createElement("p");

        ++cont;

        element.innerHTML = "Novo parágrafo";
        content.appendChild(element);

        if (cont >= 5) {
            clearInterval(newElement);
        }
    }, 1000);

    window.onload = () => {
        let spinner = document.querySelector("#spinner");

        spinner.style.display = "none";
    };
}


function htmlSpinner(){
    return `  <div class="spinner-border" role="status">
                        <span class="visually-hidden">Loading...</span>
                    </div>`
}


function valida() {


    let form = document.forms["meu-form"];
    let login = document.forms["meu-form"]["login"].value;
    let password = document.forms["meu-form"]["password"].value;
    let password1 = document.forms["meu-form"]["password1"].value;
    let spinner = document.getElementById("spinner");


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

    else if (password != password1) {
        alert("As senhas informadas não conferem!");
        form.password.select();
        form.password.focus();
        form.password.style.cssText = "border:solid 1px red;";
        form.password1.style.cssText = "border:solid 1px red;";

        return false;
    }




    else if (password === password1) {
        loadSpinner();
        document.getElementById("img-confirm").src = "./imagens/chck.png";
        form.login.style.cssText = "border:solid 1px green;";
        form.password.style.cssText = "border:solid 1px green;";
        form.password1.style.cssText = "border:solid 1px green;";
        spinner.innerHTML +=  htmlSpinner(); 
        form.action = 'controladora?action=AdicionaUsuario';
        document.getElementById("meu-form").submit();

        return true;
    }


}
