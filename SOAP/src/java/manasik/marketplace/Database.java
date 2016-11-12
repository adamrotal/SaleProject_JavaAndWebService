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
    
    static private List<Map<String, String>> getAttribut(ResultSet resultSet) throws SQLException {
        List<Map<String, String>> result = new ArrayList<>();
        
        while(resultSet.next()){
            Map<String,String> map = new HashMap<String, String>();
            map.put("id",resultSet.getString("id"));
            map.put("usernamePenjual", "ffff");
            map.put("tanggalDiTambah", resultSet.getString("tanggalDiTambah"));
            map.put("name", resultSet.getString("name"));
            map.put("price", resultSet.getString("price"));
            map.put("description", resultSet.getString("description"));
            map.put("gambar", resultSet.getString("gambar"));
            map.put("nLike", "1");
            map.put("nSales", "2");
            map.put("liked", "1");
            
            result.add(map);
            
        }
        
        return result;
    }
    
    static public List<Map<String, String>> getListCatalog() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM produk WHERE deleted = false ORDER BY id DESC ";
        ResultSet resultSet = selectFromDb(sql);
        return getAttribut(resultSet);
    }
}
