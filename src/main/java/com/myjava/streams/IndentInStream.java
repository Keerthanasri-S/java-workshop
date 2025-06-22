package com.myjava.streams;

import java.util.Scanner;
import java.util.stream.Stream;

public class IndentInStream {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String word = sc.next().trim();
        Stream.of(word).forEach(System.out::println);
    }
}
