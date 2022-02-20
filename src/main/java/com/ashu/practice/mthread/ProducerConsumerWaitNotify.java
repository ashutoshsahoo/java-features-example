package com.ashu.practice.mthread;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerWaitNotify {
    private static final int MAX_CAPACITY = 5;
    private final List<Integer> taskQueue = new ArrayList<>();

    public static void main(String[] args) {
        new ProducerConsumerWaitNotify().runProducerConsumerExample();
    }

    private void runProducerConsumerExample() {
        Thread producer = new Thread(() -> {
            var counter = 0;
            while (true) {
                try {
                    produce(counter++);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }
        }, "Producer");
        Thread consumer = new Thread(() -> {
            while (true) {
                try {
                    consume();
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }
        }, "Consumer");
        producer.start();
        consumer.start();
    }

    private void produce(int counter) throws InterruptedException {
        synchronized (taskQueue) {
            while (taskQueue.size() == MAX_CAPACITY) {
                System.out.println("Queue is full " + Thread.currentThread().getName() + " is waiting , size: " + taskQueue.size());
                taskQueue.wait();
            }
            Thread.sleep(1000);
            taskQueue.add(counter);
            System.out.println("Produced: " + counter);
            taskQueue.notifyAll();
        }
    }


    private void consume() throws InterruptedException {
        synchronized (taskQueue) {
            while (taskQueue.isEmpty()) {
                System.out.println("Queue is empty " + Thread.currentThread().getName() + " is waiting , size: " + taskQueue.size());
                taskQueue.wait();
            }
            Thread.sleep(1000);
            Integer number = taskQueue.remove(0);
            System.out.println("Consumed: " + number);
            taskQueue.notifyAll();
        }
    }

}
