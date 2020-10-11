package com;

import java.util.HashSet;
import java.util.Set;

public class Seat {
    private final Set<Integer> seats = new HashSet<>();

    public void add(int seatNumber){
        this.seats.add(seatNumber);
    }

    public Set<Integer> getData(){
        return this.seats;
    }
}
