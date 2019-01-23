$(document).ready(function () {
    $('#login').on('show.bs.modal', function (e) {
        /* get data written in data-person-name field */
        var personName = $(e.relatedTarget).data('person-name');
        /* append that to form our service url */
        var jqxhr = $.getJSON("http://localhost/onlinejson/index.php?name=" + personName, function (json) {
            /* this function is called when request finishes. The response is stored in this json object*/
            /* we get the div that holds the header and put there the value of the "title" element */
            $('#login .modal-header .modal-title').html(json["title"]);
            /* we get the modal-body div and put the content of the "data" key in our php */
            $('#login .modal-body').html(json["data"]);
        });
    });
    
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
    
    $('#btnLogin').click(function() {
    	var phoneNumber = $.trim($('#txtPhoneNumber').val());
    	var password = $.trim($('#txtPassword').val());
    	var message = $('#error');

    	if ('' == phoneNumber || '' == password) {
    		message.css('color', 'red');
    		message.text('Nhập số điện thoại và mật khẩu');

    		return false;
    	} else {
    		$.post({
    			url : '/account/login',
    			data : {
    				'txtPhoneNumber' : phoneNumber,
    				'txtPassword' : password
    			},
    			success : function(response) {
    				
    			}
    		});

    		return true;
    	}
    });
});