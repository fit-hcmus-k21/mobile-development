package com.example.threadprogressbar;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.threadprogressbar.R;

public class MainActivity extends Activity {
    EditText edtBox;
    TextView txtMsg;
    ProgressBar progressBar;
    Button btnDoItAgain;

    private int nWork;
    private final int progressStep = 1;
    private int accumulator = 0;
    private int percentage = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        edtBox = (EditText) findViewById(R.id.edtBox);
        txtMsg = (TextView) findViewById(R.id.txtMsg);
        progressBar = (ProgressBar) findViewById(R.id.myBarHor);
        btnDoItAgain = (Button) findViewById(R.id.btnDoItAgain);

        btnDoItAgain.setOnClickListener(view -> {
            if (edtBox.getText().toString().length() > 0)
                onStart();
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (edtBox.getText().toString().length() > 0)
            nWork =  Integer.parseInt(edtBox.getText().toString());
        accumulator = 0;
        percentage = 0;
        txtMsg.setText("0%");
        progressBar.setProgress(0);
        progressBar.setMax(nWork);
        progressBar.setVisibility(View.VISIBLE);

        Thread thread = new Thread(background, "backgroundThread");
        thread.start();
    }
    private Runnable foreground = new Runnable() {
        @Override
        public void run() {
            try {
                progressBar.incrementProgressBy(progressStep);
                accumulator += progressStep;
                percentage = ( accumulator * 100) / nWork;
                txtMsg.setText(percentage + "%");

                btnDoItAgain.setEnabled(accumulator >= progressBar.getMax());
            }
            catch (Exception e) {
                Log.e("Foreground:", e.getMessage());
            }
        }
    };

    private Runnable background = new Runnable() {
        @Override
        public void run() {
            try {
                for (int i = 0; i < nWork/progressStep; i++) {
                    SystemClock.sleep(1);
                    handler.post(foreground);
                }
            }
            catch (Exception e) {
                Log.e("Background:", e.getMessage());
            }
        }
    };
}