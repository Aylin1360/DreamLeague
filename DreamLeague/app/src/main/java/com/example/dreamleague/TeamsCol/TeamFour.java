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

public class TeamFour extends Fragment {

    private TextView mTextViewResult4;
    Button buttonParse4;
    private EditText editText4;

    View view;

    public TeamFour() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.team4, container, false);

        mTextViewResult4 = view.findViewById(R.id.text_view_result4);
        buttonParse4 = view.findViewById(R.id.button_parse4);
        editText4 = view.findViewById(R.id.txtInput4);

        buttonParse4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String team_name4 = editText4.getText().toString();

                buttonParse4.setEnabled(false);
                MainActivity.jsonParse(team_name4, mTextViewResult4);
            }
        });

        return view;
    }
}
