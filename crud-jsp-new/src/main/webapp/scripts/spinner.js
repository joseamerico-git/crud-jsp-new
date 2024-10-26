export function loadSpinner() {
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