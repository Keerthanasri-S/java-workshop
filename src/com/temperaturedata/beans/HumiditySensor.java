package com.temperaturedata.beans;//class opjp

public class HumiditySensor implements Sensor {
    private float temp;
    public HumiditySensor(float t){
        temp=t;
    }
    public float getReading(){
        return temp;
    }
    public float getReading(ReadingUnit unit){
        if(ReadingUnit.Kg.equals(unit)){
            return temp/1000;
        }
        if(ReadingUnit.Kg.equals(unit)){
            return temp;
        }
    }
}
