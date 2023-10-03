package com.example.register;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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

//        --------------------------------------------------------
//        Toast.makeText(getApplicationContext(), "onCreate in receiver", Toast.LENGTH_SHORT).show();

//        return Register activity if user has just exited
        SharedPreferences sharedPreferences = getSharedPreferences("appPrefs", Context.MODE_PRIVATE);
        boolean isExited = sharedPreferences.getBoolean("isExited", false);

        if (isExited) {

            Intent intent = new Intent(ActivityReceiver.this, ActivitySender.class);
            startActivity(intent);
            finish();
        }
//          ------------------------------------------------------
//        Toast.makeText(getApplicationContext(), "In receiver activity now !", Toast.LENGTH_SHORT).show();

//        display new layout in view
        setContentView(R.layout.confirm_layout);

//        match java objects
        usernameInView = findViewById(R.id.usernameInView);
        passwordInView = findViewById(R.id.passwordInView);
        birthdateInView = findViewById(R.id.birthdateInView);
        genderInView = findViewById(R.id.genderInView);
        hobbiesInView = findViewById(R.id.hobbiesInView);

        exitBtn = findViewById(R.id.exitBtn);

//        receive data from bundle intent and display in view
        Bundle receiverBundle = getIntent().getExtras();
        if (receiverBundle != null) {
//            get data to show
            String username = receiverBundle.getString("username");
            String password = receiverBundle.getString("password");
            String birthdate = receiverBundle.getString("birthdate");
            String gender = receiverBundle.getString("gender");
            String hobbies = receiverBundle.getString("hobbies");

//            show in view
            usernameInView.setText(username);
            passwordInView.setText(password);
            birthdateInView.setText(birthdate);
            genderInView.setText(gender);
            hobbiesInView.setText(hobbies);
        }


//        1. set event onClick Exit button | exit app immediately
            exitBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    -----------------------------------------------------
                    SharedPreferences sharedPreferences = getSharedPreferences("appPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("isExited", true);
                    editor.apply();
//                    -----------------------------------------------------

                    finishAffinity();
                }
            });
    }


}