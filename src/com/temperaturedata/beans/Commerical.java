package com.temperaturedata.beans;

import java.util.Calendar;

public class Commerical extends Building{
    private Calendar openHour;
    private Calendar closeHour;
    public void setOpenHour(Calendar openHour){
        this.openHour=openHour;

    }
    public void setcloseHour(Calendar closeHour){
        this.openHour=openHour;

    }
    public Calendar getOpenHour(){
        return openHour;
    }
    public Calendar getCloseHour(){
        return closeHour;
    }

    @Override
    void ebbill() {

    }
}
