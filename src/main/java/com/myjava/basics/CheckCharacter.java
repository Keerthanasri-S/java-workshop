package com.myjava.basics;

import java.util.Scanner;

public class CheckCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char a = sc.next().charAt(0);
        if(Character.isAlphabetic(a)){
            System.out.println("character");
        }
        else{
            System.out.println("not");
        }
    }
}
