package com.temperaturedata.beans;

public interface Sensor {
    public float getReading();
    public float getReading(ReadingUnit unit);
}
