package com.myjava.streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class MaxNumber {
    public static void main(String[] args) {
        Integer[] arr ={1,4,5,9,3,10};
        Stream<Integer> maxNmber = Arrays.stream(arr);
        int max=Arrays.stream(arr).reduce(0,(a,b)->a>b?a:b);
        System.out.println(max);
    }
}
