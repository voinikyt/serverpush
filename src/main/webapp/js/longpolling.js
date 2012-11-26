$(document).ready(function() {
	
    $('#increment').button();
    $('#decrement').button();	
	
    $('#increment').click(function() {
        $.post("http://localhost:8080/push/longpolling/number", {
            operation: "increment"
        } );
    });
	
    $('#decrement').click(function() {
        $.post("http://localhost:8080/push/longpolling/number", {
            operation: "decrement"
        } );
    });
	        
    $.post("http://localhost:8080/push/longpolling/number", 
        {operation: "get"},
        function(data) {			
            $('#number').html(data);	            
        }, 
        'text'
    );
    	     
    function getNumber() {
        $.get('http://localhost:8080/push/longpolling/number', 
            function(data, textStatus, jqXHR) {			
                $('#number').html(data);	            
                $('#console').prepend(getTimeString() + " - NEW RESULT\n");
                getNumber();
            }, 'text'
        ).error(function (jqXHR, textStatus, errorThrown) {
            $('#console').prepend(getTimeString() + " - RECONNECTING\n");
            getNumber();
        });	 
    }
    
    getNumber();
    
    function getTimeString() {
        var date  = new Date();
        return date.getHours() + ':' + date.getMinutes() + ':' + date.getSeconds() + '.' + date.getMilliseconds(); 
    }
    
});