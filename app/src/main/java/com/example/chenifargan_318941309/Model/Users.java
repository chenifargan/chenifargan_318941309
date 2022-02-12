package com.example.chenifargan_318941309.Model;

public class Users {
    private String Name;
    private String phoneNumber;
    private String password;

    public Users() {

    }
    public Users(String name, String phoneNumber, String password) {
        Name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }



    public String getName() {
        return Name;
    }

    public Users setName(String name) {
        Name = name;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Users setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Users setPassword(String password) {
        this.password = password;
        return this;
    }


}
