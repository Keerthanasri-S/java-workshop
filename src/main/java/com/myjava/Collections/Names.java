package com.myjava.Collections;

import java.util.ArrayList;
import java.util.List;

public class Names {
    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("Keerthana");
        name.add("Satha");
        name.add("madasamy");
        name.add("shoban");
        System.out.println(name);
        name.removeFirst();
        System.out.println(name);

        List<String>names = new ArrayList<>();
        names.addAll(name);
        System.out.println(names);
        names.add("vijay");
        names.add("senthil");

        System.out.println( names.subList(0,2));

    }
}
