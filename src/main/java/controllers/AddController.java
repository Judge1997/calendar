package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import models.Items;

public class AddController {

    private Items items;

    public AddController (Items items){
        this.items = items;
    }

    @FXML
    private Button donButton;



    @FXML
    public void doneNewCalendar (ActionEvent event){

    }

}
