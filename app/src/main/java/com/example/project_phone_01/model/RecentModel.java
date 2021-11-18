package com.example.project_phone_01.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

public class RecentModel {


    private int id;
    private String name, number, date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RecentModel(String name, String number, String date) {
        this.name = name;
        this.number = number;
        this.date = date;
    }

    public RecentModel() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDate(){
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        DateFormat dateFormat = new SimpleDateFormat("yyyy MMMM dd hh:mm:ss");
        this.date = dateFormat.format(date);
    }

    public static Comparator<RecentModel> recentsModelDateComparator = new Comparator<RecentModel>() {
        @Override
        public int compare(RecentModel recent1, RecentModel recent2) {
            return Integer.parseInt(recent1.getDate()) - Integer.parseInt(recent2.getDate());
        }
    };
}