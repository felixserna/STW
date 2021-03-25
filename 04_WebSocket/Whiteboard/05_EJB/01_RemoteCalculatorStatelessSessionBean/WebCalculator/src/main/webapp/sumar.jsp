<%-- 
    Document   : sumar
    Created on : 17-feb-2016, 12:40:50
    Author     : FS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web Remote Calculator</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://fonts.xz.style/serve/inter.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@exampledev/new.css@1.1.2/new.min.css">

    </head>
    <body>
        <h1>Web Remote Calculator (con servlet)</h1>
        Elige: <a href="index.jsp">versión JSP</a> | <b>versión Servlet</b>
        <hr>
        <br>
        <br>
        <br>
        <form method="POST" action="sumarRemotamente">
            <input name="s1" value="${s1}" size="4"> + 
            <input name="s2" value="${s2}" size="4"> = 
            ${resultadoRemoto}
            <br>
            <input type="submit" value="¡A sumarr!">
        </form>
        <br>
        <br>
        La suma ha necesitado: ${us} us.

            
    </body>
</html>
