/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manasik.marketplace;

import java.sql.SQLException;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Rotal
 */
@WebService(serviceName = "Sales_WS")
public class Sales_WS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     * @param id
     * @return 
     * @throws java.lang.ClassNotFoundException 
     * @throws java.sql.SQLException 
     */
    @WebMethod(operationName = "getListSales")
    public List<String> getListSales(@WebParam(name = "id") String id) throws ClassNotFoundException, SQLException {
        return Database.getListSales(id);
    }

    /**
     * Web service operation
     * @param id
     * @return 
     * @throws java.lang.ClassNotFoundException 
     * @throws java.sql.SQLException 
     */
    @WebMethod(operationName = "getListPurchases")
    public List<String> getListPurchases(@WebParam(name = "id") String id) throws ClassNotFoundException, SQLException {
        return Database.getListPurchases(id);
    }
}
