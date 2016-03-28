<%-- 
    Document   : 403
    Created on : 12/01/2015, 09:15:14 AM
    Author     : SIG01
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    response.setHeader( "Pragma", "no-cache" ); 
    response.addHeader( "Cache-Control", "must-revalidate" ); 
    response.addHeader( "Cache-Control", "no-cache" ); 
    response.addHeader( "Cache-Control", "no-store" ); 
    response.setDateHeader("Expires", 0);   
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Cache-Control" content="no-cache">
        <title>Acceso Denegado</title>
    </head>
    <body>
        <a href="<c:url value="/"/>">Ir al inicio</a>
                <h2>Username : <sec:authentication property="principal.username"/> <br/>
                    ${error}</h2>
 
</body>
</html>
