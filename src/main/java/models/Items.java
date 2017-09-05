package models;

import java.util.ArrayList;

public class Items {

    private ArrayList<Item> items = new ArrayList<Item>();

    public void addItem(String detail, String day, String month, String year, String hour, String minute){
        Item item = new Item(detail, day, month, year, hour, minute);
        this.items.add(item);
    }

    public void deleteItem(int index){
        this.items.remove(index);
    }

    public void editItem(Item item, String detail, String day, String month, String year, String hour, String minite){
        int index = this.items.indexOf(item);
        this.items.get(index).setAllDetail(detail, day, month, year, hour, minite);
    }

    public ArrayList<Item> getItems(){
        return this.items;
    }

}
