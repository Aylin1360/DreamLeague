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

import com.example.dreamleague.MainActivity;
import com.example.dreamleague.R;

public class Winner extends Fragment {

    private TextView resultOne;
    private TextView champ;
    Button buttonWinner;

    View view;
    public Winner() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.winner_lay, container, false);
        resultOne = view.findViewById(R.id.result1);
        buttonWinner = view.findViewById(R.id.button_winner);
        champ = view.findViewById(R.id.champ);

        buttonWinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonWinner.setEnabled(false);
                resultOne.append(MainActivity.teamsHeap.toString());
                champ.append(MainActivity.teamsHeap.winner());
            }
        });

        return view;
    }
}
