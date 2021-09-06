const deleteDonationButtons = document.querySelectorAll(".deleteDonationButton");
const confirmDonationButtons = document.querySelectorAll(".confirmDonationButton");
const demoteButton = document.querySelectorAll(".demoteButton");
const deleteFoundationButtons = document.querySelectorAll(".deleteFoundationButton");
const deleteCategoryButtons = document.querySelectorAll(".deleteCategoryButton");

deleteDonationButtons.forEach((button) => {
    button.addEventListener("click", evt => {
        if (confirm("Czy na pewno chcesz usunąć tę darowiznę ?")) {
            location.href = '/donation/delete/' + button.id;
        }
    })
})

confirmDonationButtons.forEach((button) => {
    button.addEventListener("click", evt => {
        if (confirm("Czy potwierdzasz że donacja została odebrana ?")) {
            location.href = '/donation/confirm/' + button.id;
        }
    })
})

demoteButton.forEach((button) => {
    button.addEventListener("click", evt => {
        if (confirm("Czy na pewno chcesz zdegradować tego administratora ?")) {
            location.href = '/admin/admins/demote/' + button.id;
        }
    })
})
deleteFoundationButtons.forEach((button) => {
    button.addEventListener("click", evt => {
        if (confirm("Czy na pewno chcesz usunąć tą fundację ?")) {
            location.href = '/admin/foundations/delete/' + button.id;
        }
    })
})
deleteCategoryButtons.forEach((button) => {
    button.addEventListener("click", evt => {
        if (confirm("Czy na pewno chcesz usunąć tą kategorię ?")) {
            location.href = '/admin/categories/delete/' + button.id;
        }
    })
})