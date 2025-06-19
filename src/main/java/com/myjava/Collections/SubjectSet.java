package com.myjava.Collections;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SubjectSet {
    public static void main(String[] args) {
        TreeSet<String> subjects = new TreeSet<>(Comparator.reverseOrder());
        subjects.add("tamil");
        subjects.add("english");
        subjects.add("maths");
        subjects.add("science");
        subjects.add("social");
        System.out.println(subjects);
        System.out.println(subjects.removeLast());
        System.out.println(subjects);
    }
}
