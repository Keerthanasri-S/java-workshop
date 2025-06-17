package com.temperature;

import com.temperaturedata.beans.HumiditySensor;
import com.temperaturedata.beans.ReadingUnit;
import com.temperaturedata.beans.Sensor;
import com.temperaturedata.beans.TempSensor;

public class TemperatureData {


    public static void main(String[] args) {
        TempSensor obj= new TempSensor(24);//like registration form
        System.out.println(obj.getReading());
        System.out.println(obj.getReading(ReadingUnit.C));
        System.out.println(obj.getReading(ReadingUnit.F));
//        Sensor obj1= new HumiditySensor(50);
//        System.out.println(obj1.getReading());
//        System.out.println(obj.getReading(ReadingUnit.G));
//        System.out.println(obj.getReading(ReadingUnit.Kg));

        System.out.println(obj.getClass());
        System.out.println(obj.hashcode());
        System.out.println(obj.toString());

        TempSensor tempSensor=new TempSensor(24);  //exam form
        System.out.println(tempSensor.getClass());
        System.out.println(tempSensor.hashcode());
        System.out.println(tempSensor.toString());
        System.out.println(obj.equals(tempSensor));
    }

}
