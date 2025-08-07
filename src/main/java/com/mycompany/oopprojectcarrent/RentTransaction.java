package com.mycompany.oopprojectcarrent;

import java.io.Serializable;
import java.util.Date;

public class RentTransaction implements Serializable {
    public static int nextTransactionNumber = 1;
    public int transactionNumber;
    public Car rentedCar;
    public Client rentingClient;
    public Date transactionDate;
    public double rentingPrice;
    
    public RentTransaction(Car rentedCar, Client rentingClient) {
        this.transactionNumber = nextTransactionNumber++;
        this.rentedCar = rentedCar;
        this.rentingClient = rentingClient;
        this.transactionDate = new Date();
        this.rentingPrice = rentedCar.calculatePrice();
    }
    
    public int getTransactionNumber() {
        return transactionNumber;
    }
    
    public Car getRentedCar() {
        return rentedCar;
    }
    
    public Client getRentingClient() {
        return rentingClient;
    }
    
    public Date getTransactionDate() {
        return transactionDate;
    }
    
    public double getRentingPrice() {
        return rentingPrice;
    }
    
    @Override
    public String toString() {
        return "\n\tRentTransaction [transactionNumber=" + this.transactionNumber + ", rentedCar=" + this.rentedCar + ", rentingClient=" + this.rentingClient + ", transactionDate=" + this.transactionDate + ", rentingPrice=" + this.rentingPrice + "]";
    }
}