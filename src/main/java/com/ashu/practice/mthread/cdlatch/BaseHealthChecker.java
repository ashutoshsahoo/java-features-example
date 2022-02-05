package com.ashu.practice.mthread.cdlatch;

import java.util.concurrent.CountDownLatch;

public abstract class BaseHealthChecker implements Runnable {

    private final String serviceName;
    private final CountDownLatch latch;
    private boolean serviceUp;

    protected BaseHealthChecker(String serviceName, CountDownLatch latch) {
        this.serviceName = serviceName;
        this.latch = latch;
        this.serviceUp = false;
    }

    @Override
    public void run() {
        try {
            verifyService();
            serviceUp = true;
        } catch (Throwable t) {
            System.err.println(t.getMessage());
            serviceUp = false;
        } finally {
            if (latch != null) {
                latch.countDown();
            }
        }
    }

    public String getServiceName() {
        return serviceName;
    }

    public boolean isServiceUp() {
        return serviceUp;
    }

    protected abstract void verifyService();
}
