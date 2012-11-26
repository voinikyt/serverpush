<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/jquery-ui.css" type="text/css" />	
        <title>HTML Forms</title>
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

        <div id="container">
            <form method="get" action="<%=request.getContextPath()%>/form">
                <table>
                    <tr><td colspan="2"><h1>GET FORM</h1></td></tr>
                    <tr>                    
                        <td>Name</td> 		
                        <td><input type="text" name="name"/></td>
                    </tr>
                    <tr>                    
                        <td>Age</td> 		
                        <td><input type="text" name="age" /></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="Sumbit"/></td>				
                    </tr>
                </table>
            </form>
            <br/>
             <form method="post" action="<%=request.getContextPath()%>/form">
                 <table>
                     <tr><td colspan="2"><h1>POST FORM</h1></td></tr>
                     <tr>                    
                         <td>Name</td> 		
                         <td><input type="text" name="name"/></td>
                     </tr>
                     <tr>                    
                         <td>Age</td> 		
                         <td><input type="text" name="age" /></td>
                     </tr>
                     <tr>
                         <td colspan="2"><input type="submit" value="Sumbit"/></td>				
                     </tr>
                 </table>
             </form>
        </div>        
    </body>
</html>