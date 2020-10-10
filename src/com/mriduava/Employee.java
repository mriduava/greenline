package com.mriduava;

public abstract class Employee implements User {
    private String name;
    private int id;
    private int salary;

    public Employee(String name, int id, int salary) {
        this.name = name;
        this.salary = salary;
        this.salary = salary;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getId() {
        return this.id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}
