package com.myjava.basics;

import java.util.Scanner;

public class armsttong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int t = a;
        int sum = 0;
        while(t!=0){
            int b = t%10;
            sum+= b * b* b;
            t/=10;
        }
        System.out.println(sum);
    }
}
