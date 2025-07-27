package com.myjava.array;

import java.util.Scanner;

public class Character {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] a = new char[n];
        for(int i=0;i<n;i++){
            a[i]= sc.next().charAt(0);
        }
        String name="" ;
        for(int i=0;i<n;i++){
            name +=String.valueOf(a[i]);

        }
        System.out.println(name);;
    }
}
