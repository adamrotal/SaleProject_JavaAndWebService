/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest;

// import java.sql.SQLException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author afp
 */
public class TokenGenerator {
    static private TokenGenerator addr = null;
    static private final int PANJANG = 15;
    
    public boolean isValidToken(String token) {
        
        return true;
    }
    
    static public String generateToken(String key) throws ClassNotFoundException, SQLException {
        String seed = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxz1234567890";
        String token;
        Random rand = new Random();
        int ind;
        System.out.println(key);
        do{
            token = "";
            for(int i = 0; i < PANJANG; i++) {
                ind = rand.nextInt(seed.length()-1);
                token = token + seed.charAt(ind);
            }
        } while (false);// isValidToken(token));
        
        Date date = new Date();
        long ms;
        ms = date.getTime();
        ms = ms + menitKeMs(10);
        Database.insertToken(token, ms, key);
        
        
        return token;
    }
    
    static private int menitKeMs(int menit) {
        return menit * 60 * 1000;
    }
    
}
