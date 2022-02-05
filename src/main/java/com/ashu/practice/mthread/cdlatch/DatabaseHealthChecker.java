package com.ashu.practice.mthread.cdlatch;

import java.util.concurrent.CountDownLatch;

public class DatabaseHealthChecker extends BaseHealthChecker {

    public DatabaseHealthChecker(CountDownLatch latch) {
        super("Database Service", latch);
    }

    @Override
    protected void verifyService() {
        System.out.println("Checking " + this.getServiceName());
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        System.out.println(this.getServiceName() + " is UP");
    }
}
