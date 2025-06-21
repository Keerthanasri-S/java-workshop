package com.myjava.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MarkListwithSort {
    public static void main(String[] args) {
        List<Integer>marks=new ArrayList<>();
        marks.add(70);
        marks.add(90);
        marks.add(40);
        marks.add(65);
        System.out.println(marks);
        marks.sort(Comparator.reverseOrder());
        System.out.println(marks);
        marks.sort(Comparator.naturalOrder());
        System.out.println(marks);
    }
}
