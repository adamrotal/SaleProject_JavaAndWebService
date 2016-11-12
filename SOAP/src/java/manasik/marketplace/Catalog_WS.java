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
import javax.jws.WebResult;

/**
 *
 * @author Rotal
 */
@WebService(serviceName = "Catalog_WS")
public class Catalog_WS {
    
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
    static final String DB_URL="jdbc:mysql://localhost:3306/tubes_wbd?zeroDateTimeBehavior=convertToNull";

    //  Database credentials
    static final String USER = "kuliah";
    static final String PASS = "kuliah";
    
    /**
     * This is a sample web service operation
     * @param id
     * @return 
     */
    @WebMethod(operationName = "getCatalog")
    @WebResult(name="String")
    public ArrayList<String> getCatalog(@WebParam(name = "id") int id) throws SQLException, ClassNotFoundException {
    
        ArrayList<String> result = new ArrayList<String>();
    
        Class.forName("com.mysql.jdbc.Driver");        
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        
        Statement stmt = conn.createStatement();
        String sql;
        sql = "SELECT * FROM produk WHERE deleted = 0 ORDER BY id DESC";
        
        PreparedStatement pre = conn.prepareStatement(sql);
//        pre.setInt(1,user_id);
        
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
        
        return result;
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "searchCatalog")
    @WebResult(name="String")
    public ArrayList<String> searchCatalog(@WebParam(name = "keyword") String keyword, @WebParam(name = "category") String category, @WebParam(name = "id") int user_id) {
        
        ArrayList<String> result = new ArrayList<String>();
        try {
            Class.forName("com.mysql.jdbc.Driver");        
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            // Execute SQL query
            Statement stmt = conn.createStatement();
            String sql;
            
            if (category.equals("product")) {
                sql = "SELECT * FROM produk WHERE (name LIKE ?) AND (deleted = 0) ORDER BY id DESC";
            }
            else { //searchMethod store
                sql = "SELECT product.product_id, product.username, product.product_name, product.price, product.description, product.total_likes, product.total_purchased, product.image_address, product.timestamp, (SELECT count(1) FROM like_data WHERE like_data.product_id = product.product_id AND user_id = ?) AS liked FROM product WHERE username LIKE ? AND deleted = 0";
            }
           
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, "%" + keyword + "%");
            
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
        } catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
       
        }
        return result;
    }
}