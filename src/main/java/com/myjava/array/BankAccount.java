package com.myjava.array;

import java.util.Scanner;

public class BankAccount {
    private int balance;
    BankAccount(int balance){
        this.balance= balance;
    }
    public void deposit(int amount){
        balance+=amount;
        System.out.println(balance);
    }
    public void  credit(int amount){
        balance-=amount;
        System.out.println(balance);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balance = sc.nextInt();
        BankAccount bankAccount = new BankAccount(balance);
        int amount = sc.nextInt();

        bankAccount.credit(amount);
        bankAccount.deposit(amount);

    }
}
