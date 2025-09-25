package com.myjava.array;

import java.util.Scanner;

public class MAx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int []b = new int[a];
        for(int i=0;i<a;i++){
            b[i]=sc.nextInt();
        }
        int n=b[0];
        int c= Integer.MIN_VALUE;
        for(int i=0;i<a;i++){
            if(b[i]>n){
                n=b[i];
            }
        }
        for(int j=0;j<a;j++){
            if(b[j]>c && b[j]<n){
                c=b[j];
            }
        }
        System.out.println(c);
    }
}
