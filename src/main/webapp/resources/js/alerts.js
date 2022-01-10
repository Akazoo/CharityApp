const deleteDonationButtons = document.querySelectorAll(".deleteDonationButton");
const confirmDonationButtons = document.querySelectorAll(".confirmDonationButton");
const demoteButton = document.querySelectorAll(".demoteButton");
const deleteFoundationButtons = document.querySelectorAll(".deleteFoundationButton");
const deleteCategoryButtons = document.querySelectorAll(".deleteCategoryButton");
const deleteUserButtons = document.querySelectorAll(".deleteUserButton");
const blockUserButtons = document.querySelectorAll(".blockUserButton");
const elevateUserButtons = document.querySelectorAll(".elevateUserButton");
const plButton = document.querySelector("#PL");
const engButton = document.querySelector("#ENG");

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
plButton.addEventListener("click", evt => {
    if (confirm("Przy zmianie języka zostaniesz przeniesiony na główną stronę. Wszelkie wprowadzone dane zostaną utracone.\nWhen you change the language, you will be taken to the main page. Any data you have entered will be lost.")) {
        location.href = '/?lang=pl';
    }
})
engButton.addEventListener("click", evt => {
    if (confirm("Przy zmianie języka zostaniesz przeniesiony na główną stronę. Wszelkie wprowadzone dane zostaną utracone.\nWhen you change the language, you will be taken to the main page. Any data you have entered will be lost.")) {
        location.href = '/?lang=eng';
    }
})
deleteUserButtons.forEach((button) => {
    button.addEventListener("click", evt => {
        if (confirm("Czy na pewno chcesz usunąć tego użytkownika ?")) {
            location.href = '/admin/users/delete/' + button.id;
        }
    })
})
blockUserButtons.forEach((button) => {
    button.addEventListener("click", evt => {
        if (confirm("Czy na pewno chcesz zablokować/odblokować tego użytkownika ?")) {
            location.href = '/admin/users/block/' + button.id;
        }
    })
})
elevateUserButtons.forEach((button) => {
    button.addEventListener("click", evt => {
        if (confirm("Czy na pewno chcesz nadać uprawnienia administratora temu użytkownikowi ?")) {
            location.href = '/admin/users/elevate/' + button.id;
        }
    })
})