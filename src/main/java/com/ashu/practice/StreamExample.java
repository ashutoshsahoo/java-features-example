package com.ashu.practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("ashutosh", 30, 10_000),
                new Employee("Ram", 20, 5_000),
                new Employee("Shyam", 35, 15_000),
                new Employee("Gobind", 25, 10_000)
        );
//        averageSalary_average(employees);
//        totalSalary_reduce(employees);
//        joinNames_joining(employees);
//        joinNames_toArray(employees);
 //       applySummarizing(employees);
        printSquareOfNumbersBefore256();
    }

    private static void averageSalary_average(List<Employee> employees) {
        var averageSalary = employees.stream()
                .mapToDouble(Employee::salary)
                .average()
                .orElseThrow(NoSuchElementException::new);
        System.out.println("Average Salary : " + averageSalary);
    }

    private static void totalSalary_reduce(List<Employee> employees) {
        var totalSalary = employees.stream()
                .map(Employee::salary)
                .reduce(0.0, Double::sum);
        System.out.println("Total Salary : " + totalSalary);
    }

    private static void joinNames_joining(List<Employee> employees) {
        String commaSeparatedNames = employees.stream()
                .map(Employee::name)
                .collect(Collectors.joining(","));
        System.out.println(commaSeparatedNames);
    }

    private static void joinNames_toArray(List<Employee> employees) {
        var commaSeparatedNames = employees.stream()
                .map(Employee::name)
                .toArray();
        System.out.println(Arrays.toString(commaSeparatedNames));
    }
    private static void applySummarizing(List<Employee> employees) {
        var stats = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::salary));
        System.out.println(stats);
    }

    private static void printSquareOfNumbersBefore256(){
        Stream.
                iterate(1, i -> i < 256, i -> i * 2)
                .forEach(System.out::println);
    }
}

record Employee(String name, int age, double salary) {
}