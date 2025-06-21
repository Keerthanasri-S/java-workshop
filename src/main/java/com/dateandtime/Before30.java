package com.dateandtime;

import java.time.LocalTime;

public class Before30 {
    public static void main(String[] args) {

        LocalTime time = LocalTime.now().minusMinutes(30);
        System.out.println(time);
    }
}
