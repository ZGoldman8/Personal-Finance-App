package com.example.personalfinanceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class Frag2 extends Fragment {
    Button netWorthProgression;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag2_layout, container, false);
        netWorthProgression = view.findViewById(R.id.netWorthProgressionButton);

        netWorthProgression.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNetWorthProgression();
            }
        });
        return view;
    }

    public void openNetWorthProgression() {
        Intent intent = new Intent(getActivity(), NetWorthProgressionActivity.class);
        startActivity(intent);
    }
}
