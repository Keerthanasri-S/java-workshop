package com.myjava.array;

import java.util.Scanner;

public class BuildingName {
    public void build(){
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        String[] building=new String[n];
        for(int i=0;i<n;i++) {
            building[i]=sc.next();
        }
        for(int i=0;i<n;i++) {
            System.out.println(building[i]);
        }
    }


}
