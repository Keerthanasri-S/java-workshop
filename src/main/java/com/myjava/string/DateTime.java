package com.myjava.string;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class DateTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    Date today =new Date();
    System.out.println(today);
    LocalDate dateofbirth =  LocalDate.of(2004,3,27);
       System.out.println(LocalDate.now().compareTo(dateofbirth));
       int dayOfMonth = LocalDate.now().getDayOfMonth();
        int year= LocalDate.now().getYear();
        int month=LocalDate.now().getMonthValue();
      System.out.println((year-dateofbirth.getYear())+ " years "+ (month-dateofbirth.getMonthValue()) +" months " + (dayOfMonth - dateofbirth.getDayOfMonth()) + " days ");
         String a = sc.next();
         LocalDate date =LocalDate.parse(a);
        System.out.println(date);
        System.out.println(date.format(DateTimeFormatter.ofPattern("dd-LLLL-YYYY")));



    }
}
