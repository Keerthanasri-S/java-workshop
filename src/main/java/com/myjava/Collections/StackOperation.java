package com.myjava.Collections;

import java.util.Stack;

public class StackOperation {
    public static void main(String[] args) {
        Stack<String> Bookshelf= new Stack<>();
        Bookshelf.add("book1");
        Bookshelf.add("book2");
        Bookshelf.add("book3");
        Bookshelf.add("book4");
        System.out.println(Bookshelf.pop());
        System.out.println(Bookshelf);
        System.out.println(Bookshelf.push("book5"));
        System.out.println(Bookshelf);
        System.out.println(Bookshelf.pop());
        System.out.println(Bookshelf.pop());System.out.println(Bookshelf.pop());
        //System.out.println(Bookshelf.pop());
        System.out.println(Bookshelf.peek());
        System.out.println(Bookshelf);


    }
}
