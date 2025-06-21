package com.myjava.string;

import java.util.*;

public class Unique {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String sentence=sc.nextLine();
        char[] letters=sentence.toCharArray();
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<letters.length;i++){
            char l=letters[i];
            map.put(l, map.getOrDefault(l,0)+1);
        }
        for(int i=0;i<letters.length;i++){
            char l=letters[i];
            if(map.get(l)==1){
                System.out.println(l);
            }
        }

    }
}
