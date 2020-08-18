package com.example.android.sacktest;


import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by DELL on 3/14/2018.
 */

class OnSwipeTouchListener implements View.OnTouchListener {

    private GestureDetector gestureDetector;

    OnSwipeTouchListener(Context context) {
        //Override the method fling()
        gestureDetector = new GestureDetector(context, new GestureDetector.OnGestureListener() {
            @Override
                  public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override
            public void onShowPress(MotionEvent motionEvent) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                return false;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {

            }

            @Override
            public boolean onFling(MotionEvent motionEvent1, MotionEvent motionEvent2, float v, float v1) {
                float distance = motionEvent1.getX() - motionEvent2.getX();
                if (distance < 0.0) {
                    onSwipeRight();
                }

                if (distance > 0.0) {
                    onSwipeLeft();
                }

                return false;
            }

        });

    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return gestureDetector.onTouchEvent(motionEvent);
    }

    public void onSwipeLeft() {

    }

    public void onSwipeRight() {

    }
}
