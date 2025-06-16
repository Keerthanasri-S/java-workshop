package com.DateAndTime;

import java.time.LocalTime;
import java.util.Scanner;

public class Before30 {
    public static void main(String[] args) {

        LocalTime time = LocalTime.now().minusMinutes(30);
        System.out.println(time);
    }
}
