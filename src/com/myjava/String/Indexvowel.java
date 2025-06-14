package com.myjava.String;

import java.util.Scanner;

public class Indexvowel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String words = sc.next();
        char[] letters = words.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            if ((letters[i] == 'a') || (letters[i] == 'e') || (letters[i] == 'i') || (letters[i] == 'o') ||
                    (letters[i] == 'u')) {
                System.out.println(i);
            }
        }
    }
}





