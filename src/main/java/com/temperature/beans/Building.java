package com.temperature.beans;

public abstract sealed class Building permits Residential,Commerical {
//    private Floor[] floors;
    private String color;
    private String shape;
    private String name;
    private int bulidingNumber;
    private double height;
    private double squareFeet;
    private boolean parkingAvailable;
    abstract void ebbill();

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBulidingNumber() {
        return bulidingNumber;
    }

    public void setBulidingNumber(int bulidingNumber) {
        this.bulidingNumber = bulidingNumber;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getSquareFeet() {
        return squareFeet;
    }

    public void setSquareFeet(double squareFeet) {
        this.squareFeet = squareFeet;
    }

    public boolean isParkingAvailable() {
        return parkingAvailable;
    }

    public void setParkingAvailable(boolean parkingAvailable) {
        this.parkingAvailable = parkingAvailable;
    }
}
