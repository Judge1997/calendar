package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Item;
import models.Items;
import models.SqlDatabase;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class Controller {

    private Items items = Items.getSelf();
    private EditController editController;
    public static SqlDatabase database;

    static {
        try {
            database = new SqlDatabase();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private ListView listCalendar;

    @FXML
    private TextArea detailCalendar;

    public Controller() throws SQLException, ParseException {
        items.setItems(database.readDatabase());
    }

    @FXML
    private void initialize(){
        listCalendar.setItems(items.getItems());
        listCalendar.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if(event.getButton() == MouseButton.SECONDARY)
                {
                    Item item = (Item) listCalendar.getSelectionModel().getSelectedItem();
                    detailCalendar.setText("Title: "+item.getTitle()+"\n\n"
                            +"Detail: "+item.getDetail()+"\n\n"
                            +"Time: "+item.getDateAndTime());
                }else{
                    Item item = (Item) listCalendar.getSelectionModel().getSelectedItem();
                    detailCalendar.setText("Title: "+item.getTitle()+"\n\n"
                            +"Detail: "+item.getDetail()+"\n\n"
                            +"Time: "+item.getDateAndTime());
                }
            }
        });
    }

    @FXML
    public void addCalendar(ActionEvent event) throws IOException {
        Button add = (Button) event.getSource();

        Stage addWindow = (Stage) add.getScene().getWindow();
        Parent window = FXMLLoader.load(getClass().getResource("/AddCalendar.fxml"));

        addWindow.setTitle("Add Calendar");
        addWindow.setScene(new Scene(window,400,600));
        addWindow.setResizable(false);
        addWindow.show();
    }

    @FXML
    public void editCalendar(ActionEvent event) throws IOException {
        Item item = (Item) listCalendar.getSelectionModel().getSelectedItem();

        Button add = (Button) event.getSource();

        Stage addWindow = (Stage) add.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/EditCalendar.fxml"));
        Parent window = loader.load();
        this.editController = loader.getController();;
        this.editController.setItem(item);

        addWindow.setTitle("Edit Calendar");
        addWindow.setScene(new Scene(window,400,600));
        addWindow.setResizable(false);
        addWindow.show();
    }

    @FXML
    public void exitCalendar(ActionEvent event) throws SQLException {
        database.closeDatabase();
        System.exit(0);
    }

    @FXML
    public void deleteCalendar(ActionEvent event) throws SQLException {

        int index = listCalendar.getSelectionModel().getSelectedIndex();
        database.deleteDate(items.getItems().get(index).getId());
        items.deleteItem(index);
        detailCalendar.setText("");

    }

}
