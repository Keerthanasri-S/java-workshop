package com.myjava.streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class SumofArray {
    public static void main(String[] args) {
        Integer []sum = {1,2,3,4,5};
        Stream<Integer> sumoOfDigits =  Arrays.stream(sum);
        int total = Arrays.stream(sum).reduce(0,(a,b)->a+b);
        System.out.println(total);

    }
}