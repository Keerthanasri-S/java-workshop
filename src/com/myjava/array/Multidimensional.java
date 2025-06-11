package com.myjava.array;

import java.util.Scanner;

public class Multidimensional {
    public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            String[][] TemperatureArray = new String[5][6];
            for(int i=0;i<5;i++){
                for(int j=0;j<6;j++){
                    TemperatureArray[i][j]= sc.next();
                }
            }
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 6; j++) {
                    System.out.print(TemperatureArray[i][j]+" ");
                    if(j==5){
                        System.out.print(",");
                    }

                }
                System.out.println();
            }
        }


}
