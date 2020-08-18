package com.example.android.sacktest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_start);
        initImage();
    }

    private void initImage() {
        ImageView iv_start = (ImageView) findViewById(R.id.imageView5);


        iv_start.setImageResource(R.drawable.startpicture);

        //set the scale
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.9f, 1.4f, 1.9f, 1.4f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(5000);

        //remain the scale after animation
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                View view = null;
                startActivity(view);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        iv_start.startAnimation(scaleAnimation);
    }


    public void startActivity(View view) {
        Intent intent = new Intent(StartActivity.this, MenuActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }
}


