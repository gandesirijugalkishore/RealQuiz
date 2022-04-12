package com.example.realquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
 // this is quiz result activity
public class QuizResultActivity extends AppCompatActivity {
    TextView txtResult; // text view
    RatingBar ratingBar; // rating bar
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_quiz_result);
        txtResult = findViewById(R.id.txtResult);
        ratingBar = findViewById(R.id.ratingBar);
        int score = getIntent().getIntExtra("marks",10);
        txtResult.setText(score+"/10"); // setting values for rating bar
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                showThankYouDialog(); // method to show thank you dialog
            }
        });
    }
// method for thank you dialog
    private void showThankYouDialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_thank_you);
        Window window = dialog.getWindow();
        dialog.setCancelable(false);
        window.setLayout(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT);

        Button btnReset = dialog.findViewById(R.id.btnResetQuiz);
        Button btnExit = dialog.findViewById(R.id.btnExit);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(dialog.getContext());

        btnReset.setOnClickListener(view -> {
            dialog.dismiss();
            // intent to start Question activity
            startActivity(new Intent(QuizResultActivity.this,QuestionActivity.class));
            finish();
        });
        btnExit.setOnClickListener(view -> {
            dialog.dismiss();
            finishAffinity();
        });
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(),
                "Please Rate Us", Toast.LENGTH_SHORT).show();
    }
}