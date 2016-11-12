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
       
    /**
     * This is a sample web service operation
     * @param id
     * @return 
     */
    @WebMethod(operationName = "getCatalog")
    public ArrayList<String> getCatalog(@WebParam(name = "id") int id) throws SQLException, ClassNotFoundException {
    
        ArrayList<String> result = new ArrayList<String>();
        try {

            String sql = "SELECT * FROM produk WHERE deleted = 0 ORDER BY id DESC";

            ResultSet rs = DB.selectFromDB(sql);

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
            
        } catch(SQLException | ClassNotFoundException se){
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
    @WebMethod(operationName = "searchCatalog")
    @WebResult(name="String")
    public ArrayList<String> searchCatalog(@WebParam(name = "keyword") String keyword, @WebParam(name = "category") String category, @WebParam(name = "id") int user_id) {
        
        ArrayList<String> result = new ArrayList<String>();
        try {
            String sql;
            if (category.equals("product")) {
                sql = "SELECT * FROM produk WHERE (name LIKE ?) AND (deleted = 0) ORDER BY id DESC";
            }
            else { //searchMethod store
                sql = "SELECT product.product_id, product.username, product.product_name, product.price, product.description, product.total_likes, product.total_purchased, product.image_address, product.timestamp, (SELECT count(1) FROM like_data WHERE like_data.product_id = product.product_id AND user_id = ?) AS liked FROM product WHERE username LIKE ? AND deleted = 0";
            }
           
            ResultSet rs = DB.selectFromDB(sql);
            
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
             
        } catch(SQLException | ClassNotFoundException se){
            //Handle errors for JDBC
        }
        //Handle errors for Class.forName
        finally{
            
        }
        
        return result;
    }
}