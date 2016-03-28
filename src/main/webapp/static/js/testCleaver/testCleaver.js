/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function(){
    
    $("#articleRespuestas .respuesta").each(function(index, col){
        col.addEventListener('dragstart', handleDragStart, false);
//        col.addEventListener('dragenter', handleDragEnter, false);
//        col.addEventListener('dragover', handleDragOver, false);
//        col.addEventListener('dragleave', handleDragLeave, false);
//        col.addEventListener('drop', handleDrop, false);
        col.addEventListener('dragend', handleDragEnd, false);
    });
    
});


//function allowDrop(ev) {
//    ev.preventDefault();
//}

function drag(ev) {
    ev.dataTransfer.setData("text/html", ev.target.id);
}

function drop(ev) {
    ev.preventDefault();
    var data=ev.dataTransfer.getData("text/html");
    var claseBase = 'moreless';
    alert(ev.target.className);
    //Verifico que la clase del div contenedor sea sobre quien se quiera transferir el contendio
    if(ev.target.className.indexOf(claseBase) > -1){
        if(verifChild(claseBase, document.getElementById(data).id)){
            var nodeCopy = document.getElementById(data).cloneNode(true);
          //  nodeCopy.id = "myId"; /* We cannot use the same ID */
            $(nodeCopy).css({
                'border':'1px solid rgba(0,0,0,0.5)',
                'background-image':'none',
                'background':'transparent',
                'line-height': 'normal',
                'padding': '10px',
                'cursor': 'auto',
                'width':$("#"+ev.target.id).width()+'px',
                'height':$("#"+ev.target.id).height()+'px',
                'opacity' : '1',
                'transform': 'scale(1)'
            });
            $(nodeCopy).removeAttr('draggable');
            $(nodeCopy).removeAttr('ondragstart');
            //Elimino los elementos que esten dentro actualmente
            $(ev.target).empty();
//            $(ev.target).css('border-color','transparent');
            ev.target.appendChild(nodeCopy);
        }
        else{
            alert("No puedes agregar dos veces la misma respuesta.");
        }
    }
}

function verifChild(clase, idNow){
    var valor = true;
    $("."+clase).each(function( index ) {
        $("#"+$($("#"+$(this).attr("id"))).attr("id")).find("div.respuesta").each(function( index ) {
            if($( this ).attr("id") === idNow){
                valor = false;
                return false;
            }
        });
    });
    return valor;
}

function handleDragStart(e) {
    this.style.opacity = '0.6';  // Opacidad del elemento al iniciar el arrastre.
    this.classList.add('moving');//Agrego la clase que escala el elemnto
    //Agrego la función Hover al div
//    $( "#contenedorResp .moreless" ).hover(function() {
//        $(this).addClass("hovermoreless");
//    });
//    $("#contenedorResp .moreless").each(function (index, col) {
//        col.classList.add('hovermoreless');
//    });
    //$(this).find("div").parent().css("backgroud","red");
//    dragSrcEl = this;
//    e.dataTransfer.effectAllowed = 'move';
//    e.dataTransfer.setData('text/html', this.innerHTML);
}

//function handleDragOver(e) {
//    if (e.preventDefault) {
//        e.preventDefault(); // Impedir el comportamiento predeterminado del navegador
//    }
////    e.dataTransfer.dropEffect = 'move';  // See the section on the DataTransfer object.
//    e.target.classList.add('hovermoreless');
//    return false;
//}

function handleDragEnd(e) {
    // this/e.target is the source node.
    this.style.opacity = '1';
    this.classList.remove('moving');//Elimino la clase que escala el elemnto
    $("#contenedorResp .moreless").each(function (index, col) {
        col.classList.remove('hovermoreless');
    });
}

function handleDragEnter(e) {
    e.target.classList.add('hovermoreless');
}

function handleDragLeave(e) {
    e.target.classList.remove('hovermoreless');  // this / e.target is previous target element.
}