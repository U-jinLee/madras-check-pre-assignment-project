document.querySelectorAll('input.default-file-extension:checked').forEach(element => {
    element.addEventListener("click", () => {
        console.log(element);
    })
})

document.querySelectorAll(".material-symbols-outlined").forEach(element => {
    element.addEventListener("click", () => {

        fetch("/api/file-extensions/" + element.dataset.id, {
            method: "DELETE",
            headers: {
                "Content-Type": "application/json"
            }
        })
            .then(response => {
                if(response.ok == true) {
                    location.href = "";
                }
            })

    });
})