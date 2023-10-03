package com.example.register;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ActivityReceiver extends AppCompatActivity {
//  declares some variables
    private TextView usernameInView, passwordInView, birthdateInView, genderInView, hobbiesInView;
    private Button exitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        match java objects
        usernameInView = findViewById(R.id.usernameInView);
        passwordInView = findViewById(R.id.passwordInView);
        birthdateInView = findViewById(R.id.birthdateInView);
        genderInView = findViewById(R.id.genderInView);
        hobbiesInView = findViewById(R.id.hobbiesInView);

        exitBtn = findViewById(R.id.exitBtn);

//        1. set event onClick Exit button | exit app immediately
    }


}