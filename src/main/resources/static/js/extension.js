//기본 확장자 로직 변경
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
                        element.dataset.id = "0";
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
                    response.json().then(data => {
                        element.dataset.id = data.id;
                    })
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

//파일 확장자 넣기
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

            if(response.ok === true) {
                response.json().then(data => {
                    document.getElementById("chip-wrap").appendChild(nodeMaker.chip(data.name, data.id));
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

//파일 확장자 삭제
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

var nodeMaker = {
    chip: (name, id) => {
        let parser = new DOMParser();
        let result = "<div class=\"chip\">";
        result += "<div class=\"file-extension-name\">"+ name +"</div>";
        result += "<span class=\"material-symbols-outlined\" data-id=\""+ id +"\">";
        result += "close";
        result += "</span>";
        result += "</div>";

        return parser.parseFromString(result, 'text/html').body.firstChild;
    }
}