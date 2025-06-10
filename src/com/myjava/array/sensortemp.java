package com.myjava.array;

import java.util.Scanner;

public class sensortemp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();//6 row
        int n2=sc.nextInt();//1 col
        String[][] n1 = new String[n][n2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n2; j++) {
                n1[i][j] = sc.next();
            }
        }
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(n1[j][i]);
            }
        }
    }
}
