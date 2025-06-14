package com.myjava.String;

import java.util.Scanner;

public class Comparechar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        char[] reverse = a.toCharArray();
        char b = sc.next().charAt(0);
        int count=0;

        for (int i = 0; i < reverse.length; i++) {
            if (reverse[i] == b) {
                count++;

            }

        }
        if (count>=1) {
            System.out.println(b + " " + count);
        }

        }
    }

