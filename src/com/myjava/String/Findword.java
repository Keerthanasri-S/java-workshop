package com.myjava.String;

import java.util.Arrays;
import java.util.Scanner;

public class Findword {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String sentence=sc.nextLine();
        System.out.println(sentence);
        char[] chars=sentence.toCharArray();
        for(char a:chars) System.out.println(a);
    }
}

