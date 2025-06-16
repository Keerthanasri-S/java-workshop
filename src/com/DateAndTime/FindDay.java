package com.DateAndTime;

import java.time.LocalDate;

public class FindDay {
    public static void main(String[] args) {
        String date1= "2025-03-15";
    int date = LocalDate.parse(date1).getDayOfYear();
        System.out.println(date);
    }
}
