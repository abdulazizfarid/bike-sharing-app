package com.example.bikesharingapp.Models;

public class UserLogin {
    public String phone;
    public String Password;
    public boolean mode;

    public UserLogin(String phone, String Password, boolean mode){
        this.phone = phone;
        this.Password = Password;
        this.mode = mode;
    }
}
