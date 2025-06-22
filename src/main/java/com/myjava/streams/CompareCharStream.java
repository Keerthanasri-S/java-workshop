package com.myjava.streams;

import java.util.Scanner;
import java.util.stream.IntStream;

public class CompareCharStream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        char[] reverse = a.toCharArray();
        char b = sc.next().charAt(0);
        long count=IntStream.range(0, reverse.length).filter(i->(reverse[i]==b)).count();
        System.out.println(count);
    }
}
