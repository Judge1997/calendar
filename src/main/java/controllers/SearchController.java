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
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Item;
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
    private TextArea detailSearchCalendar;

    @FXML
    private void initialize(){
        listCalendar.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if(event.getButton() == MouseButton.SECONDARY)
                {
                    Item item = (Item) listCalendar.getSelectionModel().getSelectedItem();
                    detailSearchCalendar.setText("Title: "+item.getTitle()+"\n\n"
                            +"Detail: "+item.getDetail()+"\n\n"
                            +item.getDateAndTime());
                }else{
                    Item item = (Item) listCalendar.getSelectionModel().getSelectedItem();
                    detailSearchCalendar.setText("Title: "+item.getTitle()+"\n\n"
                            +"Detail: "+item.getDetail()+"\n\n"
                            +item.getDateAndTime());
                }
            }
        });
    }

    @FXML
    public void searchButton(ActionEvent event) throws ParseException {
        ObservableList<Item> observableList = FXCollections.observableArrayList();

        observableList.addAll(items.searchItem(dateSearchCalendar.getValue().getDayOfMonth(),dateSearchCalendar.getValue().getMonthValue(),
                dateSearchCalendar.getValue().getYear()));

        listCalendar.setItems(observableList);
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
