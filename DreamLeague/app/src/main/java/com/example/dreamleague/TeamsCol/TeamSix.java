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

public class TeamSix extends Fragment {

    private TextView mTextViewResult6;
    Button buttonParse6;

    View view;
    public TeamSix() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.team6, container, false);
        mTextViewResult6 = view.findViewById(R.id.text_view_result6);
        buttonParse6 = view.findViewById(R.id.button_parse6);

        buttonParse6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonParse6.setEnabled(false);
                MainActivity.jsonParse(mTextViewResult6);
            }
        });

        return view;
    }
}
