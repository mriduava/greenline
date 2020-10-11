package com.mriduava;
import com.RentBus;

public class BusAdapter implements Bus{
    RentBus rentBus = new RentBus();

    @Override
    public String getBusOneRegNo() {
        rentBus.busOneNumber();
        return null;
    }

    @Override
    public String getBusTwoRegNo() {
        rentBus.busTwoNumber();
        return null;
    }

    @Override
    public String[] getBusTwoSeats() {
        rentBus.busTwoSeats();
        return new String[0];
    }

    @Override
    public void getBusOneSeats() {
        rentBus.busOneSeats();
    }

    @Override
    public void getBusInfo() {
        rentBus.getBusInfo();
    }
}
