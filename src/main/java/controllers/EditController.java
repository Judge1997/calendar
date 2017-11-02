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
import models.Item;
import models.Items;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import static controllers.Controller.database;

public class EditController {

    private Item item;

    private ObservableList<String> hourChoice = FXCollections.observableArrayList("0","1","2","3","4","5","6","7","8","9","10",
            "11","12","13","14","15","16","17","18","19","20","21","22","23");

    private ObservableList<String> minuteChoice = FXCollections.observableArrayList("0","5","10","15","20","25","30","35","40",
            "45","50","55");

    private ObservableList<String> statusChoice = FXCollections.observableArrayList("Normal","Daily","Weekly","Monthly");

    @FXML
    private DatePicker dateEditCalendar;

    @FXML
    private TextArea titleEditCalendar;

    @FXML
    private TextArea detailEditCalendar;

    @FXML
    private ComboBox hourEditCalendar;

    @FXML
    private ComboBox minuteEditCalendar;

    @FXML
    private ComboBox statusEditCalendar;

    @FXML
    private void initialize(){
        hourEditCalendar.setItems(hourChoice);
        minuteEditCalendar.setItems(minuteChoice);
        statusEditCalendar.setItems(statusChoice);
    }

    @FXML
    private void doneEditCalendar(ActionEvent event) throws IOException, ParseException, SQLException, ClassNotFoundException {
        this.item.setTitle(titleEditCalendar.getText());
        this.item.setDetail(detailEditCalendar.getText());
        this.item.setDate(dateEditCalendar.getValue().getDayOfMonth(),
                dateEditCalendar.getValue().getMonthValue(),
                dateEditCalendar.getValue().getYear(),
                hourEditCalendar.getValue().toString(),
                minuteEditCalendar.getValue().toString());
        this.item.setStatus(statusEditCalendar.getValue().toString());

        database.editData(this.item);

        this.toMainWindow(event);
    }

    public void setItem(Item item){
        this.item = item;
        titleEditCalendar.setText(this.item.getTitle());
        detailEditCalendar.setText(this.item.getDetail());
        dateEditCalendar.setValue(LocalDate.parse(this.item.getDate()));
        hourEditCalendar.setValue(this.item.getTime().substring(0,2));
        minuteEditCalendar.setValue(this.item.getTime().substring(3,5));
        statusEditCalendar.setValue(this.item.getStatus());
    }

    @FXML
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
