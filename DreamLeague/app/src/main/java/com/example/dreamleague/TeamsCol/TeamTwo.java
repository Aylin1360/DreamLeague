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

public class TeamTwo extends Fragment {

    private TextView mTextViewResult2;
    Button buttonParse2;
    private EditText editText2;

    View view;
    public TeamTwo() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.team2, container, false);

        mTextViewResult2 = view.findViewById(R.id.text_view_result2);
        buttonParse2 = view.findViewById(R.id.button_parse2);
        editText2 = view.findViewById(R.id.txtInput2);

        buttonParse2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String team_name2 = editText2.getText().toString();

                buttonParse2.setEnabled(false);
                MainActivity.jsonParse(team_name2, mTextViewResult2);
            }
        });
        return view;
    }
}
