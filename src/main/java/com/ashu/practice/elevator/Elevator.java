package com.ashu.practice.elevator;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.TreeSet;
import java.util.concurrent.PriorityBlockingQueue;

@Getter
@Setter
@Slf4j
public class Elevator {

    public static final String REACHED_FLOOR = "We have reached floor {}";
    private int currentFloor = 0;
    private Direction currentDirection = Direction.UP;
    private State currentState = State.IDLE;

    // jobs which are being processed
    private volatile TreeSet<Request> currentJobs = new TreeSet<>();

    // up jobs which can not be processed now, put up in pending queue
    private TreeSet<Request> upPendingJobs = new TreeSet<>();
    // down jobs which can not be processed now, put up in pending queue
    private TreeSet<Request> downPendingJobs = new TreeSet<>();


    /**
     * Starts Elevator
     */
    public void startElevator() {
        log.info("The Elevator has started functioning");
        while (true) {
            if (checkIfJob()) {
                if (Direction.UP == currentDirection) {
                    Request request = currentJobs.pollFirst();
                    processUpRequest(request);
                    if (currentJobs.isEmpty()) {
                        addPendingDownJobsToCurrentJobs();
                    }
                }

                if (Direction.DOWN == currentDirection) {
                    Request request = currentJobs.pollLast();
                    processDownRequest(request);
                    if (currentJobs.isEmpty()) {
                        addPendingUpJobsToCurrentJobs();
                    }
                }
            }
        }
    }


    private boolean checkIfJob() {
        return !currentJobs.isEmpty();
    }

    private void processUpRequest(Request request) {
        // the Elevator is not on the current floor i.e. source floor. So, first bring it there
        int startFloor = currentFloor;
        if (startFloor < request.getExternalRequest().getSourceFloor()) {
            for (int i = startFloor; i <= request.getExternalRequest().getSourceFloor(); i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie) {
                    log.error(ie.getMessage(), ie);
                }
                log.info(REACHED_FLOOR, i);
                currentFloor = i;
            }
        }

        // The elevator is nw on the same floor where the person has requested it i.e. source floor
        log.info("Reached source floor, opening door");
        startFloor = currentFloor;
        for (int i = startFloor + 1; i <= request.getInternalRequest().getDestinationFloor(); i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                log.error(ie.getMessage(), ie);
            }
            log.info(REACHED_FLOOR, i);
            currentFloor = i;
            if (checkIfNewJobCanBeProcessed(request)) {
                break;
            }
        }
    }

    private void addPendingDownJobsToCurrentJobs() {
        if (!downPendingJobs.isEmpty()) {
            log.info("Pick a pending down job and execute it by putting in current job");
            currentJobs = downPendingJobs;
            currentDirection = Direction.DOWN;
        } else {
            currentState = State.IDLE;
            log.info("The elevator is in Idle state");
        }
    }

    private void processDownRequest(Request request) {
        int startFloor = currentFloor;
        if (startFloor < request.getExternalRequest().getSourceFloor()) {
            for (int i = startFloor; i <= request.getExternalRequest().getSourceFloor(); i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie) {
                    log.error(ie.getMessage(), ie);
                }
                log.info(REACHED_FLOOR, i);
                currentFloor = i;
            }
        }

        // The elevator is nw on the same floor where the person has requested it i.e. source floor
        log.info("Reached source floor, opening door");
        startFloor = currentFloor;
        for (int i = startFloor - 1; i >= request.getInternalRequest().getDestinationFloor(); i--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                log.error(ie.getMessage(), ie);
            }
            log.info(REACHED_FLOOR, i);
            currentFloor = i;
            if (checkIfNewJobCanBeProcessed(request)) {
                break;
            }
        }
    }

    private void addPendingUpJobsToCurrentJobs() {
        if (!upPendingJobs.isEmpty()) {
            log.info("Pick a pending up job and execute it by putting in current job");
            currentJobs = upPendingJobs;
            currentDirection = Direction.UP;
        } else {
            currentState = State.IDLE;
            log.info("The elevator is in Idle state");
        }
    }

    private boolean checkIfNewJobCanBeProcessed(Request currentRequest) {
        if (checkIfJob()) {
            if (Direction.UP == currentDirection) {
                Request request = currentJobs.pollLast();
                if (request.getInternalRequest().getDestinationFloor() < currentRequest.getInternalRequest().getDestinationFloor()) {
                    currentJobs.add(request);
                    currentJobs.add(currentRequest);
                    return true;
                }
                currentJobs.add(request);
            }

            if (Direction.DOWN == currentDirection) {
                Request request = currentJobs.pollFirst();
                if (request.getInternalRequest().getDestinationFloor() > currentRequest.getInternalRequest().getDestinationFloor()) {
                    currentJobs.add(request);
                    currentJobs.add(currentRequest);
                    return true;
                }
                currentJobs.add(request);
            }

        }
        return false;
    }

    public void addJob(Request request) {
        if (currentState == State.IDLE) {
            // check if the elevator is already on the floor on which the user
            // is if yes then we can directly process the destination floor
            if (currentFloor == request.getExternalRequest().getSourceFloor()) {
                log.info("Added current queue job -- lift state is - " + currentState + " location is - "
                        + currentFloor + " to move to floor - " + request.getInternalRequest().getDestinationFloor());
            }
            // check if the elevator is already on the floor on which the user
            // is if no then elevator first needs to move to source floor
            else {
                log.info("Added current queue job -- lift state is - " + currentState + " location is - "
                        + currentFloor + " to move to floor - " + request.getExternalRequest().getSourceFloor());
            }
            currentState = State.MOVING;
            currentDirection = request.getExternalRequest().getDirectionToGo();
            currentJobs.add(request);
        } else if (currentState == State.MOVING) {
            if (request.getExternalRequest().getDirectionToGo() != currentDirection) {
                addToPendingJobs(request);
            } else {
                if (currentDirection == Direction.UP &&
                        request.getInternalRequest().getDestinationFloor() < currentFloor) {
                    addToPendingJobs(request);
                } else if (currentDirection == Direction.DOWN &&
                        request.getInternalRequest().getDestinationFloor() > currentFloor) {
                    addToPendingJobs(request);
                } else {
                    currentJobs.add(request);
                }
            }
        }
    }

    private void addToPendingJobs(Request request) {
        if (request.getExternalRequest().getDirectionToGo() == Direction.UP) {
            log.info("Add to Pending up Jobs");
            upPendingJobs.add(request);
        } else {
            log.info("Add to Pending  down Jobs");
            downPendingJobs.add(request);
        }
    }


}
