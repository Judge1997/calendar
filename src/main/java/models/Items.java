package models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.text.ParseException;
import java.util.ArrayList;

public class Items {

    private ObservableList<Item> items = FXCollections.observableArrayList();

    private static Items self = null;

    public static Items getSelf() {
        if (self == null){
            self = new Items();
        }
        return self;
    }

    public void addItem(int id, String title, String detail, int day, int month, int year, String hour, String minute) throws ParseException {
        Item item = new Item(id,title, detail, day, month, year, hour, minute);
        this.items.add(item);
    }

    public void setItems(ObservableList<Item> items){
        this.items = items;
    }

    public void deleteItem(int index){
        this.items.remove(index);
    }

    public ObservableList<Item> getItems(){
        return this.items;
    }

}
