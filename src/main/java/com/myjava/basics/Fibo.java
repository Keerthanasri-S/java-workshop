package com.myjava.basics;


import java.util.Scanner;

public class Fibo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         int a = sc.nextInt();
         int n=0;
         int n1=1;
        System.out.print(n+"");
        System.out.print(n1+"");
        int t=0;
         for(int i =2 ;i<a;i++){
             t = n+n1;
             System.out.print(t+"");
             n=n1;
             n1=t;

        }

    }
}
