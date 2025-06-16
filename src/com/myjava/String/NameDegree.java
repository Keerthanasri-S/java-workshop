package com.myjava.String;

import java.util.Scanner;

public class NameDegree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name= sc.nextLine();
        String degree= sc.nextLine();
        String college= sc.nextLine();
        StringBuilder namewithdegree = new StringBuilder();
        namewithdegree.append(name);
        namewithdegree.append(degree);
        namewithdegree.append(college);
        System.out.println("I'm " + name + " I have completed my " + degree+ " in college of "+college);

    }
}
