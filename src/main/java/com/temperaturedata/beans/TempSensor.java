package com.temperaturedata.beans;

public class TempSensor {
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
    @Override
    public String toString(){
        return "temperature"+temp;
    }
    public int hashcode(){
        return (int)temp*20;
    }
    @Override
    public boolean equals(Object tempSensor){
        TempSensor tempSensor1=(TempSensor) tempSensor;
        if (super.equals(tempSensor1)) {
            return true;
        }
        else{
            return this.temp==tempSensor1.temp;
        }
    }
}
