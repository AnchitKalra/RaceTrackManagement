package com.example.geektrust.service;

import com.example.geektrust.Constants;
import com.example.geektrust.model.Bike;
import com.example.geektrust.model.Car;
import com.example.geektrust.model.Suv;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class BookingService {

  private   static int bikeCount = 0;
  private   static int carCount = 0;
  private   static int suvCount = 0;

  private   static int vipCarCount = 0;

   private static int vipSuvCount = 0;
    private int vipAmount = 0;

   private Bike bike[] = new Bike[10];
   private Car car[] = new Car[10];
   private Suv suv[] = new Suv[10];

   private Map<String, String> map = new HashMap<>();


    public int getVipAmount() {
        return vipAmount;
    }

    public void setVipAmount(int vipAmount) {
        this.vipAmount = vipAmount;
    }

    public LocalTime minTime() {
        LocalTime minLocalTime = LocalTime.parse("13:00");
        return minLocalTime;
    }

    public LocalTime maxTime() {
        LocalTime maxLocalTIme = LocalTime.parse("20:00");
        return maxLocalTIme;

    }
    public int book(String input[]) {
        int amount = 0;
        switch (input[1]) {
            case Constants.BIKE:
                LocalTime localTime = LocalTime.parse(input[3]);
                if(localTime.compareTo(minTime()) < 0) {
                    System.out.println(Constants.INVALID_ENTRY_TIME);
                    return 0;
                }
                if(localTime.plusHours(3).compareTo(maxTime()) > 0) {
                    System.out.println(Constants.INVALID_ENTRY_TIME);
                    return 0;
                }
                if(bikeCount < 4) {
                    amount += 60 * 3;
                    bike[bikeCount] = new Bike();
                    bike[bikeCount].setBikeNumber(input[2]);
                    bike[bikeCount].setEntryTime(localTime);
                    map.put(input[2], Constants.BIKE);
                    System.out.println("SUCCESS");
                    bikeCount++;
                }
                else {
                    for (int i = 0; i < bikeCount; i++) {
                        LocalTime time = bike[i].getEntryTime();
                       time = time.plusHours(3);
                        if(localTime.compareTo(time) > 0) {
                            bike[i] = new Bike();
                            bike[i].setBikeNumber(input[2]);
                            bike[i].setEntryTime(localTime);
                            map.put(input[2], Constants.BIKE);
                            amount += 60 * 3;
                            System.out.println("SUCCESS");
                            return amount;
                        }
                    }
                    System.out.println("RACETRACK_FULL");
                    return 0;
                }


                return amount;


            case Constants.CAR:
                localTime = LocalTime.parse(input[3]);
                if(localTime.compareTo(minTime()) < 0) {
                    System.out.println(Constants.INVALID_ENTRY_TIME);
                    return 0;
                }
                if(localTime.plusHours(3).compareTo(maxTime()) > 0) {
                    System.out.println(Constants.INVALID_ENTRY_TIME);
                    return 0;
                }
                if(carCount < 2) {
                    amount += 120 * 3;
                    car[carCount] = new Car();
                    car[carCount].setCarNumber(input[2]);
                    car[carCount].setEntryTime(localTime);
                    carCount++;
                    System.out.println("SUCCESS");
                    map.put(input[2], Constants.CAR);
                    return amount;
                }
                else {
                    for (int i = 0; i < carCount; i++) {
                        LocalTime time = car[i].getEntryTime();
                        time = time.plusHours(3);
                        if (localTime.compareTo(time) > 0) {
                            car[i] = new Car();
                            car[i].setCarNumber(input[2]);
                            car[i].setEntryTime(localTime);
                            amount += 120 * 3;
                            System.out.println("SUCCESS");
                            map.put(input[2], Constants.CAR);
                            return amount;
                        }
                    }
                    if(vipCarCount < 1) {
                        car[vipCarCount] = new Car();
                        car[vipCarCount].setCarNumber(input[2]);
                        car[vipCarCount].setEntryTime(localTime);
                        map.put(input[2], Constants.CAR);
                        vipCarCount++;
                        setVipAmount(getVipAmount() + (250 * 3));
                        System.out.println("SUCCESS");
                        return 0;
                    }
                    else {
                        LocalTime time = car[vipCarCount - 1].getEntryTime();
                       time = time.plusHours(3);
                        if(localTime.compareTo(time) > 0) {
                            car[--vipCarCount] = new Car();
                            car[vipCarCount].setCarNumber(input[2]);
                            car[vipCarCount].setEntryTime(localTime);
                            setVipAmount(getVipAmount() + (250 * 3));
                            vipCarCount++;
                            System.out.println("SUCCESS");
                            map.put(input[2], Constants.CAR);
                            return 0;
                        }

                        System.out.println("RACETRACK_FULL");
                        return 0;
                    }
                }





            case Constants.SUV:
                localTime = LocalTime.parse(input[3]);
                if(localTime.compareTo(minTime()) < 0) {
                    System.out.println(Constants.INVALID_ENTRY_TIME);
                    return 0;
                }
                if(localTime.plusHours(3).compareTo(maxTime()) > 0) {
                    System.out.println(Constants.INVALID_ENTRY_TIME);
                    return 0;
                }
                if(suvCount < 2) {
                    amount += 200 * 3;
                    suv[suvCount] = new Suv();
                    suv[suvCount].setSuvNumber(input[2]);
                    suv[suvCount].setEntryTime(localTime);
                    suvCount++;
                    System.out.println("SUCCESS");
                    map.put(input[2], Constants.SUV);
                    return amount;
                }
                else {
                    for (int i = 0; i < suvCount; i++) {
                        LocalTime time = suv[i].getEntryTime();
                        time = time.plusHours(3);
                        if (localTime.compareTo(time) > 0) {
                            suv[i] = new Suv();
                            suv[i].setSuvNumber(input[2]);
                            suv[i].setEntryTime(localTime);
                            amount += 200 * 3;
                            System.out.println("SUCCESS");
                            map.put(input[2], Constants.SUV);
                            return amount;
                        }
                    }
                    if(vipSuvCount < 1) {
                        suv[vipSuvCount] = new Suv();
                        suv[vipSuvCount].setSuvNumber(input[2]);
                        suv[vipSuvCount].setEntryTime(localTime);
                        vipSuvCount++;
                        setVipAmount(getVipAmount() + (300 * 3));
                        System.out.println("SUCCESS");
                        map.put(input[2], Constants.SUV);
                        return 0;
                    }
                    else {
                        LocalTime time = suv[vipSuvCount - 1].getEntryTime();
                        time = time.plusHours(3);
                        if(localTime.compareTo(time) > 0) {
                            suv[--vipSuvCount] = new Suv();
                            suv[vipSuvCount].setSuvNumber(input[2]);
                            suv[vipSuvCount].setEntryTime(localTime);
                            setVipAmount(getVipAmount() + (300 * 3));
                            vipSuvCount++;
                            System.out.println("SUCCESS");
                            map.put(input[2], Constants.SUV);
                            return 0;
                        }

                        System.out.println("RACETRACK_FULL");
                        return 0;
                    }
                }





        }
        return amount;
    }

    public int additional(String []input) {
        int amount = 0;
                String vehicleType = map.get(input[1]);
                switch (vehicleType){
                    case Constants.BIKE:
                        LocalTime localTime = LocalTime.parse(input[2]);
                        if(localTime.compareTo(maxTime()) > 0) {
                            System.out.println(Constants.INVALID_EXIT_TIME);
                            return 0;
                        }
                        if(bikeCount <= 4) {
                        for (int i = 0; i < bikeCount; i++) {
                            if (input[1].equalsIgnoreCase(bike[i].getBikeNumber())) {
                            LocalTime localTime1 = bike[i].getEntryTime();
                            localTime1 = localTime1.plusHours(3);
                            String exit = localTime.toString();
                            String entry = localTime1.toString();
                            int extraHours = Integer.parseInt(exit.split(":")[0]) - Integer.parseInt(entry.split(":")[0]);
                            int extraMinutes = Math.abs(Integer.parseInt(exit.split(":")[1]) - Integer.parseInt(entry.split(":")[1]));
                            if(extraHours == 0 && extraMinutes <= 15) {
                               bike[i].setEntryTime(bike[i].getEntryTime().plusMinutes(extraMinutes));
                                System.out.println("SUCCESS");
                                return 0;
                            }
                            else {
                                if(extraMinutes > 0) {
                                    bike[i].setEntryTime(bike[i].getEntryTime().plusHours(extraHours));
                                    bike[i].setEntryTime(bike[i].getEntryTime().plusMinutes(extraMinutes));
                                    extraHours += 1;
                                    amount += 50 * extraHours;
                                    System.out.println("SUCCESS");

                                    break;
                                }
                            }
                        }
                    }
                }
                else {
                    System.out.println("RACETRACK_FULL");
                    return 0;
                }


                return amount;
                    case Constants.CAR:
                localTime = LocalTime.parse(input[2]);
                if(localTime.compareTo(maxTime()) > 0) {
                    System.out.println(Constants.INVALID_EXIT_TIME);
                    break;
                }
                if(carCount <= 2) {
                    for (int i = 0; i < carCount; i++) {
                        if (input[1].equalsIgnoreCase(car[i].getCarNumber())) {
                            LocalTime localTime1 = car[i].getEntryTime();
                            localTime1 = localTime1.plusHours(3);
                            String exit = localTime.toString();
                            String entry = localTime1.toString();
                            int extraHours = Integer.parseInt(exit.split(":")[0]) - Integer.parseInt(entry.split(":")[0]);
                            int extraMinutes = Math.abs(Integer.parseInt(exit.split(":")[1]) - Integer.parseInt(entry.split(":")[1]));
                            if(extraHours == 0 && extraMinutes <= 15) {
                               car[i].setEntryTime(car[i].getEntryTime().plusMinutes(extraMinutes));
                                System.out.println("SUCCESS");
                                return 0;
                            }
                            else {
                                if(extraMinutes > 0) {
                                    car[i].setEntryTime(car[i].getEntryTime().plusMinutes(extraMinutes));
                                    car[i].setEntryTime(car[i].getEntryTime().plusHours(extraHours));
                                    extraHours += 1;
                                    amount += 50 * extraHours;
                                    System.out.println("SUCCESS");
                                    break;
                                }
                            }
                        }
                    }
                }
                else {
                    if(vipCarCount <= 1) {

                        if (input[2].equalsIgnoreCase(car[vipCarCount - 1].getCarNumber())) {
                            LocalTime localTime1 = car[vipCarCount - 1].getEntryTime();
                            localTime1 = localTime1.plusHours(3);
                            String exit = localTime.toString();
                            String entry = localTime1.toString();
                            int extraHours = Integer.parseInt(exit.split(":")[0]) - Integer.parseInt(entry.split(":")[0]);
                            int extraMinutes = Math.abs(Integer.parseInt(exit.split(":")[1]) - Integer.parseInt(entry.split(":")[1]));
                            if(extraHours == 0 && extraMinutes <= 15) {
                                car[vipCarCount - 1].setEntryTime(car[vipCarCount - 1].getEntryTime().plusMinutes(extraMinutes));
                                System.out.println("SUCCESS");
                                return 0;
                            }
                            else {
                                if(extraMinutes > 0) {
                                    car[vipCarCount - 1].setEntryTime(car[vipCarCount - 1].getEntryTime().plusMinutes(extraMinutes));
                                    car[vipCarCount - 1].setEntryTime(car[vipCarCount - 1].getEntryTime().plusHours(extraHours));
                                    extraHours += 1;
                                    setVipAmount(getVipAmount() + (50 * extraHours));
                                    System.out.println("SUCCESS");
                                    break;
                                }
                            }
                        }
                    }
                    else {
                        System.out.println("RACETRACK_FULL");
                        return 0;
                    }
                }
                    case Constants.SUV:
                        localTime = LocalTime.parse(input[2]);
                if(localTime.compareTo(minTime()) < 0) {
                    System.out.println(Constants.INVALID_ENTRY_TIME);
                    break;
                }
                if(suvCount <= 2) {
                    for (int i = 0; i < suvCount; i++) {
                        if (input[1].equalsIgnoreCase(suv[i].getSuvNumber())) {
                            LocalTime localTime1 = suv[i].getEntryTime();
                            localTime1 = localTime1.plusHours(3);
                            String exit = localTime.toString();
                            String entry = localTime1.toString();
                            int extraHours = Integer.parseInt(exit.split(":")[0]) - Integer.parseInt(entry.split(":")[0]);
                            int extraMinutes = Math.abs(Integer.parseInt(exit.split(":")[1]) - Integer.parseInt(entry.split(":")[1]));
                            if(extraHours == 0 && extraMinutes <= 15) {
                                suv[i].setEntryTime(suv[i].getEntryTime().plusMinutes(extraMinutes));
                                System.out.println("SUCCESS");
                                return 0;
                            }
                            else {
                                if(extraMinutes > 0) {
                                   suv[i].setEntryTime(suv[i].getEntryTime().plusMinutes(extraMinutes));
                                    suv[i].setEntryTime(suv[i].getEntryTime().plusHours(extraHours));
                                    extraHours += 1;
                                   amount +=  (50 * extraHours);
                                    System.out.println("SUCCESS");
                                    break;
                                }
                            }
                        }
                    }
                }
                else {
                    if(vipSuvCount <= 1) {
                        if (input[1].equalsIgnoreCase(suv[vipSuvCount - 1].getSuvNumber())) {
                            LocalTime localTime1 = suv[vipSuvCount - 1].getEntryTime();
                            localTime1 = localTime1.plusHours(3);
                            String exit = localTime.toString();
                            String entry = localTime1.toString();
                            int extraHours = Integer.parseInt(exit.split(":")[0]) - Integer.parseInt(entry.split(":")[0]);
                            int extraMinutes = Math.abs(Integer.parseInt(exit.split(":")[1]) - Integer.parseInt(entry.split(":")[1]));
                            if(extraHours == 0 && extraMinutes <= 15) {
                                suv[vipSuvCount - 1].setEntryTime(suv[vipSuvCount - 1].getEntryTime().plusMinutes(extraMinutes));
                                System.out.println("SUCCESS");
                                return 0;
                            }
                            else {
                                if(extraMinutes > 0) {
                                    suv[vipSuvCount - 1].setEntryTime(suv[vipSuvCount - 1].getEntryTime().plusMinutes(extraMinutes));
                                    suv[vipSuvCount - 1].setEntryTime(suv[vipSuvCount - 1].getEntryTime().plusHours(extraHours));
                                    extraHours += 1;
                                    setVipAmount(getVipAmount() + (50 * extraHours));
                                    System.out.println("SUCCESS");
                                    break;
                                }
                            }
                        }
                    }
                    else {
                        System.out.println("RACETRACK_FULL");
                        return 0;
                    }
                }
        }
        return amount;
    }

    public int revenue(int amount) {
        System.out.println(amount + " " + getVipAmount());
        return amount + getVipAmount();
    }
}
