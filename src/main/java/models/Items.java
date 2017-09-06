package models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.text.ParseException;
import java.util.ArrayList;

public class Items {

    private ObservableList<Item> items = FXCollections.observableArrayList();

    public static Items self = null;

    public static Items getSelf() {
        if (self == null){
            self = new Items();
        }
        return self;
    }

    public void addItem(String title, String detail, int day, int month, int year, String hour, String minute) throws ParseException {
        Item item = new Item(title, detail, day, month, year, hour, minute);
        this.items.add(item);
    }



    public void deleteItem(int index){
        this.items.remove(index);
    }

    public void editItem(Item item, String title, String detail, int day, int month, int year, String hour, String minite){
        int index = this.items.indexOf(item);
        this.items.get(index).setAllDetail(title, detail, day, month, year, hour, minite);
    }

    public ObservableList<Item> getItems(){
        return this.items;
    }

}
