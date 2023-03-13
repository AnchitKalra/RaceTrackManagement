package com.example.geektrust.model;

import java.time.LocalTime;

public class Suv {

    private String suvNumber;

    private LocalTime entryTime;


    public LocalTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalTime entryTime) {
        this.entryTime = entryTime;
    }

    public String getSuvNumber() {
        return suvNumber;
    }

    public void setSuvNumber(String suvNumber) {
        this.suvNumber = suvNumber;
    }
}
