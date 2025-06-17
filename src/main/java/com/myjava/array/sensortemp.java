package com.myjava.array;

import java.util.Scanner;

public class sensortemp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();//6 row
        String[] n1 = new String[n];
        for (int i = 0; i < n; i++) {
                n1[i] = sc.next();

        }

            for (int j = 0; j < n; j++) {
                System.out.println(n1[j]);
            }
        }
    }

