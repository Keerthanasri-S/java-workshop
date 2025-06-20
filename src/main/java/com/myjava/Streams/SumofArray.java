package com.myjava.Streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class SumofArray {
    public static void main(String[] args) {
        Integer []sum = {2,3,4,5};
        Stream<Integer> sumoOfDigits =  Arrays.stream(sum);
       sumoOfDigits.map(num->num+num).forEach(System.out::println);

    }
}