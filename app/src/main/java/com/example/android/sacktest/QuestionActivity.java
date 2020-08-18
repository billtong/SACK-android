package com.example.android.sacktest;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class QuestionActivity extends AppCompatActivity {

    private static final String TAG = "001";
    static int currentNum = 1;
    static int score = 0;
    TextView txtProcess, txtQuestionTitle, txtQuestion, txtAnswer;
    RadioGroup options;
    RadioButton option1, option2, option3, option4;
    Button btnConfirm, btnNext;
    ProgressBar progressBar;
    QuizQuestion currentQuestion = null;
    Boolean isConfirm = false, isSelect = false, isCorrect = false;

    ArrayList<QuizQuestion> questionList;


    //user's answer
    String answer;
    ArrayList<String> myAnswers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        setUpQuizQuestions();
        iniView();
        loadCurrentQuestion();
    }

    private void loadCurrentQuestion() {
        currentQuestion = questionList.get(currentNum - 1);

        //Log.i(TAG, "loadCurrentQuestion: "+currentQuestion.getQuestion());
        String str = Integer.toString(currentQuestion.getQuestionID());
        txtQuestionTitle.setText("\n" + str + ":  ");
        txtQuestion.setText("\n" + currentQuestion.getQuestion());
        option1.setText(currentQuestion.getOption1());
        option2.setText(currentQuestion.getOption2());
        option3.setText(currentQuestion.getOption3());
        option4.setText(currentQuestion.getOption4());

    }

    //connect the txt and rb with the xml files
    //setup the radiogroup
    private void iniView() {
        //get TextViews from activity_question.xml
        txtProcess = findViewById(R.id.txt_process);
        txtQuestionTitle = findViewById(R.id.txt_question_title);
        txtQuestion = findViewById(R.id.txt_question);
        txtAnswer = findViewById(R.id.txt_answer);

        btnConfirm = findViewById(R.id.btn_confirm);

        options = findViewById(R.id.radioGroup);
        option1 = findViewById(R.id.rb_option1);
        option2 = findViewById(R.id.rb_option2);
        option3 = findViewById(R.id.rb_option3);
        option4 = findViewById(R.id.rb_option4);
        options.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                answer = "";
                switch (i) {

                    case R.id.rb_option1:
                        answer = option1.getText().toString();
                        break;
                    case R.id.rb_option2:
                        answer = option2.getText().toString();
                        break;
                    case R.id.rb_option3:
                        answer = option3.getText().toString();
                        break;
                    case R.id.rb_option4:
                        answer = option4.getText().toString();
                        break;
                }
                isSelect = true;
            }
        });

        btnNext = findViewById(R.id.btn_next);
        progressBar = findViewById(R.id.progressBar);

        progressBar.setProgress(currentNum);
        progressBar.setMax(questionList.size());
        txtProcess.setText(currentNum + "/" + questionList.size());

    }

    private void setUpQuizQuestions() {
        QuizQuestion.iniData();
        questionList = QuizQuestion.getMyQuestions();
    }

    //call when click the next button-->change question or go to the result page
    public void next(View view) {


        if (isConfirm && currentNum < questionList.size()) {

            currentNum++;
            if (isCorrect) {
                score++;
            }
            progressBar.setProgress(currentNum);
            txtProcess.setText(currentNum + "/" + questionList.size());
            for (int i = 0; i < options.getChildCount(); i++) {
                options.getChildAt(i).setEnabled(true);
            }
            options.clearCheck();
            txtAnswer.setText("");
            currentQuestion = questionList.get(currentNum - 1);
            loadCurrentQuestion();
            isSelect = false;
            isCorrect = false;
            isConfirm = false;

        } else if (isConfirm && currentNum >= questionList.size()) {

            if (isCorrect) {
                score++;
            }

            //send the score QuizResultActivity for display
            Intent intent = new Intent(QuestionActivity.this, QuizResultActivity.class);
            intent.putExtra("score", score);
            clear();
            startActivity(intent);

        } else if (!isConfirm) {
            nullAnswerAlert();
        }

    }

    public void nullAnswerAlert() {
        AlertDialog.Builder ab = new AlertDialog.Builder(QuestionActivity.this)
                .setTitle("Alert!")
                .setMessage("You forget to choose an answer.")
                .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();

                    }
                })
                .setNegativeButton("Pass this one", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        isConfirm = true;
                        dialogInterface.cancel();
                    }

                });
        ab.create().show();
    }

    public void clear() {
        currentQuestion = null;
        currentNum = 1;
        score = 0;
        questionList = null;
        answer = null;
        myAnswers = new ArrayList<>();
        isSelect = false;
        isCorrect = false;
        isConfirm = false;
    }

    //disable the back button
    @Override
    public void onBackPressed() {
    }

    public void confirm(View view) {
        if (isSelect) {
            if (currentQuestion.getCorrectAnswer().equalsIgnoreCase(answer)) {
                isCorrect = true;
                txtAnswer.setTextColor(Color.GREEN);
                txtAnswer.setText("\n" + "good!");
            } else {
                txtAnswer.setTextColor(Color.RED);
                txtAnswer.setText("\n" + "Well,It's better..." + currentQuestion.getCorrectAnswer());
            }
            isConfirm = true;

            //disable the radio buttons
            for (int i = 0; i < options.getChildCount(); i++) {
                options.getChildAt(i).setEnabled(false);
            }

        } else {
            nullAnswerAlert();
        }

    }

    public void exit(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}
