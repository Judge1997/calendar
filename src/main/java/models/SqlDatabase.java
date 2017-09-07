package models;

import java.sql.*;

public class SqlDatabase {

    private Connection connect;

    public SqlDatabase() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        String dbURL = "jdbc:sqlite:bookstore.db";
        connect = DriverManager.getConnection(dbURL);
        if(connect != null){
            System.out.println("Connected to Database...");
        }
    }


//    public static void main(String[] args){
//        try {
//            // setup
//            Class.forName("org.sqlite.JDBC");
//            String dbURL = "jdbc:sqlite:bookstore.db";
//            conn = DriverManager.getConnection(dbURL);
//            if (conn != null) {
//                System.out.println("Connected to the database....");
//                // display database information
//                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
//                System.out.println("Driver name: " + dm.getDriverName());
//                System.out.println("Product name: " + dm.getDatabaseProductName());
//
//                // execute SQL statements
//                System.out.println("----- Data in Book table -----");
//
//                String query = "Select * from book";
//                Statement statement = conn.createStatement();
//                ResultSet resultSet = statement.executeQuery(query);
//
//                while (resultSet.next()) {
//                    int id = resultSet.getInt(1);
//                    String name = resultSet.getString(2);
//                    double price = resultSet.getDouble(3);
//
//                    System.out.println("id:"+id+" name:"+name+" price: "+price);
//                }
//// close connection
//                conn.close();
//            }
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }

}
