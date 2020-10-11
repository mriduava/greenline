package com;

public class Bus {
    private String regNumber;
    private Seat seat;

    public Bus(String regNumber, Seat seat) {
        this.regNumber = regNumber;
        this.seat = seat;
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

    public String toString(){
        return "Reg No: " + regNumber.toUpperCase() + "\n"
                + "Seats: " + seat.getData() + "\n";
    }
}
