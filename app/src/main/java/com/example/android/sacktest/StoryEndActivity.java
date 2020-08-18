package com.example.android.sacktest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ShareActionProvider;
import android.widget.TextView;

import java.util.ArrayList;

public class StoryEndActivity extends AppCompatActivity {

    TextView txtView;
    ArrayList<EndStoryScene> allEnds;
    EndStoryScene currentEnds;
    private int endId;
    private int scenario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_end);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        endId = intent.getIntExtra("FinalScene", endId);
        scenario = intent.getIntExtra("Scenario", scenario);

        setEndStory();
        iniView();


    }


    private void setEndStory() {
        switch (scenario) {
            case 0:
                EndStoryScene.iniDateEndStoryScene();
                allEnds = EndStoryScene.getDateEndStoryScenes();
                break;
            case 1:
                EndStoryScene.iniStreetEndStoryScene();
                allEnds = EndStoryScene.getStreetEndStoryScenes();
                break;
            case 2:
                EndStoryScene.iniPartyEndStoryScene();
                allEnds = EndStoryScene.getPartyEndStoryScenes();
                break;
            case 3:
                EndStoryScene.iniBarEndStoryScene();
                allEnds = EndStoryScene.getBarEndStoryScenes();
                break;
        }

        for (EndStoryScene endStoryScene : allEnds) {
            if (endStoryScene.getId() == endId) {
                currentEnds = endStoryScene;
            }
        }

    }

    private void iniView() {
        txtView = findViewById(R.id.txt_should_do);
        txtView.setText(currentEnds.getEndStoryScene() + "\n\n" + currentEnds.getWhatYouShouldDo());
    }

    public void backToMenu(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}
