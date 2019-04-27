package com.example.dreamleague.TeamsCol;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dreamleague.MainActivity;
import com.example.dreamleague.R;

public class TeamFive extends Fragment {

    private TextView mTextViewResult5;
    Button buttonParse5;
    private EditText editText5;

    View view;

    public TeamFive() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.team5, container, false);

        mTextViewResult5 = view.findViewById(R.id.text_view_result5);
        buttonParse5 = view.findViewById(R.id.button_parse5);
        editText5 = view.findViewById(R.id.txtInput5);

        buttonParse5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String team_name5 = editText5.getText().toString();

                buttonParse5.setEnabled(false);
                MainActivity.jsonParse(team_name5, mTextViewResult5);
            }
        });

        return view;
    }
}
