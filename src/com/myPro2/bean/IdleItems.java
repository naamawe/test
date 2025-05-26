package com.myPro2.bean;

import java.sql.Timestamp;

public class IdleItems {
    private String name;
    private String category;
    private double price;
    private String isSold;
    private Timestamp timeOfSold;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIsSold() {
        return isSold;
    }

    public void setIsSold(String isSold) {
        this.isSold = isSold;
    }

    public Timestamp getTimeOfSold() {
        return timeOfSold;
    }

    public void setTimeOfSold(Timestamp timeOfSold) {
        this.timeOfSold = timeOfSold;
    }

}
