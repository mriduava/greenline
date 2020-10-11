package com.mriduava;

public abstract class Employee implements User {
    private String name;
    private int id;
    private String role;

    public Employee(String name, int id, String role) {
        this.name = name;
        this.id = id;
        this.role = role;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getRole() {
        return this.role;
    }

    @Override
    public String toString() {
        return "Employee {" +
                "Name: " + name.toUpperCase() + '\'' +
                ", Id: " + id +
                ", Role: " + role.toUpperCase() +
                '}';
    }
}
