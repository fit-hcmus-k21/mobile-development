package com.example.currencyconverter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;


//    Implementing a currency converter: USD -> Euro -> Colon (CR)
//    Exchange rate:
//      1 Costa Rican Colon = 0.0019 U.S dollars
//      1 Euro = 1.35 U.S dollars
public class Currency1 extends Activity {
    //    declare some constants: exchange rate and unicode codes to display symbol of currency
    private final double EURO2USD = 1.35;
    private final double CR2USD = 0.0019;

    private final char EUROSYM = '\u20AC';
    private final char CRSYM = '\u20A1';

    //   convert numbers to text with USA money format (12 digits, 2 decimals)
    DecimalFormat usaDF = new DecimalFormat("###,###,###,###.##");

    //    GUI widgets
    Button btnConvert, btnClear;
    EditText txtUSDollars, txtEuros, txtColones;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_linear);

//        bind local controls to GUI widgets
        txtUSDollars = (EditText) findViewById(R.id.txtUSDollars);

//        make Euros box not-editable (no user input)
        txtEuros = (EditText) findViewById(R.id.txtEuros);
        txtEuros.setInputType(EditorInfo.TYPE_NULL);

//        No user input. see layout: android:editable="false"
        txtColones = (EditText) findViewById(R.id.txtColones);

//        attach click behavior to buttons
        btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(new OnClickListener() {
            //            clear the text boxes
            @Override
            public void onClick(View v) {
                txtColones.setText("");
                txtEuros.setText("");
                txtUSDollars.setText("");
            }
        });

//        do the conversion from USD to Euros and Colones
        btnConvert = (Button) findViewById(R.id.btnConvert);
        btnConvert.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String usdStr = txtUSDollars.getText().toString();
                    double usd = Double.parseDouble(usdStr);

                    String euros = EUROSYM + String.valueOf(usaDF.format(usd / EURO2USD));
                    String colones = CRSYM + String.valueOf(usaDF.format(usd / CR2USD));

                    txtEuros.setText(euros);
                    txtColones.setText(colones);
                } catch (NumberFormatException e) {
//                    ignore
                }
            }
        });
    }


}