<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/jquery-ui.css" type="text/css" />	
        <title>HTTP Streaming</title>
        <style type="text/css">
            #container { margin: 0; padding: 0; }
            #container { margin: 0; padding: 0; }
            html, body { width: 100%; height: 100%; }

            body { background: #EEE; color: #000; font: normal 12px/1.2 Arial, Helvetica, sans-serif; }

            #container { margin: 50px 0; text-align: center; font-size: 24px; }

            #number { display: inline-block; padding: 0 35px; line-height: 1.6; }

            #number { background: #000; color: #FFF; font-size: 56px; }
        </style>
    </head>
    <body>
        <h1>Open 2 Mozilla browsers. Other browsers require 
            <a href="http://www.slideshare.net/mocheng/comet-server-pushoverweb">hacks</a></h1>
        <div id="container">
            <table>
                <tr>
                    <td><button id="increment">+</button></td> 	
                    <td><button id="decrement">-</button></td> 		
                    <td><span id="number"></span></td>
                </tr>
                <tr>
                    <td colspan="3"><textarea id="console" rows="20" cols="50"></textarea></td>				
                </tr>
            </table>
        </div>

        <script src="<%=request.getContextPath()%>/js/jquery-1.8.2.js"></script>
        <script src="<%=request.getContextPath()%>/js/jquery-ui.js"></script>
        <script src="<%=request.getContextPath()%>/js/streaming.js"></script>
    </body>
</html>