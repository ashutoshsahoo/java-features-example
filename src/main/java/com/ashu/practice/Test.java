package com.ashu.practice;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class Test {

    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//        log.info("No of n to print");
//        int n = scanner.nextInt();
//
//        log.info("Here is your pattern with input={}", n);
//
//        for (int i = n; i > 0; i--) {
//            for (int j = 1; j <= i; j++) {
//                System.out.print(j + " ");
//            }
//            System.out.println();
//        }

        String s1 = new String("ashu");
        String s2 = "ashu";

        log.info("{}",s1==s2);

    }

}
