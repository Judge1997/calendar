package models;

public class Item {

    private String title;
    private String detail;
    private String day;
    private String month;
    private String year;
    private String hour;
    private String minute;

    public Item (String detail, String day, String month, String year, String hour, String minute){
        this.setAllDetail(detail, day, month, year, hour, minute);
    }

    public void setAllDetail(String detail, String day, String month, String year, String hour, String minute){
        this.setDetail(detail);
        this.setDay(day);
        this.setMonth(month);
        this.setYear(year);
        this.setHour(hour);
        this.setMinute(minute);
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        if (detail.length() == 0){
            this.detail = "Please! write your detail.";
        } else {
            this.detail = detail;
        }
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        if (day.length() == 2){
            this.day = day;
        } else if (day.length() == 1){
            this.day = "0"+day;
        } else {
            this.day = "00";
        }

    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        if (month.length() <= 2){
            this.month = month;
            int count = 2-month.length();
            while (count > 0){
                this.month = "0"+this.month;
                count--;
            }
        } else {
            this.month = "00";
        }
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        if(year.length() <= 4){
            this.year = year;
            int count = 4-year.length();
            while (count > 0){
                this.year = "0"+this.year;
                count--;
            }
        } else {
            this.year = "0000";
        }

    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        if (hour.length() <= 2){
            this.hour = hour;
            int count = 2-hour.length();
            while (count > 0){
                this.hour = "0"+this.hour;
                count--;
            }
        } else {
            this.hour = "00";
        }
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        if (minute.length() <= 2){
            this.minute = minute;
            int count = 2-minute.length();
            while (count > 0){
                this.minute = "0"+this.minute;
                count--;
            }
        } else {
            this.minute = "00";
        }
    }

    public String toString(){
        return this.title;
    }

}