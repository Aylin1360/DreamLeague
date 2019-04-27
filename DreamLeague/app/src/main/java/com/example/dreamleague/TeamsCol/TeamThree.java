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

public class TeamThree extends Fragment {

    private TextView mTextViewResult3;
    Button buttonParse3;

    View view;
    public TeamThree() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.team3, container, false);

        mTextViewResult3 = view.findViewById(R.id.text_view_result3);
        buttonParse3 = view.findViewById(R.id.button_parse3);

        buttonParse3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonParse3.setEnabled(false);
                MainActivity.jsonParse(mTextViewResult3);
            }
        });

        return view;
    }
}
