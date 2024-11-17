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
     let codigo = document.forms["meu-form"]["codigo"].value;
    let nome = document.forms["meu-form"]["nome"].value;

    let spinner = document.getElementById("spinner");
    let btnSalvar =  document.forms["meu-form"]["btn-salvar"]
    let btn =  document.forms["meu-form"]["btn"]


    if (nome === "") {
        alert("Preencha o campo nome!");
        form.nome.style.cssText = "border:solid 1px red;";
        form.nome.focus()
        return false;
    }

        
        form.submit();
       
        return true;
    }


}

function submeterForm(){
     
}
