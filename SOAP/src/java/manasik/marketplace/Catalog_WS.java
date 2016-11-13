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
import java.util.List;
import java.util.Map;
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
     * @param token
     * @return 
     * @throws java.lang.ClassNotFoundException 
     * @throws java.sql.SQLException 
     */
    @WebMethod(operationName = "getCatalog")
    @WebResult(name="String")
    public List<String> getCatalog(@WebParam(name = "token") String token) throws ClassNotFoundException, SQLException {   
        return Database.getListCatalog("1");
    }
    
    /**
     * Web service operation
     * @param keyword
     * @param category
     * @param id
     * @return 
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    @WebMethod(operationName = "searchCatalog")
    @WebResult(name="String")
    public List<String> searchCatalog(@WebParam(name = "keyword") String keyword, @WebParam(name = "category") String category, @WebParam(name = "id") String id) throws ClassNotFoundException, SQLException {
        return Database.getListSearchCatalog(id,keyword,category);
    }
}