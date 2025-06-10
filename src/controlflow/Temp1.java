package controlflow;

import java.util.Scanner;

public class Temp1 {
    public void temp(double t){
        if(t >= 18 && t < 20)
        {
            System.out.println("coolest");
        }
        else if (t >= 20 && t < 24)
        {
            System.out.println("cooler");
        }
        else if (t >= 24 && t <= 28)
        {
            System.out.println("cool");
        }
        else
        {
            System.out.println(t + " is out of range");
        }
    }

    public static void main(String[] args) {
        Temp1 temp1=new Temp1();
        Scanner sc=new Scanner(System.in);
         double t=sc.nextDouble();
        double t1=sc.nextDouble();
        double t2=sc.nextDouble();
        double t3=sc.nextDouble();
        double t4=sc.nextDouble();
        temp1.temp(t);
        temp1.temp(t1);
        temp1.temp(t2);
        temp1.temp(t3);
        temp1.temp(t4);

    }
}
