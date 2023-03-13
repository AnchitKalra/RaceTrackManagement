package com.example.geektrust.model;

import java.time.LocalTime;

public class Bike {

    private String bikeNumber;

    private LocalTime entryTime;


    public LocalTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalTime entryTime) {
        this.entryTime = entryTime;
    }

    public String getBikeNumber() {
        return bikeNumber;
    }

    public void setBikeNumber(String bikeNumber) {
        this.bikeNumber = bikeNumber;
    }
}
