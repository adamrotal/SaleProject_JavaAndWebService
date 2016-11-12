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
@WebService(serviceName = "YourProduct_WS")
public class YourProduct_WS {

    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
    static final String DB_URL="jdbc:mysql://localhost:3306/tubes_wbd?zeroDateTimeBehavior=convertToNull";

    //  Database credentials
    static final String USER = "kuliah";
    static final String PASS = "kuliah";
    
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "getCatalog")
    @WebResult(name="Data_produk")
     public ArrayList<Data_produk> getProducts(@WebParam(name = "id") int id_penjual) {
        
        
        return null;
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
        
    }

    /**
     * Web service operation
     */
    public String deleteProduct() {
        //TODO write your implementation code here:
        return null;
    }
}
