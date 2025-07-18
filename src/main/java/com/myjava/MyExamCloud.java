package com.myjava;

public class MyExamCloud {
       public static void main(String args[]) {
            try {
                   new MyExamCloud().method();
                  } catch(ArithmeticException e){
                  System.out.print("Arithmetic");
                 } finally {
                  System.out.print("final 1");
//                 } finally {
                 System.out.print("final 2");
                }
        }

           public void method()throws ArithmeticException{
            for(var x=0;x<5;x++){
                 var y = (int)5/x;
                 System.out.print(x);
                }
         }
 }
// Online Java Compiler
// Use this editor to write, compile and run your Java code online
//
//class Main {
//    public static void main(String[] args) {
//        System.out.println("Try programiz.pro");
//        String myArticle =...
//        String code = String.format("""
//        public void print(%s o){
//            System.out.printtln(Objects.toString(o));
//        }
//        }
//        """,myArticle);
//
//        System.out.println(code);
//    }
//}

