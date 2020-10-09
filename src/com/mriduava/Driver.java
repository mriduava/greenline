package com.mriduava;

public class Driver extends Employee {

    public Driver(String name, int id, int salary) {
        super(name, id, salary);
    }

    public String toString(){
        return "Welcoem " + getName() + "\n" +
                "Role: Driver";
    }
}
