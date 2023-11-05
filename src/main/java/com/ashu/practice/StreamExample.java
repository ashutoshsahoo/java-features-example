package com.ashu.practice;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class StreamExample {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("ashutosh", 30, 10_000),
                new Employee("Ram", 20, 5_000),
                new Employee("Shyam", 35, 15_000),
                new Employee("Gobind", 25, 10_000)
        );
        averageSalaryAverage(employees);
        averageSalaryAverage(Collections.emptyList());
        totalSalaryReduce(employees);
        joinNamesJoining(employees);
        joinNamesToArray(employees);
        applySummarizing(employees);
        printSquareOfNumbersBefore256();
    }
/*
03:42:20.965 [main] INFO  com.ashu.practice.StreamExample.averageSalaryAverage(35) - Average Salary : 10000.0
03:42:20.970 [main] INFO  com.ashu.practice.StreamExample.averageSalaryAverage(35) - Average Salary : 0.0
03:42:20.972 [main] INFO  com.ashu.practice.StreamExample.totalSalaryReduce(42) - Total Salary : 40000.0
03:42:20.973 [main] INFO  com.ashu.practice.StreamExample.joinNamesJoining(49) - ashutosh,Ram,Shyam,Gobind
03:42:20.974 [main] INFO  com.ashu.practice.StreamExample.joinNamesToArray(56) - [ashutosh, Ram, Shyam, Gobind]
03:42:20.977 [main] INFO  com.ashu.practice.StreamExample.applySummarizing(62) - DoubleSummaryStatistics{count=4, sum=40000.000000, min=5000.000000, average=10000.000000, max=15000.000000}
03:42:21.000 [main] INFO  com.ashu.practice.StreamExample.lambda$printSquareOfNumbersBefore256$2(68) - 1
03:42:21.000 [main] INFO  com.ashu.practice.StreamExample.lambda$printSquareOfNumbersBefore256$2(68) - 2
03:42:21.001 [main] INFO  com.ashu.practice.StreamExample.lambda$printSquareOfNumbersBefore256$2(68) - 4
03:42:21.001 [main] INFO  com.ashu.practice.StreamExample.lambda$printSquareOfNumbersBefore256$2(68) - 8
03:42:21.001 [main] INFO  com.ashu.practice.StreamExample.lambda$printSquareOfNumbersBefore256$2(68) - 16
03:42:21.001 [main] INFO  com.ashu.practice.StreamExample.lambda$printSquareOfNumbersBefore256$2(68) - 32
03:42:21.001 [main] INFO  com.ashu.practice.StreamExample.lambda$printSquareOfNumbersBefore256$2(68) - 64
03:42:21.002 [main] INFO  com.ashu.practice.StreamExample.lambda$printSquareOfNumbersBefore256$2(68) - 128
*/

    private static void averageSalaryAverage(List<Employee> employees) {
        var averageSalary = employees.stream()
                .mapToDouble(Employee::salary)
                .average()
                .orElse(0.0);
        log.info("Average Salary : {}", averageSalary);
    }

    private static void totalSalaryReduce(List<Employee> employees) {
        var totalSalary = employees.stream()
                .map(Employee::salary)
                .reduce(0.0, Double::sum);
        log.info("Total Salary : {}", totalSalary);
    }

    private static void joinNamesJoining(List<Employee> employees) {
        String commaSeparatedNames = employees.stream()
                .map(Employee::name)
                .collect(Collectors.joining(","));
        log.info(commaSeparatedNames);
    }

    private static void joinNamesToArray(List<Employee> employees) {
        var commaSeparatedNames = employees.stream()
                .map(Employee::name)
                .toArray();
        log.info(Arrays.toString(commaSeparatedNames));
    }

    private static void applySummarizing(List<Employee> employees) {
        var stats = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::salary));
        log.info("{}", stats);
    }

    private static void printSquareOfNumbersBefore256() {
        Stream.
                iterate(1, i -> i < 256, i -> i * 2)
                .forEach(n -> log.info("{}", n));
    }
}

record Employee(String name, int age, double salary) {
}