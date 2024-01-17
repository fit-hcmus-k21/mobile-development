package com.example.homework05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainCallBacks {
    FragmentTransaction ft;
    FragmentBlue fragmentBlue;
    FragmentRed fragmentRed;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();

        // Create a new blue fragment and show it
        ft = getSupportFragmentManager().beginTransaction();
        fragmentBlue = FragmentBlue.newInstance("Blue");
        ft.replace(R.id.main_holder_blue, fragmentBlue);
        ft.commit();

        // Create a new red fragment and show it
        ft = getSupportFragmentManager().beginTransaction();
        fragmentRed = FragmentRed.newInstance("Red");
        ft.replace(R.id.main_holder_red, fragmentRed);
        ft.commit();

    }
    @Override
    public void onMessageFromFragmentToMain(String sender, int i, ArrayList<Student> students) {
        if(sender.equals("BLUE-FRAGMENT")){
            // Send data to RED-FRAGMENT
            fragmentRed.onMessageFromMainToFragment("MAIN-ACTIVITY", i, students);
        }
        if(sender.equals("RED-FRAGMENT")){
            // Send data to BLUE-FRAGMENT
            fragmentBlue.onMessageFromMainToFragment("MAIN-ACTIVITY", i, null);
        }
    }

}