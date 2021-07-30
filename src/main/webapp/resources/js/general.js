const contactForm = document.querySelector("#contactForm");
const formMail = contactForm.querySelector("#formMail");

contactForm.addEventListener("submit", evt => {
    const errors = []

    if(!/[_a-zA-Z0-9-]+(\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.([a-zA-Z]{2,}){1}$/.test(formMail.value)){
        errors.push("Wpisz proszę poprawny adres emial i spróbuj ponownie.")
    }

    if(errors.length) {
        evt.preventDefault();
        alert(errors.join("\n"));
    }
})