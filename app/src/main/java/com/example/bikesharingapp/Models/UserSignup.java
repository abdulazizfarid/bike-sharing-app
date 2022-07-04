package com.example.bikesharingapp.Models;

import com.example.bikesharingapp.Consts.UserConsts;

public class UserSignup {
    public String name;
    public String phone;
    public String email;
    public String password;
    public boolean mode;

    public UserSignup(String Name,String Phone,String Email, String Password, boolean mode){
        this.name = Name;
        this.phone = Phone;
        this.email = Email;
        this.password = Password;
        this.mode = mode;
    }
}
