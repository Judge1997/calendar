package models;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface Database {

    public List<Item> readDatabase() throws SQLException, ParseException;
    public void addData(Item item) throws SQLException;
    public void editData(Item item) throws SQLException;
    public void deleteData(int id) throws SQLException;
    public void closeDatabase() throws SQLException;
}
