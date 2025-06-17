package com.myjava.String;

import java.util.Scanner;

public class Reverseword {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        String []sentence =new String[a];
        for(int i=0;i<a;i++) {
            sentence[i] = sc.next();
        }
        int j=0;
        int k=a-1;
        while(j<k){
            String temp=sentence[j];
            sentence[j]=sentence[k];
            sentence[k]=temp;
            j++;
            k--;
        }
        for(String word:sentence){
            System.out.print(word+" ");
        }


    }
}
