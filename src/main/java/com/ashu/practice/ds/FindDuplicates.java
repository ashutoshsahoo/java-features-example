package com.ashu.practice.ds;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicates {

    public static void main(String[] args) {
        FindDuplicates findDuplicates = new FindDuplicates();
        // 3, 4, 9
        List<Integer> list = List.of(5, 3, 4, 1, 3, 7, 2, 9, 9, 4);
        List<Integer> result = findDuplicates.findDuplicateBySetAdd(list);
        System.out.println("Find duplicates: " + result);

        List<Integer> findDuplicateBySetAddParallel = findDuplicates.findDuplicateBySetAddParallel(list);
        System.out.println("Find duplicates: " + findDuplicateBySetAddParallel);

        List<Integer> findDuplicateByGrouping = findDuplicates.findDuplicateByGrouping(list);
        System.out.println("Find duplicates: " + findDuplicateByGrouping);

        List<Integer> findDuplicateByFrequency = findDuplicates.findDuplicateByFrequency(list);
        System.out.println("Find duplicates: " + findDuplicateByFrequency);


//        List<Integer> removeDuplicateBySet = findDuplicates.removeDuplicateBySet(list);
//        System.out.println("Remove duplicates: " + removeDuplicateBySet);
    }

    public <T> List<T> findDuplicateByFrequency(List<T> list) {
        return list.stream()
                .filter(i -> Collections.frequency(list, i) > 1)
                .toList();
    }

    public <T> List<T> findDuplicateByGrouping(List<T> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
    }

    public <T> List<T> findDuplicateBySetAdd(List<T> list) {
        Set<T> set = new HashSet<>();
        return list.stream().filter(n -> !set.add(n)).toList();
    }

    public <T> List<T> findDuplicateBySetAddParallel(List<T> list) {
        Set<T> set = new HashSet<>();
        return list.parallelStream().filter(n -> !set.add(n)).toList();
    }

    public <T> List<T> removeDuplicateBySet(List<T> list) {
        Set<T> set = new HashSet<>();
        return list.stream().filter(set::add).toList(); // O(n)
        // maintain element order TC- O(n^2)
//        Set<T> set = new LinkedHashSet<>(list);
//        return set.stream().toList();
    }
}
