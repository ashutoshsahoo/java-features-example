package com.ashu.practice.hackerrank;

import org.apache.commons.math3.util.Precision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.stream.Stream;



/**
 * Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero.
 * Print the decimal value of each fraction on a new line with 6 places after the decimal.
 */
public class PlusMinus {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt).toList();
        List<Integer> arr1 = List.of(1,7,-2,3,-5,7,0);
        plusMinus(arr1);

       // bufferedReader.close();
    }

    /**
     * I/O
     * STDIN           Function
     * -----           --------
     * 6               arr[] size n = 6
     * -4 3 -9 0 4 1   arr = [-4, 3, -9, 0, 4, 1]
     *
     * Output
     *
     * 0.500000
     * 0.333333
     * 0.166667
     *
     */

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        double positiveNoCount = 0;
        double negativeNoCount = 0;
        double zeroCount = 0;

        for(Integer number: arr){
            if(number > 0) positiveNoCount++;
            else if(number < 0) negativeNoCount++;
            else zeroCount++;
        }
        NumberFormat numberFormat = new DecimalFormat("#0.000000");
        double positiveNoRatio = positiveNoCount / arr.size();
        System.out.println(positiveNoRatio);
        // apache common lang
        System.out.println(Precision.round(positiveNoRatio,6));
        // BigDecimal
        BigDecimal bd = BigDecimal.valueOf(positiveNoRatio).setScale(6, RoundingMode.HALF_EVEN);
        System.out.println(numberFormat.format(bd.doubleValue()));
        System.out.println(numberFormat.format(positiveNoRatio));
        System.out.println(numberFormat.format(negativeNoCount/ arr.size()));
        System.out.println(numberFormat.format(zeroCount/ arr.size()));
    }

}
