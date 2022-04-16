package com.ashu.practice.hackerrank;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly
 * four of the five integers. Then print the respective minimum and maximum values as
 * a single line of two space-separated long integers.
 */
public class MiniMaxSum {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt).toList();
        //List<Integer> arr = List.of(1, 2, 3, 4, 5);
        List<Integer> arr = List.of(1_000_000_000, 2, 3, 4, 5_000_000);

        miniMaxSum(arr);

//        bufferedReader.close();
    }

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        List<Long> sum = new ArrayList<>(5);

        for (int i = 0; i < arr.size(); i++) {
            Long count = 0L;
            for (int j = 0; j < arr.size(); j++) {
                if (i != j) count += arr.get(j);
            }
            sum.add(count);
        }
        System.out.println(sum.stream().min(Long::compareTo).get() + " " + sum.stream().max(Long::compareTo).get());
    }
}
