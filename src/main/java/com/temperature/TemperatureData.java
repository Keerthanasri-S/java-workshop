package com.temperature;

import com.temperature.beans.Building;
import com.temperature.beans.Location;
import com.temperature.beans.Organization;

import javax.swing.*;
import java.io.*;
import java.time.LocalDate;

public class TemperatureData {


    public static void main(String[] args) throws IOException {
//        TempSensor obj= new TempSensor(24);//like registration form
//        System.out.println(obj.getReading());
//        System.out.println(obj.getReading(ReadingUnit.C));
//        System.out.println(obj.getReading(ReadingUnit.F));
////        Sensor obj1= new HumiditySensor(50);
////        System.out.println(obj1.getReading());
////        System.out.println(obj.getReading(ReadingUnit.G));
////        System.out.println(obj.getReading(ReadingUnit.Kg));
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

        Organization ourTechnology = new Organization();
        ourTechnology.setName("ourTechnology");
        ourTechnology.setdateofinitaial(LocalDate.of(2021,04,14));
        ourTechnology.setEmail("operations@ourtech.com");
        ourTechnology.setCeo("mdkfmdsk");
        ourTechnology.setPhone(("+91 8778947245"));

        try {
            FileOutputStream outputStream = new FileOutputStream("ourTechnology.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(ourTechnology);
            objectOutputStream.close();
            outputStream.close();
            FileInputStream fileInputStream = new FileInputStream("OurTechnology.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Organization myOrg = (Organization) objectInputStream.readObject();
            System.out.println(myOrg);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Location ourlocation = new Location();
        ourlocation.setDoorno("123");
        ourlocation.setStreet(2);
        ourlocation.setAreaname(1);
        ourlocation.setCity("coimbatore");
        ourlocation.setDistrict("coimbatore");
        ourlocation.setCountry("India");
        ourlocation.setState("Tamilnadu");
        ourlocation.setLongtitude(1489.08);
        ourlocation.setLatitude(7339.7902);
        ourlocation.setPincode("623503");


        FileOutputStream fileoutputStream= new FileOutputStream("Location.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileoutputStream);
        objectOutputStream.writeObject(ourlocation);
        objectOutputStream.close();
        fileoutputStream.close();


        Location ourlocation1 = new Location();
        ourlocation1.setDoorno("124");
        ourlocation1.setStreet(3);
        ourlocation1.setAreaname(2);
        ourlocation1.setCity("chennai");
        ourlocation1.setDistrict("chennai");
        ourlocation1.setCountry("India");
        ourlocation1.setState("Tamilnadu");
        ourlocation1.setLongtitude(1489.08);
        ourlocation1.setLatitude(7339.7902);
        ourlocation1.setPincode("623503");


        fileoutputStream= new FileOutputStream("Location1.txt");
        objectOutputStream = new ObjectOutputStream(fileoutputStream);
        objectOutputStream.writeObject(ourlocation1);
        objectOutputStream.close();
        fileoutputStream.close();



    }

}
