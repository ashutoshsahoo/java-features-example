package com.ashu.practice.interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CatAndMouse {

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in))) {

            int count = Integer.parseInt(bufferedReader.readLine().trim());
            List<String> result = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                var positions = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt).mapToInt(Integer::intValue).toArray();
                result.add(findShortDistance(positions[0], positions[1], positions[2]));
            }
            result.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static String findShortDistance(int x, int y, int z) {

        if (Math.abs(x - z) < Math.abs(y - z)) {
            return "Cat A";
        } else if (Math.abs(x - z) > Math.abs(y - z)) {
            return "Cat B";
        } else {
            return "Mouse C";
        }

    }
}
