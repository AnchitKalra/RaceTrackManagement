package com.example.geektrust.controller;

import com.example.geektrust.service.BookingService;

public class BookingController {

    BookingService bookingService = new BookingService();
    int amount = 0;
    public void booking(String string[]) {
         amount += bookingService.book(string);

    }
    public void additional(String string[]) {
       amount += bookingService.additional(string);
    }

    public void revenue() {
        bookingService.revenue(amount);
    }
}
