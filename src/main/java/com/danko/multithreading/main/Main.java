package com.danko.multithreading.main;

import com.danko.multithreading.entity.Bus;
import com.danko.multithreading.entity.BusRoute;
import com.danko.multithreading.entity.BusStop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BusStop busStop1 = new BusStop("BusStop1", 2, 6);
        BusStop busStop2 = new BusStop("BusStop2", 1, 10);
        BusStop busStop3 = new BusStop("BusStop3", 3, 5);
        BusStop busStop4 = new BusStop("BusStop4", 1, 1);

        List<BusStop> busStops = new ArrayList<BusStop>(Arrays.asList(busStop1, busStop2, busStop3, busStop4));
        BusRoute busRoute1 = BusRoute.getInstance();
        busRoute1.setBusStops(busStops);
        busRoute1.setBusRouteNumber(100);

        Bus bus1 = new Bus(100);
        Bus bus2 = new Bus(100);
        Bus bus3 = new Bus(100);
        Bus bus4 = new Bus(100);
        Thread bus1Thread = new Thread(bus1);
        Thread bus2Thread = new Thread(bus2);
        Thread bus3Thread = new Thread(bus3);
        Thread bus4Thread = new Thread(bus4);
        bus1Thread.start();
        bus2Thread.start();
        bus3Thread.start();
        bus4Thread.start();
    }
}
