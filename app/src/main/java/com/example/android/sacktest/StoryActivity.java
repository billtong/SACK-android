package com.example.android.sacktest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.gesture.GestureOverlayView;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.ArrayList;

public class StoryActivity extends AppCompatActivity {

    public static final String TAG = "001";
    static StoryScene currentScene;
    static int currentID = 1;
    TextView txtContent, txtChoice1, txtChoice2;
    GestureOverlayView gestureOverlayView;
    ArrayList<StoryScene> allScenes;
    int whichScenario = -1;
    Animation MoveLeftOut, MoveRightOut;

    OnSwipeTouchListener onSwipeTouchListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        whichScenario = intent.getIntExtra("scene", whichScenario);
        //Log.i(TAG, "setScenes: "+whichScenario);

        iniView();
        setScenes();
        loadStoryScene();

    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences pref = getSharedPreferences("2", MODE_PRIVATE);
        if(pref.getBoolean("first_run1", true)) {
            openTheInstruction();
            pref.edit().putBoolean("first_run1", false).apply();
        }
    }

    private void openTheInstruction() {
        final TextView txt4 = findViewById(R.id.txt_inst4);
        final TextView txt5 = findViewById(R.id.txt_inst5);
        txt4.setVisibility(View.VISIBLE);
        txt5.setVisibility(View.VISIBLE);

        GestureOverlayView gestureOverlayView = findViewById(R.id.ly_wholeScreen);

        gestureOverlayView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt4.setVisibility(View.INVISIBLE);
                txt5.setVisibility(View.INVISIBLE);
            }
        });
    }


    private void setScenes() {
        switch (whichScenario) {
            case 0:
                StoryScene.iniDateStoryScenes();
                allScenes = StoryScene.getDateStoryScenes();
                break;
            case 1:
                StoryScene.iniStreetStoryScenes();
                allScenes = StoryScene.getStreetStoryScenes();
                break;
            case 2:
                StoryScene.iniPartyStoryScenes();
                allScenes = StoryScene.getPartyStoryScenes();
                break;
            case 3:
                StoryScene.iniBarStoryScenes();
                allScenes = StoryScene.getBarStoryScenes();
                break;
            default:
                allScenes = new ArrayList<StoryScene>();
                break;

        }

        currentScene = allScenes.get(currentID - 1);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void iniView() {
        txtContent = findViewById(R.id.txt_content);
        txtChoice1 = findViewById(R.id.txt_choice1);
        txtChoice2 = findViewById(R.id.txt_choice2);

        gestureOverlayView = findViewById(R.id.ly_wholeScreen);

        MoveLeftOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_left_out);
        MoveRightOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_right_out);

        gestureOverlayView.setOnTouchListener(new OnSwipeTouchListener(StoryActivity.this) {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public void onSwipeLeft() {
                //Log.i(TAG, "onSwipeLeft: ");
                toNextScene("left");
                txtChoice1.startAnimation(MoveLeftOut);
                txtChoice2.startAnimation(MoveLeftOut);
                txtContent.startAnimation(MoveLeftOut);
            }

            public void onSwipeRight() {
                //Log.i(TAG, "onSwipeRight: ");
                toNextScene("right");
                txtChoice1.startAnimation(MoveRightOut);
                txtChoice2.startAnimation(MoveRightOut);
                txtContent.startAnimation(MoveRightOut);
            }
        });

    }

    private void loadStoryScene() {
        txtContent.setText(currentScene.getStoryScene());
        txtChoice1.setText(currentScene.getChoice1());
        txtChoice2.setText(currentScene.getChoice2());
    }

    private void toNextScene(String side) {
        if (side.equalsIgnoreCase("left")) {
            currentID = currentScene.getChoice_1_next();
        } else if (side.equalsIgnoreCase("right")) {
            currentID = currentScene.getChoice_2_next();
        }

        if (currentID < 0) {
            getToEnding(currentID, side);
        }

        currentScene = allScenes.get(currentID - 1);
        loadStoryScene();
    }

    private void getToEnding(int currentID, String side) {
        Intent intent = new Intent(this, StoryEndActivity.class);
        intent.putExtra("FinalScene", currentID);
        intent.putExtra("Scenario", whichScenario);
        clear();
        startActivity(intent);
        if (side.equalsIgnoreCase("left")) {
            overridePendingTransition(R.anim.activity_in_from_right, R.anim.activity_out_to_left);
        } else if (side.equalsIgnoreCase("right")) {
            overridePendingTransition(R.anim.activity_in_from_left, R.anim.activity_out_to_right);
        }

    }


    public void backToMenu(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        clear();
        startActivity(intent);
    }

    private void clear() {
        txtContent = null;
        txtChoice1 = null;
        txtChoice2 = null;

        allScenes = null;
        currentScene = null;
        currentID = 1;
        whichScenario = -1;
    }

    //disable the back button
    @Override
    public void onBackPressed() {
    }






}
