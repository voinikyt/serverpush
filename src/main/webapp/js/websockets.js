$(document).ready(function() {	   
    var socket = new WebSocket("ws://localhost:8080/push/websockets");

    socket.onopen = function () {           
        socket.send("get");
        $('#console').append('Connection opened').append('\n');
    };
        
    socket.onerror = function (error) {
        $('#console').append('WebSocket Error ' + error.detail).append('\n');
    };

    socket.onmessage = function (e) {
        $('#number').html(e.data);		                   
        $('#console').append('Server: ' + e.data).append('\n');
    };
	
    socket.onclose = function (e) {
        $('#console').append('Connection closed: ' + e.reason).append('\n');
    };    			    	 				
    	     
    $('#increment').click(function(){
        socket.send("increment");
    });
    
    $('#decrement').click(function(){
        socket.send("decrement");
    });
        
    $('#increment').button();
    $('#decrement').button();
    
    function getTimeString() {
        var date = new Date();
        return date.getHours() + ':' + date.getMinutes() + ':' + date.getSeconds() + '.' + date.getMilliseconds(); 
    }
});