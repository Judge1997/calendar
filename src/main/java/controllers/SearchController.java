package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import models.Items;

import java.io.IOException;
import java.text.ParseException;

public class SearchController {

    private Items items = Items.getSelf();

    @FXML
    private DatePicker dateSearchCalendar;

    @FXML
    private ListView listCalendar;

    @FXML
    public void searchButton(ActionEvent event) throws ParseException {
        listCalendar.setItems(items.searchItem(dateSearchCalendar.getValue().getDayOfMonth(),dateSearchCalendar.getValue().getMonthValue(),dateSearchCalendar.getValue().getYear()));

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
