package com.example.dreamleague.TeamsCol;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.dreamleague.Heap;
import com.example.dreamleague.MainActivity;
import com.example.dreamleague.R;

import java.io.Console;


public class TeamOne extends Fragment {

    private TextView mTextViewResult1;
    private TextView mResult1;
    Button buttonParse1;

    View view;
    public TeamOne() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.team1, container, false);
        mTextViewResult1 = view.findViewById(R.id.text_view_result1);
        buttonParse1 = view.findViewById(R.id.button_parse1);

        mResult1 = view.findViewById(R.id.result1);

        buttonParse1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonParse1.setEnabled(false);
                MainActivity.jsonParse(mTextViewResult1);
                Log.d("gfdgdf", MainActivity.teamsHeap.toString());
                Log.d("Winner", MainActivity.teamsHeap.winner());
            }
        });

        return view;
    }

}
