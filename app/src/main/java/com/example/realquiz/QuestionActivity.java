package com.example.realquiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
// question activity
public class QuestionActivity extends AppCompatActivity {
// array list
    ArrayList<Question> listQuestion = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_question);
        initUi();
        setQuestions();
        startQuiz();
    }
    int score = 0;
    TextView txtQuestion,txtOption1,txtOption2,txtOption3,txtOption4;
    TextView que1,que2,que3,que4,que5,que6,que7,que8,que9,que10;
    Button btnNext;
    Boolean isSoundEnabled = true;
    private void initUi() {
        SharedPreferences prefs =  getSharedPreferences("MySharedPRefs", MODE_PRIVATE);
        isSoundEnabled = prefs.getBoolean("hasSound",true);

        txtQuestion = findViewById(R.id.txtQuestion);
        txtOption1 = findViewById(R.id.txtOption1);
        txtOption2 = findViewById(R.id.txtOption2);
        txtOption3 = findViewById(R.id.txtOption3);
        txtOption4 = findViewById(R.id.txtOption4);
        que1 = findViewById(R.id.que1);
        que2 = findViewById(R.id.que2);
        que3 = findViewById(R.id.que3);
        que4 = findViewById(R.id.que4);
        que5 = findViewById(R.id.que5);
        que6 = findViewById(R.id.que6);
        que7 = findViewById(R.id.que7);
        que8 = findViewById(R.id.que8);
        que9 = findViewById(R.id.que9);
        que10 = findViewById(R.id.que10);
        btnNext = findViewById(R.id.btnNext);

        txtOption1.setOnClickListener(view -> {
            txtOption2.setEnabled(false);
            txtOption3.setEnabled(false);
            txtOption4.setEnabled(false);
            if(isAnswerCorrect(currentQuestion,txtOption1.getText().toString())){ // check correct answer
                setAnswerWrongOrRight(currentQuestion,txtOption1,true);
                if(isSoundEnabled)// check sound stauts
                    playMusicFor(true);
            }else{
                setAnswerWrongOrRight(currentQuestion,txtOption1,false);
                if(isSoundEnabled)
                    playMusicFor(false);
            }
            btnNext.setVisibility(View.VISIBLE);
            btnNext.setEnabled(true);
            if(isQuizFinished(currentQuestion)) {
                btnNext.setText("Finish");
            }
        });
        txtOption2.setOnClickListener(view -> {
            txtOption1.setEnabled(false);
            txtOption3.setEnabled(false);
            txtOption4.setEnabled(false);
            if(isAnswerCorrect(currentQuestion,txtOption2.getText().toString())){
                setAnswerWrongOrRight(currentQuestion,txtOption2,true);
                if(isSoundEnabled)
                    playMusicFor(true);
            }else{
                setAnswerWrongOrRight(currentQuestion,txtOption2,false);
                if(isSoundEnabled)
                    playMusicFor(false);
            }
            btnNext.setVisibility(View.VISIBLE);
            btnNext.setEnabled(true);
            if(isQuizFinished(currentQuestion)) {
                btnNext.setText("Finish");
            }
        });
        txtOption3.setOnClickListener(view -> {
            txtOption2.setEnabled(false);
            txtOption1.setEnabled(false);
            txtOption4.setEnabled(false);
            if(isAnswerCorrect(currentQuestion,txtOption3.getText().toString())){
                setAnswerWrongOrRight(currentQuestion,txtOption3,true);
                if(isSoundEnabled)
                    playMusicFor(true);
            }else{
                setAnswerWrongOrRight(currentQuestion,txtOption3,false);
                if(isSoundEnabled)
                    playMusicFor(false);
            }
            btnNext.setVisibility(View.VISIBLE);
            btnNext.setEnabled(true);
            if(isQuizFinished(currentQuestion)) {
                btnNext.setText("Finish");
            }
        });
        txtOption4.setOnClickListener(view -> {
            txtOption2.setEnabled(false);
            txtOption3.setEnabled(false);
            txtOption1.setEnabled(false);
            if(isAnswerCorrect(currentQuestion,txtOption4.getText().toString())){
                setAnswerWrongOrRight(currentQuestion,txtOption4,true);
                if(isSoundEnabled)
                 playMusicFor(true);
            }else{
                setAnswerWrongOrRight(currentQuestion,txtOption4,false);
                if(isSoundEnabled)
                 playMusicFor(false);
            }
            btnNext.setVisibility(View.VISIBLE);
            btnNext.setEnabled(true);
            if(isQuizFinished(currentQuestion)) {
                btnNext.setText("Finish");
            }
        });
        btnNext.setOnClickListener(view -> {
            if(isQuizFinished(currentQuestion)) {
             //show result quiz finish here

                Intent intent = new Intent(QuestionActivity.this,QuizResultActivity.class);
                intent.putExtra("marks",score);
                startActivity(intent);
                finish();
            }else {
                txtOption1.setEnabled(true);
                txtOption2.setEnabled(true);
                txtOption3.setEnabled(true);
                txtOption4.setEnabled(true);
                currentQuestion++;
                showQuestion(currentQuestion);
                btnNext.setVisibility(View.INVISIBLE);
                btnNext.setEnabled(false);
            }
        });
    }
 // for music player
    private void playMusicFor(boolean isRight) {
        if(isRight){
            MediaPlayer mediaPlayer=MediaPlayer.create(this,R.raw.correct);
            mediaPlayer.start();
        }else{
            MediaPlayer mediaPlayer=MediaPlayer.create(this,R.raw.wrong);
            mediaPlayer.start();
        }
    }
