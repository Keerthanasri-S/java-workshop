package com.myjava.array;

import java.util.Arrays;
import java.util.Scanner;

public class Append {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int buildingnumber = sc.nextInt();
        String[] Building = new String[buildingnumber];
        for (int i = 0; i < buildingnumber; i++) {
            Building[i] = sc.next();
        }
        int count = 0;
        for (int i = 0, j = 0; i < buildingnumber; i++) {
            if (!Building[i].equals("c")) {
                Building[j] = Building[i];
                j++;
            }
            if(Building[i].equals("c")){
                count++;
            }
        }
        for (int i = buildingnumber-count ; i < buildingnumber; i++) {
            Building[i] = null;
        }
        for (int j = 0; j < buildingnumber; j++) {
            System.out.println(Building[j]);
        }

    }
}
