package com.myjava.string;

import java.util.StringTokenizer;

public class Tokenizer {
    public static void main(String[] args) {
        String sentence =  "String is immutable object which stores values of byte array.";
        StringTokenizer word = new StringTokenizer(sentence," ");
        System.out.println(word.countTokens());
        while (word.hasMoreElements()){
            System.out.println(word.nextElement());
        }

    }
}
