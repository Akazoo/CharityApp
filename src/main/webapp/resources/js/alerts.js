const deleteButtons = [...document.querySelectorAll(".deleteButton")];
const confirmButtons = document.querySelectorAll(".confirmButton");

deleteButtons.forEach((button) => {
    button.addEventListener("click", evt => {
        if (confirm("Czy na pewno chcesz usunąć tę donację ?")) {
            location.href='/donation/delete/' + button.id;
        }
    })
})

confirmButtons.forEach((button) => {
    button.addEventListener("click", evt => {
        if (confirm("Czy potwierdzasz że donacja została odebrana ?")) {
            location.href = '/donation/confirm/' + button.id;
        }
    })
})