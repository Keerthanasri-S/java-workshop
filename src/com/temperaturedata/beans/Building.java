package com.temperaturedata.beans;

public abstract class Building {
    private Floor[] floors;
    private String color;
    private String shape;
    private String name;
    private int bulidingNumber;

    private double height;
    private double squareFeet;
    private boolean parkingAvailable;
    abstract void ebbill();

}
