package com.myjava.pratice;

public class Arrayindex {
    public int number(int []arr, int i){
        if(i>= arr.length){
            throw new ArrayIndexOutOfBoundsException("Index out of bound");
        }
        return arr[i];
    }

}
