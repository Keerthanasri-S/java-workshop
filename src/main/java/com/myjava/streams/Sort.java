package com.myjava.streams;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        String[] arr ={"apple","orange","banana","kiwi"};
        Arrays.stream(arr).sorted().map(String::toUpperCase).forEach(System.out::println);
    }
}
