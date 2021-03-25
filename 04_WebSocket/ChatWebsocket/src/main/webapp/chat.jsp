<%-- 
    Document   : index
    Created on : 08-mar-2021, 22:35:42
    Author     : fsern
--%>

<%@page import="fs.chat.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    String login = (String) session.getAttribute("login");
    if (login==null){
        response.sendRedirect("index.jsp");
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://fonts.xz.style/serve/inter.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@exampledev/new.css@1.1.2/new.min.css">  
-->
    </head>
    <body>
        <style>
            body {font-family: "Lato", sans-serif; font-size: 14px;}
        </style>
    
        <table>
            <tr>
                <td><h1>Chat!</h1></td>
                <td></td>
                <td> <div id="queHoraEs"></div></td>
            </tr>
            <tr>
                <td>Hola, <b>${login}</b>.</td>
                <td>Usuarios registrados:</td>
                <td><div id="numUsuariosRegistrados" style="font-weight: bold"></div></td>
            </tr>
        </table>
        <br>
        <form action="<%=response.encodeURL("salirDelChat")%>"><input type="submit" value="Salir"></form>
        <hr>
        <table>
            <tr>
                <td valign="top">
                    <fieldset>
                        <legend>Conectados:</legend>
                        <div id="registrados"></div>
                    </fieldset>
                </td>

                <td valign="top">
                    <fieldset>
                        <legend>
                            Mensaje a Enviar:
                        </legend>

                        <table>
                            <tr>
                                <td>Mensaje: </td>
                                <td><input id="txField"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td align="center"><button onclick="enviarMensaje('${login}')">Enviar</button></td>
                            </tr>
                        </table>
                    </fieldset>
                </td>
                
                
                <td valign="top">
                    <fieldset>
                        <legend>
                            Mensajes recibidos:
                        </legend>
                        <div id="rx"></div>
                    </fieldset>
                </td>
            </tr>
        </table>
    </body>
    <script type="text/javascript" src="chatWebsocket.js"></script>
</html>
