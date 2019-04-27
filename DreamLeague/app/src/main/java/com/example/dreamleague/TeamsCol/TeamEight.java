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

public class TeamEight extends Fragment {

    private TextView mTextViewResult8;
    Button buttonParse8;
    private EditText editText8;

    View view;
    public TeamEight() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.team8, container, false);

        mTextViewResult8 = view.findViewById(R.id.text_view_result8);
        buttonParse8 = view.findViewById(R.id.button_parse8);
        editText8 = view.findViewById(R.id.txtInput8);

        buttonParse8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String team_name8 = editText8.getText().toString();

                buttonParse8.setEnabled(false);
                MainActivity.jsonParse(team_name8, mTextViewResult8);
            }
        });
        return view;
    }
}
