package com.myjava.String;

import java.util.Arrays;
import java.util.Scanner;

public class Vowels {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String words = sc.next();
        char [] letters=words.toCharArray();
        int count = 0;
        for (char word: letters) {
            if ((word=='a') || (word=='e') ||
                    (word=='i') || (word=='o') ||
                    (word=='u')) {
                count++;
            }
        }
        System.out.println( count);
    }
}

