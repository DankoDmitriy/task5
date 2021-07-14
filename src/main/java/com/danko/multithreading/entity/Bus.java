package com.danko.multithreading.entity;

import com.danko.multithreading.util.BusIdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

import static org.apache.logging.log4j.Level.INFO;

public class Bus implements Runnable {
    private static Logger logger = LogManager.getLogger();
    private long busId;
    private int busNumber;
//    private BusRoute busRoute;
    private int nextStop;

    public Bus(int busNumber) {
        this.busId = BusIdGenerator.generatorId();
        this.busNumber = busNumber;
//        this.busRoute = busRoute;
        this.nextStop = 0;
    }

    public long getBusId() {
        return busId;
    }

    public void setBusId(long busId) {
        this.busId = busId;
    }

    public int getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(int busNumber) {
        this.busNumber = busNumber;
    }

    public void run() {
        logger.log(INFO, String.format("I am Bus number %d and I started my trip.", busNumber));
        BusRoute busRoute = BusRoute.getInstance();
        busRoute.getNextBusStop(nextStop);

        for (int i = 0; i < busRoute.getBusStops().size(); i++) {
            System.out.println("I am on BusStop name = " + busRoute.getBusStops().get(i).getName());

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {

            }
        }
    }
}
