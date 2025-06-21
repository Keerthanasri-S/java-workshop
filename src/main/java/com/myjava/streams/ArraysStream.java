package com.myjava.streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArraysStream {
    public static void main(String[] args) {
        int []values = {1,2,4,6,8,5,3,7};
        Stream<Integer> number = Arrays.stream(values).boxed();
        number.filter(value->value%2==0).forEach(System.out::println);
    }
}
