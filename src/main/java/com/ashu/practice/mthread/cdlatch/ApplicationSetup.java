package com.ashu.practice.mthread.cdlatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ApplicationSetup {

    private static final ApplicationSetup INSTANCE = new ApplicationSetup();

    private ApplicationSetup() {
    }

    public static ApplicationSetup getInstance() {
        return INSTANCE;
    }

    public boolean checkExternalServices() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        List<BaseHealthChecker> services = new ArrayList<>();
        services.add(new CacheHealthChecker(latch));
        services.add(new NetworkHealthChecker(latch));
        services.add(new DatabaseHealthChecker(latch));

        ExecutorService executorService = Executors.newFixedThreadPool(services.size());
        services.forEach(executorService::execute);
        latch.await();
        System.out.println("All the services started, starting main application");
        executorService.shutdownNow();
        return services.parallelStream().allMatch(BaseHealthChecker::isServiceUp);
    }
}
