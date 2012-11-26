<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="css/jquery-ui.css" />
	<title>TCP socket server</title>
</head>
<body>
    <h1>Don't forget to start the <a href="https://github.com/voinikyt/websocketserver">websocketserver</a> before you try this</h1>
    <div >	
        <button id="startWebSocket">START</button>
    </div>
    <div >
        <input id="text" size="20"/>	
        <button id="send">SEND</button>
    </div>
    <div>	
        <textarea id="log" rows="10" cols="50"></textarea>
    </div>
    <script src="js/jquery-1.8.2.js"></script>
    <script src="js/jquery-ui.js"></script>
    <script src="js/seocket.js"></script>
</body>
</html>