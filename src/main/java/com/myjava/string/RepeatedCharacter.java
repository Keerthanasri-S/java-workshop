package com.myjava.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RepeatedCharacter {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String word=sc.nextLine();
        Map<Character, Integer> map = new HashMap<>();
        for(char words:word.toCharArray()){
            map.put(words,map.getOrDefault(words,0)+1);
    }
        System.out.println(map);
        for(char words:map.keySet()){
            if(map.get(words)>1){
                System.out.println(words+" "+map.get(words));
            }
        }
    }
}
