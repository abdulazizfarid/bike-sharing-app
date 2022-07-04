package com.example.bikesharingapp.Services.Interfaces;

import com.example.bikesharingapp.Models.User;
import com.example.bikesharingapp.Models.UserLogin;
import com.example.bikesharingapp.Models.UserSignup;

import java.util.Map;

public interface IUserService {
    void UserLogin(UserLogin userLogin, CustomCallBackFunction listener);
    void UserSignup(UserSignup userSignup, CustomCallBackFunction listener);
    User GetUserFromSharedPrefs();
    String GetRefreshToken();
    String GetAuthToken();
    String GetUserId();
    Map<String,String> GetAuthHeader();
}

