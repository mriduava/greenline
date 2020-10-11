package com;

import java.util.ArrayList;

public class RentBus {

    private ArrayList<Bus> buses = new ArrayList<>();
    private Seat seat = new Seat();

    Bus bus1 = new Bus("ABC 007", seat);
    Bus bus2 = new Bus("XYZ 009", seat);

   public void getBusInfo(){
       for(int i=1; i<=20; i++){
           seat.add(i);
       }
       buses.add(bus1);
       buses.add(bus2);
       if (buses != null){
           for (Bus bus: buses){
               System.out.println(bus.toString());
           }
       }
   }
}
