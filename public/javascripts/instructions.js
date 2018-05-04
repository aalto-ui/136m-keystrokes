
$(document).ready(function() {
    typingtestRoutes.controllers.TypingTest.newUid().ajax({
        error: function(error) {
            document.location.href = "uid_err";
        },
        success: function (success) {
            $.ajax('browserData', {
                url: 'browserData',
                type: 'POST',
                contentType: 'application/json; charset=UTF-8',
                dataType: 'json',
                data:
                    JSON.stringify(
                        {
                            os: $.ua.os.name,
                            osVersion: $.ua.os.version,
                            browser: $.ua.browser.name,
                            browserVersion: $.ua.browser.version
                        }),
                success: function(msg) {
                    console.log(document.cookie);
                    return;
                },
                error: function(msg) {
                    document.location.href = "uid_err";
                }
            });
        }
    });

    $('#start-btn').click(function () {
        document.location.href = "typingtest";
    });
});