package com.myjava.array;

import java.util.Arrays;
import java.util.Scanner;

public class Sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] b = new int[a];
        for(int i=0;i<a;i++){
            b[i]=sc.nextInt();
        }
        for(int i=0;i<a;i++){
            System.out.print(b[i]);
        }

        int i=0;
        int j= a-1;
        while(i<j){
            int t= b[i];
            b[i]= b[j];
            b[j]=t;
            i++;j--;
        }
        for (int k =0 ;k<a ;k++){
            System.out.print(b[k]);
        }
    }
}
