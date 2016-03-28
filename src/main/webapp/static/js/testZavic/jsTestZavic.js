/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.idPregAct='';

$(function() {
    //$("#instrucciones").css("display","none");
    $("#irPagInicio").css("display","none");
    $("#instrucciones").css("display","block");
    $("#preguntas").css("display","none");
    $("#btnInicioCuestionario").click(function(){
        $("#instrucciones").css("display","none");
        $("#preguntas").css("display","block");
        //$("#nextPregunta").trigger('click');
        //nextQuestion();
        enviarRespuestas();
    });
    $("#nextPregunta").click(function(){
        enviarRespuestas();
    });
    
});

//function nextQuestion(){
//    $.ajax({
//        type: "POST",
//        url: 'TestZavic/getNextPregunta',
//        data: '', //Parametro enviados a la acción
//        cache: false,
//        contentType: "application/json; charset=UTF-8",
//        success: function (datos) {
//            if(datos !== '' && datos !== null){
//                var pregunta = datos.pregunta;
//                window.idPregAct = datos.pregunta.idPregunta;
//                var resp1 = datos.respuesta1;
//                var resp2 = datos.respuesta2;
//                var resp3 = datos.respuesta3;
//                var resp4 = datos.respuesta4;
//                $("#preguntaActual").html(pregunta.descripcion);
//                $("#respuestaA").html("<p>" + resp1.descripcion + "</p>");
//                $("#respuestaB").html("<p>" + resp2.descripcion + "</p>");
//                $("#respuestaC").html("<p>" + resp3.descripcion + "</p>");
//                $("#respuestaD").html("<p>" + resp4.descripcion + "</p>");
//            }
//            else{
//                alert('El Test Zavic se ha terminado ');
//                var href = $('#irPagInicio')[0].href;
//                window.location.href = href; 
//            }
//        },
//        error: function (data) {
//            //En caso de error mostramos una ventan a de error.
//            alert('#msjError ' + data);
//        }
//    });
//}

function enviarRespuestas(){
    var solucion = new Object();
    var ordenSolucion = getRespuestasOrden();
    solucion.idPregunta = window.idPregAct;
    solucion.opc1 = ordenSolucion[0];
    solucion.opc2 = ordenSolucion[1];
    solucion.opc3 = ordenSolucion[2];
    solucion.opc4 = ordenSolucion[3];
    var objNames = new Array();
    objNames[0] = "idPregunta";
    objNames[1] = "opc1";
    objNames[2] = "opc2";
    objNames[3] = "opc3";
    objNames[4] = "opc4";
    var jsonObj = JSON.stringify(solucion, objNames, "\t");
    $.ajax({
        type: "POST",
        url: 'TestZavic/saveDatosPreguntaAcualGetNext',
        data: jsonObj,
        cache: false,
        contentType: "application/json; charset=UTF-8",
        success: function (datos) {
            //Reinicio los id's de los div's que contien a las preguntas
            ordernaDivRespuestas();
            
            if(datos !== '' && datos !== null){
                var pregunta = datos.pregunta;
                window.idPregAct = datos.pregunta.idPregunta;
                var resp1 = datos.respuesta1;
                var resp2 = datos.respuesta2;
                var resp3 = datos.respuesta3;
                var resp4 = datos.respuesta4;
                $("#preguntaActual").html(pregunta.descripcion);
                $("#respuestaA").html("<p>" + resp1.descripcion + "</p>");
                $("#respuestaB").html("<p>" + resp2.descripcion + "</p>");
                $("#respuestaC").html("<p>" + resp3.descripcion + "</p>");
                $("#respuestaD").html("<p>" + resp4.descripcion + "</p>");
            }
            else{
                alert('El Test Zavic se ha terminado ');
                var href = $('#irPagInicio')[0].href;
                window.location.href = href; 
            }
        },
        error: function (data) {
            alert("Error: " + data);
        }
    });
}

//función que me da los la letra de respuesta respectivas de la opción
function getRespuestasOrden(){
    var orden = new Array();
    $("#respuestas .respuesta").each(function (index, col) {
        var idR = $(col).find("div")[0].id;
        //optengo la letra (la ultima posiscion del nombre de id)
        orden[index] = (idR).charAt(idR.length - 1);
    });
    return orden;
}

//Función para ordenar los div's con sus id's correctos
function ordernaDivRespuestas() {
    var ordenCorr = "ABCD";
    $("#respuestas .respuesta").each(function (index, col) {
        var idD = $(col).find("div")[0].id;
        $(col).find("div")[0].id = (idD.replace(idD.charAt(idD.length - 1), ordenCorr.charAt(index)));
        alert((idD.replace(idD.charAt(idD.length - 1), ordenCorr.charAt(index))));
    });
}

/*Para el efecto de Drag and Drop*/

var dragSrcEl = null;
$(function () {
    //
    $("#respuestas.respuesta.over").css("background", "red");

    $("#respuestas .respuesta").each(function (index, col) {
        col.addEventListener('dragstart', handleDragStart, false);
        col.addEventListener('dragenter', handleDragEnter, false);
        col.addEventListener('dragover', handleDragOver, false);
        col.addEventListener('dragleave', handleDragLeave, false);
        col.addEventListener('drop', handleDrop, false);
        col.addEventListener('dragend', handleDragEnd, false);
    });
    $("#accion").click(function () {
        $("#respuestas .respuesta").each(function (index, col) {
            alert(($(col).find("div")[0].id));
        });
    });
    $("#ordenar").click(function () {
        ordernaDivRespuestas();
    });
});

function ordernaDivRespuestas() {
    $("#respuestas .respuesta").each(function (index, col) {
        $(col).find("div")[0].id = getLetraIndice(index + 1);
    });
}

function getLetraIndice(indice) {
    switch (parseInt(indice)) {
        case 1:
            return "respuestaA";
            break;
        case 2:
            return "respuestaB";
            break;
        case 3:
            return "respuestaC";
            break;
        case 4:
            return "respuestaD";
            break;
    }
}

function handleDragStart(e) {
    this.style.opacity = '0.6';  // Opacidad del elemento al iniciar el arrastre.
    this.classList.add('moving');//Agrego la clase que escala el elemnto
    //$(this).find("div").parent().css("backgroud","red");
    dragSrcEl = this;
    e.dataTransfer.effectAllowed = 'move';
    e.dataTransfer.setData('text/html', this.innerHTML);
}

function handleDragOver(e) {
    if (e.preventDefault) {
        e.preventDefault(); // Impedir el comportamiento predeterminado del navegador
    }
    e.dataTransfer.dropEffect = 'move';  // See the section on the DataTransfer object.
    return false;
}

function handleDragEnter(e) {
    // this / e.target is the current hover target.
    this.classList.add('over');

}

function handleDragLeave(e) {
    this.classList.remove('over');  // this / e.target is previous target element.
}

function handleDrop(e) {
    // this / e.target is current target element.
    if (e.stopPropagation) {
        e.stopPropagation(); // stops the browser from redirecting.
    }
    // See the section on the DataTransfer object.
    // Don't do anything if dropping the same respuesta we're dragging.
    if (dragSrcEl !== this) {
        // Set the source respuesta's HTML to the HTML of the columnwe dropped on.
        dragSrcEl.innerHTML = this.innerHTML;
        this.innerHTML = e.dataTransfer.getData('text/html');
    }
    return false;
}

function handleDragEnd(e) {
    // this/e.target is the source node.
    this.style.opacity = '1';
    this.classList.remove('moving');//Elimino la clase que escala el elemnto
    $("#respuestas .respuesta").each(function (index, col) {
        col.classList.remove('over');
    });
}