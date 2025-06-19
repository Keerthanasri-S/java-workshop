package com.temperature.beans;

import java.util.List;

public class Floor {

    private int floorNumber;
    private String floorName;

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public List<zone> getZones() {
        return zones;
    }

    public void setZones(List<zone> zones) {
        this.zones = zones;
    }

    private List<zone> zones;

}
