package com.temperature.model;

import java.sql.Timestamp;

public record Temp_dataRep(Integer tempData, Timestamp dateTime,Integer sensor_id) {
}
