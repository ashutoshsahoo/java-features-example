package com.ashu.practice.recordd;

import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
public record Employee(int id, String name) implements Serializable, Comparable<Employee> {
    public static void main(String[] args) {
        log.info("main method started");
        Employee emp1 = new Employee(1, "ashutosh");
        Employee emp2 = new Employee(1, "ashu");
        log.info("Employee1 : {}", emp1);
        log.info("Employee2 : {}", emp2);
        log.info("if emp1==emp2 ? Ans : {}", emp1.equals(emp2));
        log.info("if emp1.compareTo(emp2) ? Ans : {}", emp1.compareTo(emp2));
        log.info("emp1 hashcode={}, emp2 hashcode={}", emp1.hashCode(), emp2.hashCode());
        log.info("emp1 id ={}", emp1.id());
        log.info("emp2 name ={}", emp2.name());
    }
/*
10:22:14.407 [main] INFO  com.ashu.practice.recordd.Employee.main(10) - main method started
10:22:14.407 [main] INFO  com.ashu.practice.recordd.Employee.main(13) - Employee1 : Employee[id=1, name=ashutosh]
10:22:14.454 [main] INFO  com.ashu.practice.recordd.Employee.main(14) - Employee2 : Employee[id=1, name=ashu]
10:22:14.454 [main] INFO  com.ashu.practice.recordd.Employee.main(15) - if emp1==emp2 ? Ans : false
10:22:14.454 [main] INFO  com.ashu.practice.recordd.Employee.main(16) - if emp1.compareTo(emp2) ? Ans : 4
10:22:14.454 [main] INFO  com.ashu.practice.recordd.Employee.main(17) - emp1 hashcode=-673331346, emp2 hashcode=3003614
10:22:14.454 [main] INFO  com.ashu.practice.recordd.Employee.main(18) - emp1 id =1
10:22:14.454 [main] INFO  com.ashu.practice.recordd.Employee.main(19) - emp2 name =ashu
 */
    @Override
    public int compareTo(Employee o) {
        return name.compareTo(o.name());
    }
}