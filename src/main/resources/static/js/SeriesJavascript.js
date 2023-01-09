function deleteSeries(id) {
    $.confirmModal('Are you sure you want to delete this movie?', function () {
        $.ajax({
            url: window.location.href.substring(0, window.location.href.lastIndexOf('/')) + "/series/" + id + "/delete",
            type: 'DELETE',
            success: function () {
                var url = '/table';
                $("#licenseTable").load(url);

                window.location = window.location.href.substring(0, window.location.href.lastIndexOf('/')) + "/series";
                $.toast({
                    text: "Successfully deleted series", // Text that is to be shown in the toast
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

function markSeries(id) {
    $.confirmModal('Are you sure you want to mark this series?', function () {
        $.ajax({
            url: window.location.href.substring(0, window.location.href.lastIndexOf('/')) + "/series/" + id + "/mark",
            type: 'POST',
            success: function () {
                var url = '/table';
                $("#licenseTable").load(url);

                window.location = window.location.href.substring(0, window.location.href.lastIndexOf('/')) + "/series";
                $.toast({
                    text: "Successfully marked series", // Text that is to be shown in the toast
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

function viewSeries(id) {
    $.ajax({
        url: window.location.href.substring(0, window.location.href.lastIndexOf('/')) + "/series/" + id + "/info",
        type: 'GET',
        success: function () {
            var url = '/table';
            $("#licenseTable").load(url);

            window.location = window.location.href.substring(0, window.location.href.lastIndexOf('/')) + "/series";
            $.toast({
                text: "Successfully deleted series", // Text that is to be shown in the toast
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

    $('#add-new-series-btn').click(function (event) {
        event.preventDefault();
        $('#new-series-modal').modal('show');
    });

    $('#new-series-modal').on('hidden.bs.modal', function (e) {
        $('#modalForm').find("input, textarea").val("");
    });

    $('[id^="edit-series-btn"]').click(function (event) {
        event.preventDefault();
        var movieId = event.target.id.substring(15);
        $('#edit-series-modal' + movieId).modal('show');
    });

    $('[id^="editModalForm"]').submit(function (event) {
        event.preventDefault();
        var seriesId = event.target.id.substring(13);
        var seriesTitle = $('#edit-series-title' + seriesId).val();
        var seriesGenre = $('#edit-series-genre' + seriesId).val();
        var seriesYear = $('#edit-series-year' + seriesId).val();
        var seriesDirector = $('#edit-series-director' + seriesId).val();
        var seriesDuration = $('#edit-series-duration' + seriesId).val();
        var seriesImage = $('#edit-series-image' + seriesId).prop('files')[0];

        if (seriesImage === undefined) {
            var jsonData = {
                title: seriesTitle,
                genre: seriesGenre,
                year: seriesYear,
                director: seriesDirector,
                durationInMinutes: seriesDuration,
            };

            $.ajax({
                url: window.location.href.substring(0, window.location.href.lastIndexOf('/')) + "/series/" + seriesId + "/edit",
                type: 'PUT',
                contentType: "application/json",
                dataType: "json",
                data: JSON.stringify(jsonData),
                success: function () {
                    var url = '/table';
                    $("#movieTable").load(url);

                    window.location = window.location.href.substring(0, window.location.href.lastIndexOf('/')) + "/series";
                    $.toast({
                        text: "Successfully edited series", // Text that is to be shown in the toast
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
                    title: seriesTitle,
                    genre: seriesGenre,
                    year: seriesYear,
                    director: seriesDirector,
                    durationInMinutes: seriesDuration,
                    image: base64String
                };

                $.ajax({
                    url: window.location.href.substring(0, window.location.href.lastIndexOf('/')) + "/series/" + seriesId + "/edit",
                    type: 'PUT',
                    contentType: "application/json",
                    dataType: "json",
                    data: JSON.stringify(jsonData),
                    success: function () {
                        var url = '/table';
                        $("#movieTable").load(url);

                        window.location = window.location.href.substring(0, window.location.href.lastIndexOf('/')) + "/series";
                        $.toast({
                            text: "Successfully edited series", // Text that is to be shown in the toast
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
            reader.readAsDataURL(seriesImage);
        }
    });

    $('#modalForm').submit(function (event) {
        event.preventDefault();
        var seriesTitle = $('#series-title').val();
        var seriesGenre = $('#series-genre').val();
        var seriesYear = $('#series-year').val();
        var seriesDirector = $('#series-director').val();
        var seriesDuration = $('#series-duration').val();

        var seriesImage = $('#series-image').prop('files')[0];
        var reader = new FileReader();
        reader.onload = function () {
            var movieImageBase64 = reader.result;
            var base64String = movieImageBase64.substring(movieImageBase64.indexOf(',') + 1);
            var jsonData = {
                title: seriesTitle,
                genre: seriesGenre,
                year: seriesYear,
                director: seriesDirector,
                durationInMinutes: seriesDuration,
                image: base64String
            };

            $.ajax({
                url: window.location.href.substring(0, window.location.href.lastIndexOf('/')) + "/series",
                type: 'POST',
                contentType: "application/json",
                dataType: "json",
                data: JSON.stringify(jsonData),
                success: function () {
                    var url = '/table';
                    $("#movieTable").load(url);

                    window.location = window.location.href.substring(0, window.location.href.lastIndexOf('/')) + "/series";
                    $.toast({
                        text: "Successfully created new series", // Text that is to be shown in the toast
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
        reader.readAsDataURL(seriesImage);
    });

    $('.date-picker').datepicker({
        format: 'mm-dd-yyyy'
    });
});