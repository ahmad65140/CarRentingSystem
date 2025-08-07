package com.mycompany.oopprojectcarrent;

/**
 *
 * @author ahmad
 */


public class Bus extends Car {
    int capacity;

    public Bus(int capacity, String name, String color, int ID, int chassisNumber, double regularRentingPrice, int maxAllowedRenting) {
        super(name, color, ID, chassisNumber, regularRentingPrice, maxAllowedRenting);
        this.capacity = capacity;
    }
    
    

    public int getCapacity() {
        return capacity;
    }
    
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    @Override
    public double calculatePrice() {
        return getRegularRentingPrice() * Math.abs(1 - capacity/30.0);
    }

    @Override
    public String toString() {
        return "\tBus{" + super.toString()+"capacity=" + capacity + '}';
    }

    
    
    

}