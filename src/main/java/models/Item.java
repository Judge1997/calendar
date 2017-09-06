package models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Item {

    private String title;
    private String detail;
    private Date date;

    public Item (String title, String detail, int day, int month, int year, String hour, String minute) throws ParseException {
        DateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yy HH:mm");
        this.date = dateTimeFormat.parse(day+"/"+month+"/"+year+" "+hour+":"+minute);
        this.title = title;
        this.detail = detail;
    }

    public String getTitle(){ return this.title; }

    public String getDetail(){ return this.detail; }

    public Date getDate(){ return this.date; }

    public String toString(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setDetail(String detail){
        this.detail = detail;
    }

    public void setDate(int day, int month, int year, String hour, String minute) throws ParseException {
        DateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yy HH:mm");
        this.date = dateTimeFormat.parse(day+"/"+month+"/"+year+" "+hour+":"+minute);
    }

}