package com.myjava.String;



import java.util.Arrays;
import java.util.Scanner;

public class wordCount {
    public static void main(String[] args) {


        String word = "String is immutable object which stores value as byte array.";
//        int c=0;
//        for(int i=0;i<word.length();i++){
//            if(word.charAt(i) !=' '){
//                c++;
//            }
//        }
//        System.out.println(c);
        String []words = word.split(" ");
        int c = 0;
        for(int i=0;i< words.length;i++) {

            c+=i;
        }
        System.out.println(c);
    }



    }


