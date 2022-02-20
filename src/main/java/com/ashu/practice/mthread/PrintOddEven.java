package com.ashu.practice.mthread;

public class PrintOddEven {
    public static void main(String[] args)  {
        new PrintOddEven().printOddEvenInDifferentThreads();
    }

    private void printOddEvenInDifferentThreads() {
        final Object lock = new Object();
        Thread odd = new Thread(() -> {
            synchronized (lock) {
                for (int i = 1; i < 10; i += 2) {
                    System.out.println(Thread.currentThread().getName() + "-" + i);
                    lock.notifyAll();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notifyAll();
            }
        }, "Odd");
        odd.start();

        Thread even = new Thread(() -> {
            synchronized (lock) {
                for (int i = 2; i <= 10; i += 2) {
                    System.out.println(Thread.currentThread().getName() + "-" + i);
                    lock.notifyAll();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notifyAll();
            }
        }, "Even");
        even.start();

    }
}

