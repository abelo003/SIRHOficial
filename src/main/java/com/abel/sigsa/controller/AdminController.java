/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abel.sigsa.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author macpro
 */
@Controller
@RequestMapping("/Admin")
@PreAuthorize("hasRole('ROLE_ADMIN')")//Verifico nuevamente que el rol de usuario que intenta ingresar al controlador es un Admin
public class AdminController {
    @RequestMapping(value = {"/",""}, method=RequestMethod.GET)
    public String hola(){
        //Se retorna la vista de administrador
        return "admin";
    }
}
