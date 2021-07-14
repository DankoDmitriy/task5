package com.danko.multithreading.entity;

import com.danko.multithreading.util.BusStopIdGenerator;

public class BusStop {
    private long busStopId;
    private String name;
    private int busesMax;
    private long timeStop;

    public BusStop() {
        busStopId = BusStopIdGenerator.generatorId();
    }

    public BusStop(String name, int busesMax, long timeStop) {
        busStopId = BusStopIdGenerator.generatorId();
        this.name = name;
        this.busesMax = busesMax;
        this.timeStop = timeStop;
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
