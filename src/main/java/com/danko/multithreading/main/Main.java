package com.danko.multithreading.main;

import com.danko.multithreading.entity.Bus;
import com.danko.multithreading.entity.BusRoute;
import com.danko.multithreading.entity.BusStop;
import com.danko.multithreading.parser.BusParser;
import com.danko.multithreading.parser.BusStopParser;
import com.danko.multithreading.reader.TextReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static Logger logger = LogManager.getLogger();
    private static final String BUSES_PATCH = "test_data\\buses.txt";
    private static final String BUSES_STOPS_PATCH = "test_data\\bus_stops.txt";

    public static void main(String[] args) throws Exception {
        BusParser busParser = new BusParser();
        BusStopParser busStopParser = new BusStopParser();

        List<String> lines = TextReader.readLines(BUSES_STOPS_PATCH);
        List<BusStop> busStops = busStopParser.parse(lines);

        lines = TextReader.readLines(BUSES_PATCH);
        List<Bus> buses = busParser.parse(lines);

        BusRoute busRoute = BusRoute.getInstance();
        busRoute.setBusStops(busStops);
        busRoute.setBusRouteNumber(100);

        ExecutorService executorForBuses = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        buses.forEach(executorForBuses::execute);

        executorForBuses.shutdown();

        boolean allBusesFinished = false;
        while (!allBusesFinished){
            allBusesFinished = buses.stream().allMatch(bus -> bus.getNextStop() == 4);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                logger.log(Level.ERROR, "Buses were interrupted: ", e);
                Thread.currentThread().interrupt();
            }
        }
    }
}
