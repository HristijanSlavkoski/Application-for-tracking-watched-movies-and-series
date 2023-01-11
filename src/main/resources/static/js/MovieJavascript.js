function deleteMovie(id) {
    $.confirmModal('Are you sure you want to delete this movie?', function () {
        $.ajax({
            url: window.location.href.substring(0, window.location.href.lastIndexOf('/')) + "/movies/" + id + "/delete",
            type: 'DELETE',
            success: function () {
                var url = '/table';
                $("#licenseTable").load(url);

                window.location = window.location.href.substring(0, window.location.href.lastIndexOf('/')) + "/movies";
                $.toast({
                    text: "Successfully deleted movie", // Text that is to be shown in the toast
                    heading: 'Success', // Optional heading to be shown on the toast
                    icon: 'success', // Type of toast icon
                    showHideTransition: 'fade', // fade, slide or plain
                    allowToastClose: true, // Boolean value true or false
                    hideAfter: 6000, // false to make it sticky or number representing the miliseconds as time after which toast needs to be hidden
                    stack: 5, // false if there should be only one toast at a time or a number representing the maximum number of toasts to be shown at a time
                    position: 'top-left', // bottom-left or bottom-right or bottom-center or top-left or top-right or top-center or mid-center or an object representing the left, right, top, bottom values

                    textAlign: 'left',  // Text alignment i.e. left, right or center
                    loader: true,  // Whether to show loader or not. True by default
                    loaderBg: '#9EC600',  // Background color of the toast loader
                });
            },
            error: function (data) {
                $.toast({
                    text: data.responseText, // Text that is to be shown in the toast
                    heading: 'Error', // Optional heading to be shown on the toast
                    icon: 'error', // Type of toast icon
                    showHideTransition: 'fade', // fade, slide or plain
                    allowToastClose: true, // Boolean value true or false
                    hideAfter: 6000, // false to make it sticky or number representing the miliseconds as time after which toast needs to be hidden
                    stack: 5, // false if there should be only one toast at a time or a number representing the maximum number of toasts to be shown at a time
                    position: 'top-left', // bottom-left or bottom-right or bottom-center or top-left or top-right or top-center or mid-center or an object representing the left, right, top, bottom values

                    textAlign: 'center',  // Text alignment i.e. left, right or center
                    loader: true,  // Whether to show loader or not. True by default
                    loaderBg: '#9EC600',  // Background color of the toast loader
                });
            }
        });
    });
}

function markMovie(id) {
    var dateInput = $('#dateInput' + id).val();
    if (dateInput == "") {
        alert("Please enter a date when you watched the movie.");
    } else {
        var dateInputParsed = Date.parse(dateInput.replace(/-/g, ' '));
        $.confirmModal('Are you sure you want to mark this movie?', function () {
            $.ajax({
                url: window.location.href.substring(0, window.location.href.lastIndexOf('/')) + "/movies/" + id + "/mark",
                type: 'POST',
                contentType: "application/json",
                dataType: "json",
                data: JSON.stringify({dateWatched: dateInputParsed}),
                success: function () {
                    var url = '/table';
                    $("#licenseTable").load(url);

                    window.location = window.location.href.substring(0, window.location.href.lastIndexOf('/')) + "/movies";
                    $.toast({
                        text: "Successfully marked movie", // Text that is to be shown in the toast
                        heading: 'Success', // Optional heading to be shown on the toast
                        icon: 'success', // Type of toast icon
                        showHideTransition: 'fade', // fade, slide or plain
                        allowToastClose: true, // Boolean value true or false
                        hideAfter: 6000, // false to make it sticky or number representing the miliseconds as time after which toast needs to be hidden
                        stack: 5, // false if there should be only one toast at a time or a number representing the maximum number of toasts to be shown at a time
                        position: 'top-left', // bottom-left or bottom-right or bottom-center or top-left or top-right or top-center or mid-center or an object representing the left, right, top, bottom values

                        textAlign: 'left',  // Text alignment i.e. left, right or center
                        loader: true,  // Whether to show loader or not. True by default
                        loaderBg: '#9EC600',  // Background color of the toast loader
                    });
                },
                error: function (data) {
                    $.toast({
                        text: data.responseText, // Text that is to be shown in the toast
                        heading: 'Error', // Optional heading to be shown on the toast
                        icon: 'error', // Type of toast icon
                        showHideTransition: 'fade', // fade, slide or plain
                        allowToastClose: true, // Boolean value true or false
                        hideAfter: 6000, // false to make it sticky or number representing the miliseconds as time after which toast needs to be hidden
                        stack: 5, // false if there should be only one toast at a time or a number representing the maximum number of toasts to be shown at a time
                        position: 'top-left', // bottom-left or bottom-right or bottom-center or top-left or top-right or top-center or mid-center or an object representing the left, right, top, bottom values

                        textAlign: 'center',  // Text alignment i.e. left, right or center
                        loader: true,  // Whether to show loader or not. True by default
                        loaderBg: '#9EC600',  // Background color of the toast loader
                    });
                }
            });
        });
    }
}

