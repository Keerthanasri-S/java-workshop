package com.DateAndTime;

import java.time.LocalDate;

public class LeapDay {
    public static void main(String[] args) {
        boolean date1 = LocalDate.now().isLeapYear();
        System.out.println(date1);
    }
}
