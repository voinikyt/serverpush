$(document).ready(function() {
	
    $('#increment').button();
    $('#decrement').button();	
	
    $('#increment').click(function() {
        $.post("http://localhost:8080/push/sync/number", {
            operation: "increment"
        }, function () {
            getAjaxNumber();
        } );
    });
	
    $('#decrement').click(function() {
        $.post("http://localhost:8080/push/sync/number", {
            operation: "decrement"
        }, function(){
            getAjaxNumber();
        } );
    });
	
    function getTimeString() {
        var date = new Date();
        return date.getHours() + ':' + date.getMinutes() + ':' + date.getSeconds() + '.' + date.getMilliseconds(); 
    }
	
    function getAjaxNumber() {
        $.get('http://localhost:8080/push/sync/number', function(data, textStatus, jqXHR) {
            if ( data != $('#number').html()) {
                $('#number').html(data);		
                $('#console').prepend(getTimeString() + " - NEW RESULT\n");
            } else {
                $('#console').prepend(getTimeString() + " - NOTHING NEW\n");
            };			 
        }, 'text');
    };	   
    
    getAjaxNumber();
});