package com.mriduava;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Destination {
    private final Set<String> destinations = new HashSet<String>();

    public void add(String destination){
        this.destinations.add(destination);
    }

/*    public Iterator<String> getIterator(){
        return new DestinationIterator(this);
    }*/

    public Set<String> getData(){
        return this.destinations;
    }

 /*   public class DestinationIterator implements Iterator<String> {
        private Iterator<String> iterator;

        public DestinationIterator(Destination destination) {
            this.iterator = destination.getData().iterator();
        }

        @Override
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override
        public String next() {
            if (this.iterator.hasNext()){
                return this.iterator.next();
            }
            return null;
        }
    }*/
}
