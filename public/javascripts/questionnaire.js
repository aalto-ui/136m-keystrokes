
$(document).ready(function () {

    // TODO: Check that all fields have been changed before enabling results-btn
    // TODO: Use Play's form handling instead of this custom shit

    changeKbd();

    $('#results-btn').attr('disabled', true);

    $('#states').hide();

    $.each(countries, function (key, value) {
        $('#countries').append('<option value="' + key + '">' + value + '</option>');
    });

    $.each(states, function (key, value) {
        $('#states').append('<option value="' + key + '">' + value + '</option>');
    });

    $.each(isoLangs, function (key, value) {
        $('#native-language').append('<option value="' + key + '">' + value.name + '</option>');
    })

    $('#countries').change(function () {
        if ($('#countries').val() == "US") {
            $('#states').show();
        } else {
            $('#states').hide();
        }
    });

    $('#keyboard-type').change(function () {
        changeKbd();
    });

    $('#age').on('input', function () {
        checkChanges();
    });

    $('#time-spent-typing').on('input', function () {
        checkChanges();
    });

    $('#native-language').val('en');

    $('#countries').val('US');

    if ($('#countries').val() == "US") {
        $('#states').show();
    }

    function checkChanges() {
        if ($('#age').val() && $('#age').val() != "" && $('#time-spent-typing').val() && $('#time-spent-typing').val() != "") {
            $('#results-btn').attr('disabled', false);
            $('#results-btn').removeClass('disabled');
        } else {
            $('#results-btn').attr('disabled', true);
            $('#results-btn').addClass('disabled');
        }
    }

    function changeKbd() {
        $('#kbd-type-img').attr('src', 'assets/images/keyboards/' + $('#keyboard-type').val() + '.png');
    }

    $("#questionnaire-form").submit(function (event) {
        event.preventDefault();

        var country = 'none';
        var state = 'none';
        if ($('#countries').val() != undefined) {
            country = $('#countries').val();
        }
        if ($('#states').val() != undefined && country == 'US') {
            state = $('#states').val();
        }
        $.ajax('questionnaire', {
            url: 'questionnaire',
            type: 'POST',
            contentType: 'application/json; charset=UTF-8',
            dataType: 'json',
            data:
                JSON.stringify(
                    {
                        age: parseInt($('#age').val()),
                        gender: $('input:radio[name="gender"]:checked').val(),
                        hasTakenTypingCourse: $('input:radio[name="typing-course"]:checked').val(),
                        fingers: $('#fingers').val(),
                        timeSpentTyping: $('#time-spent-typing').val(),
                        layout: $('#layout').val(),
                        keyboardType: $('#keyboard-type').val(),
                        nativeLanguage: $('#native-language').val(),
                        country: country,
                        state: state
                    }),
            success: function(msg) {
                document.location.href = "results";
                return;
            },
            error: function(msg) {
                var error = JSON.parse(msg.responseText).error;
                if (error === "validation_err") {
                    $('html,body').scrollTop(0);
                    $("#alert-row").html('<div class="alert alert-danger">' +
                                            'Please verify that you answered all the questions correctly.' +
                                        '</div>')
                } else if (error === "uid_missing_err" || error === "tsid_missing_err") {
                    document.location.href = "assets/session_err.html";
                    return;
                } else {
                    console.log("Unknown error");
                }
            }
        });
    });
});