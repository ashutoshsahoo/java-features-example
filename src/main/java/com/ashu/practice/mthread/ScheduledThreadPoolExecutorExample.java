package com.ashu.practice.mthread;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorExample {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        System.out.println("Starting Thread-" + LocalDateTime.now());
        scheduledExecutorService.schedule(() -> System.out.println("Running after 10 seconds-" + LocalDateTime.now()), 10, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
        boolean awaitTermination = scheduledExecutorService.awaitTermination(5, TimeUnit.MINUTES);
        if (awaitTermination) {
            System.out.println("Successful termination");
        }
    }
}
