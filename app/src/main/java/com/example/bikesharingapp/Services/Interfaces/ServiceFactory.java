package com.example.bikesharingapp.Services.Interfaces;

import android.content.Context;

import com.example.bikesharingapp.Services.UserService;


public class ServiceFactory {
    public static IUserService GetUserService(Context c){
        return new UserService(c);
    }
}
