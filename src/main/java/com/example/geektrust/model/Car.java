package com.example.geektrust.model;

import java.time.LocalTime;

public class Car {

    private String carNumber;

    private LocalTime entryTime;


    public LocalTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalTime entryTime) {
        this.entryTime = entryTime;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }
}
