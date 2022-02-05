package com.ashu.practice.ds;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Fork(value = 2, jvmArgs = {"-Xms4G", "-Xmx4G"})
@Threads(value = 3)
public class BenchmarkFindDuplicate {

    private FindDuplicates classToJBH;
    private List<Integer> dataForTesting;

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(BenchmarkFindDuplicate.class.getSimpleName())
                .forks(2)
                .build();
        new Runner(options).run();
    }

    @Setup
    public void init() throws NoSuchAlgorithmException {
        classToJBH = new FindDuplicates();
        Random random = SecureRandom.getInstanceStrong();
        dataForTesting = random
                .ints(1000, 1, 1000)
                .boxed()
                .toList();
    }

    @Benchmark
    public void findDuplicateBySetAdd(Blackhole bh) {
        List<Integer> list = classToJBH.findDuplicateBySetAdd(dataForTesting);
        bh.consume(list);
    }

    @Benchmark
    public void findDuplicatesByGrouping(Blackhole bh) {
        List<Integer> list = classToJBH.findDuplicateByGrouping(dataForTesting);
        bh.consume(list);
    }

    @Benchmark
    public void findDuplicatesByFrequency(Blackhole bh) {
        List<Integer> list = classToJBH.findDuplicateByFrequency(dataForTesting);
        bh.consume(list);
    }
}
