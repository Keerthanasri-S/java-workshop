package com.myjava.collections;

import java.util.LinkedList;
import java.util.Queue;

public class QueueOperation {
    public static void main(String[] args) {
        Queue<Integer> admissionQueue = new LinkedList<>();
        admissionQueue.add(500);
        admissionQueue.add(300);
        admissionQueue.add(600);
        admissionQueue.add(400);
        System.out.println(admissionQueue);
        System.out.println(admissionQueue.remove());
        System.out.println(admissionQueue);
        admissionQueue.add(200);
        System.out.println(admissionQueue);
        Integer rollNumber=admissionQueue.poll() ;
//        while(rollNumber!=null){
//            System.out.println(rollNumber);
//            rollNumber=admissionQueue.poll();
//        }
        System.out.println(admissionQueue.peek());
        System.out.println(admissionQueue.peek());

    }
}
