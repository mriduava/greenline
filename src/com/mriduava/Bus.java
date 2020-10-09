package com.mriduava;

public class Bus {
    private String regNumber;
    private int NUMBER_OF_SEATS = 20;

    public Bus(String regNumber, int NUMBER_OF_SEATS) {
        this.regNumber = regNumber;
        this.NUMBER_OF_SEATS = NUMBER_OF_SEATS;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }
}
