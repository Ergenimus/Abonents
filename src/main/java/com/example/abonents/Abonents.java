package com.example.abonents;

public class Abonents {

    String name, street, house, workPhone, homePhone, mobilePhone;

    public void setFio(String name) {
        this.name = name;
    }

    public String getFio() {
        return name;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getHouse() {
        return house;
    }

    public void setWPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getWPhone() {
        return workPhone;
    }

    public void setHPhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getHPhone() {
        return homePhone;
    }

    public void setMPhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getMPhone() {
        return mobilePhone;
    }

    public Abonents(String name, String street, String house, String workPhone, String homePhone, String mobilePhone){
        this.name = name;
        this.street = street;
        this.house = house;
        this.workPhone = workPhone;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
    }

}
