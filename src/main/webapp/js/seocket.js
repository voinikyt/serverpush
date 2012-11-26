$(document).ready(function() {
	
    var socket = null;
	
    function sendChatMessageWebSocket() {
        $('#log').html('');
        socket = new WebSocket("ws://localhost:4444/chat", "csc-chat");
    	
        socket.onopen = function () {
            socket.send("Hello server");
            $('#log').append('Connection opened').append('\n');
        };
        
        socket.onerror = function (error) {
            $('#log').append('WebSocket Error ' + error.detail).append('\n');
        };
        
        socket.onmessage = function (e) {
            $('#log').append('Server: ' + e.data).append('\n');
        };
	
        socket.onclose = function (e) {
            $('#log').append('Connection closed: ' + e.reason).append('\n');
        };    			    	 				
    }
	
    $('#log').resizable();
	
    $('#startWebSocket').button();
    $('#startWebSocket').click(function () {
        sendChatMessageWebSocket();
    });
	
    $('#send').button();
    $('#send').click(function () {
        var text = $('#text').val();
        socket.send(text);
        $('#text').val('');
    });
});