package com.example.dynamic_ride_allocator.Models;

import java.io.Serializable;

public class Location implements Serializable {
    int id;
    String name;

    public Location(){

    }

    public Location(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
