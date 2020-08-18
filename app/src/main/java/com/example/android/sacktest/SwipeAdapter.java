package com.example.android.sacktest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
/**
 * Created by DELL on 3/6/2018.
 */


public class SwipeAdapter extends FragmentStatePagerAdapter {

    private static final String TAG = "001cat";


    public SwipeAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = new PageFragment();
        Bundle args = new Bundle();

        // Our object is just an integer :-P
        args.putInt("Count", i);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "OBJECT " + (position + 1);
    }

}