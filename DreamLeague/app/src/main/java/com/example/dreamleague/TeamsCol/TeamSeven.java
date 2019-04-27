package com.example.dreamleague.TeamsCol;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.dreamleague.MainActivity;
import com.example.dreamleague.R;

public class TeamSeven extends Fragment {

    private TextView mTextViewResult7;
    Button buttonParse7;

    View view;
    public TeamSeven() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.team7, container, false);

        mTextViewResult7 = view.findViewById(R.id.text_view_result7);
        buttonParse7 = view.findViewById(R.id.button_parse7);

        buttonParse7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonParse7.setEnabled(false);
                MainActivity.jsonParse(mTextViewResult7);
            }
        });

        return view;
    }
}
