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

import java.io.IOException;

public class Controller {

    private Items items = Items.getSelf();

    @FXML
    private ListView listCalendar;

    @FXML
    private TextArea detailCalendar;

    @FXML
    private void initialize(){
        listCalendar.setItems(items.getItems());
        listCalendar.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if(event.getButton() == MouseButton.SECONDARY)
                {
                    Item item = (Item) listCalendar.getSelectionModel().getSelectedItem();
                    detailCalendar.setText("Title: "+item.getTitle()+"\n"
                            +"Detail: "+item.getDetail()+"\n"
                            +"Time: "+item.getDate());
                }else{
                    Item item = (Item) listCalendar.getSelectionModel().getSelectedItem();
                    detailCalendar.setText("Title: "+item.getTitle()+"\n"
                            +"Detail: "+item.getDetail()+"\n"
                            +"Time: "+item.getDate());
                }
            }
        });
    }

    @FXML
    public void addCalendar(ActionEvent event) throws IOException {
        System.out.println(123);
        Button add = (Button) event.getSource();

        Stage addWindow = (Stage) add.getScene().getWindow();
        Parent window = FXMLLoader.load(getClass().getResource("/AddCalendar.fxml"));

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
        int index = listCalendar.getSelectionModel().getSelectedIndex();
        items.deleteItem(index);
        detailCalendar.setText("");
    }

}
