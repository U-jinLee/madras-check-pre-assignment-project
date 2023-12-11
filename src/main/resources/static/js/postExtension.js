document.querySelectorAll(".default-file-extension").forEach(element => {
    element.addEventListener("click", () => {

        if (element.checked == false) {
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

            return;
        }

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

document.getElementById("add-button").addEventListener("click", async () => {

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

            if(response.ok === true) {
                response.json().then(data => {
                    document.getElementById("chip-wrap").appendChild(maker.chip(data.name, data.id));
                    count.plus();

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
                                        element.parentElement.remove();
                                        count.minus();
                                    }
                                })

                        });
                    })

                })

            }

            if (response.ok === false) {
                response.json().then(data => {

                    let message = data.message == "Invalid Input Value" ? data.errors[0].reason : data.message;
                    alert(message);

                })
            }

        })

});

var count = {
    plus: () => {
        let countNow = document.getElementById("count-now").innerText;
        document.getElementById("count-now").innerText = Number(countNow) + 1;
    },
    minus : () => {
        let countNow = document.getElementById("count-now").innerText;
        document.getElementById("count-now").innerText = Number(countNow) - 1;
    }
}