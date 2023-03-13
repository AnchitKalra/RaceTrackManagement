package com.example.geektrust;

import com.example.geektrust.controller.BookingController;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read
            BookingController bookingController = new BookingController();
            while (sc.hasNextLine()) {
               //Add your code here to process input commands
                String input = sc.nextLine();
                String processedInput[] = input.split(" ");
                if(processedInput[0].equalsIgnoreCase(Constants.BOOK)) {
                 //   System.out.println(processedInput[1]);
                    bookingController.booking(processedInput);
                }
                else if(processedInput[0].equalsIgnoreCase(Constants.ADDITIONAL)) {
                   // System.out.println("S");
                    bookingController.additional(processedInput);
                }
                else if(processedInput[0].equalsIgnoreCase(Constants.REVENUE)) {
                    bookingController.revenue();
                }
            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
        }
    }
}
