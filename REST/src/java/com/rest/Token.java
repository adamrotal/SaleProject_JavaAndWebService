/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest;

import java.util.Random;

/**
 *
 * @author afp
 */
public class Token {
    static private Token addr = null;
    static private final int PANJANG = 15;
    
    private Token() {
        
    }
    
    static public Token instance() {
        if(addr == null) {
            addr = new Token();
        }
        
        return addr;
    }
    
    public boolean isValidToken(String token) {
        
        return false;
    }
    
    public String generateToken(String email) {
        String seed = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxz1234567890";
        String token = "";
        Random rand = new Random();
        int ind;
        
        do{
            token = "";
            for(int i = 0; i < PANJANG; i++) {
                ind = rand.nextInt(seed.length());
                token = token + seed.charAt(ind);
            }
        } while (isValidToken(token));
        
        
        
        return token;
    }
    
}
