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
import android.app.DatePickerDialog;
import android.widget.DatePicker;

import java.util.Date;
import java.util.regex.*;
import java.util.Locale;
import java.util.Calendar;
import java.text.SimpleDateFormat;


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
        this.setTitle("");

//        ---------------------------------------------------------
//        Notes: because when i exit app from ActivityReceiver and open app again,
//               this app will display confirmation form and I can't back to ActivitySender then
//               So, I added this, just using key-value stored in sharePreferences to check
//                  and switch to main activity (ActivitySender) to reuse app again


        //        update sharedPrefs key isExited
        SharedPreferences sharedPreferences = getSharedPreferences("appPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isExited", false);
        editor.apply();
//      ------------------------------------------------------------------

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
        signupBtn = findViewById(R.id.signupBtn);

//       1. set event onCLick select button | show datePicker dialog            ***
        selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });

//        2. set event onClick reset button | reset all input from user with ""     *** done
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usernameInput.setText("");
                passwordInput.setText("");
                retypeInput.setText("");
                birthdateInput.setText("");
                birthdateInput.clearFocus();

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


//      3. set event onClick sign up button         *** done
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context = getApplicationContext();

//                get inform from input and store to some variables
                String birthdate = "";
                if (!birthdateInput.getText().toString().equals("")) {
                    birthdate = birthdateInput.getText().toString();
                }
                String gender = "", hobbies = "";
                if (maleGenderInput.isChecked()) {
                    gender = "Male";
                } else if (femaleGenderInput.isChecked()) {
                    gender = "Female";
                } else {
//                    no gender input is checked | notify ?
                }

                if (tennisHobbiesInput.isChecked()) {
                    hobbies = "Tennis";
                }

                if (footballHobbiesInput.isChecked()) {
                    if (hobbies.length() > 0) {
                        hobbies += ", ";
                    }
                    hobbies += "Football";
                }

                if (othersHobbiesInput.isChecked()) {
                    if (hobbies.length() == 0) {
                        hobbies += "Others";
                    } else {
                        hobbies += " and others";
                    }
                }

//          if all requirements are ok, then switch to continue activity/ confirm
                if (!usernameInput.getText().toString().equals("")
                        && !passwordInput.getText().toString().equals("")
                        && passwordInput.getText().toString().equals(retypeInput.getText().toString())

                ) {
                    if (!birthdate.equals("") && !isFollowedDateFormat(birthdate)) {
//                            Toast.makeText(context, "Birthdate must be in format dd/mm/yyyy !", Toast.LENGTH_SHORT).show();
                    } else {
                        //                    Toast.makeText(context, "okay", Toast.LENGTH_SHORT).show();

                        //   3.1 | send information for ActivityReceiver to display in Confirm form             *** done
                        Intent senderIntent = new Intent(ActivitySender.this, ActivityReceiver.class);

//                       create bundle to store and transfer data to another activity
                        Bundle senderBundle = new Bundle();
                        senderBundle.putString("username", usernameInput.getText().toString());
                        senderBundle.putString("password", passwordInput.getText().toString());
                        senderBundle.putString("birthdate", birthdate);
                        senderBundle.putString("gender", gender);
                        senderBundle.putString("hobbies", hobbies);

                        senderIntent.putExtras(senderBundle);
                        startActivity(senderIntent);
                    }


                }
//                check whether user entered any input or not
                if (usernameInput.getText().toString().equals("")
                    && passwordInput.getText().toString().equals("")
                ) {
                    Toast.makeText(context, "Please fill out username and password fields !", Toast.LENGTH_SHORT).show();
                }


//          3.2 | check whether password and retype is same or not              *** done
                if (!passwordInput.getText().toString().equals(retypeInput.getText().toString())) {
//              | notify user to enter password and retype again if they are diff (using Toast)
                    Toast.makeText(context, "The password and retype don't match !", Toast.LENGTH_SHORT).show();
                }

//               | check if dont have any password entered/ notify to user
                if (passwordInput.getText().toString().equals("")) {
                    Toast.makeText(context, "Password is required !", Toast.LENGTH_SHORT).show();
                }

//          3.3 | check whether birthdate is in format dd/mm/yyyy or not                    *** done
                if (!birthdate.equals("") && !isFollowedDateFormat(birthdate)) {
//              | notify user to enter birthdate again if it is not in format (using Toast)
                    Toast.makeText(context, "Birthdate must be in format dd/mm/yyyy !", Toast.LENGTH_SHORT).show();
                }

//                check whether the date entered is exist or not, for example user enter 31/02/2099 ?       *** optional
                if (!birthdate.equals("") && !isDateExist(birthdate)) {
                }
//
            }
        });


    }

    //    function check string is in format dd/mm/yyyy             ***
    protected boolean isFollowedDateFormat(String date) {
        String regexPattern = "\\d{2}/\\d{2}/\\d{4}";
        if (!Pattern.matches(regexPattern, date)) {
            return false;
        }
        return true;
    }

    //    function check whether date entered is exist or not       *** optional
    protected boolean isDateExist(String date) {


        return true;
    }


    private void showDatePickerDialog() {
//        create an Calender instance to initialize DatePickerDialog with current date
        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int day) {
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, monthOfYear);
                        calendar.set(Calendar.DAY_OF_MONTH, day);

                        String selectedDate = "";
                        if (day < 10) {
                            selectedDate += "0" + day;
                        } else {
                            selectedDate += day;
                        }
                        selectedDate += "/";

                        if (monthOfYear + 1 < 10) {
                            selectedDate += "0" + (monthOfYear + 1);
                        } else {
                            selectedDate += ( monthOfYear + 1 );
                        }
                        selectedDate += "/" + year;

                        birthdateInput.setText(selectedDate);
                    }
                }, year, month, day
        );

        datePickerDialog.show();
    }




}