package com.danko.multithreading.util;

public class BusRouteIdGenerator {
    private static long counter;

    private BusRouteIdGenerator() {
    }

    public static long geratorId() {
        return ++counter;
    }
}
