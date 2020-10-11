package com;

import java.util.ArrayList;

public class RentBus {

    private ArrayList<Bus> buses = new ArrayList<>();
    private Seat seat = new Seat();

    Bus bus1 = new Bus("ABC007", seat);
    Bus bus2 = new Bus("XYZ009", seat);

    public RentBus(){
        buses.add(bus1);
        buses.add(bus2);
    }
    public void busOneNumber(){
        System.out.println(bus1.getRegNumber());
    }

    public void busTwoNumber(){
        System.out.println(bus2.getRegNumber());
    }

    public void busOneSeats(){
        System.out.println(bus1.getSeat().getData());
    }

    public void busTwoSeats(){
        System.out.println(bus2.getSeat().getData());
    }

   public void getBusInfo(){
       for(int i=1; i<=20; i++){
           seat.add(i);
       }

       if (buses != null){
           for (Bus bus: buses){
               System.out.println("BUS REG: " + bus.getRegNumber());
               System.out.println("SEAT NO: " + bus.getSeat().getData());
           }
       }
   }
}
