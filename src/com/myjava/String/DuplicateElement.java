package com.myjava.String;

import java.util.Scanner;

public class DuplicateElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String element = sc.next();
        char[] letters = element.toCharArray();
        boolean[] found=new boolean[letters.length];
        for (int i = 0; i < letters.length; i++) {
            if(found[i]){
                continue;
            }
            int count = 1;
            for (int j = i+1; j < letters.length; j++) {
                if (letters[i] == letters[j]) {
                    found[j]=true;
                    count++;
                }
            }
            if (count > 1) {
                System.out.println(letters[i] + " " + count);
            }
        }
    }
}
