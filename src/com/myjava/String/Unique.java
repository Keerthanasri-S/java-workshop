package com.myjava.String;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Unique {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String sentence=sc.nextLine();
        Set<Character> set = new HashSet<>();
        for(char a: sentence.toCharArray()){// convert string to character using tochararray
            set.add(a);
        }
        System.out.println(set);

    }
}
