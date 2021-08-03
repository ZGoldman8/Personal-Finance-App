package com.example.personalfinanceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class Frag1 extends Fragment {
    Button netWorth, netWorthProgression, assetsInventory;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag1_layout, container, false);
        netWorth = view.findViewById(R.id.netWorthButton);
        netWorthProgression = view.findViewById(R.id.netWorthProgressionButton);
        assetsInventory = view.findViewById(R.id.assetsInventoryButton);

        netWorth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNetWorth();
            }
        });

        netWorthProgression.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNetWorthProgression();
            }
        });

        assetsInventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAssetsInventory();
            }
        });

        return view;
    }

    public void openNetWorth() {
        Intent intent = new Intent(getActivity(), NetWorthCalculatorActivity.class);
        startActivity(intent);
    }

    public void openNetWorthProgression() {
        Intent intent = new Intent(getActivity(), NetWorthProgressionActivity.class);
        startActivity(intent);
    }

    public void openAssetsInventory() {
        Intent intent = new Intent(getActivity(), AssetsInventoryActivity.class);
        startActivity(intent);
    }
}
