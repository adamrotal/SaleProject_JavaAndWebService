package manasik.marketplace;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/onlineshop?zeroDateTimeBehavior=convertToNull";
    private static final String USER = "kuliah";
    private static final String PASS = "kuliah";
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    
    static private void updateToDb(String sql) throws ClassNotFoundException, SQLException {
        // Creating Connection
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(URL, USER, PASS);
        
        // Creating statement
        Statement statement = connection.createStatement();
        
        int executeUpdate = statement.executeUpdate(sql); 
    }
    
    static private ResultSet selectFromDb(String sql) throws ClassNotFoundException, SQLException {
        // Creating Connection
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(URL, USER, PASS);
        
        // Creating statement
        Statement statement = connection.createStatement();
        
        return statement.executeQuery(sql); 
    }
    
    static private List<String> getAttribut(ResultSet resultSet,String id) throws SQLException {
        List<String> result = new ArrayList<>();
        
        while(resultSet.next()){
            result.add("id");
            result.add(resultSet.getString("id"));
            result.add("usernamePenjual");
            result.add("ffff");
            result.add("tanggalDiTambah");
            result.add(resultSet.getString("tanggalDiTambah"));
            result.add("name");
            result.add(resultSet.getString("name"));
            result.add("price");
            result.add(resultSet.getString("price"));
            result.add("description");
            result.add(resultSet.getString("description"));
            result.add("gambar");
            result.add(resultSet.getString("gambar"));
            result.add("nLike");
            result.add("1");
            result.add("nSales");
            result.add("1");
            result.add("liked");
            result.add("1");
            
        }
        
        return result;
    }
    
    static public List<String> getListCatalog(String id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM produk WHERE deleted = false ORDER BY id DESC ";
        ResultSet resultSet = selectFromDb(sql);
        return getAttribut(resultSet,id);
    }
    
    static public List<String> getListSearchCatalog(String id,String keyword,String category) throws ClassNotFoundException, SQLException {
        String sql;
        if(category.equals("product")) {
            sql = "SELECT * FROM produk WHERE (name LIKE '%"+keyword+"%') AND (deleted = false) ORDER BY id DESC";
        } else {
            sql = "SELECT * FROM produk WHERE (namaPenjual LIKE '%"+keyword+"%') AND (deleted = false) ORDER BY id DESC";
        }
        ResultSet resultSet = selectFromDb(sql);
        return getAttribut(resultSet,id);
    }
}
