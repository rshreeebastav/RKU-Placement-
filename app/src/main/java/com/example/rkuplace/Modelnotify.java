package com.example.rkuplace;

public class Modelnotify {

    //Initialization
    private int Id;
    String Name, Date, Time, Venue;

    public Modelnotify(int id, String name, String date, String time, String venue) {
        Id = id;
        Name = name;
        Date = date;
        Time = time;
        Venue = venue;
    }

    //Getter and setter

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getVenue() {
        return Venue;
    }

    public void setVenue(String venue) {
        Venue = venue;
    }
}
