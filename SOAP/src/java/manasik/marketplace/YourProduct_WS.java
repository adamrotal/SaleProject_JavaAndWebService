/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manasik.marketplace;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Rotal
 */
@WebService(serviceName = "YourProduct_WS")
public class YourProduct_WS {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/onlineshop?zeroDateTimeBehavior=convertToNull";
    private static final String USER = "kuliah";
    private static final String PASS = "kuliah";
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "getProduct")
    public ArrayList<String> getProducts(@WebParam(name = "id") int id_penjual) {
        ArrayList<String> result = new ArrayList<String>();
        
        try{
            
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // Open a connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            // Execute SQL query
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM produk WHERE (idPenjual = ?) AND (deleted = 0) ORDER BY id DESC";
            
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1,id_penjual);
            
            ResultSet rs = pre.executeQuery();
            
            while(rs.next()){
                result.add(rs.getString("id"));
                result.add(rs.getString("idPenjual"));
                result.add(rs.getString("name"));
                result.add(rs.getString("description"));
                result.add(rs.getString("price"));
                result.add(rs.getString("gambar"));
                result.add(rs.getString("tanggalDiTambah"));
                result.add(rs.getString("namaPenjual"));
                result.add(rs.getString("deleted"));
            }
           
            rs.close();
            stmt.close();
            
        }catch(SQLException | ClassNotFoundException se){
            //Handle errors for JDBC

        }
        //Handle errors for Class.forName
        finally{
       
        }
        
        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editProduct")
    public void editProduct(@WebParam(name = "product_id") int prod_id,
            @WebParam(name = "name") String name, 
            @WebParam(name = "desc") String desc,
            @WebParam(name = "harga") int harga)
    { 
        try{       
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // Open a connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            // Execute SQL query
            Statement stmt = conn.createStatement();
            String sql;
            sql = "UPDATE produk SET name = ?, description = ?, price = ? WHERE id = ?";
            
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1,prod_id);
            pre.setString(2,name);
            pre.setString(3,desc);
            pre.setInt(4,harga);
            
            
            ResultSet rs = pre.executeQuery();
            
            rs.close();
            stmt.close();
            
        }catch(SQLException | ClassNotFoundException se){
            //Handle errors for JDBC

        }
        //Handle errors for Class.forName
        finally{
       
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteProduct")
    public void deleteProduct(@WebParam(name = "product_id") int prod_id) {
        try{       
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // Open a connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            // Execute SQL query
            Statement stmt = conn.createStatement();
            String sql;
            sql = "UPDATE produk SET deleted = true WHERE id = ?";
            
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1,prod_id);
            
            ResultSet rs = pre.executeQuery();
            
            rs.close();
            stmt.close();
            
        }catch(SQLException | ClassNotFoundException se){
            //Handle errors for JDBC

        }
        //Handle errors for Class.forName
        finally{
       
        }
    }
}
