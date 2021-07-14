package com.danko.multithreading.util;

public class BusIdGenerator {
    private static long counter;

    private BusIdGenerator() {
    }

    public static long generatorId() {
        return ++counter;
    }
}
