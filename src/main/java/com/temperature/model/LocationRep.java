package com.temperature.model;

public record LocationRep(
        Integer location_id,
        String location_name,
        String address,
        Integer org_id) {}