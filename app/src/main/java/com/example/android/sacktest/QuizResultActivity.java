package com.example.android.sacktest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class QuizResultActivity extends AppCompatActivity {

    TextView txtScore, txtComment;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);
        iniView();

    }

    private void iniView() {
        txtScore = findViewById(R.id.txt_score);
        txtComment = findViewById(R.id.txt_comment);

        Intent intent = getIntent();
        score = intent.getIntExtra("score", score);

        txtScore.setText(Integer.toString(score));
        if (score > 8) {
            txtComment.setText("excellent!");
        } else if (score > 5 && score < 8) {
            txtComment.setText("good!");
        } else if (score < 5) {
            txtComment.setText("fail");
        }

    }


    public void back(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    //disable the back button
    @Override
    public void onBackPressed() {
    }
}
