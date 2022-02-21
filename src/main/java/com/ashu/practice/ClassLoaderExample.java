package com.ashu.practice;

import org.openjdk.jmh.runner.RunnerException;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ClassLoaderExample {
    public static void main(String[] args) {
        System.out.println("Classloader of PrintWriter:" + PrintWriter.class.getClassLoader());
        System.out.println("Classloader of ArrayList:" + ArrayList.class.getClassLoader());

        System.out.println("Classloader of DataSource:" + DataSource.class.getClassLoader());
        System.out.println("Classloader of AtomicInteger:" + AtomicInteger.class.getClassLoader());

        System.out.println("Classloader of LocalDateTime:" + LocalDateTime.class.getClassLoader());
        System.out.println("Classloader of RunnerException:" + RunnerException.class.getClassLoader());
    }
/*
Classloader of PrintWriter:null // Bootstrap Class Loader
Classloader of ArrayList:null
Classloader of DataSource:jdk.internal.loader.ClassLoaders$PlatformClassLoader@4dd8dc3
Classloader of AtomicInteger:null
Classloader of LocalDateTime:null
Classloader of RunnerException:jdk.internal.loader.ClassLoaders$AppClassLoader@1d44bcfa
 */

}
