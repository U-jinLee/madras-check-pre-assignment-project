document.getElementById("add-file").addEventListener("click", () => {
    let file = document.getElementById("file").files[0];
    let formData = new FormData();
    formData.append("file", file);

    fetch("/api/files", {
        method: "POST",
        body: formData
    }).then(response => {
        if (response.status == '201') {
            alert("파일 등록이 완료됐습니다 🎉");
            location.href = '';
        }

        if(response.ok == false) {
            response.json().then(data => {
                alert(data.message);
            })
        }

    })
});