function deleteEpisode(seriesId, episodeId) {
    $.confirmModal('Are you sure you want to delete this episode?', function () {
        $.ajax({
            url: window.location.href.substring(0, window.location.href.lastIndexOf('/')) + "/episodes/" + episodeId + "/delete",
            type: 'DELETE',
            success: function () {
                var url = '/table';
                $("#licenseTable").load(url);

                window.location = window.location.href.substring(0, window.location.href.lastIndexOf('/')) + "/episodes";
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

function markEpisode(id) {
    var dateInput = $('#dateInput' + id).val();
    if (dateInput == "") {
        alert("Please enter a date when you watched the episode.");
    } else {
        var dateInputParsed = Date.parse(dateInput.replace(/-/g, ' '));
        $.confirmModal('Are you sure you want to mark this episode?', function () {
            $.ajax({
                url: window.location.href.substring(0, window.location.href.lastIndexOf('/')) + "/episodes/" + id + "/mark",
                type: 'POST',
                contentType: "application/json",
                dataType: "json",
                data: JSON.stringify({dateWatched: dateInputParsed}),
                success: function () {
                    var url = '/table';
                    $("#licenseTable").load(url);

                    window.location = window.location.href.substring(0, window.location.href.lastIndexOf('/')) + "/episodes";
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

function unMarkEpisode(id) {
    $.confirmModal('Are you sure you want to mark this episode?', function () {
        $.ajax({
            url: window.location.href.substring(0, window.location.href.lastIndexOf('/')) + "/episodes/" + id + "/unmark",
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

function viewEpisode(id) {
    $.ajax({
        url: window.location.href.substring(0, window.location.href.lastIndexOf('/')) + "/episodes/" + episodeId + "/info",
        type: 'GET',
        success: function () {
            var url = '/table';
            $("#licenseTable").load(url);

            window.location = window.location.href.substring(0, window.location.href.lastIndexOf('/')) + "/episodes";
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

    $('#add-new-episode-btn').click(function (event) {
        event.preventDefault();
        $('#new-episode-modal').modal('show');
    });

    $('#new-episode-modal').on('hidden.bs.modal', function (e) {
        $('#modalForm').find("input, textarea").val("");
    });

    $('[id^="edit-episode-btn"]').click(function (event) {
        event.preventDefault();
        var episodeId = event.target.id.substring(16);
        $('#edit-episode-modal' + episodeId).modal('show');
    });

    $('[id^="editModalForm"]').submit(function (event) {
        event.preventDefault();
        var episodeId = event.target.id.substring(13);
        var episodeTitle = $('#edit-episode-title' + episodeId).val();
        var episodeSeasonNumber = $('#edit-episode-season-number' + episodeId).val();
        var episodeNumber = $('#edit-episode-episode-number' + episodeId).val();
        var dateToEdit = $('#edit-episode-release-date' + episodeId).val();
        var episodeReleaseDate = Date.parse(dateToEdit.replace(/-/g, ' '));
        var episodeDuration = $('#edit-episode-duration' + episodeId).val();

        var jsonData = {
            seasonNumber: episodeSeasonNumber,
            episodeNumber: episodeNumber,
            title: episodeTitle,
            durationInMinutes: episodeDuration,
            releaseDate: episodeReleaseDate
        };

        $.ajax({
            url: window.location.href.substring(0, window.location.href.lastIndexOf('/')) + "/episodes/" + episodeId + "/edit",
            type: 'PUT',
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(jsonData),
            success: function () {
                var url = '/table';
                $("#movieTable").load(url);

                window.location = window.location.href.substring(0, window.location.href.lastIndexOf('/')) + "/episodes";
                $.toast({
                    text: "Successfully edited episode", // Text that is to be shown in the toast
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

    $('#modalForm').submit(function (event) {
        event.preventDefault();
        var episodeTitle = $('#episode-title').val();
        var episodeSeasonNumber = $('#episode-season-number').val();
        var episodeNumber = $('#episode-episode-number').val();
        var episodeReleaseDate = Date.parse($('#episode-release-date').val().replace(/-/g, ' '));
        var episodeDuration = $('#episode-duration').val();

        var jsonData = {
            seasonNumber: episodeSeasonNumber,
            episodeNumber: episodeNumber,
            title: episodeTitle,
            durationInMinutes: episodeDuration,
            releaseDate: episodeReleaseDate
        };


        $.ajax({
            url: window.location.href.substring(0, window.location.href.lastIndexOf('/')) + "/episodes",
            type: 'POST',
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(jsonData),
            success: function () {
                var url = '/table';
                $("#movieTable").load(url);

                window.location = window.location.href.substring(0, window.location.href.lastIndexOf('/')) + "/episodes";
                $.toast({
                    text: "Successfully created new episode", // Text that is to be shown in the toast
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

    $('.date-picker').datepicker({
        format: 'yyyy-mm-dd'
    });
});