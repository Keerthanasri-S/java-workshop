package com.myjava.streams;

import java.util.Arrays;

public class Duplicate {
    public static void main(String[] args) {
        Integer[] arr={1,2,2,3,3,4,4,5,5,6,6};
        //Stream<Integer> Duplicates= Arrays.stream(arr);
        Arrays.stream(arr).distinct().limit(6).forEach(System.out::println);
    }
}
