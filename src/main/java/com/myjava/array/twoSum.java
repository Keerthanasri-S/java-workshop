package com.myjava.array;

import java.util.Scanner;

public class twoSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] b = new int[a];
        for(int i=0;i<a;i++){
            b[i]=sc.nextInt();
        }
        int c = 8;
        for(int i =0 ;i< a;i++){
            for(int j=i+1;j<a;j++){
                if(b[i]+b[j]==c){
                    System.out.println("("+ b[i]+"," +b[j]+")");
                }
            }
        }
    }
}
