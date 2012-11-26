$(document).ready(function() {	   
    var socket = new WebSocket("ws://localhost:8080/push/websockets");

    socket.onmessage = function (e) {   
        var img = document.createElement('img');
        $(img).addClass('thumb');
        img.src = e.data;                                            
        document.getElementById('gallery').insertBefore(img, null);         
    };
	
    socket.onclose = function (e) {
        alert('Connection closed: ' + e.reason);
    };    			    	 				    	    
    
    function handleFileSelect(evt) {
        evt.stopPropagation();
        evt.preventDefault();        
        
        var files = evt.dataTransfer.files; 
        
        for (var i = 0, f; f = files[i]; i++) {            
            if (!f.type.match('image.*')) {
                continue;
            }
            var reader = new FileReader();

            reader.onload = (function(theFile) {
                return function(e) {                    
                    socket.send(e.target.result);                
                };
            })(f);            
            reader.readAsDataURL(f);          
        }
    }
    
    function handleDragOver(evt) {
        evt.stopPropagation();
        evt.preventDefault();
        evt.dataTransfer.dropEffect = 'copy';
    }
    
    var dropZone = document.getElementById('drop_zone');
    dropZone.addEventListener('dragover', handleDragOver, false);
    dropZone.addEventListener('drop', handleFileSelect, false);   
        
    $('#files').button();
});