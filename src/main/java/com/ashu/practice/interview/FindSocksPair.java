package com.ashu.practice.interview;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * There is a large pile of socks that must be paired by color. Given an array of integers representing the color of each sock,
 * determine how many pairs of socks with matching colors there are.
 * <p>
 * Example
 * <p>
 * <p>
 * There is one pair of color  and one of color . There are three odd socks left, one of each color. The number of pairs is .
 * <p>
 * Function Description
 * <p>
 * Complete the sockMerchant function in the editor below.
 * <p>
 * sockMerchant has the following parameter(s):
 * <p>
 * int n: the number of socks in the pile
 * int ar[n]: the colors of each sock
 * Returns
 * <p>
 * int: the number of pairs
 * Input Format
 * <p>
 * The first line contains an integer , the number of socks represented in .
 * The second line contains  space-separated integers, the colors of the socks in the pile.
 * <p>
 * Constraints
 * <p>
 * where
 * Sample Input
 * <p>
 * STDIN                       Function
 * -----                       --------
 * 9                           n = 9
 * 10 20 20 10 10 30 50 10 20  ar = [10, 20, 20, 10, 10, 30, 50, 10, 20]
 * Sample Output
 * <p>
 * 3
 */
public class FindSocksPair {
    public static void main(String[] args) {
        int n = 9;
        List<Integer> list = List.of(10, 20, 20, 10, 10, 30, 50, 10, 20);
        System.out.println(sockMerchant(n, list));
    }


    public static int sockMerchant(int n, List<Integer> ar) {
        var longMap = ar.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.reducing(0, e -> 1, Integer::sum)));
        return longMap.values().stream().reduce(0, (a, b) -> a + b / 2);
    }

}
