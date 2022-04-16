package com.ashu.practice.interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Checks whether the input string with brackets is balanced or not
 */
public class BracketBalance {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in))) {
            String input = null;
            do {
                System.out.println("Please provide the input string");
                input = reader.readLine();
                if (isBalanced(input)) {
                    System.out.println("Balanced");
                } else {
                    System.out.println("Not Balanced");
                }
            } while (!("exit".equalsIgnoreCase(input)));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Checks whether the input string with brackets is balanced or not
     *
     * @param input input string
     * @return true if balanced otherwise false
     */
    private static boolean isBalanced(String input) {
        if (input == null) {
            return false;
        }
        String inputTrimmed = input.trim();
        if (inputTrimmed.length() == 0 || inputTrimmed.length() % 2 != 0) {
        //if (inputTrimmed.length() == 0) { // for parenthesis with text
            return false;
        }
        char[] chars = inputTrimmed.toCharArray();
        Deque<Character> characterDeque = new ArrayDeque<>(chars.length);
        for (char aChar : chars) {
            if (aChar == '[' || aChar == '{' || aChar == '(') {
                characterDeque.push(aChar);
            } else if (aChar == ']' || aChar == '}' || aChar == ')') {
                if (characterDeque.isEmpty()) {
                    break;
                }
                char lastChar = characterDeque.pop();
                return isCharMatch(lastChar, aChar);
            }
        }
        return false;
    }


    private static boolean isCharMatch(char i, char o) {
        return switch (i) {
            case '[' -> o == ']';
            case '{' -> o == '}';
            case '(' -> o == ')';
            default -> false;
        };

    }
}
