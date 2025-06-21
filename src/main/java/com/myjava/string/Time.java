package com.myjava.string;

import java.time.LocalTime;
import java.util.Scanner;

public class Time {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalTime time = LocalTime.of(7,15,45);
        int minute = LocalTime.now().getMinute();
        int second= LocalTime.now().getSecond();
        int hour=LocalTime.now().getHour();
        System.out.println((minute-time.getMinute())+ " minute "+ (second-time.getSecond()) +" seconds " + (hour - time.getHour()) + " hour ");

    }
}
