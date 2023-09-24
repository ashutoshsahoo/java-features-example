package com.ashu.practice.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        Integer[] arr = {1, 1, 3, 2, 1};
        System.out.println(countingSort(Arrays.asList(arr)));
    }

    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code
        List<Integer> res = new ArrayList<>(Collections.nCopies(100, 0));
        for (Integer no : arr) {
            res.set(no, res.get(no) + 1);
        }
        return res;
    }
}
