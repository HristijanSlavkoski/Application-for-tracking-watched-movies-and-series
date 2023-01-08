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
    $.confirmModal('Are you sure you want to mark this movie?', function () {
        $.ajax({
            url: window.location.href.substring(0, window.location.href.lastIndexOf('/')) + "/movies/" + id + "/mark",
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
    var url = window.location.href.substring(0, window.location.href.lastIndexOf('/')) + "/licenses/" + id + "/download";

    var xhr = new XMLHttpRequest();
    xhr.open("GET", url, true);
    xhr.responseType = "blob";
    xhr.onload = function (e) {
        if (this.status == 200) {
            const blob = this.response;
            const a = document.createElement("a");
            document.body.appendChild(a);

            //get filename from response
            var filename = "";
            var disposition = xhr.getResponseHeader('Content-Disposition');
            if (disposition && disposition.indexOf('attachment') !== -1) {
                var filenameRegex = /filename[^;=\n]*=((['"]).*?\2|[^;\n]*)/;
                var matches = filenameRegex.exec(disposition);
                if (matches != null && matches[1]) {
                    filename = matches[1].replace(/['"]/g, '');
                }
            }

            const blobUrl = window.URL.createObjectURL(blob);
            a.href = blobUrl;
            a.download = filename;
            a.click();
            setTimeout(() => {
                window.URL.revokeObjectURL(blobUrl);
                document.body.removeChild(a);
            }, 0);
        }
    };
    xhr.send();
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

    $('#modalForm').submit(function (event) {
        //function addMovie(id) {
        event.preventDefault();
        var movieTitle = $('#movie-title').val();
        var movieGenre = $('#movie-genre').val();
        var movieYear = $('#movie-year').val();
        var movieDirector = $('#movie-director').val();
        var movieDuration = $('#movie-duration').val();
        var movieImage = $('#movie-image')[0].files[0];

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
                duration: movieDuration,
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
                        text: "Successfully created new license", // Text that is to be shown in the toast
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
//    }

    });

    $('.date-picker').datepicker({
        format: 'mm-dd-yyyy'
    });
});