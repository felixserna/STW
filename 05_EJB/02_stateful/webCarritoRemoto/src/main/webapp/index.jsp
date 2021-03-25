<%-- 
    Document   : index
    Created on : 3 mar. 2020, 9:24:30
    Author     : Usuario
--%>
<%@page import="javax.naming.NamingException"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="demo.ejb.CarritoRemoto"%>
<%@page import="demo.Producto"%>
<%@page import="demo.util.Util"%>
<%@page import="demo.util.Util"%>

<%
    CarritoRemoto carrito = (CarritoRemoto)session.getAttribute("carrito");
    if (carrito==null){
        InitialContext ic = new InitialContext();
        try {
            carrito = (CarritoRemoto)ic.lookup("java:global/CarritoBeanModule/CarritoBean!demo.ejb.CarritoRemoto");
            session.setAttribute("carrito", carrito);
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
    }
 %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrito</title>

    </head>
    <body>
        <style>
            body {font-family: "Lato", sans-serif; font-size: 14px;}
        </style>
        
        <h1>Stateful carrito Remoto!</h1>
        <hr>
        Host: <%=request.getLocalAddr()%><br>
        Server instance: <%= System.getProperty("com.sun.aas.instanceName") %><br>
        Served from: <%= request.getServerName()%> : <%=request.getServerPort()%><br>
        Session ID: <%=session.getId()%>
        <br>
        <br>
        <div style="background-color: red; color:white;">${msg}</div>
        <br>
        
        <table>
            <tr>
                <td valign="top">
                    <fieldset>
                        <legend>Artículo a comprar:</legend>
                        <form method="POST" action="<%=response.encodeRedirectURL("addToCarrito")%>">
                            <table>
                                <tr><td>Nombre del Producto:</td><td><input name="nombre"></td></tr>
                            <tr><td>Precio Unitario:</td><td><input name="precio"></td></tr>
                            <tr><td>Unidades:</td><td><input name="unidades"></td></tr>
                            <tr><td></td><td><input type="submit" value="Comprar"></td></tr>
                            </table>
                        </form>
                    </fieldset>
                </td>
                
                
                <td valign="top">
                    <fieldset>
                        <legend>Carrito:</legend>
                        <table>
                            <tr style="background-color: blue; color:white "><td>Producto</td><td>Unidades</td><td>Precio</td><td>Importe</td></tr>
                        <% for (Producto p: carrito.getProductos()){ %>
                        <tr><td><%=p.getNombre()%></td><td align="right"><%=p.getUnidades()%></td><td align="right"><%=p.getPrecioUnitario()%> €</td><td align="right"><%=Util.getNumberFormatted(p.getImporte(), "#,###,##0.00")%> €</td></tr>
                        <% } %>
                        <tr style="background-color: blue; color:white "><td></td><td></td><td><b>Total:</b></td><td align="right"><b><%=Util.getNumberFormatted(carrito.getImporteTotal(), "#,###,##0.00")%> €</b></td></tr>
                        </table>
                        <br>
                        <button onclick='document.location.href="<%=response.encodeRedirectURL("procesarCarrito")%>"'>Procesar Carrito</button>
                    </fieldset>
                </td>
            </tr>
        </table>
    </body>
</html>
