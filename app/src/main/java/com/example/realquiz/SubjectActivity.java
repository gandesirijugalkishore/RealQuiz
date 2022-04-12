package com.example.realquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.inputmethod.EditorInfoCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
//subject activity
public class SubjectActivity extends AppCompatActivity {

    CardView cardCricket;// card view
    ImageView imgSound;
    boolean isSoundEnabled; // toggle for sound
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_subject);
        cardCricket = findViewById(R.id.cardCricket);
        imgSound = findViewById(R.id.imgSound);
        SharedPreferences prefs =  getSharedPreferences("MySharedPRefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        isSoundEnabled = prefs.getBoolean("hasSound",true);
        if(isSoundEnabled){ // when sound is enabled
            imgSound.setImageResource(R.drawable.ic_baseline_volume_up_24);
        }else{  // when sound is disabled
            imgSound.setImageResource(R.drawable.ic_baseline_volume_off_24);
        }
        imgSound.setOnClickListener(view -> {
            if(isSoundEnabled){
                imgSound.setImageResource(R.drawable.ic_baseline_volume_off_24);
                editor.putBoolean("hasSound",false);
                editor.commit();
                isSoundEnabled = false;
            }else{
                imgSound.setImageResource(R.drawable.ic_baseline_volume_up_24);
                editor.putBoolean("hasSound",true);
                editor.commit();
                isSoundEnabled = true;
            }
        });
        cardCricket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // intent to goto question activity
                Intent intent = new Intent(SubjectActivity.this, QuestionActivity.class);
                startActivity(intent);
            }
        });
    }
}