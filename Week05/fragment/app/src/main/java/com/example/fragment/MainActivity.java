package com.example.fragment;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements MainCallbacks{
    FragmentTransaction ft; FirstFragment firstFragment; SecondFragment secondFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
// create a new BLUE fragment - show it
        ft = getSupportFragmentManager().beginTransaction();
        firstFragment = FirstFragment.newInstance("first");
        ft.replace(R.id.firstFragment, firstFragment);
        ft.commit();
// create a new RED fragment - show it
        ft = getSupportFragmentManager().beginTransaction();
        secondFragment = SecondFragment.newInstance("second");
        ft.replace(R.id.secondFragment, secondFragment);
        ft.commit();

    }
    // MainCallback implementation (receiving messages coming from Fragments)
    @Override
    public void onMsgFromFragToMain(String sender, String strValue) {
// show message arriving to MainActivity
//        Toast.makeText(getApplication(), " MAIN GOT>> " + sender + "\n" + strValue, Toast.LENGTH_LONG).show();
        if (sender.equals("SECOND-FRAG")) { /* TODO: if needed, do here something on behalf of the RED fragment*/ }
        if (sender.equals("FIRST-FRAG")) {
            try { // forward blue-data to redFragment using its callback method
                secondFragment.onMsgFromMainToFragment( strValue);
            }
            catch (Exception e) { Log.e("ERROR", "onStrFromFragToMain " + e.getMessage()); }
        }
    }


}