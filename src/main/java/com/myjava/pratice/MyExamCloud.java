//package com.myjava.pratice;
//
//
////Saved as MyExamCloud.java
//    class Account {}
//    class StandardAccount extends Account {}
//    class PremiumAccount extends Account {
//        int monthsRemaining() {
//            return 10;
//        }
//    }
//    public class MyExamCloud{
//        record point(int i, int j){}
//        static void testType(Object o) {
//            switch (o) {
//                case null -> System.out.println("null");
//                case String s -> System.out.println("String");
//                case StandardAccount a -> System.out.println("Account");
//                case PremiumAccount p -> System.out.println("PremiumAccount");
//                case int[] ia -> System.out.println("Array");
//                default -> System.out.println("Something else");
//            }}
//        public static void main(String as[]) {
//            testType(new PremiumAccount());
//            testType(new StandardAccount());
//            testType(new Account());
//            testType(null);
//            testType("");
//            testType(new int[] {
//                    1, 2, 3, 4, 5
//            });
//        }}
//
//
