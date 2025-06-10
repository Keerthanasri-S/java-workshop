package com.myjava.array;

import java.lang.reflect.Array;
import java.util.Scanner;

public class MultidimensionalEven {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[][] n1 = new int[5][5];
            for(int i=0;i<5;i++){
                for(int j=0;j<5;j++){
                    n1[i][j]= sc.nextInt();
                }
            }

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    int a=n1[j][i];
                    if(a%2==0){
                        System.out.println(a);
                    }
                }


            }


        }
    }

