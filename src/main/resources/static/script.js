let response;
let currentPostIndex;

async function listPost() {
    try {
        response = await $.get('/list');
        let post_preview = $('#post-preview');
        let i = 0;
        post_preview.html("");
        for (; i < response.length; i++) {
            post_preview.prepend(`<a onclick="changePost(\'${i}\')" id="preview_${response[i].id}">${response[i].title}</a><br>`);
        }
        $('.content').html(`
            <div id="post_title" style="font-size: 30px;">${response[i-1].title}</div><hr>
            <p>작성자:${response[i-1].author}</p><p>작성일:${response[i-1].created}</p><hr>
            <div id="post_content">
                ${response[i-1].content}
            </div>
            `);
    } catch (err) {
    }
}

function changePost(i) {
    $('.content').html(`
            <div id="post_title" style="font-size: 30px;">${response[i].title}</div><hr>
            <p>작성자:${response[i].author}</p><p>작성일:${response[i].created}</p><hr>
            <div id="post_content">
                ${response[i].content}
            </div>
    `);
}

function updatePost(){
    $
}

function removePost(id) {

    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/remove"+id,
        success: (data => {
            if(data.data === true) {
                alert("삭제 성공");
            }
        })
    });
}