package com.ashu.practice.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockExample {
    private final Lock lockA = new ReentrantLock();
    private final Lock lockB = new ReentrantLock();

    public static void main(String[] args) {
        new DeadLockExample().execute();
    }

    public void execute() {
        new Thread(this::processThis, "Thread-A").start();
        new Thread(this::processThat, "Thread-B").start();
    }

    private void processThis() {
        lockA.lock();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lockB.lock();

        lockA.unlock();
        lockB.unlock();
    }

    private void processThat() {
        lockB.lock();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lockA.lock();

        lockA.unlock();
        lockB.unlock();
    }
}
