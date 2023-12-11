var maker = {
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