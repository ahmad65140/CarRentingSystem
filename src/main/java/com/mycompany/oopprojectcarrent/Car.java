
package com.mycompany.oopprojectcarrent;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public abstract class Car implements Comparable<Car>, Serializable {
    public String name;
    public String color;
    public int ID;
    public int chassisNumber;
    public boolean available;
    public double regularRentingPrice;
    public int numberOfTimesRented;
    public int maxAllowedRenting;
    public Date dateOfOwning;
    public ArrayList<RentTransaction> transactions;

    public Car(String name, String color, int ID, int chassisNumber, double regularRentingPrice,int maxAllowedRenting) {
        this.name = name;
        this.color = color;
        this.ID = ID;
        this.available = true;
        this.chassisNumber = chassisNumber;
        this.regularRentingPrice = regularRentingPrice;
        this.numberOfTimesRented = 0;
        this.maxAllowedRenting = maxAllowedRenting;
        this.dateOfOwning = new Date();
        this.transactions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getID() {
        return ID;
    }

    public int getChassisNumber() {
        return chassisNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public double getRegularRentingPrice() {
        return regularRentingPrice;
    }

    public int getNumberOfTimesRented() {
        return numberOfTimesRented;
    }

    public int getMaxAllowedRenting() {
        return maxAllowedRenting;
    }

    public Date getDateOfOwning() {
        return dateOfOwning;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String rentCar() {
        if (available && this.numberOfTimesRented<=this.maxAllowedRenting) {
            this.numberOfTimesRented++;
            this.available = false;
            return "The car is successully rented.";
        } else {
            return "The car is already rented";
        }
    }

    public String returnCar() {
        if (!available) {
            available = true;
        }
        return "The car has been successfully returned.";
    }

    public abstract double calculatePrice();

    public void printTransactions() {
        for (RentTransaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public void addTransaction(RentTransaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public int compareTo(Car otherCar) {
        return this.dateOfOwning.compareTo(otherCar.dateOfOwning);
    }

    @Override
    public String toString() {
        String x;
        if(this instanceof NormalCar){
            x = "type=Normal car, maxRentDuration= "+((NormalCar)this).maxRentDuration+", discount= "+((NormalCar)this).discount;
        }else x = ", type=Bus, capacity="+((Bus)this).capacity;
        return "\tCar{" +
                "name= " + name + '\'' +
                ", color='" + color + '\'' +
                ", ID=" + ID +
                ", chassisNumber=" + chassisNumber +
                ", available=" + available +
                ", regularRentingPrice=" + regularRentingPrice +
                ", numberOfTimesRented=" + numberOfTimesRented +
                ", maxAllowedRenting=" + maxAllowedRenting +
                ", dateOfOwning=" + dateOfOwning +x+
                '}';
    }

    public String displayTransDates(Date d1, Date d2) {
        StringBuilder sb = new StringBuilder();
        for (RentTransaction transaction : transactions) {
            if (transaction.getTransactionDate().compareTo(d1) >= 0 && transaction.getTransactionDate().compareTo(d2) <= 0) {
                sb.append(transaction.toString()).append("\n");
            }
        }
        String rtn = sb.toString();
        return rtn;
    }
}
