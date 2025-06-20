package com.myjava.Generic;

import java.util.*;

public class TypeSafety {
    public static void main(String[] args) {
        List mylist = new ArrayList();
        mylist.add("keerthana");
        mylist.add(40);
        mylist.add(40.28922);
        System.out.println(mylist);

        String name = (String)mylist.get(0);
        System.out.println(name);

        Integer number =(Integer)mylist.get(1);
        System.out.println(number);

    }
}
