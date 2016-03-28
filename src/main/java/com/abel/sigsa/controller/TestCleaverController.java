/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abel.sigsa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author macpro
 */
@Controller
@RequestMapping("/TestCleaver")
public class TestCleaverController {
    
    @RequestMapping(value={"/",""})
    public String inicio(){
        return "testCleaver/testCleaver";
    }
}
