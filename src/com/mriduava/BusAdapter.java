package com.mriduava;
import com.RentBus;

public class BusAdapter implements Bus{

    RentBus rentBus = new RentBus();

    @Override
    public void getBusInfo() {
       rentBus.getBusInfo();
    }
}
