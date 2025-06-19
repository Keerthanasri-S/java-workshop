package com.myjava.Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Names {
   public static void main(String[] args) {
        List<String> name = new Vector<>();
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
//
//        Iterator<String> iterator = name.iterator();
//        //iterator.forEachRemaining(System.out::println);
//
//        while(iterator.hasNext()){
//            String names = iterator.next();
//            if(names.equals("satha")){
//                name.remove(names);
//            }
//            System.out.println(names);
//
//        }
        System.out.println(name);
    }
}
