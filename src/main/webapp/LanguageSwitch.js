function languageSwitch() {
    let language = document.getElementById("language_switch").valueOf();
    changeLanguage(language);
}

function changeLanguage(language) {
    let docElements = document.querySelector('[lang]');
    for(let i = 0; i < docElements.length; i++) {
        if(docElements[i].getAttribute("lang") === language) {
            docElements[i].style.display = "block";
        } else {
            docElements[i].style.display = "none";
        }
    }
}

document.addEventListener("DOMContentLoaded", ()=>{ changeLanguage("ru");});