// Array for associating keydown-, keypress- and keyup-events
var unresolvedKeypresses = [];

// Current sentence
var sentenceCount = 0;

// Number of sentences per participant
var totalSentences = 15;

var toSubmit = [];

// Counter of keypresses since last push to the server
var keypressCount = 0;

// Flag of the key state. False if key is up, true if down
var keyFlags = [145];

$(document).ready(function() {

    for (var i = 0; i < keyFlags.length; i++) {
        keyFlags[i] = false;
    }

    var $testInput = $('#test-input');
    var $errorRate = $('#error-rate');
    var $nextBtn = $('#next-btn');

    var processing = false;

    function parseError(msg) {
        var error = JSON.parse(msg.responseText).error;
        if (error === "uid_missing_err" || error === "tsid_missing_err") {
            document.location.href = "assets/session_err.html";
            return;
        } else {
            console.log("Unknown error");
        }
    }

    getNewSentence(true);
    $testInput.focus();

    function getNewSentence(first) {

        if (first) {
            typingtestRoutes.controllers.TypingTest.getWPM().ajax({
                success: function (result) {
                    $('#wpm').html(result.wpm);
                }
            });
            typingtestRoutes.controllers.TypingTest.getErrorRate().ajax({
                success: function (result) {
                    $errorRate.html(result.errorRate.toFixed(2) + "%");
                    if (result.errorRate > 5) {
                        $errorRate.css('color', 'red');
                    } else if (result.errorRate <= 5) {
                        $errorRate.css('color', '#4747a3');
                    }
                },
                error: function(error) {
                    parseError(error);
                }
            });

        }

        typingtestRoutes.controllers.TypingTest.sentence(first).ajax({
            success: function (result) {
                $('#test-sentence').val(result.sentence);
                sentenceCount = parseInt(result.count);
                $('#sentence-count').html(sentenceCount.toString() + "/" + totalSentences.toString());
            },
            error: function(error) {
                parseError(error);
            }
        });
    }

    $nextBtn.click(function () {
        setTimeout(testSectionEnd, 100);
        $testInput.focus();
    });

    $testInput.bind('paste', function (e) {
        e.preventDefault();
    });

    function testSectionEnd() {
        if ($testInput.val() == "") {
            return;
        }
        $nextBtn.attr('disabled', true);
        $nextBtn.addClass('disabled');
        $testInput.attr('disabled', true);
        processing = true;
        $('#test-sentence').val('');
        var input = $testInput.val();
        $testInput.val("");
        keypressCount = 0;
        setTimeout(function() {
            saveKeystrokes(function(msg) {
                $.ajax('userInput', {
                    url: 'userInput',
                    type: 'POST',
                    contentType: 'application/json; charset=UTF-8',
                    dataType: 'json',
                    data:
                        JSON.stringify(
                            {
                                userInput: input
                            }),
                    success: function(msg) {
                        if(sentenceCount >= totalSentences) {
                            typingtestRoutes.controllers.TypingTest.updateStats().ajax({
                                success: function (result) {
                                    if (result.questionnaire === "true") {
                                        document.location.href = "results";
                                    } else {
                                        document.location.href = "questionnaire";
                                    }
                                },
                                error: function(error) {
                                    parseError(error);
                                }
                            });
                            return;
                        }
                        typingtestRoutes.controllers.TypingTest.getWPM().ajax({
                            success: function (result) {
                                $('#wpm').html(result.wpm);
                            },
                            error: function(error) {
                                parseError(error);
                            }
                        });
                        typingtestRoutes.controllers.TypingTest.getErrorRate().ajax({
                            success: function (result) {
                                $errorRate.html(result.errorRate.toFixed(2) + "%");
                                if (result.errorRate > 5) {
                                    $errorRate.css('color', 'red');
                                } else if (result.errorRate <= 5) {
                                    $errorRate.css('color', '#4747a3');
                                }
                                getNewSentence(false);
                            },
                            error: function(error) {
                                parseError(error);
                            }
                        });

                    },
                    error: function(error) {
                        parseError(error);
                    },
                    complete: function() {
                        $testInput.attr('disabled', false);
                        $nextBtn.attr('disabled', false);
                        $nextBtn.removeClass('disabled');
                        $testInput.focus();
                        processing = false;
                    }
                });
            })
        }, 50);
    }

    function saveKeystrokes(callback) {
        var ks = toSubmit.slice(0);
        toSubmit = [];
        $.ajax('keystrokes', {
            url: 'keystrokes',
            type: 'POST',
            contentType: 'application/json; charset=UTF-8',
            dataType: 'json',
            data:
                JSON.stringify(
                    {
                        keystrokes: ks
                    }),
            success: callback,
            error: function(error) {
                parseError(error);
            }
        });
    }

    $testInput.keydown(function(event) {
        if (keyFlags[event.keyCode]) {
            if (event.keyCode >= 65 && event.keyCode <= 90) {
                var inputValue = $testInput.val();
                $testInput.val(inputValue.slice(0, inputValue.length - 1));
            }
            return;
        }
        var letter;
        keyFlags[event.keyCode] = true;
        $.each(keycodes, function (key, value) {
            if (event.keyCode == key) {
                letter = value;
            }
        });
        unresolvedKeypresses.push(new UnresolvedKeypress(event, letter, event.keyCode, $.now()));
    });

    $testInput.on('keypress', function(event) {
        var time = Date.now();
        if (event.which === 13 && !processing) {
            testSectionEnd();
        } else {
            for (var i = 0; i < unresolvedKeypresses.length; i++) {
                if (unresolvedKeypresses[i] == undefined) {
                    continue;
                } else if (unresolvedKeypresses[i].downTime >= (time - 20) && unresolvedKeypresses[i].downTime <= time) {
                    unresolvedKeypresses[i].letter = String.fromCharCode(event.keyCode);
                    keypressCount++;
                    break;
                }
            }
        }
    });

    $testInput.keyup(function(event) {
        var time = $.now();
        for (var i = 0; i < unresolvedKeypresses.length; i++) {
            var unresolved = unresolvedKeypresses[i];
            if (unresolved == undefined || unresolved.letter == undefined) {
                continue;
            } else if (unresolved.keydown.keyCode === event.keyCode) {
                toSubmit.push(
                    {
                        pressTime: unresolved.downTime,
                        releaseTime: time,
                        keycode: unresolved.keycode,
                        letter: unresolved.letter
                    });
                delete unresolvedKeypresses[i];
                break;
            }
        }

        keyFlags[event.keyCode] = false;

        if (keypressCount >= 5) {
            keypressCount = 0;
            saveKeystrokes(function () {

            });
        }
    });

});

function UnresolvedKeypress(keydown, letter, keycode, downTime) {
    this.keydown = keydown;
    this.letter = letter;
    this.keycode = keycode;
    this.downTime = downTime;
}
