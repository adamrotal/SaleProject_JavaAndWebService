/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manasik.marketplace;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

/**
 *
 * @author Rotal
 */
public class DB {
    private static final String URL = "jdbc:mysql://localhost:3306/onlineshop?zeroDateTimeBehavior=convertToNull";
    private static final String USER = "kuliah";
    private static final String PASS = "kuliah";
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    
    static public void updateToDb(String sql) throws ClassNotFoundException, SQLException {
        // Creating Connection
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(URL, USER, PASS);
        
        // Creating statement
        Statement statement = connection.createStatement();
        
        int executeUpdate = statement.executeUpdate(sql); 
    }

    static public ResultSet selectFromDB(String sql) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(URL, USER, PASS);
        
        // Creating statement
        Statement statement = connection.createStatement();
        
        return statement.executeQuery(sql);
    }
}
