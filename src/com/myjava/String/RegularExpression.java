package com.myjava.String;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
    public static void main(String[] args) {
        Pattern name=Pattern.compile(" ((a-zA-Z)&&[aeiou]");
        Matcher matcher = name.matcher("keerthana");
        System.out.println(matcher.find());
    }
}
