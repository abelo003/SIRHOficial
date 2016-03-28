
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
        <meta http-equiv="Cache-Seconds" content="0">
        <title>SIRH</title>
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
                <h1 align="center">P&Aacute;GINA PRINCIPAL DEL SISTEMA</h1>
                <div style="text-align: right; width: 100%;"><h2>Bienvendio <sec:authentication property="principal.username"/></h2></div>
                <div style="text-align: center; width: 100%; font-size: 20px;">           
                    <a href="<c:url value="/Admin"/>"> Seccion Administrativa</a>
                    <a href="<c:url value="/TestZavic"/>">Test Zavic</a>
                    <a href="<c:url value="/TestCleaver"/>">Test Cleaver</a>
                    <a href="<c:url value="/logout"/>">Cerrar sesion</a>
                </div>
                <sec:authorize access="hasAnyRole('ROLE_ADMIN')">
                    <div><h1>Esta seccion solo la pueden ver usuarios con el ROL_ADMIN</h1></div>
                </sec:authorize>
                
            </section>
        </section>
        <footer>
            <div id="copyright">Sistemas de Información Geográfica SA de CV</div>
            <div id="contacto">Departamento de Recursos Humanos</div>
        </footer>
  </body>
</html>
