<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" href="css/jquery-ui.css" />
        <title>Server push technologies</title>
        <style>
            #wrapper {
                width: 960px;
                min-height: 500px;
                padding: 50px 10px 50px 10px;
                margin: 0 auto;
                margin-top: 50px;
                text-align: center;
                background: #D5D5D5;
                border-radius: 20px;
                box-shadow: 0 0px 30px #555;
            }
            #wrapper a {
                font:normal 36pt Arial;
                color:#FFFFFF;
                text-shadow: 0 1px 0 #ccc,
                    0 2px 0 #c9c9c9,
                    0 3px 0 #bbb,
                    0 4px 0 #b9b9b9,
                    0 5px 0 #aaa,
                    0 6px 1px rgba(0,0,0,.1),
                    0 0 5px rgba(0,0,0,.1),
                    0 1px 3px rgba(0,0,0,.3),
                    0 3px 5px rgba(0,0,0,.2),
                    0 5px 10px rgba(0,0,0,.25),
                    0 10px 10px rgba(0,0,0,.2),
                    0 20px 20px rgba(0,0,0,.15);
                text-decoration: none;
            }
            li {
                margin-bottom: 20px;
                text-align: left;
            }
        </style>
    </head>
    <body>
        <div id="wrapper">	            
            <ul  style="list-style: none;">                
                <li><a href="<%=request.getContextPath()%>/forms.jsp">1. Forms</a></li>
                <li><a href="<%=request.getContextPath()%>/ajaxforms.jsp">2. Forms Ajax</a></li>
                <li><a href="<%=request.getContextPath()%>/ajaxnumber.jsp">3. Ajax Number</a></li>
                <li><a href="<%=request.getContextPath()%>/polling.jsp">4. Polling - Synchronous Ajax</a></li>
                <li><a href="<%=request.getContextPath()%>/longpolling.jsp">5. Long Polling</a></li>
                <li><a href="<%=request.getContextPath()%>/streaming.jsp">6. HTTP Streaming</a></li>
                <li><a href="<%=request.getContextPath()%>/socket.jsp">7. Java Server Socket</a></li>
                <li><a href="<%=request.getContextPath()%>/websockets.jsp">8. Web Sockets Number</a></li>
                <li><a href="<%=request.getContextPath()%>/images.jsp">9. Web Sockets Images</a></li>
            </ul>
        </div>
    </body>
</html>