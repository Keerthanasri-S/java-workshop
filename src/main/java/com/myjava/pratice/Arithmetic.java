package com.myjava.pratice;

public class Arithmetic {
    public int division(int a ,int b){
        if(b==0){
            throw new ArithmeticException("you can't divide number by 0");
        }
        return a/b;
    }
}
