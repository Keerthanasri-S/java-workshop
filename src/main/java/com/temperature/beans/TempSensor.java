package com.temperature.beans;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class TempSensor {
    private float temp;
    private Map<LocalDateTime,Tempdata> temperatureDAtaMAp;

    public Map<LocalDateTime, Tempdata> getTemperatureDAtaMAp() {
        return temperatureDAtaMAp;
    }

    public void setTemperatureDAtaMAp(Map<LocalDateTime, Tempdata> temperatureDAtaMAp) {
        this.temperatureDAtaMAp = temperatureDAtaMAp;
    }
//    public TempSensor(float atemp ) throws TemperatureException {
//        if(atemp < -89 || atemp >58){
//            throw new TemperatureException("Temperature out of range");
//        }
//        temp = atemp;
//    }

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
