package com.example.realquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ProgressBar;
// starting screen of app
public class SplashActivity extends AppCompatActivity {
    ProgressBar progressBar; // progress bar
    int counting = 0; // variable for progress bar
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progress);
        CountDownTimer counter = new CountDownTimer(2000, 50) {

            public void onTick(long millisUntilFinished) {
                progressBar.setProgress(counting+=50);
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                finish();
                // intent to go to next activity
                Intent intent = new Intent(SplashActivity.this, SubjectActivity.class);
                startActivity(intent);
            }
        };
        counter.start();
    }

    @Override
    public void onBackPressed() {
    }
}