/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest;

import java.sql.SQLException;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author afp
 */
public class Token {
    static private Token addr = null;
    static private Database database = null;
    private final int PANJANG = 15;
    
    private Token() {
        
    }
    
    static public Token instance() {
        if(addr == null) {
            addr = new Token();
            database = Database.instance();
        }
        
        return addr;
    }
    
    public boolean isValidToken(String token) {
        
        return true;
    }
    
    public String generateToken(String key) throws ClassNotFoundException, SQLException {
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
        } while (false);// isValidToken(token));
        
        Date date = new Date();
        long ms;
        ms = date.getTime();
        ms = ms + menitKeMs(10);
        database.insertToken(token, ms, key);
        return token;
    }
    
    private int menitKeMs(int menit) {
        return menit * 60 * 1000;
    }
    
}
