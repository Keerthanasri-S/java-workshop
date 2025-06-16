package com.myjava.pattern;

import java.util.Scanner;

public class Append {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String degree = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.append(name) + " "+(degree));
    }
}
