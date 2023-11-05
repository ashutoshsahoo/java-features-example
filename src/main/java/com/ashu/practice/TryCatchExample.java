package com.ashu.practice;

public class TryCatchExample {
    public static void main(String[] args) {
        try {
            System.out.println("try block");
            throw new RuntimeException("some exception");
//            System.exit(0);
        } catch (Exception e) {
            System.out.println("catch block");
        } finally {
            System.out.println("finally block");
            new String("");
        }
    }
/*
try block
 */
}
