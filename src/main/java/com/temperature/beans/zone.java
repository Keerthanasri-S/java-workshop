package com.temperature.beans;

import java.util.List;

public class zone {
        private List<Sensor> sensors;

        public int getZoneNumber() {
                return zoneNumber;
        }

        public void setZoneNumber(int zoneNumber) {
                this.zoneNumber = zoneNumber;
        }

        public String getZoneName() {
                return zoneName;
        }

        public void setZoneName(String zoneName) {
                this.zoneName = zoneName;
        }

        public int getNoOfRooms() {
                return noOfRooms;
        }

        public void setNoOfRooms(int noOfRooms) {
                this.noOfRooms = noOfRooms;
        }

        public String getZoneType() {
                return zoneType;
        }

        public void setZoneType(String zoneType) {
                this.zoneType = zoneType;
        }

        private int zoneNumber;
        private String zoneName;
        private int noOfRooms;
        private String zoneType;


}
