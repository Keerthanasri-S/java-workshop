package com.myjava.Streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class SquareStream {
    public static void main(String[] args) {
        Integer []arr = {2,3,4,5,6};
        Stream<Integer>square = Arrays.stream(arr);
        square.map(num->num*num).filter(num1->num1>10).forEach(System.out::println);
    }
}
