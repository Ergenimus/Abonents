package com.example.abonents.classes;

public class Phones {

    String name, phone;

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Phones(String name, String phone){
        this.phone = phone;
        this.name = name;
    }

}
