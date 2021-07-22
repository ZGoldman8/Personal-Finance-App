package com.example.personalfinanceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class Frag1 extends Fragment {
    Button netWorth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag1_layout, container, false);
        netWorth = view.findViewById(R.id.netWorthButton);

        netWorth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNetWorth();
            }
        });
        return view;
    }

    public void openNetWorth() {
        Intent intent = new Intent(getActivity(), NetWorthActivity.class);
        startActivity(intent);
    }
}
