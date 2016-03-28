/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abel.sigsa.controller;

import com.abel.sigsa.clases.PreguntaRespuesta;
import com.abel.sigsa.clases.SolucionPreguntaZavic;
import com.abel.sigsa.clases.TestZavic;
import com.abel.sigsa.daoimp.PreguntaDaoImp;
import com.abel.sigsa.domine.Pregunta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * @author macpro
 */
@Controller
@RequestMapping("/TestZavic")
public class TestZavicController {
    @Autowired
    PreguntaDaoImp preguntaQuery;
    
    ServletRequestAttributes session;
    //Regreso la vista cuando se haga la peticion a la raiz de controlador
    @RequestMapping(value={"/",""}, method=RequestMethod.GET)
    public String inicio(){
        //Cuando se hace por primera vez la petición por GET se hace la creación del objeto de control de preguntas del test zavic
        session = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        TestZavic tz = new TestZavic();
        session.setAttribute("testZavic", tz, 1);
        return "testZavic/testZavic";
    }
    
//    @RequestMapping(value="/getNextPregunta", method=RequestMethod.POST)
//    public @ResponseBody PreguntaRespuesta getNextQuestion(){
//        try{
//            //Obtengo la pregunta actual
//            int preguntaActual = ((TestZavic)(session.getAttribute("testZavic", 1))).getIdPreguntaActual();
//            if(preguntaActual < 21){
//                PreguntaRespuesta pr = new PreguntaRespuesta();
//                Pregunta p = new Pregunta();
//                Respuesta r1 = new Respuesta();
//                Respuesta r2 = new Respuesta();
//                Respuesta r3 = new Respuesta();
//                Respuesta r4 = new Respuesta();
//                p.setIdPregunta(preguntaActual);
//                p.setDescripcion("Si Luis llega a su casa y observa que le están robando las llantas al automóvil de su vecino:");
//                r1.setIdPregunta(preguntaActual);
//                r1.setIdRespuesta(1);
//                r1.setInciso('A');
//                r1.setDescripcion("Llamaría a la policia.");
//
//                r2.setIdPregunta(preguntaActual);
//                r2.setIdRespuesta(2);
//                r2.setInciso('B');
//                r2.setDescripcion("Llamaría a su vecino.");
//
//                r3.setIdPregunta(preguntaActual);
//                r3.setIdRespuesta(3);
//                r3.setInciso('C');
//                r3.setDescripcion("Pediría parte del veneficio que obtendrán en el robo, por guardar silencio.");
//
//                r4.setIdPregunta(preguntaActual);
//                r4.setIdRespuesta(4);
//                r4.setInciso('D');
//                r4.setDescripcion("Mejor no haría nada y se metería a su casa.");
//
//                pr.setPregunta(p);
//                pr.setRespuesta1(r1);
//                pr.setRespuesta2(r2);
//                pr.setRespuesta3(r3);
//                pr.setRespuesta4(r4);
//                return pr;
//            }
//            else{
//                //El cuestionario se ha terminado
//                //Elimino el objeto TestZavic de ala sesion
//                session.removeAttribute("testZavic", 1);
//                //Le envio decir al usuario que se ha conluido este test
//                return null;
//            }
//            
//        }
//        catch(Exception a){
//            //El test se ha terminado
//            return null;
//        }
//    }
//    
//    @RequestMapping(value = "/saveDatosPreguntaAcual", method = RequestMethod.POST)
//    @ResponseBody
//    public String saveDatos(@RequestBody SolucionPreguntaZavic datos){
//        try{
//            //Obtengo la pregunta actual
//            int preguntaActual = ((TestZavic)(session.getAttribute("testZavic", 1))).getIdPreguntaActual();
//            //Se obtendrá el usuario de la sesión para hacer el insert en la base de datos
//            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//            String name = auth.getName(); //get logged in username
//            System.out.println("Esta en el server: " +preguntaActual+ " enviado del cliente: "+datos.getIdPregunta() + " " + datos.getOpc1() + " " + datos.getOpc2() + " " + datos.getOpc3() + " " + datos.getOpc4() + " usuario logeado: " + name);
//
//            
//            
//            
//            
//            
//            
//            
//            
//            
//            //Al final incremento el número de la pregunta
//            //Hago avanzar de pregunta en el objeto que esta guardado en sesion
//            ((TestZavic)(session.getAttribute("testZavic", 1))).setIdPreguntaActual(preguntaActual + 1);
//            return "hecho";
//        }
//        catch(NullPointerException s){
//            //Se ha terminado el test
//            return "";
//        }
//    }
//    
    
