package com.example.changebackgrounddemo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity {
    EditText colorSelected;
    TextView spyBox;
    Button exitBtn;

    LinearLayout myLayout;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("");

        setContentView(R.layout.main_layout);

//        bind objects
        colorSelected = findViewById(R.id.colorSelected);
        spyBox = findViewById(R.id.spyBox);
        exitBtn = findViewById(R.id.exitBtn);
        myLayout = findViewById(R.id.mainLayout);

//        add event onClick exit btn
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

//        add change text in editText
        colorSelected.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                nothing to do
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//          nothing to do
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String color = editable.toString().toLowerCase();
                setBackgroundColor(color, myLayout);
                spyBox.setText(color);
            }
        });

    }

    protected void setBackgroundColor(String color, LinearLayout layoutSelected) {
//        create a list of colors
        HashMap<String, String> colors = new HashMap<>();
        colors.put("violet", "#CCCCFF");
        colors.put("blue", "#CCFFFF");
        colors.put("green", "#99FF99");
        colors.put("orange", "#FF6633");
        colors.put("red", "#FF3333");
        colors.put("pink", "#FF9999");
        colors.put("gray", "#999999");
        colors.put("default", "#FFCC99");



        String colorCode = colors.get(color) ;
        if (colorCode == null) {
            colorCode = colors.get("default");
//            spyBox.setText("Color you entered is not exist, default color chosen instead !");
        }
        layoutSelected.setBackgroundColor(Color.parseColor(colorCode));
    }

}
