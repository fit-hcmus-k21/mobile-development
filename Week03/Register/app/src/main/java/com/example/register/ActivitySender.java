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


//        2. set event onClick reset button | reset all input from user with ""



//      3. set event onClick sign up button
//          3.1 | check whether password and retype is same or not
//              | notify user to enter password and retype again if they are diff (using Toast)
//          3.2 | check whether birthdate is in format dd/mm/yyyy or not
//              | notify user to enter birthdate again if it is not in format (using Toast)
//          3.3 | send information for ActivityReceiver to display in Confirm form


    }


}