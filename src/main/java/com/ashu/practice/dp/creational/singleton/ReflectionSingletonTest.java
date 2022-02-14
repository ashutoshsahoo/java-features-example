package com.ashu.practice.dp.creational.singleton;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;

@Slf4j
public class ReflectionSingletonTest {

    public static void main(String[] args) {
        SingletonStatic instanceOne = SingletonStatic.getInstance();
        SingletonStatic instanceTwo = null;
//        SingletonEnum instanceOne = SingletonEnum.INSTANCE;
//        SingletonEnum instanceTwo = null;
        try {
            Constructor<?>[] constructors = SingletonStatic.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                //Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (SingletonStatic) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        log.info(String.valueOf(instanceOne.hashCode()));
        log.info(String.valueOf(instanceTwo.hashCode()));
    }
}
/*
O/P with SingletonStatic

01:12:00.099 [main] INFO  c.a.p.d.s.ReflectionSingletonTest.main(24) - 1037324811
01:12:00.106 [main] INFO  c.a.p.d.s.ReflectionSingletonTest.main(25) - 1675763772

O/P with SingletonStatic

01:18:32.511 [main] ERROR c.a.p.d.s.ReflectionSingletonTest.main(24) - Cannot reflectively create enum objects
java.lang.IllegalArgumentException: Cannot reflectively create enum objects
	at java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:492)
	at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:480)
	at com.ashu.practice.dp.singleton.ReflectionSingletonTest.main(ReflectionSingletonTest.java:20)
01:18:32.519 [main] INFO  c.a.p.d.s.ReflectionSingletonTest.main(26) - 1924582348
Exception in thread "main" java.lang.NullPointerException: Cannot invoke "com.ashu.practice.dp.singleton.SingletonEnum.hashCode()" because "instanceTwo" is null
	at com.ashu.practice.dp.singleton.ReflectionSingletonTest.main(ReflectionSingletonTest.java:27)


 */