    @RequestMapping(value = "/saveDatosPreguntaAcualGetNext", method = RequestMethod.POST)
    @ResponseBody
    public PreguntaRespuesta saveDatosGetNext(@RequestBody SolucionPreguntaZavic datos){
        try{
            PreguntaRespuesta pr = new PreguntaRespuesta();
            //Obtengo la pregunta actual
            int preguntaActual = ((TestZavic)(session.getAttribute("testZavic", 1))).getIdPreguntaActual();
            if(preguntaActual < 22){
                if(preguntaActual != 1){
                    //Se inserta en la base de datos la informacion
                    //Se obtendrá el usuario de la sesión para hacer el insert en la base de datos
                    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                    String name = auth.getName(); //get logged in username
                    System.out.println("Next en el server: " +preguntaActual+ " enviado del cliente actual: "+datos.getIdPregunta() + " " + datos.getOpc1() + " " + datos.getOpc2() + " " + datos.getOpc3() + " " + datos.getOpc4() + " usuario logeado: " + name);

                }
                //Hago avanzar de pregunta en el objeto que esta guardado en sesion
                ((TestZavic)(session.getAttribute("testZavic", 1))).setIdPreguntaActual(preguntaActual + 1);
                //se lee de la base de datos la siguiente pregunta
//                Pregunta p = new Pregunta();
//                Respuesta r1 = new Respuesta();
//                Respuesta r2 = new Respuesta();
//                Respuesta r3 = new Respuesta();
//                Respuesta r4 = new Respuesta();
//                p.seti(preguntaActual);
//                p.setDescripcion("Si Luis llega a su casa y observa que le están robando las llantas al automóvil de su vecino:");
//                r1.setIdPregunta(preguntaActual);
//                r1.setIdRespuesta(1);
//                r1.setInciso('A');
//                r1.setDescripcion("Llamaría a la policia.");
//
//                r2.setIdPregunta(preguntaActual);
//                r2.setIdRespuesta(2);
//                r2.setInciso('B');
//                r2.setDescripcion("Llamaría a su vecino.");
//
//                r3.setIdPregunta(preguntaActual);
//                r3.setIdRespuesta(3);
//                r3.setInciso('C');
//                r3.setDescripcion("Pediría parte del veneficio que obtendrán en el robo, por guardar silencio.");
//
//                r4.setIdPregunta(preguntaActual);
//                r4.setIdRespuesta(4);
//                r4.setInciso('D');
//                r4.setDescripcion("Mejor no haría nada y se metería a su casa.");
//
//                pr.setPregunta(p);
//                pr.setRespuesta1(r1);
//                pr.setRespuesta2(r2);
//                pr.setRespuesta3(r3);
//                pr.setRespuesta4(r4);
//                return pr;
                Pregunta p = preguntaQuery.findPreguntaId(2);
                System.out.println(p.getDescripcion());
            }
            else{
                //El cuestionario se ha terminado
                //Elimino el objeto TestZavic de ala sesion
                session.removeAttribute("testZavic", 1);
                //Le envio decir al usuario que se ha conluido este test
                return null;
            }
            return pr;
        }
        catch(NullPointerException s){
            //Se ha terminado el test
            return null;
        }
    }
}
