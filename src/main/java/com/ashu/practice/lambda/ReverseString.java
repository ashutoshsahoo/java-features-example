package com.ashu.practice.lambda;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class ReverseString {

    private static final String NOT_NULL_MESSAGE = "This should not be null";

    public static void main(String[] args) {
        String s = "ashutosh";
        String reverseString = reverseWithoutMethod(s);
        System.out.printf("Reverse of %s  is %s and it is %s", s, reverseString, Objects.equals(reverseString, "hsotuhsa"));
        String reverseStringLambda = reverseWithLambda(s);
        System.out.printf("%nReverse of %s  is %s and it is %s", s, reverseStringLambda, Objects.equals(reverseStringLambda, "hsotuhsa"));
        reverseWordWithDot();
    }
/*
Reverse of ashutosh  is hsotuhsa and it is true
Reverse of ashutosh  is hsotuhsa and it is true
Reverse of abcd.efg.qwerty  is dcba.gfe.ytrewq and it is true
 */
    private static String reverseWithoutMethod(String s) {
        Objects.requireNonNull(s, NOT_NULL_MESSAGE);
        char[] charArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = charArray.length - 1; i >= 0; i--) {
            sb.append(charArray[i]);
        }
        return sb.toString();
    }

    private static String reverseWithLambda(String s) {
        Objects.requireNonNull(s, NOT_NULL_MESSAGE);
        UnaryOperator<String> function = rs -> new StringBuilder(rs).reverse().toString();
        return function.apply(s);
    }

    private static void reverseWordWithDot() {
        // Given a String of length S, reverse the whole string without reversing the individual words in it. Words are separated by dots.
        String str = "abcd.efg.qwerty";
        String reversed = Arrays.stream(str.split("\\.")).map(m -> new StringBuilder(m).reverse().toString()).collect(Collectors.joining("."));
        System.out.printf("%nReverse of %s  is %s and it is %s", str, reversed, Objects.equals(reversed, "dcba.gfe.ytrewq"));
    }
}
