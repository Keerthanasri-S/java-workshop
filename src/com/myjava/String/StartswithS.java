package com.myjava.String;

import java.util.Scanner;

public class StartswithS {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int a = sc.nextInt();
        sc.nextLine();
        String[] buildingNames= new String[a];
        for(int i=0;i< buildingNames.length;i++){
            buildingNames[i]= sc.nextLine();
        }
        for(int i=0;i< buildingNames.length;i++){
            if(buildingNames[i].toLowerCase().startsWith("s")){
                System.out.println(buildingNames[i]);
            }
        }
    }
}
