package controlflow;

import java.util.Scanner;

public class Printer1while {
    public void floor(int n,int t) {
        System.out.println(n);
        int i=1;
        while(i<t){

            System.out.println("floor"+i);
            i++;
        }
    }

    public static void main(String[] args) {
       Printer1while printer1while=new Printer1while();

        printer1while.floor(1,4);
        printer1while.floor(2,5);
        printer1while.floor(3,6);

    }
}
