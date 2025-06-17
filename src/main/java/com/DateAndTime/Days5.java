package com.DateAndTime;

import java.time.LocalDate;

public class Days5 {
    public static void main(String[] args) {
        LocalDate date =LocalDate.now().minusDays(5);
        System.out.println(date);
    }
}
