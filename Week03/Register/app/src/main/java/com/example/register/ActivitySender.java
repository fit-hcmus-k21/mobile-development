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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ActivitySender extends AppCompatActivity {
//    declare some variables
    private EditText usernameInput, passwordInput, retypeInput, birthdateInput;
    private RadioButton maleGenderInput, femaleGenderInput;
    private CheckBox tennisHobbiesInput, footballHobbiesInput, othersHobbiesInput;
    private Button selectBtn, resetBtn, signupBtn;
    
    private Context context;    // used as param in toast method


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        display register form
        setContentView(R.layout.register_layout);

//      match objects
        usernameInput = findViewById(R.id.usernameInput);
        passwordInput = findViewById(R.id.passwordInput);
        retypeInput = findViewById(R.id.retypeInput);
        birthdateInput = findViewById(R.id.birthdateInput);

        maleGenderInput = findViewById(R.id.maleGenderInput);
        femaleGenderInput = findViewById(R.id.femaleGenderInput);

        tennisHobbiesInput = findViewById(R.id.tennisHobbiesInput);
        footballHobbiesInput = findViewById(R.id.footballHobbiesInput);
        othersHobbiesInput = findViewById(R.id.othersHobbiesInput);

        selectBtn = findViewById(R.id.selectBtn);
        resetBtn = findViewById(R.id.resetBtn);
        signupBtn = findViewById(R.id.resetBtn);

//       1. set event onCLick select button | show datePicker dialog
        selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

//        2. set event onClick reset button | reset all input from user with ""     *** done
            resetBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    usernameInput.setText("");
                    passwordInput.setText("");
                    retypeInput.setText("");
                    birthdateInput.setText("dd/mm/yyyy");

//                    reset radio buttons and check buttons
                    if (maleGenderInput.isChecked()) {
                        maleGenderInput.setChecked(false);
                    }

                    if (femaleGenderInput.isChecked()) {
                        femaleGenderInput.setChecked(false);
                    }

                    if (tennisHobbiesInput.isChecked()) {
                        tennisHobbiesInput.setChecked(false);
                    }

                    if (footballHobbiesInput.isChecked()) {
                        footballHobbiesInput.setChecked(false);
                    }

                    if (othersHobbiesInput.isChecked()) {
                        othersHobbiesInput.setChecked(false);
                    }
                }
            });


//      3. set event onClick sign up button
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context = getApplicationContext();

//                get inform from input and store to some variables
                String birthdate = birthdateInput.getText().toString();
                String gender = "", hobbies = "";
                if (maleGenderInput.isChecked()) {
                    gender = "male";
                } else if (femaleGenderInput.isChecked()) {
                    gender = "female";
                } else {
//                    no gender input is checked | notify ?
                }

                if (tennisHobbiesInput.isChecked()) {
                    hobbies = "Tennis";
                }

                if (footballHobbiesInput.isChecked()) {
                    hobbies = hobbies + ", Football";
                }

                if (othersHobbiesInput.isChecked()) {
                    hobbies = hobbies + " and others";
                }

//          3.1 | check whether password and retype is same or not
                if (passwordInput.getText() != retypeInput.getText()) {
//              | notify user to enter password and retype again if they are diff (using Toast)
                    Toast.makeText(context, "the password and retype don't match !!!", Toast.LENGTH_SHORT).show();
                }
//          3.2 | check whether birthdate is in format dd/mm/yyyy or not
                if ( ! isFollowedDateFormat(birthdate) ) {
//              | notify user to enter birthdate again if it is not in format (using Toast)
                    Toast.makeText(context, "birthdate entered is not in format dd/mm/yyyy !!!", Toast.LENGTH_SHORT).show();
                }

                if ( ! isDateExist(birthdate) ) {

                }

//          3.3 | send information for ActivityReceiver to display in Confirm form
                Intent intentToConfirm = new Intent(ActivitySender.this, ActivityReceiver.class);


//                create bundle to store and transfer data to another activity
                Bundle senderBundle = new Bundle();
                senderBundle.putString("username", usernameInput.getText().toString());
                senderBundle.putString("password", passwordInput.getText().toString());
                senderBundle.putString("birthdate", birthdate );
                senderBundle.putString("gender", gender);
                senderBundle.putString("hobbies", hobbies);

                intentToConfirm.putExtras(senderBundle);
                startActivity(intentToConfirm);
            }
        });




    }

//    function check string is in format dd/mm/yyyy
    protected boolean isFollowedDateFormat(String date) {


        return true;
    }

//    function check whether date entered is exist or not
    protected boolean isDateExist(String date) {


        return true;
    }




}