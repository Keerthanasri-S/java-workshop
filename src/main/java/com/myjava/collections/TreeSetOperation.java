package com.myjava.collections;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetOperation {
    public static void main(String[] args) {
        Set<String> names = new TreeSet<>(Comparator.reverseOrder());
        names.add("keerthana");
        names.add("satha");
        names.add("madasamy");
        names.add("shoban");
        System.out.println(names);
    }
}
