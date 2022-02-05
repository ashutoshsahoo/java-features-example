package com.ashu.practice.interfacee;

import lombok.extern.slf4j.Slf4j;


@FunctionalInterface
interface DBService {

    private static void printConnectionString(String connectionString) {
        System.out.println("DB connectionString is " + connectionString);
    }

    static void printUsername(String username) {
        System.out.println("DB username is " + username);
    }

    private void printPassword(String password) {
        System.out.println("DB password is " + password);
    }

    void testDB();

    private void printDBName(String name) {
        System.out.println("DB name is " + name);
    }

    default void checkParams(String name, String connectionString, String username, String password) {
        System.out.println("CheckParams method called ");
        printDBName(name);
        printConnectionString(connectionString);
        printUsername(username);
        printPassword(password);
    }
}

@FunctionalInterface
interface DBServiceV2 extends DBService {

    @Override
    default void checkParams(String name, String connectionString, String username, String password) {
        System.out.println("override method CheckParams on impl class");
        DBService.super.checkParams(name, connectionString, username, password);
    }
}

@Slf4j
class DBServiceImpl implements DBService {

    @Override
    public void testDB() {
        log.info("called testdb  method");
    }

    @Override
    public void checkParams(String name, String connectionString, String username, String password) {
        log.info("override method CheckParams on child interface");
        DBService.super.checkParams(name, connectionString, username, password);
    }
}

@Slf4j
public class InterfaceExample {
    public static void main(String[] args) {
        DBService dbservice = new DBServiceImpl();
        dbservice.testDB();
        dbservice.checkParams("dbname", "connection string", "root", "root123");
        // lambda function way
        DBServiceV2 dbservicev2 = () -> log.info("called testdb  method using lambda style");
        dbservicev2.testDB();
        dbservicev2.checkParams("dbname2", "connection string2", "root2", "root1232");
    }
/* Output
10:19:13.681 [main] INFO  c.a.p.interfacee.DBServiceImpl.testDB(51) - called testdb  method
10:19:13.681 [main] INFO  c.a.p.interfacee.DBServiceImpl.checkParams(56) - override method CheckParams on child interface
CheckParams method called
DB name is dbname
DB connectionString is connection string
DB username is root
DB password is root123
10:19:13.697 [main] INFO  c.a.p.interfacee.InterfaceExample.lambda$main$0(68) - called testdb  method using lambda style
override method CheckParams on impl class
CheckParams method called
DB name is dbname2
DB connectionString is connection string2
DB username is root2
DB password is root1232

 */
}

