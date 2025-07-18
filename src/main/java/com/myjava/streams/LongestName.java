package com.myjava.streams;

import java.util.Arrays;
import java.util.Comparator;

public class LongestName {
    public static void main(String[] args) {
        String[] names = {"keerthanasri","satha","madasamy","shoban","raja sir"};
//        int maxLength = Arrays.stream(names).map(String::length).sorted(Comparator.reverseOrder()).findFirst().get();
//        Arrays.stream(names).filter(name -> name.length() == maxLength).forEach(System.out::println);
        System.out.println(Arrays.stream(names).sorted(Comparator.comparing(String::length).reversed()).findFirst().get());

    }
}
