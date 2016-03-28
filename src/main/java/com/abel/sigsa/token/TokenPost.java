/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abel.sigsa.token;

/**
 *
 * @author macpro
 */
public class TokenPost {
    private String strToken;
    
    public TokenPost(){
        generarToken();
    }

    public String getStrToken() {
        return strToken;
    }

    public void setStrToken(String strToken) {
        this.strToken = strToken;
    }
    
    public void nextToken(){
        generarToken();
    }
    
    private void generarToken(){
        this.strToken = "ToKenAbel"+String.valueOf((int)(Math.random() * 1000));
    }
}
