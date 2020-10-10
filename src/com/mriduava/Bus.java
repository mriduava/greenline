package com.mriduava;

import java.security.PrivateKey;

public class Bus {
    private String regNumber;
    private Seat seat;
    private Destination destination;

    public Bus(String regNumber, Seat seat, Destination destination) {
        this.regNumber = regNumber;
        this.seat = seat;
        this.destination = destination;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public String toString(){
        return "Registration Number: " + regNumber.toUpperCase() + "\n"
                + "Seats: " + seat.getData() + "\n"
                + "Destinations: " + destination.getData();
    }
}
