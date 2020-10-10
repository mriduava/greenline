package com.mriduava;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Seat {

    private final Set<Integer> seats = new HashSet<>();

    public void add(int seatNumber){
        this.seats.add(seatNumber);
    }

   /* public Iterator<Integer> getIterator(){
        return new SeatIterator(this);
    }*/

    public Set<Integer> getData(){
        return this.seats;
    }


/*    public class SeatIterator implements Iterator<Integer> {
        private Iterator<Integer> iterator;

        public SeatIterator(Seat seat) {
            this.iterator = seat.getData().iterator();
        }

        @Override
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override
        public Integer next() {
            if (this.iterator.hasNext()){
                return this.iterator.next();
            }
            return null;
        }
    }*/

}
