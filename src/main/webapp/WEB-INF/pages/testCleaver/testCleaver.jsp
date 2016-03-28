<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
        <title>Test Cleaver</title>
        <script src="<c:url value="/js/jQuery/jquery-2.1.3.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/js/testCleaver/testCleaver.js"/>" type="text/javascript"></script>
        <link href="<c:url value="/css/cssEsqueleto.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/testCleaver/testCleaver.css"/>" rel="stylesheet" type="text/css"/>
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
                <div id="preguntas">
                    <section>
                        <!--Encabezado-->
                        <div id="nombreTest">Test CLEAVER</div>
                        <div id="indicadorPregunta">Pregunta 10/25</div>
                    </section>
                    <section>
                        <!--Seccion de las preguntas y respuestas-->
                        <!--<div id="preguntaActual" class="caja caja-sombra">Esta es la pregunta que se le hace al participante</div>-->
                        <div id="contenedorRespuestas">
                            <article id="contenedorResp">
                                <div class="moreless" id="divResPlus" ondrop="drop(event)" ondragenter="handleDragEnter(event)" ondragleave="handleDragLeave(event)"></div>
                                <div class="moreless" id="divResLess" ondrop="drop(event)" ondragenter="handleDragEnter(event)" ondragleave="handleDragLeave(event)"></div>
                            </article>
                            <article id="articleRespuestas">
                                <div class="respuesta" id="resp1" draggable="true" ondragstart="drag(event)">Amiguero</div>
                                <div class="respuesta" id="resp2" draggable="true" ondragstart="drag(event)">Paciente</div>
                                <div class="respuesta" id="resp3" draggable="true" ondragstart="drag(event)">Confianza en sí mismo</div>
                                <div class="respuesta" id="resp4" draggable="true" ondragstart="drag(event)">Mensurado para hablar</div>
                            </article>
                        </div>
                    </section>
                </div>
            </section>
        </section>
        <footer>
            <div id="copyright">Sistemas de Información Geográfica SA de CV</div>
            <div id="contacto">Departamento de Recursos Humanos</div>
        </footer>
  </body>
</html>
