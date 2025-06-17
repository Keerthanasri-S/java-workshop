package com.myjava.basics;
import java.util.Scanner;
public class Temperature {
    public void sensor(int a,int b){
            System.out.println("enter the sensor");
            System.out.println(a);
            System.out.println("enter the temperature");
            System.out.println(b);
        }
        public void temperature1(int a1,int b1){
            System.out.println("enter the sensor");
            System.out.println(a1);
            System.out.println("enter the temperature");
            System.out.println(b1);
        }
        public static void main(String[] args) {

            Scanner scanner=new Scanner(System.in);
            int a=scanner.nextInt();
            int a1=scanner.nextInt();
            int b=scanner.nextInt();
            int b1=scanner.nextInt();
            Temperature temperature=new Temperature();
            temperature.sensor(a,b);
            temperature.temperature1(a1,b1);



    }

}
