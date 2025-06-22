package com.myjava.streams;

import java.util.Scanner;
import java.util.stream.Stream;

public class FindWordInStream {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String sentence=sc.nextLine();
        Stream.of(sentence.length()).forEach(System.out::println);

        String[]  words =sentence.split(" ");
        long word=Stream.of(words).count();
        System.out.println(word);

        String[] paragraph = sentence.split("\\.");
        long paragraph1=Stream.of(paragraph).count();
        System.out.println(paragraph1);
    }
}
