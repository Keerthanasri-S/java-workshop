package com.temperature;

import com.temperature.beans.*;

import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.util.Locale;

public class TemperatureData {

//        TempSensor obj= new TempSensor(24);//like registration form
//        System.out.println(obj.getReading());
//        System.out.println(obj.getReading(ReadingUnit.C));
//        System.out.println(obj.getReading(ReadingUnit.F));

    /// /        Sensor obj1= new HumiditySensor(50);
    /// /        System.out.println(obj1.getReading());
    /// /        System.out.println(obj.getReading(ReadingUnit.G));
    /// /        System.out.println(obj.getReading(ReadingUnit.Kg));
//
//        System.out.println(obj.getClass());
//        System.out.println(obj.hashcode());
//        System.out.println(obj.toString());
//
//        TempSensor tempSensor=new TempSensor(24);  //exam form
//        System.out.println(tempSensor.getClass());
//        System.out.println(tempSensor.hashcode());
//        System.out.println(tempSensor.toString());
//        System.out.println(obj.equals(tempSensor));
    public static void main(String[] args) {
        try{
            Commerical  commerical = new Commerical();
            commerical.setNooffloors(200);
        } catch (BuildingException e) {
            throw new RuntimeException(e);
        }
        }


    private static void extracted() {
        Organization ourTechnology = new Organization();
        ourTechnology.setName("ourTechnology");
        ourTechnology.setdateofinitaial(LocalDate.of(2021, 04, 14));
        ourTechnology.setEmail("operations@ourtech.com");
        ourTechnology.setCeo("mdkfmdsk");
        ourTechnology.setPhone(("+91 8778947245"));

        FileOutputStream outputStream = null;
        ObjectOutputStream objectOutputStream = null;
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
             outputStream = new FileOutputStream("ourTechnology.txt");
             objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(ourTechnology);
            objectOutputStream.close();
            outputStream.close();
             fileInputStream = new FileInputStream("OurTechnology.txt");
             objectInputStream = new ObjectInputStream(fileInputStream);
            Organization myOrg = (Organization) objectInputStream.readObject();
            System.out.println(myOrg);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {


                if (outputStream != null) {
                    outputStream.close();
                }
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
