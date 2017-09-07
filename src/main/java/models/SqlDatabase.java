package models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.text.ParseException;

public class SqlDatabase {

    private Connection connect;

    public SqlDatabase() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        String dbURL = "jdbc:sqlite:calendarStore.db";
        connect = DriverManager.getConnection(dbURL);
        if(connect != null){
            System.out.println("Connected to Database...");
        }
    }

    public ObservableList<Item> readDatabase() throws SQLException, ParseException {
        ObservableList<Item> items = FXCollections.observableArrayList();

        String query = "Select * from dataBaseCalendar";
        Statement statement = connect.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String title = resultSet.getString(2);
            String detail = resultSet.getString(3);
            String date = resultSet.getString(4);
            String time = resultSet.getString(5);

            int day = Integer.parseInt(date.substring(8,10));
            int month = Integer.parseInt(date.substring(5,7));
            int year = Integer.parseInt(date.substring(0,4));

            items.add(new Item(id,title,detail,day,month,year,time.substring(0,2),time.substring(3,5)));
        }

        return items;
    }

    public void addDate(Item item) throws SQLException {
        String query = "INSERT INTO dataBaseCalendar (id, 'title', 'detail', 'date', 'time') " +
                "VALUES ( " + item.getId()+ ",'"+item.getTitle()+"','"+item.getDetail()+"','"+item.getDate()+ "','"+item.getTime()+"');";
        Statement statement = connect.createStatement();
        statement.executeUpdate(query);
    }

    public void editDate(Item item) throws SQLException {
        String query = "UPDATE dataBaseCalendar SET id = " +item.getId() +
                ", title ='"+item.getTitle()+"' , detail ='"+item.getDetail()+"' , date ='"+item.getDate()+"', time ='"+item.getTime()+ "' WHERE id = "+item.getId();
        Statement statement = connect.createStatement();
        statement.executeUpdate(query);
    }

    public void deleteDate(int id) throws SQLException {
        String query = "Delete from dataBaseCalendar where Id = "+id;
        Statement statement = connect.createStatement();
        statement.executeUpdate(query);
    }

    public void closeDatabase() throws SQLException {
        connect.close();
        System.out.println("Close Database...");
    }

}
