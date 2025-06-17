package com.myjava.String;

import java.util.Scanner;

public class CamelCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        sc.nextLine();
        String[] word= new String[a];
        for(int i=0;i< word.length;i++){
            word[i]= sc.nextLine().trim();
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i< word.length;i++){
            String words = word[i].toLowerCase();
            if(i==0){
                sb.append(words);
            }
            else{
                sb.append(Character.toUpperCase(words.charAt(0)));
                sb.append(words.substring(1));
            }
        }
        System.out.println(sb.toString());
    }
}
