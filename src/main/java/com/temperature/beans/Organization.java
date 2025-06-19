package com.temperature.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Organization implements Serializable {
    //creating a location array
    private List<Location> locations;
    private String name;
    private String certificateid;
    private String type;
    private LocalDate dateofinitaial;
    private String email;
    private String phone;
    private String ceo;

    public Location[] getLocations() {
        return locations;
    }

    public void setLocations(Location[] locations) {
        this.locations = locations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCertificateid() {
        return certificateid;
    }

    public void setCertificateid(String certificateid) {
        this.certificateid = certificateid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getdateofinitaial() {
        return dateofinitaial;
    }

    public void setdateofinitaial(LocalDate dateofinitaial) {
        this.dateofinitaial = dateofinitaial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }
    public String toString() {
        return this.name + " " +
                this.phone;
    }
}
