package com.myjava.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class MaxNumber {
    public static void main(String[] args) {
        Integer[] arr ={1,4,5,9,3,10};
        Integer max =Arrays.stream(arr).sorted(Comparator.reverseOrder()).findFirst().get();
        System.out.println(max);
    }
}
