package com.ashu.practice.ds.search;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Fork(value = 2, jvmArgs = {"-Xms4G", "-Xmx4G","-Xss1G"})
@Threads(value = 3)
public class BenchmarkBinarySearch {

    private int[] dataForTesting;
    private int searchItem;

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(BenchmarkBinarySearch.class.getSimpleName())
                .forks(2)
                .build();
        new Runner(options).run();
    }

    @Setup
    public void init() throws NoSuchAlgorithmException {
        Random random = SecureRandom.getInstanceStrong();
        dataForTesting = random
                .ints(10, 1, 100)
                .toArray();
        searchItem = random.nextInt(1, 100);
    }


    @Benchmark
    public void benchmarkSearchIterative(Blackhole bh) {
        int index = BinarySearch.searchIterative(dataForTesting, searchItem);
        bh.consume(index);
    }


    @Benchmark
    public void benchmarkSearchRecursive(Blackhole bh) {
        int index = BinarySearch.searchRecursive(dataForTesting, searchItem, 0, dataForTesting.length);
        bh.consume(index);
    }
}
