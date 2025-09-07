package com.myjava.array;

import java.util.Scanner;

public class BankAccount {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balance = sc.nextInt();
        BankAccount bankAccount = new BankAccount(balance);
        int amount = sc.nextInt();

        bankAccount.credit(amount);
        bankAccount.deposit(amount);

    }
}
