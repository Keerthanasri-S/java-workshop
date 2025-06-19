package com.temperature.beans;

import java.util.List;

public abstract sealed class Building permits Residential,Commerical {
    private String color;
    private String shape;
    private String name;
    private int bulidingNumber;
    private double height;
    private double squareFeet;
    private List<Floor> floors;

    public int getNooffloors() {
        return nooffloors;
    }

    public void setNooffloors(int nooffloors)throws BuildingException{
       if(nooffloors>100){
           throw new BuildingException("number of floors are greater than 100");
       }
        this.nooffloors = nooffloors;
    }

    private int nooffloors;
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
