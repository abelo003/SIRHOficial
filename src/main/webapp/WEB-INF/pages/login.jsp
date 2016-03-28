<%-- 
    Document   : login
    Created on : 09-ene-2015, 22:02:13
    Author     : oscar
--%>
<%
    response.setHeader("Pragma", "no-cache");
    response.addHeader("Cache-Control", "must-revalidate");
    response.addHeader("Cache-Control", "no-cache");
    response.addHeader("Cache-Control", "no-store");
    response.setDateHeader("Expires", 0);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Cache-Control" content="no-cache">
        <meta http-equiv="Cache-Seconds" content="0">
        <title>SIRH - Log In</title>
        <link href="<c:url value="css/login/cssLogin.css"/>" rel="stylesheet" type="text/css"/>
        <script src="<c:url value="js/jQuery/jquery-2.1.3.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="js//login/jsLogin.js"/>" type="text/javascript"></script>

    </head>
    <body>
        <div id="login-box">
            <h3>Inicio de sesión</h3>
            <c:if test="${not empty param.err}">
                <div class="error">${SPRING_SECURITY_LAST_EXCEPTION.message}</div>
            </c:if>
            <c:if test="${not empty param.time}">
                <div class="error">Sesión cerrada por inactividad</div>
            </c:if>
            <c:if test="${not empty param.out}">
                <div class="msg">Cierre de sesión exitosa</div>
            </c:if>
            <form name='formLogin' action="<c:url value="/login.do"/>" method="post">
                <table>
                    <tr>
                        <td>Usuario:</td>
                        <td><input type='text' name='username' value=''></td>
                    </tr>
                    <tr>
                        <td>Contraseña</td>
                        <td><input type='password' name='password' /></td>
                    </tr>
                    <tr>
                        <td colspan='2'><input name="submit" type="submit" value="submit" /></td>
                    </tr>
                </table>
            </form>
            <!--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->
        </div>
</html>
