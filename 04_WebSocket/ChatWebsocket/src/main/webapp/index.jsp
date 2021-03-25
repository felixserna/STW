<%-- 
    Document   : index
    Created on : 08-mar-2021, 22:35:42
    Author     : fsern
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    
    String msg = (String) session.getAttribute("msg");
    
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chat</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://fonts.xz.style/serve/inter.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@exampledev/new.css@1.1.2/new.min.css"> 
    </head>
    <body>
        <style>
            body {font-family: "Lato", sans-serif; font-size: 14px;}
        </style>
    

        <h1>Chat!</h1>
        <br>
        <br>
        
    <%  if (msg!=null){ %>
        <div style="background-color: red; color:white; font-weight: bold"><%=msg%></div>
    <%  
           session.setAttribute("msg", null);
        } // if 
    %>
        <table>
            <tr>
                <td>Login:
                </td>
                <td>
                    <form method="POST" action="login">
                        <input name="login" size="8">
                        <input type="submit" value="Registrar usuario">
                </td>
            </tr>
        </table>
    </body>
    
</html>
