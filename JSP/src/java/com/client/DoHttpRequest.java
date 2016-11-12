/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import static javax.servlet.SessionTrackingMode.URL;

/**
 *
 * @author afp
 */
public class DoHttpRequest {
    private static DoHttpRequest addr = null;
    
    private DoHttpRequest() {
        
    }
    
    public static DoHttpRequest instance() {
        if(addr == null) {
            addr = new DoHttpRequest();
        }
        
        return addr;
    }
    
    public String executePost(String targetURL, String urlParameters) {
        HttpURLConnection connection = null;
        
        try {
            //Create connection
            URL url;
            url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length", Integer.toString(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");  
            connection.setUseCaches(false);
            connection.setDoOutput(true);

            try (DataOutputStream wr = new DataOutputStream (connection.getOutputStream())) {
                wr.writeBytes(urlParameters);
            }

            //Get Response  
            InputStream is = connection.getInputStream();
            StringBuilder response;
            try (BufferedReader rd = new BufferedReader(new InputStreamReader(is))) {
                response = new StringBuilder(); // or StringBuffer if Java version 5+
                String line;
                while ((line = rd.readLine()) != null) {
                    response.append(line);
                }
            } // or StringBuffer if Java version 5+
            return response.toString();
        } catch (IOException e) {
            return null;
        } 
    }
}
