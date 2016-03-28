<%-- 
    Document   : testZavic
    Created on : 22-ene-2015, 21:57:47
    Author     : macpro
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <title>TEST ZAVIC</title>
        <script src="<c:url value="/js/jQuery/jquery-2.1.3.min.js"/>" type="text/javascript"></script>
        <link href="<c:url value="/css/cssEsqueleto.css"/>" rel="stylesheet" type="text/css"/>
        <script src="<c:url value="/js/testZavic/jsTestZavic.js"/>" type="text/javascript"></script>
        <link href="<c:url value="/css/testZavic/cssTestZavic.css"/>" rel="stylesheet" type="text/css"/>
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
                <div id="instrucciones">
                    <h2>Test ZAVIC</h2>
                    <article>
                        <p>
                            A continuación usted encontrará una serie de situaciones que le van a sugerir 4
                            respuestas. Lea cada una de ellas cuidadosamente y enumere con la respuesra que
                            le corresponda de la siguiente manera:<br>
                            <br>
                            <br>
                            EL número 4 Cuando la respuesta sea más importante.<br>
                            EL número 3 Cuando le sea más importante pero no tanto como la anterior.<br>
                            EL número 2 Cuando la prefiera menos que las anteriores.<br>
                            EL número 1 Cuando tenga menos importancia.<br>
                            <br>
                            <br>
                        </p>
                        <p><b>Ejemplo</b></p>
                        <br>
                        <div id="divEjemplo">
                            <p>
                                Me encuentro sentado frente a un vidrio que esta sucio, a mi no me gusta
                                esta situación lo que haría es:
                                <br>
                                <br>
                                A) Lo limpiaría.<br>
                                B) Le diría al licenciado que si lo manda limpiar.<br>
                                C) Le diría a la señora del aseo que lo haga.<br>
                                D) Me guardaría la pena y me quedaría callado.
                            </p>
                    </article>
                    <button id="btnInicioCuestionario">Iniciar</button>
                </div>
                <div id="preguntas">
                    <section>
                        <!--Encabezado-->
                        <div id="nombreTest">Test ZAVIC</div>
                        <div id="indicadorPregunta">Pregunta 10/25</div>
                    </section>
                    <section>
                        <!--Seccion de las preguntas y respuestas-->
                        <div id="preguntaActual" class="caja caja-sombra">Esta es la pregunta que se le hace al participante</div>
                        <div id="contenedorRespuestas">
                            <article id="prioridad">
                                <div id="p4">4</div>
                                <div id="p3">3</div>
                                <div id="p3">2</div>
                                <div id="p1">1</div>
                            </article>
                            <article id="articleRespuestas">
                                <div id="respuestas">
                                    <div class="respuesta" draggable="true">
                                        <div id="respuestaA">
                                            <p>A) Esta es la simulación de una respuesta.</p>
                                        </div>
                                    </div>
                                    <div class="respuesta" draggable="true">
                                        <div id="respuestaB">
                                            <p>B) Esta es la simulación de una respuesta.</p>
                                        </div>
                                    </div>
                                    <div class="respuesta" draggable="true">
                                        <div id="respuestaC">
                                            <p>C) Esta es la simulación de una respuesta.</p>
                                        </div>
                                    </div>
                                    <div class="respuesta" draggable="true">
                                        <div id="respuestaD">
                                            <p>D) Esta es la simulación de una respuesta.</p>
                                        </div>
                                    </div>
                                </div>
                            </article>
                        </div>
                    </section>
                    <div id="divBotones">
                        <button id="nextPregunta">Siguiente pregunta</button>
                        <a id="irPagInicio" href="<c:url value="/"/>">Ir inicio</a>
                    </div>
                </div>
            </section>
        </section>
        <footer>
            <div id="copyright">Sistemas de Información Geográfica SA de CV</div>
            <div id="contacto">Departamento de Recursos Humanos</div>
        </footer>
    </body>
</html>
