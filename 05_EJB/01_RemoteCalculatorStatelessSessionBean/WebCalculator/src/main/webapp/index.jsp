<%-- 
    Document   : index
    Created on : 17-feb-2016, 10:29:50
    Author     : FS
--%>
<%@page import="demo.ejb.CalculadoraRemote"%>
<%@page import="java.util.Properties"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    long t0 = System.nanoTime();

    Context context = new InitialContext();
    CalculadoraRemote calc = (CalculadoraRemote) context.lookup("java:global/ModuloAritmetico/CalculadoraBean");

    String txt_s1 = request.getParameter("s1");
    String txt_s2 = request.getParameter("s2");
    int s1 = 0;
    int s2 = 0;
    
    if (txt_s1!=null){
        s1 = Integer.valueOf(txt_s1);
        s2 = Integer.valueOf(txt_s2);
    }
    
    int suma = calc.sumar(s1, s2);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web Remote Calculator</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://fonts.xz.style/serve/inter.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@exampledev/new.css@1.1.2/new.min.css">
    </head>
    <body>
        <h1>Web Remote Calculator (JSP)</h1>
        Elige: <b>versión JSP</b> | <a href="sumar.jsp">versión Servlet</a>
        <hr>
        <br>
        <br>
        <br>
        <form method="POST" action="index.jsp">
            <input name="s1" value="<%=s1%>" size="4"> + 
            <input name="s2" value="<%=s2%>" size="4"> = 
            <%=suma%>
            <br>
            <input type="submit" value="¡A sumarr!">
        </form>
      
        <br/>
        <br/>
        La suma ha necesitado: <%=(System.nanoTime()- t0)/1000%> us.


        
    </body>
</html>
