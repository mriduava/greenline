package com.mriduava;

public class Employee extends User {

    int salary;
    public Employee(String name, int id, int salary) {
        super(name, id);
        this.salary = salary;
    }
}
