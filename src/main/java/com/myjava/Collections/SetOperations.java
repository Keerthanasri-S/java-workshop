package com.myjava.Collections;

import java.util.HashSet;
import java.util.Set;

public class SetOperations {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(10);
        set1.add(40);
        set1.add(70);
        set1.add(90);
        set1.add(20);
        Set<Integer> set2=Set.of(30,40,50,20,80);
        set1.addAll(set2);
        System.out.println(set1);
        set1.retainAll(set2);
        System.out.println(set1);
    }


}
