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
    private static final String URL = "jdbc:mysql://localhost:3306/marketplace?zeroDateTimeBehavior=convertToNull";
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
    
    static private int getNumsRow(ResultSet resultSet) throws SQLException {
        int count = 0;
        while (resultSet.next()) {
            ++count;
        }
        
        return count;
    }
    
    static private List<String> getAttribut(ResultSet resultSet,String id) throws SQLException, ClassNotFoundException {
        List<String> result = new ArrayList<>();
        
        while(resultSet.next()){
            result.add("id");
            result.add(resultSet.getString("id"));
            result.add("usernamePenjual");
            result.add(resultSet.getString("namaPenjual"));
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
            int nLike = getNlike(resultSet.getString("id"));
            result.add(String.valueOf(nLike));
            result.add("nSales");
            int nSales = getNSales(resultSet.getString("id"));
            result.add(String.valueOf(nSales));
            result.add("liked");
            result.add(getLiked(id,resultSet.getString("id")));
            
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
    
    static public List<String> getListYourProduct(String id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM produk WHERE (idPenjual="+id+") AND (deleted = false) ORDER BY id DESC";
        ResultSet resultSet = selectFromDb(sql);
        return getAttribut(resultSet,id);
    }
    
    static public List<String> getListSales(String id) throws ClassNotFoundException, SQLException {
        List<String> result = new ArrayList<>();
        String sql = "SELECT * FROM sales WHERE idPenjual = "+id+" ORDER BY id DESC";
        ResultSet resultSet = selectFromDb(sql);
        while(resultSet.next()) {
            result.add("tanggal");
            result.add(resultSet.getString("tanggalDiBeli"));
            result.add("gambar");
            result.add("gambar");//perlu dirubah
            result.add("nameProduk");
            result.add("nameProduk");//perlu diubah
            result.add("totalPrice");
            String totalPrice = String.valueOf(resultSet.getInt("kuantitas") * resultSet.getInt("hargaSatuan"));
            result.add(totalPrice);
            result.add("kuantitas");
            result.add(resultSet.getString("kuantitas"));
            result.add("price");
            result.add(resultSet.getString("hargaSatuan"));
            result.add("username");
            result.add(resultSet.getString("usernamePembeli"));
            result.add("namaPembeli");
            result.add(resultSet.getString("namaPembeli"));
            result.add("fullAddress");
            result.add(resultSet.getString("fullAddress"));
            result.add("postalCode");
            result.add(resultSet.getString("postalCode"));
            result.add("phoneNumber");
            result.add(resultSet.getString("phoneNumber"));
        }
        return result;
    }
    
    static private int getNlike(String idProduk) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM liked WHERE idProduk = "+idProduk;
        ResultSet resultSet = selectFromDb(sql);
        return getNumsRow(resultSet);
    }
    
    static private int getNSales(String idProduk) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM sales WHERE idProduk = "+idProduk;
        ResultSet resultSet = selectFromDb(sql);
        return getNumsRow(resultSet);
    }
    
    static private String getLiked(String idUser,String idProduk) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM liked WHERE idProduk = "+idProduk+" AND idUser = "+idUser;
        ResultSet resultSet = selectFromDb(sql);
        int liked = getNumsRow(resultSet);
        return String.valueOf(liked);
    }
}
