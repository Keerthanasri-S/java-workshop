package com.myjava.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class ListInStream {
    public static void main(String[] args) {
        List<Integer> marks=new ArrayList<>();
        marks.add(70);
        marks.add(90);
        marks.add(40);
        marks.add(65);
       marks.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
        System.out.println(marks.stream().findAny());
    }
    }

