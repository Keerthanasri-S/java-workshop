package com.dateandtime;

import java.time.LocalDate;

public class Kid {
    public static void main(String[] args) {
        String date ="2024-05-23";
        LocalDate date1=LocalDate.parse(date);
        System.out.println(date1.plusDays(30));
        System.out.println(date1.plusDays(50));
        System.out.println(date1.plusDays(95));
        System.out.println(date1.plusDays(150));
        System.out.println(date1.plusDays(720));
    }
}
