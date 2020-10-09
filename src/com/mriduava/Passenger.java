package com.mriduava;

public class Passenger implements User {
    private String name;
    private int id;

    public Passenger(String name, int id){
        this.name = name;
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getId() {
        return this.id;
    }
}
