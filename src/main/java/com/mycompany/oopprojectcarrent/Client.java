package com.mycompany.oopprojectcarrent;

import java.io.Serializable;

public class Client implements Serializable{
    public String name;
    public int ssn;
    public String phoneNumber;
    public String address;
    
    public Client(String name, int ssn, String phoneNumber, String address) {
        this.name = name;
        this.ssn = ssn;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    
    public String getName() {
        return name;
    }
    
    public int getSsn() {
        return ssn;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public String getAddress() {
        return address;
    }
    
    @Override
    public String toString() {
        return "Client [name=" + name + ", SSN=" + ssn + ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
    }
}