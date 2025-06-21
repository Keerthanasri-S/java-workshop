package com.myjava.string;

import java.util.Scanner;

public class NameDegree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name= sc.nextLine();
        String degree= sc.nextLine();
        String college= sc.nextLine();
        StringBuilder namewithdegree = new StringBuilder();
        namewithdegree.append(name).append(" I have completed my ");
        namewithdegree.append(degree).append(" in college of ");
        namewithdegree.append( college);

      //  System.out.println("I'm " + name + " I have completed my " + degree+ " in college of "+college);
        System.out.println(namewithdegree);
    }
}
