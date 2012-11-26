<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/jquery-ui.css" type="text/css" />	
        <title>Websocket images</title>
        <style type="text/css">
            #container { margin: 0; padding: 0; }
            #container { margin: 0; padding: 0; }
            html, body { width: 100%; height: 100%; }

            body { background: #EEE; color: #000; font: normal 12px/1.2 Arial, Helvetica, sans-serif; }

            #container { margin: 50px 0; text-align: center; font-size: 24px; }

            #number { display: inline-block; padding: 0 35px; line-height: 1.6; }

            #number { background: #000; color: #FFF; font-size: 56px; }

            .thumb {                
                height: 200px;
                border: 1px solid #000;
                margin: 10px 5px 0 0;
            }

            #drop_zone {
                border: 2px dashed #BBB;
                -moz-border-radius: 5px;
                -webkit-border-radius: 5px;
                border-radius: 5px;
                padding: 25px;
                text-align: center;
                font: 20pt bold,"Vollkorn";
                color: #BBB;
            }
        </style>
    </head>
    <body>

        <div id="container">
            <div id="drop_zone">Drop files here</div>
            
            <br/>
            <div id="gallery">              
            </div>
        </div>

        <script src="<%=request.getContextPath()%>/js/jquery-1.8.2.js"></script>
        <script src="<%=request.getContextPath()%>/js/jquery-ui.js"></script>
        <script src="<%=request.getContextPath()%>/js/images.js"></script>
    </body>
</html>