$(document).ready(function() {
    $.ajax({
        url: "zcr/gfetch"
    }).then(function(data) {
       $('.greeting-id').append(data.id);
       $('.greeting-content').append(data.content);
    });
});