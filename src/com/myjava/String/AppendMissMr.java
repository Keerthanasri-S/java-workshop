package com.myjava.String;

import java.util.Scanner;

public class AppendMissMr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String[] name = new String[a];
        for (int i = 0; i < name.length; i++) {
            name[i] = sc.next();
        }

        StringBuffer namewithtitle = new StringBuffer();
        for(int i =0;i< name.length;i++){
            if(i%2==0){
                System.out.println(namewithtitle.insert(0,"Mr.").append(name[i]));
            }
            else{
                System.out.println(namewithtitle.insert(0,"Miss.").append(name[i]));

            }
            namewithtitle.delete(0,namewithtitle.length());
        }

    }
}
