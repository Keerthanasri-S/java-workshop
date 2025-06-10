package com.myjava.array;

import java.util.Scanner;

public class Multidimensional {
    public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            String[][] n1 = new String[6][5];
            for(int i=0;i<6;i++){
                for(int j=0;j<5;j++){
                    n1[i][j]= sc.next();
                }
            }
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 6; j++) {
                    System.out.println(n1[j][i]);
                }
            }
        }


}
