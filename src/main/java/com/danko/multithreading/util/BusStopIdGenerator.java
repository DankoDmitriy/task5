package com.danko.multithreading.util;

public class BusStopIdGenerator {
    private static int counter;

    private BusStopIdGenerator() {
    }

    public static long generatorId() {
        return ++counter;
    }
}