function unMarkMovie(id) {
    $.confirmModal('Are you sure you want to unmark this movie?', function () {
        $.ajax({
            url: window.location.href.substring(0, window.location.href.lastIndexOf('/')) + "/movies/" + id + "/unmark",
            type: 'POST',
            success: function () {
                var url = '/table';
                $("#licenseTable").load(url);

                window.location = window.location.href.substring(0, window.location.href.lastIndexOf('/')) + "/movies";
                $.toast({
                    text: "Successfully marked movie", // Text that is to be shown in the toast
                    heading: 'Success', // Optional heading to be shown on the toast
                    icon: 'success', // Type of toast icon
                    showHideTransition: 'fade', // fade, slide or plain
                    allowToastClose: true, // Boolean value true or false
                    hideAfter: 6000, // false to make it sticky or number representing the miliseconds as time after which toast needs to be hidden
                    stack: 5, // false if there should be only one toast at a time or a number representing the maximum number of toasts to be shown at a time
                    position: 'top-left', // bottom-left or bottom-right or bottom-center or top-left or top-right or top-center or mid-center or an object representing the left, right, top, bottom values

                    textAlign: 'left',  // Text alignment i.e. left, right or center
                    loader: true,  // Whether to show loader or not. True by default
                    loaderBg: '#9EC600',  // Background color of the toast loader
                });
            },
            error: function (data) {
                $.toast({
                    text: data.responseText, // Text that is to be shown in the toast
                    heading: 'Error', // Optional heading to be shown on the toast
                    icon: 'error', // Type of toast icon
                    showHideTransition: 'fade', // fade, slide or plain
                    allowToastClose: true, // Boolean value true or false
                    hideAfter: 6000, // false to make it sticky or number representing the miliseconds as time after which toast needs to be hidden
                    stack: 5, // false if there should be only one toast at a time or a number representing the maximum number of toasts to be shown at a time
                    position: 'top-left', // bottom-left or bottom-right or bottom-center or top-left or top-right or top-center or mid-center or an object representing the left, right, top, bottom values

                    textAlign: 'center',  // Text alignment i.e. left, right or center
                    loader: true,  // Whether to show loader or not. True by default
                    loaderBg: '#9EC600',  // Background color of the toast loader
                });
            }
        });
    });
}

function viewMovie(id) {
    $.ajax({
        url: window.location.href.substring(0, window.location.href.lastIndexOf('/')) + "/movies/" + id + "/info",
        type: 'GET',
        success: function () {
            var url = '/table';
            $("#licenseTable").load(url);

            window.location = window.location.href.substring(0, window.location.href.lastIndexOf('/')) + "/movies";
            $.toast({
                text: "Successfully deleted movie", // Text that is to be shown in the toast
                heading: 'Success', // Optional heading to be shown on the toast
                icon: 'success', // Type of toast icon
                showHideTransition: 'fade', // fade, slide or plain
                allowToastClose: true, // Boolean value true or false
                hideAfter: 6000, // false to make it sticky or number representing the miliseconds as time after which toast needs to be hidden
                stack: 5, // false if there should be only one toast at a time or a number representing the maximum number of toasts to be shown at a time
                position: 'top-left', // bottom-left or bottom-right or bottom-center or top-left or top-right or top-center or mid-center or an object representing the left, right, top, bottom values

                textAlign: 'left',  // Text alignment i.e. left, right or center
                loader: true,  // Whether to show loader or not. True by default
                loaderBg: '#9EC600',  // Background color of the toast loader
            });
        },
        error: function (data) {
            $.toast({
                text: data.responseText, // Text that is to be shown in the toast
                heading: 'Error', // Optional heading to be shown on the toast
                icon: 'error', // Type of toast icon
                showHideTransition: 'fade', // fade, slide or plain
                allowToastClose: true, // Boolean value true or false
                hideAfter: 6000, // false to make it sticky or number representing the miliseconds as time after which toast needs to be hidden
                stack: 5, // false if there should be only one toast at a time or a number representing the maximum number of toasts to be shown at a time
                position: 'top-left', // bottom-left or bottom-right or bottom-center or top-left or top-right or top-center or mid-center or an object representing the left, right, top, bottom values

                textAlign: 'center',  // Text alignment i.e. left, right or center
                loader: true,  // Whether to show loader or not. True by default
                loaderBg: '#9EC600',  // Background color of the toast loader
            });
        }
    });
}

