package com.ashu.practice.mthread.cdlatch;

public class CountDownLatchExample {

    public static void main(String[] args) {
        boolean result = false;

        try {
            result = ApplicationSetup.getInstance().checkExternalServices();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("External services validation completed !! Result was :: " + result);
    }
/* Output
Checking Cache Service
Checking Database Service
Checking Network Service
Cache Service is UP
Network Service is UP
Database Service is UP
All the services started, starting main application
External services validation completed !! Result was :: true
 */
}
