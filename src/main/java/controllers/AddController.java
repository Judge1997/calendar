package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import models.Items;

import java.io.IOException;
import java.text.ParseException;

public class AddController{

    private Items items = Items.getSelf();

    private ObservableList<String> hourChoice = FXCollections.observableArrayList("0","1","2","3","4","5","6","7","8","9","10",
            "11","12","13","14","15","16","17","18","19","20","21","22","23");

    private ObservableList<String> minuteChoice = FXCollections.observableArrayList("0","5","10","15","20","25","30","35","40",
            "45","50","55");

    @FXML
    private DatePicker dateAddCalendar;

    @FXML
    private TextArea titleAddCalendar;

    @FXML
    private TextArea detailAddCalendar;

    @FXML
    private ComboBox hourAddCalendar;

    @FXML
    private ComboBox minuteAddCalendar;

    @FXML
    private void initialize(){
        hourAddCalendar.setItems(hourChoice);
        minuteAddCalendar.setItems(minuteChoice);
    }

    @FXML
    private void doneAddCalendar(ActionEvent event) throws IOException, ParseException {

        items.addItem(titleAddCalendar.getText(),detailAddCalendar.getText(),dateAddCalendar.getValue().getDayOfMonth(),
                dateAddCalendar.getValue().getMonthValue(),  dateAddCalendar.getValue().getYear(),
                hourAddCalendar.getValue().toString(), minuteAddCalendar.getValue().toString());

        this.toMainWindow(event);

    }

    public void toMainWindow(ActionEvent event) throws IOException {
        Button done = (Button) event.getSource();

        Stage mainWindow = (Stage) done.getScene().getWindow();
        Parent window = FXMLLoader.load(getClass().getResource("/Calendar.fxml"));

        mainWindow.setTitle("Calendar");
        mainWindow.setScene(new Scene(window,400,600));
        mainWindow.setResizable(false);
        mainWindow.show();
    }

}
