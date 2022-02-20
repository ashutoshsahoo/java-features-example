package com.ashu.practice.mthread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
    public static void main(String[] args) throws InterruptedException {
        RunnableTask runnableTask = new RunnableTask();
        Thread t1 = new Thread(runnableTask, "t1");
        t1.start();
        Thread t2 = new Thread(runnableTask, "t2");
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Processing count=" + runnableTask.getCount());
    }
}

class RunnableTask implements Runnable {

    //private int count = 0;
    private AtomicInteger count = new AtomicInteger();

    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            processSomething(i);
           // count++;
            count.incrementAndGet();
        }
        System.out.println("Count=" + count);
    }

    public int getCount() {
       // return count;
        return count.get();
    }

    private void processSomething(int i) {
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
