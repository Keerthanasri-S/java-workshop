package com.temperaturedata.beans;

public class TempSensor implements Sensor{
    private float temp;

    public TempSensor(float t){
        temp=t;
     }
    public float getReading(){
        return temp;
    }
    public float getReading(ReadingUnit unit){
        if(ReadingUnit.C.equals(unit)){

            return (temp*9/5)+32;
        }
        if(ReadingUnit.F.equals(unit)){
            return temp;
        }
        return 0;
    }
}
