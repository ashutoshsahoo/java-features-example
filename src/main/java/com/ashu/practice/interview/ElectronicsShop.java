package com.ashu.practice.interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * A person wants to determine the most expensive computer keyboard and USB drive that can be purchased with a give budget. Given price lists for keyboards and USB drives and a budget, find the cost to buy them. If it is not possible to buy both items, return .
 * <p>
 * Example
 * The person can buy a , or a . Choose the latter as the more expensive option and return .
 * <p>
 * Function Description
 * <p>
 * Complete the getMoneySpent function in the editor below.
 * <p>
 * getMoneySpent has the following parameter(s):
 * <p>
 * int keyboards[n]: the keyboard prices
 * int drives[m]: the drive prices
 * int b: the budget
 * Returns
 * <p>
 * int: the maximum that can be spent, or  if it is not possible to buy both items
 * Input Format
 * <p>
 * The first line contains three space-separated integers , , and , the budget, the number of keyboard models and the number of USB drive models.
 * The second line contains  space-separated integers , the prices of each keyboard model.
 * The third line contains  space-separated integers , the prices of the USB drives.
 * <p>
 * Constraints
 * <p>
 * The price of each item is in the inclusive range .
 * Sample Input 0
 * <p>
 * 10 2 3
 * 3 1
 * 5 2 8
 * Sample Output 0
 * <p>
 * 9
 * Explanation 0
 * <p>
 * Buy the 2nd keyboard and the 3rd USB drive for a total cost of 8+1=9 .
 * <p>
 * Sample Input 1
 * <p>
 * 5 1 1
 * 4
 * 5
 * Sample Output 1
 * <p>
 * -1
 * Explanation 1
 * <p>
 * There is no way to buy one keyboard and one USB drive because 4+5 > 5, so return -1 .
 */
public class ElectronicsShop {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in))) {

            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int spendLimit = Integer.parseInt(firstMultipleInput[0]);
            int k = Integer.parseInt(firstMultipleInput[1]);
            int d = Integer.parseInt(firstMultipleInput[2]);
            var keyboards = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt).mapToInt(Integer::intValue).toArray();
            var drives = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt).mapToInt(Integer::intValue).toArray();

            System.out.println(getMoneySpent(keyboards, drives, spendLimit));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static int getMoneySpent(int[] keyboards, int[] drives, int s) {
        int max = 0;
        for (int i = keyboards.length - 1; i >= 0; i--) {
            int sum = 0;
            for (int j = drives.length - 1; j >= 0; j--) {
                sum = keyboards[i] + drives[j];
                if (sum > max && sum <= s)
                    max = sum;
            }
        }
        if (max == 0)
            return -1;
        else
            return max;
    }
}
