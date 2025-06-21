package com.myjava.string;

import java.util.Arrays;
import java.util.Scanner;

public class Findword {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String sentence=sc.nextLine();
        System.out.println(sentence.length());//letter length
       //word length
        String [] word=sentence.trim().split("[\\s.,!?]+");
       System.out.println(word.length);
       //paragraph letter
        String []paragraph= sentence.split("\\.");
        System.out.println(Arrays.toString(paragraph));
        System.out.println(paragraph.length);
    }
}

