package com.myjava.string;


public class wordCount {
    public static void main(String[] args) {


        String word = "String is immutable object which stores value as byte array.";
        int c=0;
        for(int i=0;i<word.length();i++){
            if(word.charAt(i) !=' '){
                c++;
            }
        }
        System.out.println(c);

    }



    }


