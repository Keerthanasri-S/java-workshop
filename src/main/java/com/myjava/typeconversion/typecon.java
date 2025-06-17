package com.myjava.typeconversion;

import java.util.Arrays;
import java.util.Scanner;

public class typecon {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int[] temperature=new int[n];
        for(int i=0;i<n;i++){
            temperature[i]= Integer.parseInt(sc.next());
        }
      
        for(int i=0;i<n;i++) {
            System.out.println(temperature[i]);
        }




    }
}
