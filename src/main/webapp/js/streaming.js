$(document).ready(function() {

    $('#increment').click(function() {
        $.post("http://localhost:8080/push/streaming/number", {
            operation: "increment"
        } );
    });
	
    $('#decrement').click(function() {
        $.post("http://localhost:8080/push/streaming/number", {
            operation: "decrement"
        } );
    });
    
    $.post("http://localhost:8080/push/streaming/number", 
        {operation: "get"},
        function(data) {			
            $('#number').html(data);	            
        }, 
        'text'
    );
    
    function connect() {
        var client = null;
        try{        
            client = new XMLHttpRequest();
        }catch (e){        
            try{
                client = new ActiveXObject("Msxml2.XMLHTTP");
            }catch (e){
                client = new ActiveXObject("Microsoft.XMLHTTP");
            }
        }
        client.onreadystatechange = handleMessage;        
        client.open("GET", 'http://localhost:8080/push/streaming/number', true);
        
        function handleMessage() {            
           if (this.readyState == 3){				                
                $('#number').html(this.responseText.substring(this.responseText.lastIndexOf(';') + 1));
                $('#console').prepend(this.responseText + '\n');                
            }else if (this.readyState == 4){    
                $('#console').prepend('Recconect after readystate = 4\n');
                connect();
            }            
        }
        
        client.send(null);
    }
    
    connect();
        	
    $('#increment').button();
    $('#decrement').button();		
});