package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import models.Items;

import java.io.IOException;

public class Controller {

    private Items items;
    private AddController addController;

    public Controller (){
        this.items = new Items();
        this.addController = new AddController(this.items);
    }

    @FXML
    private Stage addWindow;

    @FXML
    private Button addButton;

    @FXML
    private Button editButton;

    @FXML
    private Button deleteButton;

    @FXML
    public void addCalendar(ActionEvent event) throws IOException {
        System.out.println(123);
        Parent window = FXMLLoader.load(getClass().getResource("/AddCalendar.fxml"));
        addWindow = new Stage();
        addWindow.setTitle("Add Calendar");
        addWindow.setScene(new Scene(window,400,600));
        addWindow.setResizable(false);
        addWindow.show();
    }

    @FXML
    public void editCalendar(ActionEvent event){

    }

    @FXML
    public void deleteCalendar(ActionEvent event){

    }

}
