const editStartButton = document.querySelector("#editStart");
const changePasswordButton = document.querySelector("#changePassword");
const editEndButton = document.querySelector("#editEnd");
const changePasswordForm = document.querySelector("#passwordForm");
const firstName = document.querySelector("#firstName");
const lastName = document.querySelector("#lastName");

editStartButton.addEventListener("click", evt => {
editStartButton.classList.add("hidden");
editEndButton.classList.remove("hidden")
    firstName.toggleAttribute("disabled")
    lastName.toggleAttribute("disabled")
});

changePasswordButton.addEventListener("click",evt => {
    changePasswordForm.classList.remove("hidden");
    changePasswordButton.classList.remove("btn--without-border")
});