package com.danko.multithreading.parser;

import com.danko.multithreading.entity.Bus;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class BusParser {
    private static Logger logger = LogManager.getLogger();
    private static final String STRING_DELIMITER = "\\s";
    private static final int BUS_NUMBER_POSITION = 0;
    private static final int BUS_PASSENGERS_POSITION = 1;
    private static final int BUS_MAX_PASSENGERS = 2;

    public List<Bus> parse(List<String> lines) {
        List<Bus> buses = new ArrayList<>();

        for (String line : lines) {
            String[] parameters = line.split(STRING_DELIMITER);
            Bus bus = new Bus(Integer.valueOf(parameters[BUS_NUMBER_POSITION]),
                    Integer.valueOf(parameters[BUS_PASSENGERS_POSITION]),
                    Integer.valueOf(parameters[BUS_MAX_PASSENGERS]));
            buses.add(bus);
        }
        logger.log(Level.INFO, "Buses have been parsed...");
        return buses;
    }
}
