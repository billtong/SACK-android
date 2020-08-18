package com.example.android.sacktest;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuActivity extends FragmentActivity {

    ViewPager viewPager;
    SharedPreferences pref = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        viewPager = (ViewPager)findViewById(R.id.StoryPagers);
        SwipeAdapter swipeAdapter = new SwipeAdapter(getSupportFragmentManager());
        viewPager.setAdapter(swipeAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        pref = getSharedPreferences("1", MODE_PRIVATE);

        if(pref.getBoolean("first_run", true)) {

            openTheInstruction();
            pref.edit().putBoolean("first_run", false).apply();
        }

    }

    private void openTheInstruction() {
        final TextView txt1 = findViewById(R.id.txt_ins1);
        final TextView txt2 = findViewById(R.id.txt_ins2);
        final TextView txt3 = findViewById(R.id.txt_ins3);
        txt1.setVisibility(View.VISIBLE);
        txt2.setVisibility(View.VISIBLE);
        txt3.setVisibility(View.VISIBLE);
        ConstraintLayout constraintLayout = findViewById(R.id.layout_menu);

        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt1.setVisibility(View.INVISIBLE);
                txt2.setVisibility(View.INVISIBLE);
                txt3.setVisibility(View.INVISIBLE);
            }
        });

    }


    public void openQuiz(View view) {
        final Intent intent = new Intent(this, QuestionActivity.class);

        AlertDialog.Builder ab = new AlertDialog.Builder(this)
                .setTitle("Rule")
                .setPositiveButton("open", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(intent);
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                .setMessage("1.choose an answer from four radio buttons \n" +
                        "2.click the confirm button to get the answer \n" +
                        "3.click the next button the go to the next question \n" +
                        "4.click the exit button if you don't want to have the quiz anymore");
        ab.create().show();



    }

    public void openAboutUs(View view) {
        Intent intent = new Intent(this, AboutUsActivity.class);
        startActivity(intent);
    }


}