// for finish quiz
    private boolean isQuizFinished(int currentQuestion) {
        return currentQuestion >= listQuestion.size();
    }

    private void setAnswerWrongOrRight(int currentQuestion, TextView selectedOption,boolean isRight) {

        if(isRight){
            selectedOption.setBackgroundResource(R.drawable.bg_border_green);
            score++;
        }else{
            selectedOption.setBackgroundResource(R.drawable.bg_border_red);
        }
        switch (currentQuestion){
            case 1:{
                if(isRight){
                    que1.setBackgroundResource(R.drawable.bg_correct_que);
                    que1.setText("✔");

                }else{
                    que1.setBackgroundResource(R.drawable.bg_wrong_que);
                    que1.setText("×");
                }
                break;
            }
            case 2:{
                if(isRight){
                    que2.setBackgroundResource(R.drawable.bg_correct_que);
                    que2.setText("✔");
                }else{
                    que2.setBackgroundResource(R.drawable.bg_wrong_que);
                    que2.setText("×");
                }
                break;
            }
            case 3:{
                if(isRight){
                    que3.setBackgroundResource(R.drawable.bg_correct_que);
                    que3.setText("✔");
                }else{
                    que3.setBackgroundResource(R.drawable.bg_wrong_que);
                    que3.setText("×");
                }
                break;
            }
            case 4:{
                if(isRight){
                    que4.setBackgroundResource(R.drawable.bg_correct_que);
                    que4.setText("✔");
                }else{
                    que4.setBackgroundResource(R.drawable.bg_wrong_que);
                    que4.setText("×");
                }
                break;
            }
            case 5:{
                if(isRight){
                    que5.setBackgroundResource(R.drawable.bg_correct_que);
                    que5.setText("✔");
                }else{
                    que5.setBackgroundResource(R.drawable.bg_wrong_que);
                    que5.setText("×");
                }
                break;
            }
            case 6:{
                if(isRight){
                    que6.setBackgroundResource(R.drawable.bg_correct_que);
                    que6.setText("✔");
                }else{
                    que6.setBackgroundResource(R.drawable.bg_wrong_que);
                    que6.setText("×");
                }
                break;
            }
            case 7:{
                if(isRight){
                    que7.setBackgroundResource(R.drawable.bg_correct_que);
                    que7.setText("✔");
                }else{
                    que7.setBackgroundResource(R.drawable.bg_wrong_que);
                    que7.setText("×");
                }
                break;
            }
            case 8:{
                if(isRight){
                    que8.setBackgroundResource(R.drawable.bg_correct_que);
                    que8.setText("✔");
                }else{
                    que8.setBackgroundResource(R.drawable.bg_wrong_que);
                    que8.setText("×");
                }
                break;
            }
            case 9:{
                if(isRight){
                    que9.setBackgroundResource(R.drawable.bg_correct_que);
                    que9.setText("✔");
                }else{
                    que9.setBackgroundResource(R.drawable.bg_wrong_que);
                    que9.setText("×");
                }
                break;
            }
            case 10:{
                if(isRight){
                    que10.setBackgroundResource(R.drawable.bg_correct_que);
                    que10.setText("✔");
                }else{
                    que10.setBackgroundResource(R.drawable.bg_wrong_que);
                    que10.setText("×");
                }
                break;
            }
        }

    }

    private boolean isAnswerCorrect(int currentQuestion, String answer) {
        return listQuestion.get(currentQuestion-1).getAnswer().equals(answer);
    }

    int currentQuestion =1;
    private void startQuiz() {
        showQuestion(currentQuestion);
    }

    private void showQuestion(int currentQuestion) {

        txtQuestion.setText(listQuestion.get(currentQuestion-1).getQuestion());
        txtOption1.setText(listQuestion.get(currentQuestion-1).getOption1());
        txtOption2.setText(listQuestion.get(currentQuestion-1).getOption2());
        txtOption3.setText(listQuestion.get(currentQuestion-1).getOption3());
        txtOption4.setText(listQuestion.get(currentQuestion-1).getOption4());
        txtOption1.setBackgroundResource(R.drawable.bg_border_white);
        txtOption2.setBackgroundResource(R.drawable.bg_border_white);
        txtOption3.setBackgroundResource(R.drawable.bg_border_white);
        txtOption4.setBackgroundResource(R.drawable.bg_border_white);
        switch (currentQuestion){
            case 1:{
                que1.setBackgroundResource(R.drawable.bg_round_white);
                break;
            }
            case 2:{
                que2.setBackgroundResource(R.drawable.bg_round_white);
                break;
            }
            case 3:{
                que3.setBackgroundResource(R.drawable.bg_round_white);
                break;
            }
            case 4:{
                que4.setBackgroundResource(R.drawable.bg_round_white);
                break;
            }
            case 5:{
                que5.setBackgroundResource(R.drawable.bg_round_white);
                break;
            }
            case 6:{
                que6.setBackgroundResource(R.drawable.bg_round_white);
                break;
            }
            case 7:{
                que7.setBackgroundResource(R.drawable.bg_round_white);
                break;
            }
            case 8:{
                que8.setBackgroundResource(R.drawable.bg_round_white);
                break;
            }
            case 9:{
                que9.setBackgroundResource(R.drawable.bg_round_white);
                break;
            }
            case 10:{
                que10.setBackgroundResource(R.drawable.bg_round_white);
                break;
            }
        }
    }

    private void setQuestions() {
        listQuestion.add(new Question(
                "How to kill an activity in Android?",
                "finish()","finishActivity(int requestCode)","A & B","kill()",
                "A & B"));
        listQuestion.add(new Question(
                "What is an anonymous class in android?",
                "Interface class","A class that does not have a name but have functionalities in it","Java class","Manifest file",
                "A class that does not have a name but have functionalities in it"));
        listQuestion.add(new Question(
                "What is APK in android?",
                "Android packages","Android pack","Android packaging kit","None of the above.",
                "Android packaging kit"));
        listQuestion.add(new Question(
                "How to kill an activity in Android?",
                "finish()","finishActivity(int requestCode)","A & B","kill()",
                "A & B"));
        listQuestion.add(new Question(
                "What is an anonymous class in android?",
                "Interface class","A class that does not have a name but have functionalities in it","Java class","Manifest file",
                "A class that does not have a name but have functionalities in it"));
        listQuestion.add(new Question(
                "What is APK in android?",
                "Android packages","Android pack","Android packaging kit","None of the above.",
                "Android packaging kit"));
        listQuestion.add(new Question(
                "How to kill an activity in Android?",
                "finish()","finishActivity(int requestCode)","A & B","kill()",
                "A & B"));
        listQuestion.add(new Question(
                "What is an anonymous class in android?",
                "Interface class","A class that does not have a name but have functionalities in it","Java class","Manifest file",
                "A class that does not have a name but have functionalities in it"));
        listQuestion.add(new Question(
                "What is APK in android?",
                "Android packages","Android pack","Android packaging kit","None of the above.",
                "Android packaging kit"));
        listQuestion.add(new Question(
                "How to kill an activity in Android?",
                "finish()","finishActivity(int requestCode)","A & B","kill()",
                "A & B"));

    }

    @Override
    public void onBackPressed() {
        showExitDialog();
    }
//  method for exit dialog
    private void showExitDialog() {
        AlertDialog dialog = new AlertDialog.Builder(QuestionActivity.this).create();
        dialog.setTitle(R.string.app_name);
        dialog.setMessage("Are You Sure To Exit Quiz?");
        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        dialog.show();
    }
}