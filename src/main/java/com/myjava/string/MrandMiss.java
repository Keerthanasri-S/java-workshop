package com.myjava.string;

import java.util.Scanner;

public class MrandMiss {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a= sc.nextInt();
        String [] names=new String[a];
        for(int i=0;i< names.length;i++){
            names[i]=sc.next();
        }
        for(int i=0;i< names.length;i++){
            if(i%2!=0){
                System.out.println("Mr"+" "+names[i]);
            }
            else {
                System.out.println("Miss"+" "+names[i]);
            }
        }
    }
}
