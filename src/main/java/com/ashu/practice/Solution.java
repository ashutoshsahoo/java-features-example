package com.ashu.practice;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        try (Scanner scanner = new Scanner(System.in)) {
            int queries = Integer.parseInt(scanner.nextLine());
            String[] inputString = new String[queries];
            for (int i = 1; i <= queries; i++) {
                String secondNum = scanner.nextLine();
                inputString[i-1] = secondNum;
            }

            for (String query : inputString) {
                String[] secondNumArray = query.split(" ");
                int a = Integer.parseInt(secondNumArray[0].trim());
                int b = Integer.parseInt(secondNumArray[1].trim());
                int n = Integer.parseInt(secondNumArray[2].trim());
                printSeries(a, b, n);
                System.out.println();
            }
        }
    }

    private static void printSeries(int a, int b, int n) {
        for (int i = 1; i <= n; i++) {
            int sum = a;
            for (int j = 0; j < i; j++) {
                sum += Math.pow(2, j) * b;
            }
            System.out.printf("%d ", sum);
        }

    }
}