document.querySelectorAll(".default-file-extension").forEach(element => {
    element.addEventListener("click", () => {

        const request = {
            name: element.value
        }

        fetch("/api/file-extensions", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(request)
        })
            .then(response => {

                if(response.ok == true) {
                    location.href = "";
                }
                if(response.ok == false) {
                    response.json().then(data => {

                        let message = data.message == "Invalid Input Value" ? data.errors[0].reason : data.message;
                        alert(message);

                    })
                }


            })

    })

})

document.getElementById("add-button").addEventListener("click", () => {

    const request = {
        name: document.getElementById("extension-name").value
    }

    fetch("/api/file-extensions", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(request)
    })
        .then(response => {
            document.getElementById("extension-name").value = "";

            if(response.ok == true) {
                location.href = "";
            }
            if(response.ok == false) {
                response.json().then(data => {

                    let message = data.message == "Invalid Input Value" ? data.errors[0].reason : data.message;
                    alert(message);

                })
            }

        })

});