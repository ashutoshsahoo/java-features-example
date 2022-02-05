package com.ashu.practice.comparee;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Slf4j
public class CompareExample {
    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "ashu", 30);
        Employee emp2 = new Employee(3, "xashutosh", 31);
        Employee emp3 = new Employee(4, "mashu3", 34);
        Employee emp4 = new Employee(2, "tashu4", 31);
        List<Employee> employees = new ArrayList<>(4);
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);
        log.info("Before sorting \n {}", employees);
        Collections.sort(employees);
        log.info("After sorting by default \n {}", employees);
        employees.sort(Comparator.comparing(Employee::name));
        log.info("After sorting by name \n {}", employees);
        employees.sort(Comparator.comparing(Employee::age));
        log.info("After sorting by age \n {}", employees);
        employees.sort(Comparator.comparing(Employee::age).reversed());
        log.info("After sorting by age reversed \n {}", employees);
        employees.sort(Comparator.comparing(Employee::age).reversed().thenComparing(Employee::name));
        log.info("After sorting by age reversed and name \n {}", employees);
    }
}

/* Output
10:14:53.000 [main] INFO  c.a.practice.comparee.CompareExample.main(22) - Before sorting
 [Employee[id=1, name=ashu, age=30], Employee[id=3, name=xashutosh, age=31], Employee[id=4, name=mashu3, age=34], Employee[id=2, name=tashu4, age=31]]
10:14:53.032 [main] INFO  c.a.practice.comparee.CompareExample.main(24) - After sorting by default
 [Employee[id=1, name=ashu, age=30], Employee[id=2, name=tashu4, age=31], Employee[id=3, name=xashutosh, age=31], Employee[id=4, name=mashu3, age=34]]
10:14:53.032 [main] INFO  c.a.practice.comparee.CompareExample.main(26) - After sorting by name
 [Employee[id=1, name=ashu, age=30], Employee[id=4, name=mashu3, age=34], Employee[id=2, name=tashu4, age=31], Employee[id=3, name=xashutosh, age=31]]
10:14:53.047 [main] INFO  c.a.practice.comparee.CompareExample.main(28) - After sorting by age
 [Employee[id=1, name=ashu, age=30], Employee[id=2, name=tashu4, age=31], Employee[id=3, name=xashutosh, age=31], Employee[id=4, name=mashu3, age=34]]
10:14:53.047 [main] INFO  c.a.practice.comparee.CompareExample.main(30) - After sorting by age reversed
 [Employee[id=4, name=mashu3, age=34], Employee[id=2, name=tashu4, age=31], Employee[id=3, name=xashutosh, age=31], Employee[id=1, name=ashu, age=30]]
10:14:53.053 [main] INFO  c.a.practice.comparee.CompareExample.main(32) - After sorting by age reversed and name
 [Employee[id=4, name=mashu3, age=34], Employee[id=2, name=tashu4, age=31], Employee[id=3, name=xashutosh, age=31], Employee[id=1, name=ashu, age=30]]

 */


record Employee(int id, String name, int age) implements Comparable<Employee> {

    @Override
    public int compareTo(Employee o) {
        return this.id - o.id;
    }
}