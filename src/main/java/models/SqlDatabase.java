package models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.text.ParseException;
import java.util.List;
import java.util.Vector;

public class SqlDatabase implements Database{

    private Connection connect;

    public SqlDatabase() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        String dbURL = "jdbc:sqlite:calendarStore.db";
        connect = DriverManager.getConnection(dbURL);

        if(connect != null){
            System.out.println("Connected to Database...");
        }

        connect.close();
    }

    public List<Item> readDatabase() throws SQLException, ParseException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        String dbURL = "jdbc:sqlite:calendarStore.db";
        connect = DriverManager.getConnection(dbURL);

        if(connect != null){
            System.out.println("Connected to Database...");
        }
        List<Item> items = new Vector<Item>();

        String query = "Select * from dataBaseCalendar";
        Statement statement = connect.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String title = resultSet.getString(2);
            String detail = resultSet.getString(3);
            String date = resultSet.getString(4);
            String time = resultSet.getString(5);
            String status = resultSet.getString(6);

            int day = Integer.parseInt(date.substring(8,10));
            int month = Integer.parseInt(date.substring(5,7));
            int year = Integer.parseInt(date.substring(0,4));

            items.add(new Item(id,title,detail,day,month,year,time.substring(0,2),time.substring(3,5), status));
        }

        connect.close();

        return items;
    }

    public void addData(Item item) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        String dbURL = "jdbc:sqlite:calendarStore.db";
        connect = DriverManager.getConnection(dbURL);

        if(connect != null){
            System.out.println("Connected to Database...");
        }
        String query = "INSERT INTO dataBaseCalendar (id, 'title', 'detail', 'date', 'time', 'status') " +
                "VALUES ( " + item.getId()+ ",'"+item.getTitle()+"','"+item.getDetail()+"','"+item.getDate()+ "','"+item.getTime()+"','"+item.getStatus()+"');";
        Statement statement = connect.createStatement();
        statement.executeUpdate(query);

        connect.close();
    }

    public void editData(Item item) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        String dbURL = "jdbc:sqlite:calendarStore.db";
        connect = DriverManager.getConnection(dbURL);

        if(connect != null){
            System.out.println("Connected to Database...");
        }
        String query = "UPDATE dataBaseCalendar SET id = " +item.getId() +
                ", title ='"+item.getTitle()+"' , detail ='"+item.getDetail()+"' , date ='"+item.getDate()+"', time ='"+item.getTime()+"' , status ='"+item.getStatus()+ "' WHERE id = "+item.getId();
        Statement statement = connect.createStatement();
        statement.executeUpdate(query);

        connect.close();
    }

    public void deleteData(int id) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        String dbURL = "jdbc:sqlite:calendarStore.db";
        connect = DriverManager.getConnection(dbURL);

        if(connect != null){
            System.out.println("Connected to Database...");
        }
        String query = "Delete from dataBaseCalendar where Id = "+id;
        Statement statement = connect.createStatement();
        statement.executeUpdate(query);

        connect.close();
    }

}
