package com.myjava.array;

import java.util.Scanner;

public class sensortemp1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();//6 row
        int n2=sc.nextInt();//1 col
        int [][] n1 = new int[n][n2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n2; j++) {
                n1[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < n; j++) {
                int a=n1[j][i];
                if(a<18 || a>28){
                    System.out.println(a + "out is range");
                }
            }
        }
    }
}
