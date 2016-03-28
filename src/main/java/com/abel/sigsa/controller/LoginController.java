/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abel.sigsa.controller;

import com.abel.sigsa.token.TokenPost;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author macpro
 */
@Controller
public class LoginController {
    
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String paginaInicio(){
        return "inicio";
    }
    
    @RequestMapping(value = "/login")
    public ModelAndView login() {
        ModelAndView model = new ModelAndView();
        model.setViewName("login");
        return model;
    }
    
    @RequestMapping(value="/error403")
    public String error403(Model model){
        model.addAttribute("error", "No tienes permisos para acceder al contenido");
        return "error/error";
    }
    
}
