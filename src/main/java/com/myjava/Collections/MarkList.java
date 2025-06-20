package com.myjava.Collections;

import java.util.ArrayList;
import java.util.List;

public class MarkList {
    public static void main(String[] args) {
        List<Integer> marks = new ArrayList<>();
        marks.add(70);
        marks.add(50);
        marks.add(80);
        marks.add(60);
        marks.add(90);
        int max= marks.get(0);
        for(int mark:marks){
            if(mark > max){
                max=mark;
            }
        }
        System.out.println(max);
        }
    }
