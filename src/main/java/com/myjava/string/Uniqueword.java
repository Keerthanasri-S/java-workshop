package com.myjava.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Uniqueword {

        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            String[] words=new String[10];
            for(int i=0;i<10;i++) {
                words[i] = sc.next();
            }
            Map<String,Integer> map=new HashMap<>();
            for(String word:words){

                map.put(word, map.getOrDefault(word,0)+1);
            }
            for(String ch:words)
                if(map.get(ch)==1){
                    System.out.println(ch);
                }
            }

        }



