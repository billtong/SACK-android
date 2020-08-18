package com.example.android.sacktest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class PageFragment extends Fragment {

    private static final String TAG = "0";
    TextView textView;
    ArrayList<String> options = new ArrayList<String>();



    public PageFragment() {
        super();
        options.add("Date");
        options.add("Street");
        options.add("Party");
        options.add("Bar");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        textView = (TextView) view.findViewById(R.id.textView3);
        final Bundle bundle = getArguments();
        textView.setText(options.get(bundle.getInt("Count")));


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), StoryActivity.class);

                switch(bundle.getInt("Count")) {
                    case 0:
                        intent.putExtra("scene", 0);
                        break;
                    case 1 :
                        intent.putExtra("scene", 1);
                        break;
                    case 2 :
                        intent.putExtra("scene", 2);
                        break;
                    case 3:
                        intent.putExtra("scene", 3);
                        break;
                }
                startActivity(intent);
            }
        });


        return view;

    }

}

