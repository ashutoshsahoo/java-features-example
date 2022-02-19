package com.ashu.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

public class SpliteratorExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Apple", "Banana", "Orange", "Mango", "Grapes", "Guava", "Pomegranate");
        sequentialTraversal(list);
        trySplit(list);
    }

    private static void sequentialTraversal(List<String> list) {
        Spliterator<String> s = list.spliterator();
        System.out.println(" --- attempting tryAdvance");
        s.tryAdvance(System.out::println);
        System.out.println(" --- bulk traversal");
        s.forEachRemaining(System.out::println);

        System.out.println(" --- attempting tryAdvance again");
        boolean b = s.tryAdvance(System.out::println);
        System.out.println("Element exists: " + b);

/*
 --- attempting tryAdvance
Apple
 --- bulk traversal
Banana
Orange
Mango
Grapes
Guava
Pomegranate
 --- attempting tryAdvance again
Element exists: false
 */
    }

    private static void trySplit(List<String> list) {
        Spliterator<String> s = list.spliterator();
        // An ideal trySplit method should divide its elements exactly in half, allowing balanced parallel computation.
        //The splitting process is termed as 'partitioning' or 'decomposition' as well.
        Spliterator<String> s1 = s.trySplit();

        System.out.println("-- traversing the first half of the spliterator --- ");
        s.forEachRemaining(System.out::println);
        System.out.println("-- traversing the other half of the spliterator --- ");
        s1.forEachRemaining(System.out::println);
    }
/*
-- traversing the first half of the spliterator ---
Mango
Grapes
Guava
Pomegranate
-- traversing the other half of the spliterator ---
Apple
Banana
Orange
 */
}