$('document').ready(function () {
    let userId = $("#userId").text();

    $('#add-new-movie-btn').click(function (event) {
        event.preventDefault();
        $('#new-movie-modal').modal('show');
    });

    $('#new-movie-modal').on('hidden.bs.modal', function (e) {
        $('#modalForm').find("input, textarea").val("");
    });

    $('[id^="edit-movie-btn"]').click(function (event) {
        event.preventDefault();
        var movieId = event.target.id.substring(14);
        $('#edit-movie-modal' + movieId).modal('show');
    });

    $('[id^="editModalForm"]').submit(function (event) {
        event.preventDefault();
        var movieId = event.target.id.substring(13);
        var movieTitle = $('#edit-movie-title' + movieId).val();
        var movieGenre = $('#edit-movie-genre' + movieId).val();
        var movieYear = $('#edit-movie-year' + movieId).val();
        var movieDirector = $('#edit-movie-director' + movieId).val();
        var movieDuration = $('#edit-movie-duration' + movieId).val();
        var movieImage = $('#edit-movie-image' + movieId).prop('files')[0];

        if (movieImage === undefined) {
            var jsonData = {
                title: movieTitle,
                genre: movieGenre,
                year: movieYear,
                director: movieDirector,
                durationInMinutes: movieDuration,
            };

            $.ajax({
                url: window.location.href.substring(0, window.location.href.lastIndexOf('/')) + "/movies/" + movieId + "/edit",
                type: 'PUT',
                contentType: "application/json",
                dataType: "json",
                data: JSON.stringify(jsonData),
                success: function () {
                    var url = '/table';
                    $("#movieTable").load(url);

                    window.location = window.location.href.substring(0, window.location.href.lastIndexOf('/')) + "/movies";
                    $.toast({
                        text: "Successfully edited movie", // Text that is to be shown in the toast
                        heading: 'Success', // Optional heading to be shown on the toast
                        icon: 'success', // Type of toast icon
                        showHideTransition: 'fade', // fade, slide or plain
                        allowToastClose: true, // Boolean value true or false
                        hideAfter: 6000, // false to make it sticky or number representing the miliseconds as time after which toast needs to be hidden
                        stack: 5, // false if there should be only one toast at a time or a number representing the maximum number of toasts to be shown at a time
                        position: 'top-left', // bottom-left or bottom-right or bottom-center or top-left or top-right or top-center or mid-center or an object representing the left, right, top, bottom values

                        textAlign: 'left',  // Text alignment i.e. left, right or center
                        loader: true,  // Whether to show loader or not. True by default
                        loaderBg: '#9EC600',  // Background color of the toast loader
                    });
                },
                error: function (data) {
                    $.toast({
                        text: data.responseText, // Text that is to be shown in the toast
                        heading: 'Error', // Optional heading to be shown on the toast
                        icon: 'error', // Type of toast icon
                        showHideTransition: 'fade', // fade, slide or plain
                        allowToastClose: true, // Boolean value true or false
                        hideAfter: 6000, // false to make it sticky or number representing the miliseconds as time after which toast needs to be hidden
                        stack: 5, // false if there should be only one toast at a time or a number representing the maximum number of toasts to be shown at a time
                        position: 'top-left', // bottom-left or bottom-right or bottom-center or top-left or top-right or top-center or mid-center or an object representing the left, right, top, bottom values

                        textAlign: 'center',  // Text alignment i.e. left, right or center
                        loader: true,  // Whether to show loader or not. True by default
                        loaderBg: '#9EC600',  // Background color of the toast loader
                    });
                }
            });
        } else {
            var reader = new FileReader();
            reader.onload = function () {
                var movieImageBase64 = reader.result;
                var base64String = movieImageBase64.substring(movieImageBase64.indexOf(',') + 1);
                var jsonData = {
                    title: movieTitle,
                    genre: movieGenre,
                    year: movieYear,
                    director: movieDirector,
                    durationInMinutes: movieDuration,
                    image: base64String
                };

                $.ajax({
                    url: window.location.href.substring(0, window.location.href.lastIndexOf('/')) + "/movies/" + movieId + "/edit",
                    type: 'PUT',
                    contentType: "application/json",
                    dataType: "json",
                    data: JSON.stringify(jsonData),
                    success: function () {
                        var url = '/table';
                        $("#movieTable").load(url);

                        window.location = window.location.href.substring(0, window.location.href.lastIndexOf('/')) + "/movies";
                        $.toast({
                            text: "Successfully edited movie", // Text that is to be shown in the toast
                            heading: 'Success', // Optional heading to be shown on the toast
                            icon: 'success', // Type of toast icon
                            showHideTransition: 'fade', // fade, slide or plain
                            allowToastClose: true, // Boolean value true or false
                            hideAfter: 6000, // false to make it sticky or number representing the miliseconds as time after which toast needs to be hidden
                            stack: 5, // false if there should be only one toast at a time or a number representing the maximum number of toasts to be shown at a time
                            position: 'top-left', // bottom-left or bottom-right or bottom-center or top-left or top-right or top-center or mid-center or an object representing the left, right, top, bottom values

                            textAlign: 'left',  // Text alignment i.e. left, right or center
                            loader: true,  // Whether to show loader or not. True by default
                            loaderBg: '#9EC600',  // Background color of the toast loader
                        });
                    },
                    error: function (data) {
                        $.toast({
                            text: data.responseText, // Text that is to be shown in the toast
                            heading: 'Error', // Optional heading to be shown on the toast
                            icon: 'error', // Type of toast icon
                            showHideTransition: 'fade', // fade, slide or plain
                            allowToastClose: true, // Boolean value true or false
                            hideAfter: 6000, // false to make it sticky or number representing the miliseconds as time after which toast needs to be hidden
                            stack: 5, // false if there should be only one toast at a time or a number representing the maximum number of toasts to be shown at a time
                            position: 'top-left', // bottom-left or bottom-right or bottom-center or top-left or top-right or top-center or mid-center or an object representing the left, right, top, bottom values

                            textAlign: 'center',  // Text alignment i.e. left, right or center
                            loader: true,  // Whether to show loader or not. True by default
                            loaderBg: '#9EC600',  // Background color of the toast loader
                        });
                    }
                });
            };
            reader.readAsDataURL(movieImage);
        }
    });

    $('#modalForm').submit(function (event) {
        event.preventDefault();
        var movieTitle = $('#movie-title').val();
        var movieGenre = $('#movie-genre').val();
        var movieYear = $('#movie-year').val();
        var movieDirector = $('#movie-director').val();
        var movieDuration = $('#movie-duration').val();

        var movieImage = $('#movie-image').prop('files')[0];
        var reader = new FileReader();
        reader.onload = function () {
            var movieImageBase64 = reader.result;
            var base64String = movieImageBase64.substring(movieImageBase64.indexOf(',') + 1);
            var jsonData = {
                title: movieTitle,
                genre: movieGenre,
                year: movieYear,
                director: movieDirector,
                durationInMinutes: movieDuration,
                image: base64String
            };

            $.ajax({
                url: window.location.href.substring(0, window.location.href.lastIndexOf('/')) + "/movies",
                type: 'POST',
                contentType: "application/json",
                dataType: "json",
                data: JSON.stringify(jsonData),
                success: function () {
                    var url = '/table';
                    $("#movieTable").load(url);

                    window.location = window.location.href.substring(0, window.location.href.lastIndexOf('/')) + "/movies";
                    $.toast({
                        text: "Successfully created new movie", // Text that is to be shown in the toast
                        heading: 'Success', // Optional heading to be shown on the toast
                        icon: 'success', // Type of toast icon
                        showHideTransition: 'fade', // fade, slide or plain
                        allowToastClose: true, // Boolean value true or false
                        hideAfter: 6000, // false to make it sticky or number representing the miliseconds as time after which toast needs to be hidden
                        stack: 5, // false if there should be only one toast at a time or a number representing the maximum number of toasts to be shown at a time
                        position: 'top-left', // bottom-left or bottom-right or bottom-center or top-left or top-right or top-center or mid-center or an object representing the left, right, top, bottom values

                        textAlign: 'left',  // Text alignment i.e. left, right or center
                        loader: true,  // Whether to show loader or not. True by default
                        loaderBg: '#9EC600',  // Background color of the toast loader
                    });
                },
                error: function (data) {
                    $.toast({
                        text: data.responseText, // Text that is to be shown in the toast
                        heading: 'Error', // Optional heading to be shown on the toast
                        icon: 'error', // Type of toast icon
                        showHideTransition: 'fade', // fade, slide or plain
                        allowToastClose: true, // Boolean value true or false
                        hideAfter: 6000, // false to make it sticky or number representing the miliseconds as time after which toast needs to be hidden
                        stack: 5, // false if there should be only one toast at a time or a number representing the maximum number of toasts to be shown at a time
                        position: 'top-left', // bottom-left or bottom-right or bottom-center or top-left or top-right or top-center or mid-center or an object representing the left, right, top, bottom values

                        textAlign: 'center',  // Text alignment i.e. left, right or center
                        loader: true,  // Whether to show loader or not. True by default
                        loaderBg: '#9EC600',  // Background color of the toast loader
                    });
                }
            });
        };
        reader.readAsDataURL(movieImage);
    });

    $('.date-picker').datepicker({
        format: 'yyyy-mm-dd'
    });
});