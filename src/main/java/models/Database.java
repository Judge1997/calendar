package models;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface Database {

    List<Item> readDatabase() throws SQLException, ParseException, ClassNotFoundException;
    void addData(Item item) throws SQLException, ClassNotFoundException;
    void editData(Item item) throws SQLException, ClassNotFoundException;
    void deleteData(int id) throws SQLException, ClassNotFoundException;
}
