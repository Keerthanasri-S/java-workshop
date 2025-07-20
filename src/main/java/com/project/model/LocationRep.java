package com.project.model;

public record LocationRep(
        Integer id,
        String doorno,
        int street,
        String areaname,
        String city,
        String district,
        String state,
        String country,
        String pincode,
        double latitude,
        double longitude
) {}