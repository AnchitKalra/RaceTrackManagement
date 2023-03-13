package com.example.geektrust.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.example.geektrust.service.BookingService;

public class MainTest {

    BookingService bookingService = new BookingService();
    @Test
    public void testVipAmount() {
        bookingService.setVipAmount(50);
        System.out.println(bookingService.getVipAmount());
        Assertions.assertEquals(50, bookingService.getVipAmount());
    }
    @Test
    public void testBook() {
        String input = "BOOK BIKE M40 14:00";
        String s[] = input.split(" ");
        int output = bookingService.book(s);
        Assertions.assertEquals(180, output);
    }

    @Test
    public void testAdditional() {
       testBook();
        String string = "ADDITIONAL M40 17:40";
        String a[] = string.split(" ");
       int output = bookingService.additional(a);
       Assertions.assertEquals(50, output);
    }

    @Test
    public void testRevenue() {

        int amount = bookingService.revenue(230);
        Assertions.assertEquals(230, amount);
    }

}