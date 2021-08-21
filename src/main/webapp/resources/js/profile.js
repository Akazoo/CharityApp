const editStartButton = document.querySelector("#editStart");
const editEndButton = document.querySelector("#editEnd");
const firstName = document.querySelector("#firstName");
const lastName = document.querySelector("#lastName");

editStartButton.addEventListener("click", evt => {
editStartButton.classList.add("hidden");
editEndButton.classList.remove("hidden")
    firstName.toggleAttribute("disabled")
    lastName.toggleAttribute("disabled")
});