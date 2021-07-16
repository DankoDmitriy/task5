package com.danko.multithreading.entity;

import com.danko.multithreading.util.BusIdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.apache.logging.log4j.Level.INFO;

public class Bus implements Runnable {
    private static Logger logger = LogManager.getLogger();
    private long busId;
    private int busNumber;
    private int nextStop;

    public Bus(int busNumber) {
        this.busId = BusIdGenerator.generatorId();
        this.busNumber = busNumber;
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
        logger.log(INFO, String.format("I am Bus number %d, my route is %d and I started my trip.", busId, busNumber));
        BusRoute busRoute = BusRoute.getInstance();
        int busStopsInRoute = busRoute.getBusStops().size();
        for (; nextStop < busStopsInRoute; nextStop++) {
            BusStop busStop = busRoute.getNextBusStop(nextStop);
//            System.out.println(busStop.getName());
            busStop.busParking(this);
        }
    }
}
