package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import models.Database;
import models.Item;
import models.Items;
import models.SqlDatabase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class Controller {

    private Items items = Items.getSelf();
    private EditController editController;
    public static Database database;

    static {
//        ApplicationContext bf = new ClassPathXmlApplicationContext("/Database.xml");
//        database = (Database) bf.getBean("database");
        ApplicationContext bf = new ClassPathXmlApplicationContext("client.xml");
        database = (Database) bf.getBean("databaseService");
    }

    @FXML
    private ListView listCalendar;

    @FXML
    private TextArea detailCalendar;

    public Controller() throws SQLException, ParseException, ClassNotFoundException {
        ObservableList<Item> observableList = FXCollections.observableArrayList();
        observableList.addAll(database.readDatabase());
        items.setItems(observableList);
    }

    @FXML
    private void initialize(){
        ObservableList<Item> observableList = FXCollections.observableArrayList();
        observableList.addAll(items.getItems());
        listCalendar.setItems(observableList);
        listCalendar.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if(event.getButton() == MouseButton.SECONDARY) {
                    Item item = (Item) listCalendar.getSelectionModel().getSelectedItem();
                    if ( item != null ){
                        detailCalendar.setText("Title: "+item.getTitle()+"\n\n"
                                +"Detail: "+item.getDetail()+"\n\n"
                                +item.getDateAndTime());
                    }
                }else{
                    Item item = (Item) listCalendar.getSelectionModel().getSelectedItem();
                    if ( item != null ){
                        detailCalendar.setText("Title: "+item.getTitle()+"\n\n"
                                +"Detail: "+item.getDetail()+"\n\n"
                                +item.getDateAndTime());
                    }
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
        System.exit(0);
    }

    @FXML
    public void deleteCalendar(ActionEvent event) throws SQLException, ClassNotFoundException {

        int index = listCalendar.getSelectionModel().getSelectedIndex();
        database.deleteData(items.getItems().get(index).getId());
        items.deleteItem(index);
        ObservableList<Item> observableList = FXCollections.observableArrayList();
        observableList.addAll(items.getItems());
        listCalendar.setItems(observableList);
        detailCalendar.setText("");

    }

    @FXML
    public void searchCalendar(ActionEvent event) throws IOException {
        Button add = (Button) event.getSource();

        Stage addWindow = (Stage) add.getScene().getWindow();
        Parent window = FXMLLoader.load(getClass().getResource("/SearchCalendar.fxml"));

        addWindow.setTitle("Search Calendar");
        addWindow.setScene(new Scene(window,400,600));
        addWindow.setResizable(false);
        addWindow.show();
    }
}
