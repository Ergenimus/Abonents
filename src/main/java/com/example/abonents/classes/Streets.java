package com.example.abonents.classes;

public class Streets {

    String street;
    int count;

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public Streets(int count, String street){
        this.count = count;
        this.street = street;
    }

}
