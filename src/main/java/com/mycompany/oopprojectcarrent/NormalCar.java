package com.mycompany.oopprojectcarrent;

import java.io.Serializable;


public class NormalCar extends Car implements Serializable {
    public int maxRentDuration;
    public double discount;

    
    
    public NormalCar(int maxRentDuration,double discount, String name, String color, int ID, int chassisNumber, double regularRentingPrice, int maxAllowedRenting) {
        super(name, color, ID, chassisNumber, regularRentingPrice, maxAllowedRenting);
        this.maxRentDuration = maxRentDuration;
        this.discount = discount;
    }
    
    
    
    @Override
    public double calculatePrice() {
        int timesRented = this.getNumberOfRentals();
        double discountFactor = 1 - (timesRented * 1.0 / this.getMaxRentals()) * (this.discount / 100);
        return this.getRegularRentPrice() * Math.abs(discountFactor);
    }

    public int getMaxRentals() {
        return this.maxRentDuration;
    }

    public double getDiscount() {
        return this.discount;
    }
    
    @Override
    public String toString() {
        return "\tNormalCar: " + super.toString() + ", max rent duration: " + this.maxRentDuration + ", discount: " + this.discount;
    }

    private int getNumberOfRentals() {
        return this.numberOfTimesRented;
    }

    private double getRegularRentPrice() {
        return this.regularRentingPrice;
    }
}