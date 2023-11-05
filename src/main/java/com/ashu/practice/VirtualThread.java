package com.ashu.practice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VirtualThread {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                log.info("Index: {}", i);
            }
        };

        Thread.ofVirtual().start(runnable);
    }
}
