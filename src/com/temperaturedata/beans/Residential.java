package com.temperaturedata.beans;

import java.util.Calendar;

public class Residential extends Building{
    private String type;
    public void setType(String aType){
        type=aType;
    }
    public String getType(){
        return type;
    }
    @Override
    void ebbill() {

    }
}
