package com.myjava.array;

import java.util.Scanner;

public class Multidimensional {
    public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            int n=sc.nextInt();
            String[][] n1 = new String[n][n];

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    n1[i][j]= sc.next();
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n1.length; j++) {
                    System.out.println(n1[j][i]);
                }
            }
        }


}
