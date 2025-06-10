package controlflow;

import java.util.Scanner;

public class printer1 {
    public void floor(int n,int t) {
        for (int j = 1; j <= n; j++) {
            System.out.println("building" + j);
            for (int i = 1; i <= t; i++) {
                System.out.println("floor" + i);
            }
        }
    }

    public static void main(String[] args) {
        printer1 print1 =new printer1();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int n1= sc.nextInt();
        int n2= sc.nextInt();
        int n3= sc.nextInt();
        print1.floor(n,n1);
        print1.floor(n,n2);
        print1.floor(n,n3);

    }
}
