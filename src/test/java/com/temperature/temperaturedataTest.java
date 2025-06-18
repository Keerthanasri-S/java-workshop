package com.temperature;

import com.temperature.beans.Location;
import com.temperature.beans.Organization;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class temperaturedataTest {
    @Test
    public void testlocation() throws IOException, ClassNotFoundException {
        TemperatureData temperatureData = new TemperatureData();
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
        temperatureData.writeLocations("coimbatore.txt",ourlocation);

        File myfile = new File("coimbatore.txt");
        Assertions.assertTrue(myfile.exists());
/// Read the file
        FileInputStream fileInputStream = new FileInputStream("coimbatore.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Location location1 = (Location) objectInputStream.readObject();
        System.out.println(location1);

        Assertions.assertEquals(ourlocation.getCity(),location1.getCity());

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

        temperatureData.writeLocations("chennai.txt",ourlocation1);
        File myfile1 = new File("chennai.txt");
        Assertions.assertTrue(myfile1.exists());

        fileInputStream = new FileInputStream("chennai.txt");
        objectInputStream = new ObjectInputStream(fileInputStream);
        Location location2 = (Location) objectInputStream.readObject();
        System.out.println(location2);

        Assertions.assertEquals(ourlocation1.getCity(),location2.getCity());
    }
}
