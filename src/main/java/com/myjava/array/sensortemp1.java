package com.myjava.array;

import java.util.Scanner;

public class sensortemp1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();//6 row
        int [] n1 = new int[n];
        for (int i = 0; i < n; i++) {
                n1[i]= sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                if(n1[i]<18 || n1[i]>28){
                    System.out.println(n1[i] + "out is range");
                }
            }
        }
    }

