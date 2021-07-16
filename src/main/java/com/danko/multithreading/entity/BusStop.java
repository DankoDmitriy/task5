package com.danko.multithreading.entity;

import com.danko.multithreading.util.BusStopIdGenerator;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BusStop {
    private long busStopId;
    private String name;
    private int busesMax;
    private long timeStop;
    private Integer busesCount = 0;
    private Semaphore semaphore;
    private Lock busStopLock = new ReentrantLock(true);

    public BusStop() {
        busStopId = BusStopIdGenerator.generatorId();
    }

    public BusStop(String name, int busesMax, long timeStop) {
        busStopId = BusStopIdGenerator.generatorId();
        this.name = name;
        this.busesMax = busesMax;
        this.timeStop = timeStop;
        semaphore = new Semaphore(busesMax, true);
    }

    public void busParking(Bus bus) {
//        busStopLock.lock();
//        if (busesCount <= busesMax) {
//            System.out.println(String.format("Bus id = %d stopped. He`s route is = %d. Bus stop name = %s",
//                    bus.getBusId(), bus.getBusNumber(), name));
//            busesCount++;
//        }
//        busStopLock.unlock();
//        try {
////            System.out.println("Passengers are transferring...");
//            System.out.printf("BusStopName = %s. BusMax = %d. Now here buses= %d%n", name, busesMax, busesCount);
//            TimeUnit.SECONDS.sleep(timeStop);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        busStopLock.lock();
//        busesCount--;
//        busStopLock.unlock();
////        System.out.println("Bus drive to next bus stop...");


//        todo - WORKing
        try {
            semaphore.acquire();
            System.out.println("QueueLength = " + semaphore.getQueueLength() + " Name = " + name);
            synchronized (busesCount) {
                if (busesCount <= busesMax) {
                    System.out.println(String.format("Bus id = %d stopped. He`s route is = %d. Bus stop name = %s",
                            bus.getBusId(), bus.getBusNumber(), name));
                    busesCount++;
                }
            }
//            System.out.println("Passengers are transferring...");
            System.out.printf("BusStopName=%s. BusMax=%d. Now here buses=%d%n", name, busesMax, busesCount);
            TimeUnit.SECONDS.sleep(timeStop);
            synchronized (busesCount) {
                busesCount--;
            }
            semaphore.release();
//            System.out.println("Bus drive to next bus stop...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getBusesCount() {
        return busesCount;
    }

    public void setBusesCount(int busesCount) {
        this.busesCount = busesCount;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public long getBusStopId() {
        return busStopId;
    }

    public void setBusStopId(long busStopId) {
        this.busStopId = busStopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBusesMax() {
        return busesMax;
    }

    public void setBusesMax(int busesMax) {
        this.busesMax = busesMax;
    }

    public long getTimeStop() {
        return timeStop;
    }

    public void setTimeStop(long timeStop) {
        this.timeStop = timeStop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BusStop busStop = (BusStop) o;

        if (busStopId != busStop.busStopId) return false;
        if (busesMax != busStop.busesMax) return false;
        if (timeStop != busStop.timeStop) return false;
        return name != null ? name.equals(busStop.name) : busStop.name == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (busStopId ^ (busStopId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + busesMax;
        result = 31 * result + (int) (timeStop ^ (timeStop >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BusStop{");
        sb.append("busStopId=").append(busStopId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", busCount=").append(busesMax);
        sb.append(", timeStop=").append(timeStop);
        sb.append('}');
        return sb.toString();
    }
}
