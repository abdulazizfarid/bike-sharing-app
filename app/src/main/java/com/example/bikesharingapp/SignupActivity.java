package com.example.bikesharingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

import com.example.bikesharingapp.Models.UserSignup;
import com.example.bikesharingapp.Services.Interfaces.IUserService;
import com.example.bikesharingapp.Services.Interfaces.ServiceFactory;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Map;
import java.util.Objects;

public class SignupActivity extends AppCompatActivity {

    IUserService userService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        userService = ServiceFactory.GetUserService(getApplicationContext());

    }
    public void Signup_OnCLick(View view) {

        String email = Objects.requireNonNull(((TextInputEditText) findViewById(R.id.et_email)).getText()).toString();
        String name = ((EditText) findViewById(R.id.et_name)).getText().toString();
        String phone = ((EditText) findViewById(R.id.et_phone)).getText().toString();
        String password = ((EditText) findViewById(R.id.et_password)).getText().toString();
        String ConfirmPass = ((EditText) findViewById(R.id.et_confirm_password)).getText().toString();
        boolean mode = ((Switch) findViewById(R.id.mode)).isChecked();


        if(ConfirmPass.equals(password)){
            userService.UserSignup(new UserSignup(name, phone, email, password, mode), data -> {
                if(!data.equals("")){
                    NavigateToHomePage();
                }
            });

        }

    }


    private void NavigateToHomePage() {
        Intent i = new Intent(this, MapsActivity.class);
        startActivity(i);
    }
}