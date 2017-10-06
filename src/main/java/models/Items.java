package models;

import javafx.collections.ObservableList;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class Items {

    private List<Item> items = new Vector<Item>();

    private static Items self = null;

    private Items(){}

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

    public List<Item> searchItem(int day, int month, int year) throws ParseException {
        List<Item> searchList = new Vector<Item>();
        DateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yy");
        Date date = dateTimeFormat.parse(day+"/"+month+"/"+year);
        for (Item i : this.items){
            if (i.getStatus().equals("Daily")){
                searchList.add(i);
            } else if (i.getStatus().equals("Weekly")){
                if (date.toString().substring(0,3).equals(i.getDateAndTime().substring(12,15))){
                    searchList.add(i);
                }
            } else if (i.getStatus().equals("Monthly")){
                if (date.toString().substring(8,10).equals(i.getDate().toString().substring(8,10))){
                    searchList.add(i);
                }
            } else {
                SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
                String dateToString = formatDate.format(date);
                String dateString = dateToString.substring(6,10)+"-"+dateToString.substring(3,5)+"-"+dateToString.substring(0,2);
                if (dateString.equals(i.getDate())){
                    searchList.add(i);
                }
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

    public List<Item> getItems(){
        return this.items;
    }

}
