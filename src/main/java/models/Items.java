package models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Items {

    private ObservableList<Item> items = FXCollections.observableArrayList();

    private static Items self = null;

    public static Items getSelf() {
        if (self == null){
            self = new Items();
        }
        return self;
    }

    public void addItem(int id, String title, String detail, int day, int month, int year, String hour, String minute, String status) throws ParseException {
        Item item = new Item(id,title, detail, day, month, year, hour, minute, status);
        this.items.add(item);
    }

    public ObservableList<Item> searchItem(int day, int month, int year) throws ParseException {
        ObservableList<Item> searchList = FXCollections.observableArrayList();
        DateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yy");
        Date date = dateTimeFormat.parse(day+"/"+month+"/"+year);
        for (Item i : this.items){
            if (i.getStatus().equals("Daily")){
                searchList.add(i);
            } else if (i.getStatus().equals("Weekly")){

            }
        }

        return searchList;
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
