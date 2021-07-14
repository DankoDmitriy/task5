package com.danko.multithreading.main;

import com.danko.multithreading.entity.Bus;
import com.danko.multithreading.entity.BusRoute;
import com.danko.multithreading.entity.BusStop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws Exception {
        BusStop busStop1 = new BusStop("BusStop1", 2, 10);
        BusStop busStop2 = new BusStop("BusStop2", 2, 5);
        BusStop busStop3 = new BusStop("BusStop3", 1, 15);
        BusStop busStop4 = new BusStop("BusStop4", 3, 12);

        List<BusStop> busStops = new ArrayList<BusStop>(Arrays.asList(busStop1, busStop2, busStop3, busStop4));
        BusRoute busRoute1 = BusRoute.getInstance();
        busRoute1.setBusStops(busStops);
        busRoute1.setBusRouteNumber(100);

        Bus bus1 = new Bus(100);
        Thread bus1Thread = new Thread(bus1);
        bus1Thread.start();

//        bus1Thread.interrupt();

        for (int i = 0; i < 15; i++) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("main");
        }


    }
}
