
$(document).ready(function () {

    window.fbAsyncInit = function() {
        console.log("moi");
        FB.init({
            appId      : '598038023696960',
            xfbml      : true,
            version    : 'v2.7'
        });
    };

    $('#retake-btn').click(function () {
        document.location.href = "typingtest";
    });

    $('#restart-btn').click(function () {
        document.location.href = "/";
    });

    $('#twitter-btn').click(function() {
        var wpm = $('#wpm').text().trim();
        var msg = "My%20typing%20speed%20is%20" + wpm + "%20words%20per%20minute%21%20What%27s%20yours%3F";
        var url = "http%3A%2F%2Fwww.typingtest.com%2Fscientific-test.html";
        var hashtags = "typingtest";
        window.open("https://twitter.com/intent/tweet?text=" + msg + "&url=" + url + "&hashtags=" + hashtags)
    });

    $('#fb-btn').click(function () {
        var app_id = 1625191694476822;
        var href = "http%3A%2F%2Fwww.typingtest.com%2Fscientific-test.html";
        // var redirect_uri = 'http%3A%2F%2Flocal.host%3A9000%2Fassets%2Fclose_fb_dialog.html';
        var wpm = $('#wpm').text().trim();
        var msg = "My%20typing%20speed%20is%20" + wpm + "%20words%20per%20minute%21%20What%27s%20yours%3F";
        // window.open("https://www.facebook.com/dialog/share?app_id=" + app_id + "&display=page&href=" + href + "&redirect_uri=" + redirect_uri + "&quote=" + msg);
        window.open("https://www.facebook.com/dialog/share?app_id=" + app_id + "&display=page&href=" + href + "&quote=" + msg);
    });
});
