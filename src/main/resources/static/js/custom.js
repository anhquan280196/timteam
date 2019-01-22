// Offset for Site Navigation
$('#siteNav').affix({
	offset: {
		top: 100
	}
})

$(document).ready(function () {
                $('#personInfo').on('show.bs.modal', function (e) {
                    /* get data written in data-person-name field */
                    var personName = $(e.relatedTarget).data('person-name');
                    /* append that to form our service url */
                    var jqxhr = $.getJSON("http://localhost/onlinejson/index.php?name=" + personName, function (json) {
                        /* this function is called when request finishes. The response is stored in this json object*/
                        /* we get the div that holds the header and put there the value of the "title" element */
                        $('#personInfo .modal-header .modal-title').html(json["title"]);
                        /* we get the modal-body div and put the content of the "data" key in our php */
                        $('#personInfo .modal-body').html(json["data"]);
                    });
                });
            });

$(document).ready(function () {
    $('#register').on('show.bs.modal', function (e) {
        /* get data written in data-person-name field */
        var personName = $(e.relatedTarget).data('person-name');
        /* append that to form our service url */
        var jqxhr = $.getJSON("http://localhost/onlinejson/index.php?name=" + personName, function (json) {
            /* this function is called when request finishes. The response is stored in this json object*/
            /* we get the div that holds the header and put there the value of the "title" element */
            $('#register .modal-header .modal-title').html(json["title"]);
            /* we get the modal-body div and put the content of the "data" key in our php */
            $('#register .modal-body').html(json["data"]);
        });
    });
});

