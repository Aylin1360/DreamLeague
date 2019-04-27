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

public class TeamTwo extends Fragment {

    private TextView mTextViewResult2;
    Button buttonParse2;

    View view;
    public TeamTwo() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.team2, container, false);

        mTextViewResult2 = view.findViewById(R.id.text_view_result2);
        buttonParse2 = view.findViewById(R.id.button_parse2);

        buttonParse2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonParse2.setEnabled(false);
                MainActivity.jsonParse(mTextViewResult2);
            }
        });
        return view;
    }
}
