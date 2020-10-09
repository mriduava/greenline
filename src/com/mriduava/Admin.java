package com.mriduava;

public class Admin extends Employee{

    public Admin(String name, int id, int salary) {
        super(name, id, salary);
    }

    public String toString(){
        return "Welcoem " + getName() + "\n" +
                "Role: Admin";
    }
}
