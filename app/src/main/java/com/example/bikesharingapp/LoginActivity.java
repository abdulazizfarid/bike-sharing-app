package com.example.bikesharingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.bikesharingapp.Models.User;
import com.example.bikesharingapp.Models.UserLogin;
import com.example.bikesharingapp.Services.Interfaces.IUserService;
import com.example.bikesharingapp.Services.Interfaces.ServiceFactory;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    IUserService userService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userService = ServiceFactory.GetUserService(getApplicationContext());
        CheckIfUserAlreadyLoggedIn();
    }

    public void onClick(View view) {

        String phone = ((TextInputEditText) findViewById(R.id.et_phone)).getText().toString();
        String password = ((EditText) findViewById(R.id.et_password)).getText().toString();
        boolean mode = ((Switch) findViewById(R.id.mode)).isChecked();
        UserLogin userlogin = new UserLogin(phone, password, mode);
        try{
            userService.UserLogin(userlogin, data -> {
                try {
                    if(!data.equals("")){
                        NavigateToHomePage();
                    }
                }
                catch(Exception e){
                    Toast.makeText(this, "Incorrect phone Or Password", Toast.LENGTH_LONG).show();
                }

            });
        }
        catch (Exception e){
            Toast.makeText(this, "Incorrect phone Or Password", Toast.LENGTH_LONG).show();
        }

    }

    public void Signup_OnCLick(View v){
        NavigateToSignupPage();
    }

    private void CheckIfUserAlreadyLoggedIn(){
        User user = userService.GetUserFromSharedPrefs();
        if(user != null){
            NavigateToHomePage();
        }
    }
    private void NavigateToHomePage() {
        Intent i = new Intent(this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }
    private void NavigateToSignupPage() {
        Intent i = new Intent(this, SignupActivity.class);
        startActivity(i);
    }

}