package com.danko.multithreading.parser;

import com.danko.multithreading.entity.BusStop;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class BusStopParser {
    private static Logger logger = LogManager.getLogger();
    private static final String STRING_DELIMITER = "\\s";
    private static final int BUS_STOP_NAME = 0;
    private static final int BUS_STOP_MAX_BUS = 1;
    private static final int BUS_STOP_TIME_STOP = 2;
    private static final int BUS_STOP_PASSENGERS = 3;

    public List<BusStop> parse(List<String> lines) {
        List<BusStop> busStops = new ArrayList<>();

        for (String line : lines) {
            String[] parameters = line.split(STRING_DELIMITER);
            BusStop busStop = new BusStop(
                    parameters[BUS_STOP_NAME],
                    Integer.valueOf(parameters[BUS_STOP_MAX_BUS]),
                    Integer.valueOf(parameters[BUS_STOP_TIME_STOP]),
                    Integer.valueOf(parameters[BUS_STOP_PASSENGERS]));
            busStops.add(busStop);
        }
        logger.log(Level.INFO, "Bus stops have been parsed...");
        return busStops;
    }
}
