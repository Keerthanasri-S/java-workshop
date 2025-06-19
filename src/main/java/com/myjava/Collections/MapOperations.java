package com.myjava.Collections;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapOperations {
    public static void main(String[] args) {
        Map<Integer,String> cseStudent = new TreeMap<>();
        cseStudent.put(10001,"keerthana");
        cseStudent.put(10002,"satha");
        cseStudent.put(10003,"madasamy");

        Map<Integer,String> cseStudentA = new HashMap<>();
        cseStudentA.put(10004,"Shoban");
        cseStudentA.put(10009,"kishore");
        cseStudentA.put(10005,"chandra");

        Map<Integer,String> cseStudentB = new HashMap<>();
        cseStudentB.putAll(cseStudent);
        cseStudentB.putAll(cseStudentA);
        System.out.println(cseStudentB);
        System.out.println(cseStudentB.keySet());
        System.out.println(cseStudentB.values());

        Map<Integer,String> cseStudentAmarklist = new HashMap<>();
        cseStudentA.put(10004,"Shoban");
        cseStudentA.put(10005,"kishore");


        Map<Integer,String> cseStudentAlist = new HashMap<>();
        cseStudentAlist.putAll(cseStudent);
        cseStudentAlist.putAll(cseStudentA);
        cseStudentAlist.entrySet().removeAll(cseStudentAmarklist.entrySet());
        System.out.println(cseStudentAlist);

    }
}
