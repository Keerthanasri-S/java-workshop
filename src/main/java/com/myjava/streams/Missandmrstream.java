package com.myjava.streams;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Missandmrstream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String[] name = new String[a];
        for (int i = 0; i < name.length; i++) {
            name[i] = sc.next();
        }
        IntStream.range(0,name.length).mapToObj(i->(i%2==0?"Miss ":"Mr ")+name[i]).forEach(System.out::println);
    }
}
