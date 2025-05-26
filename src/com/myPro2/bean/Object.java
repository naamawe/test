package com.myPro2.bean;

import java.security.Timestamp;

public class Object {
    private String name;
    private double price;
    private User u;
    private Timestamp seelTime;
    private boolean isBeBuy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    public Timestamp getSeelTime() {
        return seelTime;
    }

    public void setSeelTime(Timestamp seelTime) {
        this.seelTime = seelTime;
    }

    public boolean isBeBuy() {
        return isBeBuy;
    }

    public void setBeBuy(boolean isBeBuy) {
        this.isBeBuy = isBeBuy;
    }

}
