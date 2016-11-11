/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest;
import java.sql.* ;  

/**
 *
 * @author afp
 */
public class Database {
    private final String URL = "jdbc:mysql://localhost:3306/onlineshop?zeroDateTimeBehavior=convertToNull";
    private final String USER = "kuliah";
    private final String PASS = "kuliah";
    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static Database addr = null;
    
    private Database() {
    
    }
    
    public static Database instance() {
        if(addr == null) {
            addr = new Database();
        }
        
        return addr;
    }
    
    private ResultSet insertToDb(String sql) throws ClassNotFoundException, SQLException {
        // Creating Connection
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(URL, USER, PASS);
        
        // Creating statement
        Statement statement = connection.createStatement();
        
        return statement.executeQuery(sql); 
    }
    
    public void insertToken(String token, long waktu, String key) throws ClassNotFoundException, SQLException {
        String sql;
        sql = "UPDATE user SET token="+token+", tanggalExp="+waktu+" WHERE email="+key+" OR username="+key;
        ResultSet resultSet = insertToDb(sql);
    }
}
