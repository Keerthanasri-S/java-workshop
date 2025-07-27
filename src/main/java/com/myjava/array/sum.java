package com.myjava.array;

import java.util.Scanner;

public class sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] b = new int[a];
        for(int i=0;i<a;i++){
            b[i]=sc.nextInt();
        }
        int s=0;
        for(int i=0;i<a;i++){
            s+=b[i];
        }
        System.out.println(s);
    }
}
