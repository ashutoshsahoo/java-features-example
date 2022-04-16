package com.ashu.practice.interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FormingMagicSquare {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in))) {

            int[][] s = new int[3][3];

            IntStream.range(0, 3).forEach(i -> {
                try {
                    s[i] =
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                    .map(Integer::parseInt)
                                    .mapToInt(Integer::intValue)
                                    .toArray();

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            System.out.println(formingMagicSquare(s));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static int formingMagicSquare(int[][] s) {
        int cost = Integer.MAX_VALUE;
        int[][] t =
                {
                        {4, 9, 2, 3, 5, 7, 8, 1, 6},
                        {4, 3, 8, 9, 5, 1, 2, 7, 6},
                        {2, 9, 4, 7, 5, 3, 6, 1, 8},
                        {2, 7, 6, 9, 5, 1, 4, 3, 8},
                        {8, 1, 6, 3, 5, 7, 4, 9, 2},
                        {8, 3, 4, 1, 5, 9, 6, 7, 2},
                        {6, 7, 2, 1, 5, 9, 8, 3, 4},
                        {6, 1, 8, 7, 5, 3, 2, 9, 4},
                };
        int temp = 0;
        for (int i = 0; i < 8; i++) {
            temp = Math.abs(s[0][0] - t[i][0]) + Math.abs(s[0][1] - t[i][1]) + Math.abs(s[0][2] - t[i][2]) + Math.abs(s[1][0] - t[i][3]) + Math.abs(s[1][1] - t[i][4]) + Math.abs(s[1][2] - t[i][5]) + Math.abs(s[2][0] - t[i][6]) + Math.abs(s[2][1] - t[i][7]) + Math.abs(s[2][2] - t[i][8]);
            cost = Math.min(temp, cost);
        }
        return cost;
    }
}