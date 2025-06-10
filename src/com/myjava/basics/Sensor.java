package com.myjava.basics;

import java.util.Scanner;

public class Sensor {
    public void sensor1(int a){
        System.out.println("enter the sensor");
        System.out.println(a);
    }
    public void temperature(double b,double b1,double b2,double b3,double b4){
        System.out.println("enter the temperature");
        double s=b+b1+b2+b3+b4;
        double c=s/5;
        System.out.println(c);
    }
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int a=scanner.nextInt();
        double b=scanner.nextDouble();
        double b1=scanner.nextDouble();
        double b2=scanner.nextDouble();
        double b3=scanner.nextDouble();
        double b4=scanner.nextDouble();

        Sensor sensor=new Sensor();
        sensor.sensor1(a);

      sensor.temperature(b,b1,b2,b3,b4);



    }
}
