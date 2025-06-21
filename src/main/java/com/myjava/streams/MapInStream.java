package com.myjava.streams;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

public class MapInStream {
    public static void main(String[] args) {
        Map<Integer,String> cseStudent = new TreeMap<>();
        cseStudent.put(10001,"keerthana");
        cseStudent.put(10002,"satha");
        cseStudent.put(10003,"madasamy");

        Map<Integer,String> cseStudentA = new HashMap<>();
        cseStudentA.put(10004,"Shoban");
        cseStudentA.put(10009,"kishore");
        cseStudentA.put(10005,"chandra");

        Map<Integer,String> cseStudentAmarklist = new HashMap<>();
        cseStudentA.put(10004,"Shoban");
        cseStudentA.put(10005,"kishore");
        Stream.of(cseStudent,cseStudentA).flatMap(map->map.entrySet().stream()).
        forEach(System.out::println);

    }
}
