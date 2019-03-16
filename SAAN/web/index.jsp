<%-- 
    Document   : index
    Created on : 8/03/2019, 09:45:08 PM
    Author     : Juan Pablo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Auxiliares.*"%>
<%@page import="Clases.*"%>
<%
    MensajesEspanol.AgregarDatos();
    MensajesIngles.AgregarDatos();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SAAN</title>
    </head>
    <body>
        hola mundo
        <br/>
        <% String hola = "Funcional"; %>
        <%=hola%>
    </body>
</html>
