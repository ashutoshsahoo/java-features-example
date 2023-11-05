package com.ashu.practice.elevator;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class AddJobWorker implements Runnable {

    private final Elevator elevator;
    private final Request request;

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException ie) {
            log.error(ie.getMessage(), ie);
        }
        elevator.addJob(request);
    }
}
