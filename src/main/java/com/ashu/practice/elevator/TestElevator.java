package com.ashu.practice.elevator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestElevator {
    public static void main(String[] args) {
        log.info("Starting Elevator");
        Elevator elevator = new Elevator();
        // Thread to start the Elevator
        ProcessJobWorker processJobWorker = new ProcessJobWorker(elevator);
        Thread t1 = new Thread(processJobWorker);
        t1.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ie) {
            log.error(ie.getMessage(), ie);
        }

        // person wants to go to UP direction from 0 floor
        ExternalRequest er = new ExternalRequest(Direction.UP, 0);

        // destination floor is 5
        InternalRequest ir = new InternalRequest(5);

        Request request1 = new Request(ir, er);

        // pass the job to the elevator

        new Thread(new AddJobWorker(elevator, request1)).start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }

    }
}
