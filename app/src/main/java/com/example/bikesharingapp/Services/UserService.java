package com.example.bikesharingapp.Services;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;


import com.example.bikesharingapp.Models.User;
import com.example.bikesharingapp.Models.UserLogin;
import com.example.bikesharingapp.Models.UserSignup;
import com.example.bikesharingapp.Services.Interfaces.CustomCallBackFunction;
import com.example.bikesharingapp.Services.Interfaces.IUserService;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class UserService implements IUserService {
    private final Context context;
    public User user;
    private String LoginUrl;
    private String SignupUrl;
    public UserService(Context context){
        this.context = context;
        user = GetUserFromSharedPrefs();
    }


    public void UserLogin(UserLogin userLogin, CustomCallBackFunction customCallBackFunction) {
        customCallBackFunction.onResponse("login");
    }
    public void UserSignup(UserSignup userSignup, CustomCallBackFunction customCallBackFunction){
        customCallBackFunction.onResponse("signup");
    }

    public User GetUserFromSharedPrefs() {
        SharedPreferences sharedPref = context.getSharedPreferences("user-pref", Context.MODE_PRIVATE);
        String data = sharedPref.getString("userData", "");
        if(!data.equals("")){
            return User.GetUser(data);
        }
        return null;
    }

    private void StoreUserInSharedPrefs(User user) {
        SharedPreferences sharedPref = context.getSharedPreferences("user-pref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("userData", user.getJSON());
        editor.apply();
    }

    public String GetUserId(){
        return user.userId;
    }

    public Map<String, String> GetAuthHeader() {
        Map<String, String> headers = new HashMap<String,String>();
        headers.put("Authorization", "Bearer " + GetAuthToken());
        return headers;
    }

    public String GetAuthToken(){
        return "";
    }

    public String GetRefreshToken(){
        return "";
    }
}
