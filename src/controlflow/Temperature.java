package controlflow;

import java.util.Scanner;

public class Temperature {
    public void sensor(int a1){
        System.out.println("enter the sensor");
        System.out.println(a1);
    }
    public void temp(double a ,double b,double c,double d,double e ){
        if(a<18 || a>28 )
        {
            System.out.println(" a is out of range");
        }
        if(b<18 || b>28 )
        {
            System.out.println("b is out of range");
        }
        if(c<18 || c>28 )
        {
            System.out.println("c is out of range");
        }
        if(d<18 || d>28 )
        {
            System.out.println("d is out of range");
        }
        if(e<18 || e>28 )
        {
            System.out.println("e is out of range");
        }

    }

    public static void main(String[] args) {
        Temperature temperature=new Temperature();
        Scanner sc=new Scanner(System.in);
        int a1=sc.nextInt();
        double a=sc.nextDouble();
        double b=sc.nextDouble();
        double c=sc.nextDouble();
        double d=sc.nextDouble();
        double e=sc.nextDouble();
        temperature.sensor(a1);
        temperature.temp(a);
        temperature.temp(b);
        temperature.temp(c);
        temperature.temp(d);
        temperature.temp(e);


    }
}
