package com.myjava.streams;

import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IndexVowelInStream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String words = sc.next();
        char[] letters = words.toCharArray();
        IntStream.range(0, letters.length).filter(i->"aeiouAEIOU".indexOf(letters[i]) !=-1).forEach(i-> System.out.println(i+" "+letters[i]));
    }
}
