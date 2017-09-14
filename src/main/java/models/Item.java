package models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Item {

    private int id;
    private String title;
    private String detail;
    private Date date;
    private String status;

    public Item (int id,String title, String detail, int day, int month, int year, String hour, String minute, String status) throws ParseException {
        this.id = id;
        DateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yy HH:mm");
        this.date = dateTimeFormat.parse(day+"/"+month+"/"+year+" "+hour+":"+minute);
        this.title = title;
        this.detail = detail;
        this.status = status;
    }

    public String getTitle(){ return this.title; }

    public String getDetail(){ return this.detail; }

    public String getDateAndTime(){
        String dateAndTime;
        if (this.status.equals("Daily")){
            dateAndTime = "Date: "+"Every day"+" Time: "+this.getTime();
        } else if (this.status.equals("Weekly")){
            dateAndTime = "Date: "+"Every "+this.date.toString().substring(0,3)+" Time: "+this.getTime();
        } else if (this.status.equals("Monthly")){
            dateAndTime = "Date: "+"Every "+this.getDate().substring(8,10)+" of month"+" Time: "+this.getTime();
        } else {
            dateAndTime = "Date: "+this.date.toString().substring(0,3)+" "
                    +this.getDate().substring(8,10)+"-"
                    +this.date.toString().substring(4,7)+"-"
                    +this.getDate().substring(0,4)
                    +" Time: "+this.getTime();
        }
        return dateAndTime;
    }

    public String getDate(){
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        String date = formatDate.format(this.date);
        return date.substring(6,10)+"-"+date.substring(3,5)+"-"+date.substring(0,2);
    }

    public String getTime(){
        SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm");
        String time = formatTime.format(this.date.getTime());
        return time;
    }

    public String toString(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setDetail(String detail){
        this.detail = detail;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }

    public int getId(){ return this.id; }

    public void setDate(int day, int month, int year, String hour, String minute) throws ParseException {
        DateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yy HH:mm");
        this.date = dateTimeFormat.parse(day+"/"+month+"/"+year+" "+hour+":"+minute);
    }

}