<%-- 
    Document   : user
    Created on : 12/01/2015, 09:24:24 AM
    Author     : SIG01
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    response.setHeader( "Pragma", "no-cache" ); 
    response.addHeader( "Cache-Control", "must-revalidate" ); 
    response.addHeader( "Cache-Control", "no-cache" ); 
    response.addHeader( "Cache-Control", "no-store" ); 
    response.setDateHeader("Expires", 0);   
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Cache-Control" content="no-cache">
        <title>Administración del SIRH</title>
        <script src="<c:url value="/js/jQuery/jquery-2.1.3.min.js"/>" type="text/javascript"></script>
        <link href="<c:url value="/css/cssEsqueleto.css"/>" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <header>
            <hgroup>
                <div id="bannerIzq"></div>
                <div id="bannerDer"></div>
                <div id="bannerCen"></div>
            </hgroup>
        </header>
        <section id="contenido">
            <section id="centro">
                
                <h1 align="center">Página de administrción del sitema</h1>
                <div style="text-align: center;">
                    <a href="<c:url value="/"/>">Inicio</a>
                    <a href="<c:url value="/logout"/>">Cerrar sesion</a>
                </div>

                <div id="div_alta_usuarios" style="border: solid 1px;">
                    <h2 align="center">Administraci&oacute;n de Usuarios del Sistema</h2>
                    <sec:authentication property="principal.username"/>
                </div>

            </section>
        </section>
        <footer>
            <div id="copyright">Sistemas de Información Geográfica SA de CV</div>
            <div id="contacto">Departamento de Recursos Humanos</div>
        </footer>
    </body>
</html>
