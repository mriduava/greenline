package com.mriduava;

public class BookingInfo {

    private User user;
    private String busRegNumber;
    private int seatNumber;
    private String destination;

    public BookingInfo(User user, String busRegNumber, int seatNumber, String destination) {
        this.user = user;
        this.busRegNumber = busRegNumber;
        this.seatNumber = seatNumber;
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Booking Info: {" +
                "Passenger: " + user.getName().toUpperCase() +
                ", Bus Number:" + busRegNumber.toUpperCase() + '\'' +
                ", Seat Number: " + seatNumber +
                ", Destination='" + destination.toUpperCase() + '\'' +
                '}';
    }
}
