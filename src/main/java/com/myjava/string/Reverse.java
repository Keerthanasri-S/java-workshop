package com.myjava.string;

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String a=sc.nextLine();
        char[] reverse=a.toCharArray();
        int i=0 ;
        int j=reverse.length-1;
        while(i<j){
            char temp=reverse[i];
            reverse[i]=reverse[j];
            reverse[j]=temp;
            i++;
            j--;
        }
        for(i=0;i<reverse.length;i++){
            System.out.print(reverse[i]);
        }
    }
}
