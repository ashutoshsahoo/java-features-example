package com.ashu.practice.elevator;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProcessJobWorker implements Runnable {

    private final Elevator elevator;

    @Override
    public void run() {
        // start Elevator
        elevator.startElevator();
    }
}
